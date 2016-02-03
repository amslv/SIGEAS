/**
 * 
 */
package br.com.iterativejr.domains.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author angus
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "PermissionEmployee.verificarAcesso", query = "SELECT 1 FROM PermissionEmployee u where u.matricula = :matricula"),
		@NamedQuery(name = "PermissionEmployee.buscaPorMatricula", query = "SELECT u FROM PermissionEmployee u where u.matricula = :matricula") })
public class PermissionEmployee extends EntidadeBasica {

	/**
	 * 
	 * @param id
	 * @param matricula
	 * @param nome
	 */
	public PermissionEmployee(Long id, String matricula, String nome) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
	}

	/**
	 * 
	 * @param matricula
	 * @param nome
	 */
	public PermissionEmployee(String matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
	}

	/**
	 * construtor
	 */
	public PermissionEmployee() {
	}

	/**
	 * serial
	 */
	private static final long serialVersionUID = -4718749697624442411L;

	/**
	 * id
	 */
	@Id
	@SequenceGenerator(name = "PE_PRDID_GENERATOR", sequenceName = "seq_permissionemployee")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PE_PRDID_GENERATOR")
	@Column(name = "permissionemployee_id")
	private Long id;

	/**
	 * matricula
	 */
	@NotNull
	@Column(name = "matricula", unique = true)
	private String matricula;

	/**
	 * nome
	 */
	@NotNull
	@Column(name = "nome")
	private String nome;

	/**
	 * 
	 * @param matricula
	 */
	public PermissionEmployee(String matricula) {
		super();
		this.matricula = matricula;
	}

	/**
	 * 
	 * @return
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * 
	 * @param matricula
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * to string
	 */
	@Override
	public String toString() {
		return "PermissionEmployee [matricula=" + matricula + "]";
	}

	/**
	 * pega id
	 */
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
