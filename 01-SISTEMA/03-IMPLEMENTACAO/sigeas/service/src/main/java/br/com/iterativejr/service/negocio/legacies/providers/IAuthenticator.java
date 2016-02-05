package br.com.iterativejr.service.negocio.legacies.providers;

import br.com.iterativejr.service.negocio.legacies.validations.SigeasException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;

/**
 * Interface para autenticar
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
public abstract class IAuthenticator {

	/**
	 * Web client
	 */
	private final WebClient webClient = new WebClient(BrowserVersion.CHROME);

	/**
	 * Login
	 */
	private String login;
	
	/**
	 * senha
	 */
	private String password;

	/**
	 * Loga no sistema
	 * @return se deu tudo certo true
	 */
	abstract boolean login() throws SigeasException;

	/**
	 * Logout no sistema
	 */
	abstract void logout() throws SigeasException;

	/**
	 * Recupera uma nova instancia de WebClient para que seja possível setar a
	 * página que será utilizada durante as ações automaticas do programa.
	 *
	 * @return uma nova instancia de {@link WebClient}
	 */
	public WebClient getWebClient() {
		return webClient;
	}

	/**
	 * Retorna login
	 * @return login recuperado
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Modifica login
	 * @param login que sera setado
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Retorna senha
	 * @return password do cara
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Modifica senha
	 * @param password seta password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
