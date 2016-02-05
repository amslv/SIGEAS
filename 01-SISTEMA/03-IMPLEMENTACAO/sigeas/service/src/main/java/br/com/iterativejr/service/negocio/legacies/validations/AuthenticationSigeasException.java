package br.com.iterativejr.service.negocio.legacies.validations;

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
public class AuthenticationSigeasException extends SigeasException {

	/**
	 * Serial da exception
	 */
	private static final long serialVersionUID = 2984251099836375722L;

	/**
	 * Construtor da exception
	 * @param mensagem mensagem de erro
	 */
	public AuthenticationSigeasException(String mensagem) {
		super(mensagem);
	}

}
