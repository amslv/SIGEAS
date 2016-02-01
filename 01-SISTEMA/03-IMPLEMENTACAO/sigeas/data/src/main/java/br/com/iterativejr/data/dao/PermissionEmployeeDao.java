/**
 * 
 */
package br.com.iterativejr.data.dao;

import javax.validation.constraints.NotNull;

import br.com.iterativejr.domains.entidade.PermissionEmployee;

/**
 * 
 * @author angus
 *
 */
public interface PermissionEmployeeDao extends GenericDao<PermissionEmployee, Long>{

	/**
	 * 
	 * @param matricula
	 * @return
	 */
	boolean verificaAcesso(@NotNull String matricula);
	
	/**
	 * 
	 * @param matricula
	 * @return
	 */
	PermissionEmployee buscaPorMatricula (String matricula);
	
}
