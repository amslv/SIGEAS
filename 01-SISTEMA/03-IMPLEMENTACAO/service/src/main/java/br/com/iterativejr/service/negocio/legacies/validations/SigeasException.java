package br.com.iterativejr.service.negocio.legacies.validations;

import org.springframework.security.core.AuthenticationException;

/**
 * 
 * <p>
 * <b> Título </b>
 * </p>
 *
 * <p>
 * Descrição
 * </p>
 * 
 * <pre>
 * @see <a href="http://www.linkreferencia.com">Link de Referencia</a>
 * </pre>
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
public class SigeasException extends AuthenticationException {

	private static final long serialVersionUID = -4561956369953816976L;

	public SigeasException(String mensagem) {
		super(mensagem);
	}

	public SigeasException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}
}
