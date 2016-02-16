/**
 * 
 */
package br.com.iterativejr.domains.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * <b> Opcao da questao </b>
 * </p>
 * 
 * Opcao da Questao
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
@Entity
@NamedQueries({@NamedQuery(name = "Option.searchOptionsByQuesting", query = "SELECT u FROM Option u where question_id = :idQuestao") })
public class Option extends EntidadeBasica {

	/**
	 * Serial da classe
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Corpo da questao
	 */
	@NotNull
	@Column
	private String body;

	/**
	 * Questão
	 * Anotacao ta no get
	 */
	 @ManyToOne
	 @JoinColumn(name="question_id", referencedColumnName="question_id")
	private Question question;
	/**
	 * pontuacao da opcao
	 */
	@NotNull
	@Column
	private Double punctuation;

	/**
	 * ela foi marcada
	 */
	@NotNull
	@Column
	private Boolean marked;

	/**
	 * ID da opcao
	 */
	@Id
	@SequenceGenerator(name = "PE_PRDID_GENERATOR", sequenceName = "seq_option")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PE_PRDID_GENERATOR")
	@Column(name = "option_id")
	private Long id;

	/**
	 * Construtor Default
	 */
	public Option() {
		marked = false;
	}

	/**
	 * Construtor com todos os parametros
	 * 
	 * @param body
	 *            corpo
	 * @param punctuation
	 *            pontuacao
	 * @param marked
	 *            marcada
	 */
	public Option(String body, Double punctuation, Boolean marked, Question question) {
		super();
		this.body = body;
		this.punctuation = punctuation;
		this.marked = marked;
		this.question = question;
	}

	/**
	 * @see br.com.iterativejr.domains.entidade.EntidadeBasica#getId()
	 */
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * Pega corpo
	 * 
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * seta corpo
	 * 
	 * @param body
	 *            the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * pega pontuacao
	 * 
	 * @return the punctuation
	 */
	public Double getPunctuation() {
		return punctuation;
	}

	/**
	 * seta pontuacao
	 * 
	 * @param punctuation
	 *            the punctuation to set
	 */
	public void setPunctuation(Double punctuation) {
		this.punctuation = punctuation;
	}

	/**
	 * Pega pontuacao
	 * 
	 * @return the marked
	 */
	public Boolean getMarked() {
		return marked;
	}

	/**
	 * Seta marcacao
	 * 
	 * @param marked
	 *            the marked to set
	 */
	public void setMarked(Boolean marked) {
		this.marked = marked;
	}
	
	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Option [body=" + body + ", punctuation=" + punctuation
				+ ", marked=" + marked + ", id=" + id + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Option)) {
			return false;
		} else {
			Option option = (Option) obj;
			if (!body.equals(option.getBody())) {
				return false;
			}
			return true;
		}
	}
	
}
