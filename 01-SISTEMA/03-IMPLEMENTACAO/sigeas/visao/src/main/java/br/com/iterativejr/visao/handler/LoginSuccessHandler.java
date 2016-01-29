package br.com.iterativejr.visao.handler;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import br.com.iterativejr.domains.entidade.Role;

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
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    RedirectStrategy redirect = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)  
            throws IOException, ServletException {
    	Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
    	String name = null;
    	for (GrantedAuthority grantedAuthority : authorities) {
			name = grantedAuthority.getAuthority();
		}
        redirect.sendRedirect(request, response, new Role(name).getName().getRedirectPage());
    }
}
