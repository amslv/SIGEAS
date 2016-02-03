package br.com.iterativejr.service.negocio.impl;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.iterativejr.data.dao.PermissionEmployeeDao;
import br.com.iterativejr.domains.entidade.PermissionEmployee;
import br.com.iterativejr.service.negocio.PermissionEmployeeService;

@Validated
@Service("permissionEmployeeService")
public class PermissionEmployeeServiceImpl extends GenericServiceImpl<PermissionEmployee, Long> implements PermissionEmployeeService{

	@Autowired
	public PermissionEmployeeServiceImpl(PermissionEmployeeDao dao) {
		this.dao = dao;
	}
	
	@Override
	public boolean verificaAcesso(String matricula) {
		PermissionEmployeeDao permissionEmployeeDao= (PermissionEmployeeDao) this.dao;
		return permissionEmployeeDao.verificaAcesso(matricula);
	}

	public void setDao(PermissionEmployeeDao dao) {
		this.dao = dao;
	}

	@Override
	public PermissionEmployee buscaPorMatricula(String matricula) {
		PermissionEmployeeDao permissionEmployeeDao= (PermissionEmployeeDao) this.dao;
		return permissionEmployeeDao.buscaPorMatricula(matricula);
	}
}
