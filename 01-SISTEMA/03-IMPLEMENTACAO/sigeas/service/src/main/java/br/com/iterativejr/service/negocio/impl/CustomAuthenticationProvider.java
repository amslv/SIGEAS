package br.com.iterativejr.service.negocio.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import br.com.iterativejr.domains.entidade.AppUser;
import br.com.iterativejr.domains.entidade.enums.RoleName;
import br.com.iterativejr.service.negocio.legacies.providers.LoginProvider;

/**
 * @author <a href="https://github.com/LuizAntonioPS">Luiz Pereira</a>
 *
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		String role = new LoginProvider().login(authentication.getName(),(String) authentication.getCredentials());
		Collection<GrantedAuthority> authorities = getAuthorities(role);
		
		User appUser = new AppUser(authentication.getName(),(String) authentication.getCredentials(), true, true, true,	true, authorities);

		return new UsernamePasswordAuthenticationToken(appUser,	(String) authentication.getCredentials(), authorities);
	}

	/**
	 * Retrieves a collection of {@link GrantedAuthority} based on a numerical
	 * role
	 * 
	 * @param role
	 *            the numerical role
	 * @return a collection of {@link GrantedAuthority

	 */
	public Collection<GrantedAuthority> getAuthorities(String role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	/**
	 * Converts a numerical role to an equivalent list of roles
	 * 
	 * @param role
	 *            the numerical role
	 * @return list of roles as as a list of {@link String}
	 */
	public List<String> getRoles(String role) {
		List<String> roles = new ArrayList<String>();

		if (role.equals(RoleName.ROLE_STUDENT.name())) {
			roles.add(RoleName.ROLE_STUDENT.name());
		} else if (role.equals(RoleName.ROLE_SOCIAL_WORKER.name())) {
			roles.add(RoleName.ROLE_SOCIAL_WORKER.name());
		} else if (role.equals(RoleName.ROLE_FINANCIAL_WORKER.name())) {
			roles.add(RoleName.ROLE_FINANCIAL_WORKER.name());
		}
		return roles;
	}

	/**
	 * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects
	 * 
	 * @param roles
	 *            {@link String} of roles
	 * @return list of granted authorities
	 */
	public static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}