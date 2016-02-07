/**
 * 
 */
package br.com.iterativejr.domains.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import br.com.iterativejr.domains.entidade.enums.QuestionTypeEnum;

/**
 * <p>
 * <b> Questão do QUestionário </b>
 * </p>
 *
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Question.searchAllQuestions", query = "SELECT u FROM Question u") })
public class Question extends EntidadeBasica {

	/**
	 * Serial da questao
	 */
	private static final long serialVersionUID = -7712489433701500404L;

	/**
	 * Id da questao
	 */
	@Id
	@SequenceGenerator(name = "PE_PRDID_GENERATOR", sequenceName = "seq_question")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PE_PRDID_GENERATOR")
	@Column(name = "question_id")
	private Long id;

	/**
	 * questionario
	 */
	// private Questionnaire questionnaire;

	/**
	 * Titulo da questão
	 */
	@NotNull
	@Column
	private String title;
	/**
	 * Texto de ajuda
	 */
	@Column
	private String helpText;
	/**
	 * Tipo da questao
	 */
	@NotNull
	@Enumerated(EnumType.STRING)
	private QuestionTypeEnum type;
	/**
	 * Opcoes da questao
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Option> options = new ArrayList<Option>();
	/**
	 * Eh obrigatoria?
	 */
	@NotNull
	@Column
	private Boolean obligatory;
	/**
	 * Peso da questao
	 */
	@NotNull
	@Column
	private Double weightOfQuestion;

	/**
	 * Construtor Default
	 */
	public Question() {
	}

	/**
	 * Construtor com todos os atributos
	 * 
	 * @param title
	 *            titulo da questao
	 * @param helpText
	 *            texto de ajuda
	 * @param type
	 *            tipo da questao
	 * @param options
	 *            opcoes
	 * @param obligatory
	 *            obrigatorio
	 * @param weightOfQuestion
	 *            peso
	 */
	public Question(String title, String helpText, Boolean obligatory,
			Double weightOfQuestion) {
		super();
		this.title = title;
		this.helpText = helpText;
		this.type = type;
		// this.options = options;
		this.obligatory = obligatory;
		this.weightOfQuestion = weightOfQuestion;
	}

	/**
	 * Construtor sem o texto de ajuda e opcoes
	 * 
	 * @param title
	 *            titulo da questao
	 * @param type
	 *            tipo da questao
	 * @param obligatory
	 *            obrigatorio
	 * @param weightOfQuestion
	 *            peso
	 */
	public Question(String title, Boolean obligatory, Double weightOfQuestion,
			QuestionTypeEnum type) {
		super();
		this.title = title;
		this.type = type;
		this.obligatory = obligatory;
		this.weightOfQuestion = weightOfQuestion;
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
	 * @return the helpText
	 */
	public String getHelpText() {
		return helpText;
	}

	/**
	 * @param helpText
	 *            the helpText to set
	 */
	public void setHelpText(String helpText) {
		this.helpText = helpText;
	}

	/**
	 * @return the type
	 */
	// public QuestionTypeEnum getType() {
	// return type;
	// }

	/**
	 * @param type
	 *            the type to set
	 */
	// public void setType(QuestionTypeEnum type) {
	// this.type = type;
	// }

	/**
	 * @return the options
	 */
	public List<Option> getOptions() {
		return options;
	}

	/**
	 * @param options
	 *            the options to set
	 */
	public void setOptions(List<Option> options) {
		this.options = options;
	}

	/**
	 * @return the obligatory
	 */
	public Boolean getObligatory() {
		return obligatory;
	}

	/**
	 * @param obligatory
	 *            the obligatory to set
	 */
	public void setObligatory(Boolean obligatory) {
		this.obligatory = obligatory;
	}

	/**
	 * @return the weightOfQuestion
	 */
	public Double getWeightOfQuestion() {
		return weightOfQuestion;
	}

	/**
	 * @param weightOfQuestion
	 *            the weightOfQuestion to set
	 */
	public void setWeightOfQuestion(Double weightOfQuestion) {
		this.weightOfQuestion = weightOfQuestion;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the questionnaire
	 */
	// @ManyToOne
	// @JoinColumn(name="questionnaire_id")
	// public Questionnaire getQuestionnaire() {
	// return questionnaire;
	// }

	/**
	 * @param questionnaire
	 *            the questionnaire to set
	 */
	// public void setQuestionnaire(Questionnaire questionnaire) {
	// this.questionnaire = questionnaire;
	// }

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", helpText="
				+ helpText + ", type=" + "" + ", options=" + ""
				+ ", obligatory=" + obligatory + ", weightOfQuestion="
				+ weightOfQuestion + "]";
	}

	/**
	 * 
	 */
	public void addOption(Option option) {
		options.add(option);
	}

	public QuestionTypeEnum getType() {
		return type;
	}

	public void setType(QuestionTypeEnum type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Question)) {
			return false;
		} else {
			Question question = (Question) obj;
			if (!title.equals(question.getTitle())) {
				return false;
			}
			if (!type.equals(question.getType())) {
				return false;
			}
			if (!obligatory.equals(question.getObligatory())) {
				return false;
			}
			if (!weightOfQuestion.equals(question.getWeightOfQuestion())) {
				return false;
			}
			return true;
		}

	}
}
