package br.com.iterativejr.service.negocio.legacies.providers;

import java.io.IOException;
import java.net.UnknownHostException;

import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

import br.com.iterativejr.service.negocio.legacies.validations.AuthenticationSigeasException;
import br.com.iterativejr.service.negocio.legacies.validations.DifferentPageException;
import br.com.iterativejr.service.negocio.legacies.validations.SigeasException;

/**
 * Classe responsavel por autenticar usuario no SUAP
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 */
public class EmployeeAuthenticationSUAP extends IAuthenticator {
	
	/**
	 * Instancia do SUAP
	 */
	private static EmployeeAuthenticationSUAP instance = null;

	/**
	 * Pagina do Suap
	 */
	private HtmlPage currentPage;

	/**
	 * URL do Login
	 */
	private static final String LOGIN_PAGE_URL = "https://suap.ifpb.edu.br/accounts/login/?next=/";
	/**
	 * URL da pagina
	 */
	public static final String HOME_PAGE_URL = "https://suap.ifpb.edu.br/rh/servidor/{matricula}/?tab=0";
	/**
	 * titulo da Pagina
	 */
	private static final String LOGIN_PAGE_TITLE = "SUAP: Sistema Unificado de Administração Pública - Login";
	/**
	 * Nome do Submit
	 */
	private static final String SUBMIT_ELEM_NAME = "Acessar";
	/**
	 * Username
	 */
	private static final String USERNAME_ELEM_NAME = "username";
	/**
	 * Senha 
	 */
	private static final String SENHA_ELEM_NAME = "password";

	/**
	 * construtor privado para recuperar a conexão
	 * 
	 * @param login login do camarada
	 * @param password password do camarada
	 */
	private EmployeeAuthenticationSUAP(String login, String password) {
		super.setLogin(login);
		super.setPassword(password);
	}

	/**
	 * Este método recupera uma instancia e também efetua o login no sistema
	 * SUAP (caso o objeto não estaja instanciado) passando os parametros de
	 * login/matricula e senha.
	 *
	 * @param matricula
	 *            matricula do servidor.
	 * @param senha
	 *            senha do servidor.
	 * @return uma nova ou já criada instacia da conexão.
	 */
	public static EmployeeAuthenticationSUAP getInstance(String matricula,
			String senha) {
		if (instance == null) {
			instance = new EmployeeAuthenticationSUAP(matricula, senha);
		}
		return instance;
	}

	/**
	 * este método serve para estabelecer um login no sistema para que seja
	 * possivel recuperar informações dentro da sessão do servidor.
	 * @return true caso tenha efetuado login
	 * @throws caso algo errado ocorrer
	 */
	public boolean login() throws SigeasException {
		try {
			// recupera a pagina de login
			currentPage = this.getWebClient().getPage(LOGIN_PAGE_URL);

			// verifica se o titulo da página corresponde ao da pagina
			// recuperada
			if (!currentPage.getTitleText().endsWith(LOGIN_PAGE_TITLE)) {
				throw new DifferentPageException("");
			} else {

				/*
				 * recupera os elementos da pagina (estes elementos tiveram suas
				 * caracteristicas previamente analisadas, identificando
				 * informações utilizaveis para evitar erros)
				 */
				final HtmlForm form = currentPage.getForms().get(0);
				final HtmlTextInput username = form
						.getInputByName(USERNAME_ELEM_NAME);
				final HtmlPasswordInput pass = form
						.getInputByName(SENHA_ELEM_NAME);
				final HtmlSubmitInput button = form.getInputByValue(SUBMIT_ELEM_NAME);
				/*
				 * a partir dos elementos Input recuperados são setados os
				 * valores para efetuar o login no sistema
				 */
				username.setValueAttribute(super.getLogin());
				pass.setValueAttribute(super.getPassword());

				/*
				 * Este elemento de fato executa o login, utilizando o metodo
				 * click() no botão que submete o formulario
				 */
				this.currentPage = button.click();
				
				/*
				 * Verifica se a pagina recuperada é a página inicial, caso nao
				 * seja, é pq colocaram login ou senha inválidos
				 */
				HtmlPage homePage = getWebClient().getPage(HOME_PAGE_URL.replace("{matricula}", super.getLogin()));
				if (homePage.getTitleText().endsWith(LOGIN_PAGE_TITLE)) {
					throw new AuthenticationSigeasException(
							"Acesso Negado. Tente Novamente");
				}
				
			}
		} catch (DifferentPageException ex) {
			throw new SigeasException("Pagina Diferente");
		} catch (UnknownHostException ex) {
			throw new SigeasException(
					"Não foi possivel estabelecer uma conexão, "
							+ "verifique sua internet");
		} catch (IOException ex) {
			throw new SigeasException(
					"Ocorreu algum problema em retornar o recurso "
							+ "solicitado!");
		}

		return true;
	}

	/**
	 * Este método serve para estabelecer o logout no sistema para que não seja
	 * mais possivel recuperar informações dentro da sessão do servidor.
	 */
	public void logout() throws SigeasException {
		instance = null;
	}
}