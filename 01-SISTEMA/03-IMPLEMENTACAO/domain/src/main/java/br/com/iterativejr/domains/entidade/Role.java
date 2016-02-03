/**
 * 
 */
package br.com.iterativejr.domains.entidade;

import org.springframework.security.core.GrantedAuthority;

import br.com.iterativejr.domains.entidade.enums.RoleName;

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

	/**
	 * serial
	 */
    private static final long serialVersionUID = 1L;

    /**
     * name
     */
    private RoleName name;

    /**
     * construtor
     */
    public Role() {
    }

    /**
     * construtor com parametro nome
     * @param name
     */
    public Role(String name) {
        this.name = RoleName.valueOf(name);
    }

    /**
     * pega authority
     */
    @Override
    public String getAuthority() {
        return this.getName().name();
    }

    /**
     * 
     * @return
     */
	public RoleName getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(RoleName name) {
		this.name = name;
	}
}
