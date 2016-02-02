package br.com.iterativejr.visao.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import br.com.iterativejr.domains.entidade.PermissionEmployee;
import br.com.iterativejr.service.negocio.PermissionEmployeeService;

@Controller
@ManagedBean(name = "PemissionEmployee")
public class PermissionEmployeeController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PermissionEmployeeService employeeService;
	private PermissionEmployee permissionEmployee;
	
	@PostConstruct
	public void init() {
		permissionEmployee = new PermissionEmployee();
	}
	
	public void addEmployee(){
		employeeService.criar(permissionEmployee);
	}
	
	public void removeEmployee(){
		employeeService.apagar(permissionEmployee);
	}
	
	public List<PermissionEmployee> findAll(){
		return employeeService.buscarTodos();
	}

	public PermissionEmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(PermissionEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public PermissionEmployee getPermissionEmployee() {
		return permissionEmployee;
	}

	public void setPermissionEmployee(PermissionEmployee permissionEmployee) {
		this.permissionEmployee = permissionEmployee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
