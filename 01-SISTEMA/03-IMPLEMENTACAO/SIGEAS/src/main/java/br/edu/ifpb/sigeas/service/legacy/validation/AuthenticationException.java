package br.edu.ifpb.sigeas.service.legacy.validation;

/**
 * <p>
 * <b> Login ou senha foram inseridos incorretamente pelo usuário </b>
 * </p>
 *
 * <p>
 * Esta classe serve para controlar as excessões de uma página caso o usuário
 * não tenha inserido corretamente suas credenciais.
 * </p>
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
public class AuthenticationException extends SigeasException {

	private static final long serialVersionUID = 2984251099836375722L;

	public AuthenticationException(String mensagem) {
		super(mensagem);
	}

}
