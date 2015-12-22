package br.edu.ifpb.sigeas.service.legacy.validation;

/**
 * 
 * <p>
 * <b> Sem conexão </b>
 * </p>
 *
 * <p>
 * Esta classe serve para controlar as excessões de uma página caso nao tenha
 * internet.
 * </p>
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
public class ConnectionException extends SigeasException {

	private static final long serialVersionUID = 1491459776940859364L;

	public ConnectionException(String mensagem) {
		super(mensagem);
	}

}
