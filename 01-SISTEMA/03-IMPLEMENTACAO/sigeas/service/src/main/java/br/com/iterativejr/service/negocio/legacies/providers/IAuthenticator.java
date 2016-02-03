package br.com.iterativejr.service.negocio.legacies.providers;

import br.com.iterativejr.service.negocio.legacies.validations.SigeasException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;

/**
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
public abstract class IAuthenticator {

	/**
	 * 
	 */
	private final WebClient webClient = new WebClient(BrowserVersion.CHROME);

	/**
	 * 
	 */
	private String login;
	
	/**
	 * 
	 */
	private String password;

	/**
	 * 
	 */
	abstract boolean login() throws SigeasException;

	/**
	 * 
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
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Modifica login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Retorna senha
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Modifica senha
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
