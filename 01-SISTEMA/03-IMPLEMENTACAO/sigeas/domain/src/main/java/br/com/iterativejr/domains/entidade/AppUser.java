package br.com.iterativejr.domains.entidade;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * <p>
 * <b> Usuario do Sistema </b>
 * </p>
 *
 * <p>
 * Usuario do sistema utilizado no spring
 * </p>
 * 
 * 
 * @author <a href="https://github.com/LuizAntonioPS">Luiz Pereira</a>
 *
 */
public class AppUser extends User {

	/**
	 * Serial do user
	 */
	private static final long serialVersionUID = -8767815443695778266L;

	/**
	 * Construtor do User do Spring
	 * 
	 * @param username
	 *            login
	 * @param password
	 *            senha
	 * @param enabled
	 *            liberado
	 * @param accountNonExpired
	 *            accountNonExpired
	 * @param credentialsNonExpired
	 *            credenciais
	 * @param accountNonLocked
	 *            accountNonLocked
	 * @param authorities
	 *            permissoes
	 */
	public AppUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, Collection<GrantedAuthority> authorities) {

		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
	}
}
