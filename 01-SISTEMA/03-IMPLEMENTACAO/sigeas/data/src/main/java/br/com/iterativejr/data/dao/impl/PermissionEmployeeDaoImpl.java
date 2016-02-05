package br.com.iterativejr.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.iterativejr.data.dao.PermissionEmployeeDao;
import br.com.iterativejr.domains.entidade.PermissionEmployee;

import javax.persistence.Query;

/**
 * 
 * <p>
 * <b> Implementacao do DAO Permissao de Usuarios </b>
 * </p>
 *
 * <p>
 * Classe responsavel por adicionar novas funcoes no generico dao
 * </p>
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
@Repository("permissionEmployeeDao")
public class PermissionEmployeeDaoImpl extends GenericDaoImpl<PermissionEmployee, Long> implements PermissionEmployeeDao{

	/**
	 * Verifica acesso do usuario
	 * 
	 * @param matricula matricula do usuario que sera verificado
	 * @return true caso tenha acesso e false caso nao
	 */
	public boolean verificaAcesso(String matricula){
		Query query = this.entityManager
				.createNamedQuery("PermissionEmployee.verificarAcesso");
		query.setParameter("matricula", matricula);

		return query.getResultList().size() > 0;
	}

	/**
	 * Busca por matricula
	 * 
	 * @param matricula matricula do usuario que sera buscado
	 * @return usuario encontrado
	 */
	@Override
	public PermissionEmployee buscaPorMatricula(String matricula) {
		Query query = this.entityManager.createNamedQuery("PermissionEmployee.buscaPorMatricula");
		query.setParameter("matricula", matricula);

		@SuppressWarnings("unchecked")
		List<PermissionEmployee> permissions = query.getResultList();

		PermissionEmployee resultado = permissions.isEmpty() ? null : permissions.get(0);

		return resultado;
	}

}
