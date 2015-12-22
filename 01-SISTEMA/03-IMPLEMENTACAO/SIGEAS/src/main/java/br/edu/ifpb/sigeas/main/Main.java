package br.edu.ifpb.sigeas.main;

import br.edu.ifpb.sigeas.service.legacy.provider.LoginProvider;
import br.edu.ifpb.sigeas.service.legacy.validation.SigeasException;

public class Main {

	public static void main(String[] args) {
		LoginProvider prov = new LoginProvider();
		try {
			prov.login("201225020360", "4563321");
		} catch (SigeasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
