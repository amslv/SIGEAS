package br.com.iterativejr.domains.entidade;

import org.springframework.security.core.GrantedAuthority;

import br.com.iterativejr.domains.entidade.enums.RoleName;

/**
 * <p>
 * <b> Funcao do usuario </b>
 * </p>
 *
 * @author <a href="https://github.com/LuizAntonioPS">Luiz Pereira</a>
 *
 */
public class Role implements GrantedAuthority {

	/**
	 * Serial do grantedauthority
	 */
    private static final long serialVersionUID = 1L;

    /**
     * nome da funcao
     */
    private RoleName name;

    /**
     * construtor default
     */
    public Role() {
    }

    /**
     * Seta nome na funcao
     * @param name novo nome
     */
    public Role(String name) {
        this.name = RoleName.valueOf(name);
    }

    /**
     * Pega authority
     * @return authority recuperada
     */
    @Override
    public String getAuthority() {
        return this.getName().name();
    }

    /**
     * Pega name
     * @return name recuperado
     */
	public RoleName getName() {
		return name;
	}

	/**
	 * Seta nome
	 * @param name novo nome
	 */
	public void setName(RoleName name) {
		this.name = name;
	}
}
