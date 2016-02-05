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
 * <p>
 * <b> Permissao dos Funcionarios Service </b>
 * </p>
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
public interface PermissionEmployeeService extends
		GenericService<PermissionEmployee, Long> {

	/**
	 * Verifica acesso o usuario no sistema
	 * 
	 * @param matricula
	 *            matricula do usuario no sistema
	 * @return retorna true caso exista e false caso nao
	 */
	boolean verificaAcesso(@NotNull @NotEmpty String matricula);

	/**
	 * Seta DAO
	 * 
	 * @param dao
	 *            dao que sera setado
	 */
	void setDao(PermissionEmployeeDao dao);

	/**
	 * Busca usuario por matricula
	 * 
	 * @param matricula
	 *            matricula do usuario
	 * @return usuario buscado
	 */
	public PermissionEmployee buscaPorMatricula(
			@NotNull @NotEmpty String matricula);

}
