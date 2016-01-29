package br.com.iterativejr.service.negocio.legacies.providers;

import br.com.iterativejr.domains.entidade.Role;
import br.com.iterativejr.domains.entidade.Usuario;
import br.com.iterativejr.service.negocio.legacies.requests.RequestJobUserSUAP;
import br.com.iterativejr.service.negocio.legacies.validations.SigeasException;

public class LoginProvider {

	public Usuario login(String matricula, String senha) throws SigeasException {
		Usuario user = new Usuario();
		if (matricula.length() == 7) {
			EmployeeAuthenticationSUAP instance = EmployeeAuthenticationSUAP
					.getInstance(matricula, senha);
			RequestJobUserSUAP resquest = new RequestJobUserSUAP(instance);
			instance.login();
			if (resquest.equals("SSISTENTE SOCIAL (PCIFE)")) {
				user.setRole(new Role("ROLE_SOCIAL_WORKER"));
				return user;
			} else {
				user.setRole(new Role("ROLE_FINANCIAL_WORKER"));
				return user;
			}
		} else {
			IAuthenticator instance = StudentAuthenticationQAcademico
					.getInstance(matricula, senha);
			instance.login();
			user.setRole(new Role("ROLE_STUDENT"));
			return user;
		}
	}
}
