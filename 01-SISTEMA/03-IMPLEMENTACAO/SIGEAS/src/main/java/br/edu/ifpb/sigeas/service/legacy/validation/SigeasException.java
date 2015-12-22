package br.edu.ifpb.sigeas.service.legacy.validation;

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
public class SigeasException extends Exception {

	private static final long serialVersionUID = -4561956369953816976L;

	public SigeasException(String mensagem) {
		super(mensagem);
	}

	public SigeasException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}
}
