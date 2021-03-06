package br.com.iterativejr.service.negocio.legacies.providers;

import br.com.iterativejr.domains.entidade.enums.RoleName;
import br.com.iterativejr.service.negocio.legacies.requests.RequestJobUserSUAP;
import br.com.iterativejr.service.negocio.legacies.validations.SigeasException;

/**
 * <p>
 * <b> Login provider </b>
 * </p>
 *
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
public class LoginProvider {
	
	/**
	 * Realiza o Login
	 * 
	 * @param matricula
	 * 		Matrícula do camarada
	 * @param senha
	 * 		Senha do camarada
	 * @return login
	 * @throws SigeasException caso algo de errado aconteca
	 */
	public String login(String matricula, String senha) throws SigeasException {
		if (matricula.length() == 7) {
			EmployeeAuthenticationSUAP instance = EmployeeAuthenticationSUAP
					.getInstance(matricula, senha);
			RequestJobUserSUAP resquest = new RequestJobUserSUAP(instance);
			instance.login();
			if (resquest.equals("SSISTENTE SOCIAL (PCIFE)")) {
				instance.logout();
				return RoleName.ROLE_SOCIAL_WORKER.name();
			} else {
				instance.logout();
				return RoleName.ROLE_FINANCIAL_WORKER.name();
			}
		} else {
			IAuthenticator instance = StudentAuthenticationQAcademico
					.getInstance(matricula, senha);
			instance.login();
			instance.logout();
			return RoleName.ROLE_STUDENT.name();
		}
	}
}
