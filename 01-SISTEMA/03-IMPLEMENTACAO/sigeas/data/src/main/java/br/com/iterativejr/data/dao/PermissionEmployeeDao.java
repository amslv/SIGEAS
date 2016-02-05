package br.com.iterativejr.data.dao;

import javax.validation.constraints.NotNull;

import br.com.iterativejr.domains.entidade.PermissionEmployee;

/**
 * 
 * <p>
 * <b> Permissao para Funcionarios DAO </b>
 * </p>
 *
 * <p>
 * Mantem funcinarios que terao acesso ao sistema.
 * </p>
 * 
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
public interface PermissionEmployeeDao extends
		GenericDao<PermissionEmployee, Long> {

	/**
	 * 
	 * Verifica se o usuario tem acesso ao sistema
	 * 
	 * @param matricula
	 *            matricula não nula do usuario que sera verificado
	 * @return true se ele tiver acesou ou false caso nao
	 */
	boolean verificaAcesso(@NotNull String matricula);

	/**
	 * Busca um usuário atraves da matricula
	 * 
	 * @param matricula
	 *            matricula do usuario que sera buscado
	 * @return retorna o usuario
	 */
	PermissionEmployee buscaPorMatricula(String matricula);

}
