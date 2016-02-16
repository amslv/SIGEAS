package br.com.iterativejr.visao.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import br.com.iterativejr.domains.entidade.AppUser;
import br.com.iterativejr.service.negocio.impl.LoginServiceImpl;
import br.com.iterativejr.service.negocio.legacies.providers.LoginProvider;

/**
 * <p>
 * <b> Custom Authentication </b>
 * </p>
 *
 * @author <a href="https://github.com/LuizAntonioPS">Luiz Pereira</a>
 *
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	@Qualifier("loginService")
	private LoginServiceImpl loginService;

	/**
	 * Construtor do AuthenticationProvider
	 * 
	 * @param authentication
	 *            autenticacao
	 */
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String role = new LoginProvider().login(authentication.getName(),
				(String) authentication.getCredentials());
		Collection<GrantedAuthority> authorities = loginService
				.getAuthorities(role);
		User appUser = new AppUser(authentication.getName(),
				(String) authentication.getCredentials(), true, true, true,
				true, authorities);
		return new UsernamePasswordAuthenticationToken(appUser,
				(String) authentication.getCredentials(), authorities);

	}

	/**
	 * Recupera supports
	 * 
	 * @return suporte true, sempre
	 */
	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}