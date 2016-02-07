/**
 * 
 */
package br.com.iterativejr.domains.entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * <b> Questionário </b>
 * </p>
 *
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
@Entity 
@NamedQueries({@NamedQuery(name = "Questionnaire.searchAllQuestionsFromQuestionnaire", query = "SELECT questao from Questionnaire questionario inner join questionario.questions questao where questionario.id = :idQuestionnaire")})
public class Questionnaire extends EntidadeBasica {
// = 202
	/**
	 * Serial default do questionario
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Id da classe
	 */
	@Id
	@SequenceGenerator(name = "PE_PRDID_GENERATOR", sequenceName = "seq_questionnaire")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PE_PRDID_GENERATOR")
	@Column(name = "questionnaire_id")
	private Long id;
	/**
	 * Titulo da questao
	 */
	@NotNull
	@Column
	private String title;
	/**
	 * Questoes do questionario
	 */
	@ManyToMany (cascade=CascadeType.PERSIST)
	@JoinTable(name = "questionnaire_has_question", joinColumns = { @JoinColumn(name = "questionnaire_id") }, inverseJoinColumns = { @JoinColumn(name = "question_id") })
	private List<Question> questions;
	/**
	 * Publicado
	 */
	@NotNull
	@Column
	private Boolean published;
	/**
	 * Data De Publicacao
	 */
	@NotNull
	@Column
	private Date publicationDate;

	/**
	 * data De Conclusao
	 */
	@NotNull
	@Column
	private Date completionDate;

	/**
	 * Construtor Default
	 */
	public Questionnaire() {
		published = false;
	}

	/**
	 * Construtor com published
	 * 
	 * @param title
	 * @param published
	 * @param publicationDate
	 * @param completionDate
	 */
	public Questionnaire(String title, Boolean published, Date publicationDate,
			Date completionDate) {
		super();
		this.title = title;
		this.published = published;
		this.publicationDate = publicationDate;
		this.completionDate = completionDate;
	}
	
	/**
	 * Construtor sem published
	 * 
	 * @param title
	 * @param published
	 * @param publicationDate
	 * @param completionDate
	 */
	public Questionnaire(String title, Date publicationDate,
			Date completionDate) {
		super();
		this.title = title;
		this.published = false;
		this.publicationDate = publicationDate;
		this.completionDate = completionDate;
	}
	
	/**
	 * Construtor
	 * 
	 * @param title
	 * @param publicationDate
	 * @param completionDate
	 * @param questions
	 */
	public Questionnaire(String title, Date publicationDate,
			Date completionDate, List<Question> questions) {
		super();
		this.title = title;
		published = false;
		this.publicationDate = publicationDate;
		this.completionDate = completionDate;
		this.questions = questions;
	}

	/**
	 * Construtor full
	 * 
	 * @param title
	 * @param published
	 * @param publicationDate
	 * @param completionDate
	 * @param questions
	 */
	public Questionnaire(String title, Boolean published, Date publicationDate,
			Date completionDate, List<Question> questions) {
		super();
		this.title = title;
		this.published = published;
		this.publicationDate = publicationDate;
		this.completionDate = completionDate;
		this.questions = questions;
	}

	/**
	 * @see br.com.iterativejr.domains.entidade.EntidadeBasica#getId()
	 */
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the questions
	 */
	public List<Question> getQuestions() {
	return questions;
	}

	/**
	 * @param questions
	 *            the questions to set
	 */
	public void setQuestions(List<Question> questions) {
	this.questions = questions;
	}

	/**
	 * @return the published
	 */
	public Boolean getPublished() {
		return published;
	}

	/**
	 * @param published
	 *            the published to set
	 */
	public void setPublished(Boolean published) {
		this.published = published;
	}

	/**
	 * @return the publicationDate
	 */
	public Date getPublicationDate() {
		return publicationDate;
	}

	/**
	 * @param publicationDate
	 *            the publicationDate to set
	 */
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	/**
	 * @return the completionDate
	 */
	public Date getCompletionDate() {
		return completionDate;
	}

	/**
	 * @param completionDate
	 *            the completionDate to set
	 */
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Questionnaire [id=" + id + ", title=" + title + ", questions="
				+ "" + ", Published=" + published + ", publicationDate="
				+ publicationDate + ", completionDate=" + completionDate + "]";
	}

}
