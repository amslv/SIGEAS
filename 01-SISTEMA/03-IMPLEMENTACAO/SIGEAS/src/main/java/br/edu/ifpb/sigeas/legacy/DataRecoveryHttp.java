package br.edu.ifpb.sigeas.legacy;

import org.apache.http.client.methods.HttpPost;

public class DataRecoveryHttp {
	
	private static final String QAcademico_URL = "https://academico.ifpb.edu.br/qacademico/index.asp?t=1001";

	public static void getConnection() {
		new HttpPost(QAcademico_URL);
	}

	public static void main(String[] args) {
		getConnection();
	}
}