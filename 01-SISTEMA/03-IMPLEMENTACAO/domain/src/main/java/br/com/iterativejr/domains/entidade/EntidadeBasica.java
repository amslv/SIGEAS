/**
 * 
 */
package br.com.iterativejr.domains.entidade;

import java.io.Serializable;

/**
 * @author edsf
 *
 */
public abstract class EntidadeBasica implements Serializable {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 3347012291986207784L;

	/**
	 * pega id
	 * @return
	 */
	public abstract Long getId();

	/**
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
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @return resultado da igualdade
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
