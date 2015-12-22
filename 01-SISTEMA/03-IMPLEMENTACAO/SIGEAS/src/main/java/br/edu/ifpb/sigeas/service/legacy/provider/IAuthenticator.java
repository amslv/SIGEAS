package br.edu.ifpb.sigeas.service.legacy.provider;

import br.edu.ifpb.sigeas.service.legacy.validation.SigeasException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;

/**
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
public abstract class IAuthenticator {

	private final WebClient webClient = new WebClient(BrowserVersion.CHROME);

	private String login;
	
	private String password;

	abstract boolean login() throws SigeasException;

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	


}
