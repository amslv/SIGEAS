/**
 * 
 */
package br.com.iterativejr.service.negocio;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.iterativejr.data.dao.PermissionEmployeeDao;
import br.com.iterativejr.domains.entidade.PermissionEmployee;

/**
 * 
 * @author angus
 *
 */
public interface PermissionEmployeeService extends GenericService<PermissionEmployee, Long> {

	/**
	 * @param usuario
	 * @return
	 */
	boolean verificaAcesso(@NotNull @NotEmpty String matricula);

	/**
	 * @param dao
	 */
	void setDao(PermissionEmployeeDao dao);
	
	/**
	 * 
	 * @param matricula
	 * @return
	 */
	public PermissionEmployee buscaPorMatricula (@NotNull @NotEmpty String matricula);

}
