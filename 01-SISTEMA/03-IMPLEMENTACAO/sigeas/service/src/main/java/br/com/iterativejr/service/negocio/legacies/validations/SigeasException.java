package br.com.iterativejr.service.negocio.legacies.validations;

import org.springframework.security.core.AuthenticationException;

/**
 *
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
public class SigeasException extends AuthenticationException {

	/**
	 */
	private static final long serialVersionUID = -4561956369953816976L;

	/**
	 * Construtor
	 */
	public SigeasException(String mensagem) {
		super(mensagem);
	}

	/**
	 * Construtor
	 */
	public SigeasException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}
}
