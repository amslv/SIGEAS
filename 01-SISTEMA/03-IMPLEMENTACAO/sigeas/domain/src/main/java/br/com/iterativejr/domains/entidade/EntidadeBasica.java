package br.com.iterativejr.domains.entidade;

import java.io.Serializable;

/**
 * 
 * <p>
 * <b> Entidade basica do sistema </b>
 * </p>
 *
 * <p>
 * Entidade contendo dados basicos de classes
 * </p>
 * 
 * @author <a href="https://github.com/edsf80">edsf</a>
 *
 */
public abstract class EntidadeBasica implements Serializable {

	/**
	 * Serial da classe
	 */
	private static final long serialVersionUID = 3347012291986207784L;

	/**
	 * Pegar ID
	 * 
	 * @return Id recuperado
	 */
	public abstract Long getId();

	/**
	 * Mais informacoes em
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int resultado;

		if (this.getId() == null) {
			resultado = super.hashCode();
		} else {
			resultado = this.getId().intValue();
		}

		return resultado;
	}

	/**
	 * Mais informacoes em
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		boolean resultado = Boolean.FALSE;

		if (obj != null) {
			EntidadeBasica eb = (EntidadeBasica) obj;

			if ((eb.getId() == this.getId()) || eb.getId().equals(this.getId())) {
				resultado = Boolean.TRUE;
			}
		}

		return resultado;
	}

}
