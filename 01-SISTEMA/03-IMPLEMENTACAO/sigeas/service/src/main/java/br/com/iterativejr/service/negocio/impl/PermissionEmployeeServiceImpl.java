package br.com.iterativejr.service.negocio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.iterativejr.data.dao.PermissionEmployeeDao;
import br.com.iterativejr.domains.entidade.PermissionEmployee;
import br.com.iterativejr.service.negocio.PermissionEmployeeService;

/**
 * 
 * <p>
 * <b> Implementacao do Service da Permissao do Usuario </b>
 * </p>
 *
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
@Validated
@Service("permissionEmployeeService")
public class PermissionEmployeeServiceImpl extends GenericServiceImpl<PermissionEmployee, Long> implements PermissionEmployeeService{

	/**
	 * Contrutor para setar o DAO
	 * @param dao do que sera setado
	 */
	@Autowired
	public PermissionEmployeeServiceImpl(PermissionEmployeeDao dao) {
		this.dao = dao;
	}
	
	/**
	 * Verifica acesso de determinado empregado
	 * @param matricula matricula que sera verificada
	 * @return true caso exista ou false
	 */
	@Override
	public boolean verificaAcesso(String matricula) {
		PermissionEmployeeDao permissionEmployeeDao= (PermissionEmployeeDao) this.dao;
		return permissionEmployeeDao.verificaAcesso(matricula);
	}

	/**
	 * Seta dao
	 * 
	 * @param dao Novo dao
	 */
	public void setDao(PermissionEmployeeDao dao) {
		this.dao = dao;
	}

	/**
	 * Realiza busca por matrícula
	 * @param matricula matricula que sera buscada
	 * @return usuario buscado pela matricula
	 */
	@Override
	public PermissionEmployee buscaPorMatricula(String matricula) {
		PermissionEmployeeDao permissionEmployeeDao= (PermissionEmployeeDao) this.dao;
		return permissionEmployeeDao.buscaPorMatricula(matricula);
	}
}
