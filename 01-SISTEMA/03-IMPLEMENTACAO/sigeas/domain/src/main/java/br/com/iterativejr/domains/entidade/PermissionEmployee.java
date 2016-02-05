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
 * <p>
 * <b> Permissao para Assitentes Sociais </b>
 * </p>
 *
 * <p>
 * Classe reponsavel por manter dados necessarios para o acesso
 * </p>
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "PermissionEmployee.verificarAcesso", query = "SELECT 1 FROM PermissionEmployee u where u.matricula = :matricula"),
		@NamedQuery(name = "PermissionEmployee.buscaPorMatricula", query = "SELECT u FROM PermissionEmployee u where u.matricula = :matricula") })
public class PermissionEmployee extends EntidadeBasica {

	/**
	 * Construtor full
	 * 
	 * @param id
	 *            id do camarada
	 * @param matricula
	 *            matricula do suap
	 * @param nome
	 *            nome ou apelido
	 */
	public PermissionEmployee(Long id, String matricula, String nome) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
	}

	/**
	 * Construtor matricula e nome
	 * 
	 * @param matricula
	 *            matricula do suap
	 * @param nome
	 *            nome ou apelido
	 */
	public PermissionEmployee(String matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
	}

	/**
	 * construstor default
	 */
	public PermissionEmployee() {
	}

	/**
	 * serial da classe
	 */
	private static final long serialVersionUID = -4718749697624442411L;

	/**
	 * Id unico do usuario
	 */
	@Id
	@SequenceGenerator(name = "PE_PRDID_GENERATOR", sequenceName = "seq_permissionemployee")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PE_PRDID_GENERATOR")
	@Column(name = "permissionemployee_id")
	private Long id;

	/**
	 * Matricula nao nula e unica
	 */
	@NotNull
	@Column(name = "matricula", unique = true)
	private String matricula;

	/**
	 * Nmoe do camarada
	 */
	@NotNull
	@Column(name = "nome")
	private String nome;

	/**
	 * Construtor so com matricula
	 * 
	 * @param matricula
	 *            do suap
	 */
	public PermissionEmployee(String matricula) {
		super();
		this.matricula = matricula;
	}

	/**
	 * pega matricula
	 * 
	 * @return matricula pega matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * seta matricula
	 * 
	 * @param matricula
	 *            nova matricula
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * transforma em string
	 * 
	 * @return string do obj
	 */
	@Override
	public String toString() {
		return "PermissionEmployee [matricula=" + matricula + "]";
	}

	/**
	 * Pega id
	 * 
	 * @return id recuperado
	 */
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * Pega nome
	 * 
	 * @return nome recuperado
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Seta nome
	 * 
	 * @param nome
	 *            novo nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Seta id
	 * 
	 * @param novo
	 *            id
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
