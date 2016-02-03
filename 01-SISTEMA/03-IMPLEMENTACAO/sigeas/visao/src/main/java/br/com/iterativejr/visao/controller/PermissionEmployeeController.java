package br.com.iterativejr.visao.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
	
	/**
	 * Atributo nome de PermissionEmployee
	 */
	private String nome;
	
	/**
	 * Atributo matrícula de PermissionEmployee
	 */
	private String matricula;
	
	/**
	 * Lista de PermissionsEmployee
	 */
	private List<PermissionEmployee> permissionsEmployee;
	
	/**
	 * Camada de serviço do PermissionEmployee
	 */
	@Autowired
	private PermissionEmployeeService employeeService;
		
	@PostConstruct
	public void init() {
		permissionsEmployee=findAll();
	}
	
	/**
	 * Apagar Employee
	 * 
	 * @param employee
	 */
	public void removeEmployee(PermissionEmployee employee){
		employeeService.apagar(employee);
		permissionsEmployee=findAll();
	}
	
	/**
	 * Encontrar todos os PermissionEmployee cadastrados no sistema
	 * 
	 * @return
	 * 		Todos os PermissionEmployee cadastrados no sistema
	 */
	public List<PermissionEmployee> findAll(){
		return employeeService.buscarTodos();
	}

	/**
	 * Retorna PermissionEmployee
	 * 
	 */
	public PermissionEmployeeService getEmployeeService() {
		return employeeService;
	}

	/**
	 * Modifica EmployeeService
	 * 
	 * @param employeeService
	 */
	public void setEmployeeService(PermissionEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 * Retorna Serialversionuid
	 * 
	 * @return
	 * 		Serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Retorna PermissionsEmployee
	 * @return
	 * 		PermissionsEmployee
	 */
	public List<PermissionEmployee> getPermissionsEmployee() {
		return permissionsEmployee;
	}

	/**
	 * Modifica PermissionsEmployee
	 * 
	 * @param permissionsEmployee
	 */
	public void setPermissionsEmployee(List<PermissionEmployee> permissionsEmployee) {
		this.permissionsEmployee = permissionsEmployee;
	}

	/**
	 * Retorna nome
	 * @return
	 * 		nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Modifica nome
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Adciona Employee
	 */
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
	
	/**
	 * Retorna matrícula
	 * 
	 * @param matricula
	 */
	public String getMatricula() {
		return matricula;
	}
	
	/**
	 * Modifica matrícula
	 * 
	 * @param matricula
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
