package br.com.iterativejr.domains.entidade;

import org.springframework.security.core.GrantedAuthority;

/**
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
 * @author <a href="https://github.com/LuizAntonioPS">Luiz Pereira</a>
 *
 */
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	private String name;

	public Role(String name) {
		super();
		this.name = name;
	}

	public Role() {
	}

	@Override
	public String getAuthority() {
		return name;
	}

}
