package br.com.iterativejr.service.negocio.legacies.requests;

import java.io.IOException;
import java.net.UnknownHostException;

import br.com.iterativejr.service.negocio.legacies.providers.EmployeeAuthenticationSUAP;
import br.com.iterativejr.service.negocio.legacies.validations.SigeasException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * Busca profissao do usuario
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
public class RequestJobUserSUAP {

	/**
	 * Autenticacao
	 */
	private EmployeeAuthenticationSUAP empAuth;

	/**
	 * Tipo assistente em adm
	 */
	private static final String ASSISTENTE_EM_ADMINISTRACAO = "ASSISTENTE EM ADMINISTRACAO";
	/**
	 * Tipo assistente Social
	 */
	private static final String ASSISTENTE_SOCIAL_PCIFE = "ASSISTENTE SOCIAL (PCIFE)";
	/**
	 * Pagina atual
	 */
	private HtmlPage currentPage;

	/**
	 * Webclient
	 */
	private WebClient webClient;

	/**
	 * Construtor para setar Auth
	 * @param empAuth auth
	 */
	public RequestJobUserSUAP(EmployeeAuthenticationSUAP empAuth) {
		this.empAuth = empAuth;
	}

	/**
	 * Este metodo recupera a função do funcionário do SUAP
	 *
	 * @return Tipo da conta
	 * @throws SigeasExceptionException
	 */
	public String requestJobUser() throws SigeasException {
		try {

			webClient = new WebClient(BrowserVersion.CHROME);
			// Recupera a página a partir de uma url e seta no autenticador
			currentPage = webClient
					.getPage(EmployeeAuthenticationSUAP.HOME_PAGE_URL.replace(
							"{matricula}", empAuth.getLogin()));

			if (currentPage.asXml().contains(ASSISTENTE_SOCIAL_PCIFE)) {
				return ASSISTENTE_SOCIAL_PCIFE;
			} else if (currentPage.asXml()
					.contains(ASSISTENTE_EM_ADMINISTRACAO)) {
				return ASSISTENTE_EM_ADMINISTRACAO;
			} else {
				throw new SigeasException(
						"Este tipo de cargo não é permitido no SIGEAS");
			}
		} catch (UnknownHostException ex) {
			throw new SigeasException(
					"Não foi possivel estabelecer uma conexão, "
							+ "verifique sua internet");
		} catch (IOException ex) {
			throw new SigeasException(
					"Ocorreu algum problema em retornar o recurso "
							+ "solicitado!");
		}
	}
}