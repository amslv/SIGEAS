package br.edu.ifpb.sigeas.service.legacy.provider;

import br.edu.ifpb.sigeas.service.legacy.request.RequestJobUserSUAP;
import br.edu.ifpb.sigeas.service.legacy.validation.SigeasException;

/**
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
public class LoginProvider {

	public String login(String matricula, String senha) throws SigeasException {
		if (matricula.length()==7) {
			EmployeeAuthenticationSUAP instance = EmployeeAuthenticationSUAP.getInstance(matricula, senha);
			RequestJobUserSUAP resquest = new RequestJobUserSUAP(instance);
			instance.login();
			if (resquest.equals("SSISTENTE SOCIAL (PCIFE)")){
				return "assistente-social.xhtml";
			}else{
				return "financeiro.xhtml";
			}
		} else {
			IAuthenticator instance = StudentAuthenticationQAcademico.getInstance(matricula, senha);
			instance.login();
			return "student.xhtml";
		}
	}
}
