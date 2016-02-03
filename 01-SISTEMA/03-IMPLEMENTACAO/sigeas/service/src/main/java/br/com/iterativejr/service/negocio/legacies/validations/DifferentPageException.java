package br.com.iterativejr.service.negocio.legacies.validations;

/**
 * 
 * <p>
 * <b> Pagina Diferente do que se era esperado </b>
 * </p>
 *
 * <p>
 * Esta classe serve para controlar as excessões de uma página recuperada numa
 * condição em que esta não seja realmete a página desejada.
 * </p>
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 * @author <a href="https://github.com/ncnegoleo">Leonardo Soares</a>
 *
 */
public class DifferentPageException extends SigeasException {

	/**
	 */
	private static final long serialVersionUID = 4001968279264501283L;

	/**
	 * Construtor
	 */
	public DifferentPageException(String mensagem) {
		super(mensagem);
	}

}
