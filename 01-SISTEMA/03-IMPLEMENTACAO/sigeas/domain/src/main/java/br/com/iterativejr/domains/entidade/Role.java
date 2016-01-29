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

    private static final long serialVersionUID = 1L;

    private RoleName name;

    public Role() {
    }

    public Role(String name) {
        this.name = RoleName.valueOf(name);
    }

    @Override
    public String getAuthority() {
        return this.getName().name();
    }

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}
}
