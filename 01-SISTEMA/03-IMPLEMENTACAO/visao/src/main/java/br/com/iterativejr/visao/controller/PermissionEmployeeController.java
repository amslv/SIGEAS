package br.com.iterativejr.visao.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.iterativejr.domains.entidade.PermissionEmployee;
import br.com.iterativejr.service.negocio.PermissionEmployeeService;

@Controller
@ManagedBean
@RequestScoped
public class PermissionEmployeeController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String matricula;
	
	private List<PermissionEmployee> permissionsEmployee;
	
	@Autowired
	private PermissionEmployeeService employeeService;
		
	@PostConstruct
	public void init() {
		permissionsEmployee=findAll();
	}
	
	public void removeEmployee(PermissionEmployee employee){
		employeeService.apagar(employee);
		permissionsEmployee=findAll();
	}
	
	public List<PermissionEmployee> findAll(){
		System.out.println(employeeService.buscarTodos());
		return employeeService.buscarTodos();
	}

	public PermissionEmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(PermissionEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<PermissionEmployee> getPermissionsEmployee() {
		return permissionsEmployee;
	}

	public void setPermissionsEmployee(List<PermissionEmployee> permissionsEmployee) {
		this.permissionsEmployee = permissionsEmployee;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void addEmployee(){
		boolean contem= false;
		for (PermissionEmployee permissionEmployee : permissionsEmployee) {
			if (permissionEmployee.getMatricula().equals(matricula)){
				contem =true;
			}
		}
		if (!contem){
			employeeService.criar(new PermissionEmployee(matricula, nome));
			permissionsEmployee=findAll();
		}
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
	
}
