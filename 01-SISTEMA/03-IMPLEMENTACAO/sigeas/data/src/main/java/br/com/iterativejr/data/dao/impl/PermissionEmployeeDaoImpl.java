/**
 * 
 */
package br.com.iterativejr.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.iterativejr.data.dao.PermissionEmployeeDao;
import br.com.iterativejr.domains.entidade.PermissionEmployee;

import javax.persistence.Query;

/**
 * 
 * @author angus
 *
 */
@Repository("permissionEmployeeDao")
public class PermissionEmployeeDaoImpl extends GenericDaoImpl<PermissionEmployee, Long> implements PermissionEmployeeDao{

	/**
		UsuarioDao
	 * 
	 * @param login
	 * @return
	 */
	public boolean verificaAcesso(String matricula){
		Query query = this.entityManager
				.createNamedQuery("PermissionEmployee.verificarAcesso");
		query.setParameter("matricula", matricula);

		return query.getResultList().size() > 0;
	}

	/**
	 * 
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
