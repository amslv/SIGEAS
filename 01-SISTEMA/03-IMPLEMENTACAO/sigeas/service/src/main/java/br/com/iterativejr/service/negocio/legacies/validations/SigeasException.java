package br.com.iterativejr.service.negocio.legacies.validations;

import org.springframework.security.core.AuthenticationException;

/**
 *
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
public class SigeasException extends AuthenticationException {

	/**
	 * serial da exception
	 */
	private static final long serialVersionUID = -4561956369953816976L;

	/**
	 * Construtor com mensagem
	 * @param mensagem mensagem de erro
	 */
	public SigeasException(String mensagem) {
		super(mensagem);
	}

	/**
	 * Construtor com mensagem
	 * @param mensagem mensagem de erro
	 * @param throwable throwable 
	 */
	public SigeasException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}
}
