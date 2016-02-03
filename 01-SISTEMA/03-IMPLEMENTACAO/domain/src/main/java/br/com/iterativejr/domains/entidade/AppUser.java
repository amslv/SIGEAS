/**
 * 
 */
package br.com.iterativejr.domains.entidade;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * <p>
 * <b> Angus </b>
 * </p>
 *
 * <p>
 * Descrição
 * </p>
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
public class AppUser extends User {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -8767815443695778266L;

	/**
	 * Construtor
	 * 
	 * @param username
	 * @param password
	 * @param enabled
	 * @param accountNonExpired
	 * @param credentialsNonExpired
	 * @param accountNonLocked
	 * @param authorities
	 */
	public AppUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, Collection<GrantedAuthority> authorities) {

		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
	}
}
