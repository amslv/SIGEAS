package br.com.iterativejr.visao.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.iterativejr.domains.entidade.PermissionEmployee;
import br.com.iterativejr.service.negocio.PermissionEmployeeService;
import br.com.iterativejr.visao.controller.util.JsfUtil;

/**
 * 
 * <p>
 * <b> Controller Permissao da assistente</b>
 * </p>
 *
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
@Controller
@ManagedBean
@RequestScoped
public class PermissionEmployeeController {

	/**
	 * Serial da classe
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
		
	/**
	 * Inicia dados
	 */
	@PostConstruct
	public void init() {
		permissionsEmployee=findAll();
	}
	
	/**
	 * Apagar Employee
	 * 
	 * @param employee funcao
	 */
	public void removeEmployee(PermissionEmployee employee){
		employeeService.apagar(employee);
		permissionsEmployee=findAll();
		JsfUtil.addSuccessMessage("Usuário removido com sucesso.");
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
	 * @return service
	 */
	public PermissionEmployeeService getEmployeeService() {
		return employeeService;
	}

	/**
	 * Modifica EmployeeService
	 * 
	 * @param employeeService seta service
	 */
	public void setEmployeeService(PermissionEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 * Retorna Serialversionuid
	 * 
	 * @return
	 * 		Serialversionuid serial
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Retorna PermissionsEmployee
	 * @return
	 * 		PermissionsEmployee todos os emp
	 */
	public List<PermissionEmployee> getPermissionsEmployee() {
		return permissionsEmployee;
	}

	/**
	 * Modifica PermissionsEmployee
	 * 
	 * @param permissionsEmployee seta employ
	 */
	public void setPermissionsEmployee(List<PermissionEmployee> permissionsEmployee) {
		this.permissionsEmployee = permissionsEmployee;
	}

	/**
	 * Retorna nome
	 * @return
	 * 		nome nome do camarada
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Modifica nome
	 * @param nome nome do camarada
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Adciona Employee e valida
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
			JsfUtil.addSuccessMessage("Usuário cadastrado com sucesso.");
		}else{
			JsfUtil.addErrorMessage("Usuário já cadastrado");
		}
	}
	
	/**
	 * Retorna matrícula
	 * 
	 * @param matricula matricula recuperada
	 */
	public String getMatricula() {
		return matricula;
	}
	
	/**
	 * Modifica matrícula
	 * 
	 * @param matricula nova matricula
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}