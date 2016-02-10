/**
 * 
 */
package br.com.iterativejr.visao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import br.com.iterativejr.domains.entidade.Option;
import br.com.iterativejr.domains.entidade.Question;
import br.com.iterativejr.domains.entidade.Questionnaire;
import br.com.iterativejr.domains.entidade.enums.QuestionTypeEnum;
import br.com.iterativejr.service.negocio.QuestionnaireService;
import br.com.iterativejr.service.negocio.legacies.validations.SigeasException;
import br.com.iterativejr.visao.controller.util.JsfUtil;

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
@ManagedBean(name = "questionnaireController")
@ViewScoped
public class QuestionnaireController {

	@Autowired
	@Qualifier("questionnaireService")
	private QuestionnaireService questionnaireService;

	private List<Question> questions;
	
	private Question question;
	
	private List<Option> optionsOfQuestion;
	
	private Option option;

	private Questionnaire questionnaire;

	private QuestionTypeEnum[] typesQuestion;
	
	private List<Questionnaire> questionnaires;

	/**
	 * Inicia dados
	 */
	@PostConstruct
	public void init() {
		questions = new ArrayList<Question>();
		optionsOfQuestion = new ArrayList<Option>();
		question = new Question();
		option = new Option();
		questionnaire = new Questionnaire();
		typesQuestion = QuestionTypeEnum.values();
		questionnaires = findAll();
	}

	public void addQuestion() {
		try {
			questionnaireService.addQuestionInQuestionnaire(questionnaire, question);
			questions.add(question);
			question = new Question();
		} catch (SigeasException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void addOption() {
		try {
			questionnaireService.addOptionInQuestion(question, option);
			option.setQuestion(question);
			optionsOfQuestion.add(option);
			option = new Option();
		} catch (SigeasException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	public void removeQuestion(Question question) {
		questions.remove(question);
		questionnaire.removeQuestion(question);
		this.question = new Question();
	}
	
	public void removeOption(Option option) {
		optionsOfQuestion.remove(option);
		question.removeOption(option);
		this.option = new Option();
	}

	public void addQuestionnaire() {
		try {
			questionnaire.setQuestions(questions);
			questionnaireService.criar(questionnaire);
			restartQuestionnaire();
			questionnaires = findAll();
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	public void setaObjeto (Questionnaire questionnaire){
		List<Question> searchAllQuestionsFromQuestionnaire = questionnaireService.searchAllQuestionsFromQuestionnaire(questionnaire.getId());
		for (Question question : searchAllQuestionsFromQuestionnaire) {
			question.setOptions(questionnaireService.searchOptionsByQuesting(question.getId()));;
		}
		try {
			questionnaire.setQuestions(searchAllQuestionsFromQuestionnaire);
			QUESTION = questionnaire;
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void removeQuestionnaire(Questionnaire questionnaire) {
		questionnaireService.apagar(questionnaire);
		questionnaires = findAll();
	}
	
	private List<Questionnaire> findAll() {
		return questionnaireService.buscarTodos();
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

	public QuestionTypeEnum[] getTypesQuestion() {
		return typesQuestion;
	}

	public void setTypesQuestion(QuestionTypeEnum[] typesQuestion) {
		this.typesQuestion = typesQuestion;
	}

	public List<Questionnaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(List<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}
	
	public void publicQuestionnaire(Questionnaire questionnaire) {
		this.questionnaireService.publicQuestionnaire(questionnaire);
	}

	private void restartQuestionnaire() {
		questionnaire = new Questionnaire();
		questions = new ArrayList<Question>();
		optionsOfQuestion = new ArrayList<Option>();
		question = new Question();
		option = new Option();
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public List<Option> getOptions() {
		return optionsOfQuestion;
	}

	public void setOptions(List<Option> options) {
		this.optionsOfQuestion = options;
	}
	public static Questionnaire QUESTION;
}
