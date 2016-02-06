/**
 * 
 */
package br.com.iterativejr.visao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import br.com.iterativejr.domains.entidade.Question;
import br.com.iterativejr.domains.entidade.Questionnaire;
import br.com.iterativejr.service.negocio.QuestionnaireService;

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
@Controller 
@ManagedBean (name="questionnaireController")
@RequestScoped
public class QuestionnaireController {
	
	@Autowired
	@Qualifier("questionnaireService")
	private QuestionnaireService questionnaireService;
	
	private List<Question> questions;
	
	private Question question;
	
	private Questionnaire questionnaire; 
	
	/**
	 * Inicia dados
	 */
	@PostConstruct
	public void init() {
		questions= new ArrayList<Question>();
		question = new Question();
		questionnaire = new Questionnaire();
	}
	
	public void addQuestion() {
		System.out.println("Passou");
		System.out.println(question.getTitle());
		questions.add(question);
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}
