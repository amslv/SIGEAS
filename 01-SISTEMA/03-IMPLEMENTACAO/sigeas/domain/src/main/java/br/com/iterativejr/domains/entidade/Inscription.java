/**
 * 
 */
package br.com.iterativejr.domains.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

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
@Entity
@NamedQueries({
		@NamedQuery(name = "Inscription.getInscriptionsOfUser", query = "SELECT u FROM Inscription u WHERE u.registration = :registration"),
		@NamedQuery(name = "Inscription.getInscriptionsOfQuestionnaire", query = "SELECT u FROM Inscription u WHERE u.idQuestionnaire = :idQuestionnaire"),
		@NamedQuery(name = "Inscription.studentAlreadyAnswered", query = "SELECT count(*) FROM Inscription u where u.registration = :registration and u.idQuestionnaire = :idQuestionnaire"),
		@NamedQuery(name = "Inscription.questionnairesAnswered", query = "SELECT u.idQuestionnaire FROM Inscription u where u.registration = :registration"),
		@NamedQuery(name = "Inscription.inscriptionsOfQuestionnaire", query = "SELECT u.registration FROM Inscription u where u.idQuestionnaire = :idQuestionnaire"),
		@NamedQuery(name = "Inscription.deleteAnswers", query = "DELETE FROM Answer WHERE inscription_id=(SELECT u.id FROM Inscription u WHERE u.registration = :registration and u.idQuestionnaire = :idQuestionnaire)"),
		@NamedQuery(name = "Inscription.cancelarInscricao", query = "DELETE FROM Inscription u WHERE u.registration = :registration and u.idQuestionnaire = :idQuestionnaire"),
		@NamedQuery(name = "Inscription.searchForQuestionnaireAndRegistration", query = "SELECT u FROM Inscription u WHERE u.registration = :registration and u.idQuestionnaire = :idQuestionnaire"),
		@NamedQuery(name = "Inscription.selectAnswers", query ="SELECT u FROM Answer u WHERE u.inscription = (SELECT i.id FROM Inscription i WHERE i.registration = :registration and i.idQuestionnaire = :idQuestionnaire)")})
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

	@NotNull
	@Column
	private Long idQuestionnaire;
	
	@NotNull
	@Column
	private String registration;
	
	@Column
	private Double punctuation;
	
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "inscription", fetch=FetchType.EAGER)
	private List<Answer> answers;

	/**
	 * @param questionnaire
	 * @param student
	 */
	public Inscription() {
		super();
	}

	public Inscription(Long idQuestionnaire) {
		super();
		this.idQuestionnaire = idQuestionnaire;
		this.registration = getActualRegistration();
	}



	private String getActualRegistration() {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		return user.getUsername();
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
	 * @param idQuestionnaire
	 *            the idQuestionnaire to set
	 */
	public void setIdQuestionnaire(Long idQuestionnaire) {
		this.registration = getActualRegistration();
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

	public Double getPunctuation() {
		return punctuation;
	}

	public void setPunctuation(Double punctuation) {
		this.punctuation = punctuation;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}
