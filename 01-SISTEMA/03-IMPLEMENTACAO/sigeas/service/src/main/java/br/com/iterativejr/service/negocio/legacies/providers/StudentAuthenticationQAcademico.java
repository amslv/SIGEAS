package br.com.iterativejr.service.negocio.legacies.providers;

import java.io.IOException;
import java.net.UnknownHostException;

import br.com.iterativejr.service.negocio.legacies.validations.AuthenticationSigeasException;
import br.com.iterativejr.service.negocio.legacies.validations.ConnectionException;
import br.com.iterativejr.service.negocio.legacies.validations.DifferentPageException;
import br.com.iterativejr.service.negocio.legacies.validations.SigeasException;

import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

/**
 * 
 * <p>
 * <b> Autenticação do Aluno </b>
 * </p>
 *
 * <p>
 * Esta classe é responsável pela conexão com o sistema web do q-academico do
 * ifpb. O intuito é retornar um objeto no qual seja possivel manipular a pagina
 * e requisições por meio de ações controladas pela API <b>HtmlUnit</b>.
 * </p>
 * 
 * <pre>
 * @see <a href="http://www.htmlunit.sourceforge.net">htmlunit.sourceforge
 * .net</a>
 * </pre>
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 * @author <a href="https://github.com/ncnegoleo">Leonardo Soares</a>
 *
 */
public class StudentAuthenticationQAcademico extends IAuthenticator {

	/**
	 * 
	 */
	private static StudentAuthenticationQAcademico instance = null;

	/**
	 * 
	 */
	private HtmlPage currentPage;
	/**
	 * 
	 */
	private HtmlPage homePage;

	/**
	 * 
	 */
	private static final String LOGIN_PAGE_URL = "https://academico.ifpb.edu.br/qacademico/index.asp?t=1001";
	/**
	 * 
	 */
	private static final String LOGIN_PAGE_TITLE = "Q-Acadêmico Web para IF-PBBem Vindo!";
	/**
	 * 
	 */
	private static final String AUTH_FORM_NAME = "frmLogin";
	/**
	 * 
	 */
	private static final String SUBMIT_ELEM_NAME = "Submit";
	/**
	 * 
	 */
	private static final String USERNAME_ELEM_NAME = "LOGIN";
	/**
	 * 
	 */
	private static final String PASSWORD_ELEM_NAME = "SENHA";

	/**
	 * 
	 */
	private final String HOMEPAGE_URL = "https://academico.ifpb.edu.br/qacademico/index.asp?t=2071";
	/**
	 * 
	 */
	private final String HOMEPAGE_TITLE = "Q-Acadêmico Web para IF-PBMinhas "
			+ "Disciplinas Atualmente em Curso";

	/**
	 * construtor privado para recuperar a conexão
	 * @param login
	 * @param password
	 */
	private StudentAuthenticationQAcademico(String login, String password) {
		super.setLogin(login);
		super.setPassword(password);
	}

	/**
	 * Este método recupera uma instancia e também efetua o login no sistema
	 * q-academico IFPB (caso o objeto não estaja instanciado) passando os
	 * parametros de login/matricula e senha.
	 *
	 * @param matricula
	 *            matricula do aluno.
	 * @param senha
	 *            senha do aluno.
	 * @return uma nova ou já criada instacia da conexão.
	 */
	public static StudentAuthenticationQAcademico getInstance(String matricula,
			String senha) {
		if (instance == null || isSessionEnded()) {
			instance = new StudentAuthenticationQAcademico(matricula, senha);
		}
		return instance;
	}

	/**
	 * este método serve para estabelecer um login no sistema para que seja
	 * possivel recuperar informações dentro da sessão do aluno.
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
				final HtmlForm form = currentPage.getFormByName(AUTH_FORM_NAME);
				final HtmlSubmitInput button = form
						.getInputByName(SUBMIT_ELEM_NAME);
				final HtmlTextInput username = form
						.getInputByName(USERNAME_ELEM_NAME);
				final HtmlPasswordInput pass = form
						.getInputByName(PASSWORD_ELEM_NAME);

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
				homePage = getWebClient().getPage(HOMEPAGE_URL);
				if (!homePage.getTitleText().endsWith(HOMEPAGE_TITLE)) {
					throw new AuthenticationSigeasException(
							"Acesso Negado. Tente Novamente");
				}
			}
		} catch (DifferentPageException ex) {
			throw new DifferentPageException("Pagina Diferente");
		} catch (UnknownHostException ex) {
			throw new ConnectionException(
					"Não foi possivel estabelecer uma conexão, "
							+ "verifique sua internet");
		} catch (IOException ex) {
			throw new RuntimeException(
					"Ocorreu algum problema em retornar o recurso "
							+ "solicitado!");
		}

		return true;
	}

	/**
	 * Este método serve para estabelecer o logout no sistema para que não seja
	 * mais possivel recuperar informações dentro da sessão do aluno.
	 */
	public void logout() throws SigeasException {
		instance = null;
	}


	/**
	 * Verifica se o tempo da sessão acabou.
	 *
	 * @return Verdadeiro se o tempo estiver acabado
	 */
	public static boolean isSessionEnded() {
		HtmlPage pg = (HtmlPage) instance.getWebClient().getCurrentWindow()
				.getEnclosedPage();
		DomText acssNegado = pg
				.getFirstByXPath("//font[@color='#FF0000' and @size='2']/text()");
		if (acssNegado != null && acssNegado.asText() != null)
			return acssNegado.asText().equals("Acesso Negado");
		return false;
	}

}
