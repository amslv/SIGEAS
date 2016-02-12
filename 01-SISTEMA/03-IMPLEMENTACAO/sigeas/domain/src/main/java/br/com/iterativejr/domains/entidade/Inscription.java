/**
 * 
 */
package br.com.iterativejr.domains.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * <p>
 * <b> Título </b>
 * </p>
 *
 * <p>
 * Descrição
 * </p>
 * 
 * <pre>
 * @see <a href="http://www.linkreferencia.com">Link de Referencia</a>
 * </pre>
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
// buscar todos questionarios respondidos por Questionário
// verificar se o aluno já respondeu o questionário
@Entity
public class Inscription extends EntidadeBasica {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5928272695044108989L;

	@Id
	@SequenceGenerator(name = "PE_PRDID_GENERATOR", sequenceName = "seq_inscription")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PE_PRDID_GENERATOR")
	@Column(name = "inscription_id")
	private Long id;
	@Column
	private Long idQuestionnaire;
	
	@Column
	private String answers;
	
	@Column
	private String registration;

	/**
	 * @param questionnaire
	 * @param student
	 */
	public Inscription(Long idQuestionnaire, String answers) {
		super();
		this.answers = answers;
		this.idQuestionnaire = idQuestionnaire;
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    registration = user.getUsername(); 
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see br.com.iterativejr.domains.entidade.EntidadeBasica#getId()
	 */
	@Override
	public Long getId() {
		return id;
	}

	

	/**
	 * @return the idQuestionnaire
	 */
	public Long getIdQuestionnaire() {
		return idQuestionnaire;
	}

	/**
	 * @param idQuestionnaire the idQuestionnaire to set
	 */
	public void setIdQuestionnaire(Long idQuestionnaire) {
		this.idQuestionnaire = idQuestionnaire;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Inscription [id=" + id + ", questionnaire=" + idQuestionnaire
				+ ", registration=" + registration + "]";
	}

	/**
	 * @return the registration
	 */
	public String getRegistration() {
		return registration;
	}

	/**
	 * @param registration
	 *            the registration to set
	 */
	public void setRegistration(String registration) {
		this.registration = registration;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the answers
	 */
	public String getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(String answers) {
		this.answers = answers;
	}



	
}
