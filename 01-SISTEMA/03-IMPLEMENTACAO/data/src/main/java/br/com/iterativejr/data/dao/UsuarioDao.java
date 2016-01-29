/**
 * 
 */
package br.com.iterativejr.data.dao;

import br.com.iterativejr.domains.entidade.Usuario;

/**
 * @author edsf
 *
 */
public interface UsuarioDao extends GenericDao<Usuario, Long>  {

	public Usuario buscarPorLogin(String login);
}
