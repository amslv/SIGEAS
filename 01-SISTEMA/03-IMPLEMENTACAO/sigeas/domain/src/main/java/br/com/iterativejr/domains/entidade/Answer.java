package br.com.iterativejr.domains.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

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
 * @author <a href="https://github.com/LuizAntonioPS">Luiz Pereira</a>
 *
 */
@Entity
public class Answer extends EntidadeBasica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "PE_PRDID_GENERATOR", sequenceName = "seq_answer")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PE_PRDID_GENERATOR")
	@Column(name = "answer_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "inscription_id")
	private Inscription inscription;
	
	@NotNull
	@Column
	private Long idQuestion;
	
	@NotNull
	@Column
	private String body;
	
	@Column
	private Double punctuationOption;
	
	@Column
	private Double weightOfQuestion;
	
	public Answer() {
	}

	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Answer(Long idQuestion, String body) {
		super();
		this.idQuestion = idQuestion;
		this.body = body;
	}

	public Long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(Long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}

	public Double getPunctuationOption() {
		return punctuationOption;
	}

	public void setPunctuationOption(Double punctuationOption) {
		this.punctuationOption = punctuationOption;
	}

	public Double getWeightOfQuestion() {
		return weightOfQuestion;
	}

	public void setWeightOfQuestion(Double weightOfQuestion) {
		this.weightOfQuestion = weightOfQuestion;
	}
}
