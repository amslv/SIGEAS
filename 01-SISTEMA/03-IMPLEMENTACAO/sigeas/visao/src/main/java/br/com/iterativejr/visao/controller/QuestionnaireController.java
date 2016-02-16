/**
 * 
 */
package br.com.iterativejr.visao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;
import org.primefaces.extensions.model.dynaform.DynaFormControl;
import org.primefaces.extensions.model.dynaform.DynaFormLabel;
import org.primefaces.extensions.model.dynaform.DynaFormModel;
import org.primefaces.extensions.model.dynaform.DynaFormRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import br.com.iterativejr.domains.entidade.Answer;
import br.com.iterativejr.domains.entidade.Inscription;
import br.com.iterativejr.domains.entidade.Option;
import br.com.iterativejr.domains.entidade.Question;
import br.com.iterativejr.domains.entidade.Questionnaire;
import br.com.iterativejr.domains.entidade.enums.QuestionTypeEnum;
import br.com.iterativejr.service.negocio.InscriptionService;
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
 * @author <a href="https://github.com/LuizAntonioPS">Luiz Antonio</a>
 *
 */
@Controller
@ManagedBean(name = "questionnaireController")
@ViewScoped
public class QuestionnaireController {

	@Autowired
	@Qualifier("questionnaireService")
	private QuestionnaireService questionnaireService;

	@Autowired
	@Qualifier("inscriptionService")
	private InscriptionService inscriptionService;

	private List<Question> questions;

	private Question question;

	private DynaFormModel model = new DynaFormModel();;

	private List<Option> optionsOfQuestion;

	private Option option;

	private Questionnaire questionnaire;

	private Questionnaire questionnaireSected;

	private QuestionTypeEnum[] typesQuestion;

	private List<Questionnaire> questionnaires;

	private Inscription inscription;

	private List<Inscription> inscriptionsWithPunctuation;

	private List<Answer> answersOfInscriptions;

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
		inscription = new Inscription();
	}

	public void addQuestion() {
		try {
			questionnaireService.addQuestionInQuestionnaire(questionnaire,
					question);
			questions.add(question);
			restartQuestion();
			JsfUtil.addSuccessMessage("Pergunta adicionada com sucesso");
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
			JsfUtil.addSuccessMessage("Opção adicionada com sucesso");
		} catch (SigeasException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	public void removeQuestion(Question question) {
		questions.remove(question);
		questionnaire.removeQuestion(question);
		this.question = new Question();
		JsfUtil.addSuccessMessage("Pergunta removida com sucesso");
	}

	public void removeOption(Option option) {
		optionsOfQuestion.remove(option);
		question.removeOption(option);
		this.option = new Option();
		JsfUtil.addSuccessMessage("Opção removida com sucesso");
	}

	public String addQuestionnaire() {
		String pag = "";
		try {
			questionnaire.setQuestions(questions);
			questionnaireService.validaDatas(questionnaire);
			questionnaireService.criar(questionnaire);
			pag = restartQuestionnaire();
			questionnaires = findAll();
			JsfUtil.addSuccessMessage("Questionário adicionado com sucesso");
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
		return pag;
	}

	public void setaObjeto(Questionnaire questionnaire) {
		List<Question> searchAllQuestionsFromQuestionnaire = questionnaireService
				.searchAllQuestionsFromQuestionnaire(questionnaire.getId());
		for (Question question : searchAllQuestionsFromQuestionnaire) {
			question.setOptions(questionnaireService
					.searchOptionsByQuesting(question.getId()));
		}
		try {
			questionnaire.setQuestions(searchAllQuestionsFromQuestionnaire);
			QUESTION = questionnaire;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Questionnaire> getAllPublished() {
		return questionnaireService.searchAllQuestinnairesPublished();
	}

	public void removeQuestionnaire(Questionnaire questionnaire) {
		if (!questionnaire.getPublished()) {
			questionnaireService.apagar(questionnaire);
			inscriptionService.cancelInscriptionsOfQuestionnaire(questionnaire
					.getId());
			questionnaires = findAll();
			JsfUtil.addSuccessMessage("Questionário removido com sucesso");
		} else {
			JsfUtil.addErrorMessage("Não é possível remover um questionário durante seu período de publicação.");
		}
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
		try {
			this.questionnaireService.publicQuestionnaire(questionnaire);
		} catch (SigeasException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	private String restartQuestionnaire() {
		questionnaire = new Questionnaire();
		questions = new ArrayList<Question>();
		optionsOfQuestion = new ArrayList<Option>();
		question = new Question();
		option = new Option();
		return "questionnaires.xhtml";
	}

	private void restartQuestion() {
		question = new Question();
		optionsOfQuestion = new ArrayList<Option>();
		option = new Option();
	}

	public Option getOption() {
		return option;
	}

	public List<Inscription> getPreClassification(Questionnaire questionnaire) {
		inscriptionsWithPunctuation = null;
		inscriptionsWithPunctuation = inscriptionService
				.getPreClassification(questionnaire.getId());
		return inscriptionsWithPunctuation;
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

	public DynaFormModel getModel() {
		return model;
	}

	public List<QuestionProperty> getquestionProperties() {

		if (model == null) {
			return null;
		}

		List<QuestionProperty> questionProperties = new ArrayList<QuestionProperty>();
		for (DynaFormControl dynaFormControl : model.getControls()) {

			questionProperties
					.add((QuestionProperty) dynaFormControl.getData());
		}

		return questionProperties;
	}

	public String submitForm() {
		FacesMessage.Severity sev = FacesContext.getCurrentInstance()
				.getMaximumSeverity();
		boolean hasErrors = (sev != null && (FacesMessage.SEVERITY_ERROR
				.compareTo(sev) >= 0));

		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.addCallbackParam("isValid", !hasErrors);

		List<QuestionProperty> getquestionProperties = getquestionProperties();
		List<Answer> answers = setPropQuestionnaire(getquestionProperties);
		inscription.setIdQuestionnaire(questionnaireSected.getId());
		inscription.setAnswers(answers);
		saveInscription(inscription);
		return "inscriptions.html";
	}

	private void saveInscription(Inscription inscription) {
		try {
			inscriptionService.studentAlreadyAnswered(
					inscription.getRegistration(),
					inscription.getIdQuestionnaire());
			inscription.setId(null);
			inscriptionService.criar(inscription);
			JsfUtil.addSuccessMessage("Inscrição realizada com sucesso");
		} catch (Exception e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}

	/**
	 * @param getquestionProperties
	 * @return
	 */
	private List<Answer> setPropQuestionnaire(
			List<QuestionProperty> getquestionProperties) {
		List<Answer> answers = new ArrayList<Answer>();

		for (QuestionProperty questionProperty : getquestionProperties) {
			Question question = new Question();
			List<Question> questions2 = questionnaireSected.getQuestions();
			for (Question question1 : questions2) {
				if (question1.getId().equals(
						Long.valueOf(questionProperty.getName()))) {
					question = question1;
				}
			}
			Answer answer = new Answer();
			String answersOfQuestion = "";
			Double punctuationOptions = 0d;
			if (questionProperty.getValue() != null) {
				answersOfQuestion = answersOfQuestion
						+ String.valueOf(questionProperty.getValue());
				if (question.getType().equals(QuestionTypeEnum.SPINNER)) {
					punctuationOptions = -1d;
				}
				if (question.getType().equals(QuestionTypeEnum.RADIO)) {
					for (Option option : question.getOptions()) {
						if (String.valueOf(questionProperty.getValue()).equals(
								option.getBody())) {
							punctuationOptions = punctuationOptions
									+ option.getPunctuation();
						}
					}
				}
			} else {
				if (questionProperty.getSelectedCheck() != null
						&& questionProperty.getSelectedCheck().length != 0) {
					for (String selectItem : questionProperty
							.getSelectedCheck()) {
						answersOfQuestion = answersOfQuestion + selectItem
								+ "/";
						for (Option option : question.getOptions()) {
							if (selectItem.equals(option.getBody())) {
								punctuationOptions = punctuationOptions
										+ option.getPunctuation();
							}
						}
					}
				}
			}

			if (!answersOfQuestion.equals("")) {
				answer.setWeightOfQuestion(question.getWeightOfQuestion());
				answer.setPunctuationOption(punctuationOptions);
				answer.setIdQuestion(Long.valueOf(questionProperty.getName()));
				answer.setBody(answersOfQuestion);
				answer.setInscription(inscription);

				answers.add(answer);

			}
		}
		return answers;
	}

	public void selectQuestionnaire(Questionnaire questionnaire) {

		model = new DynaFormModel();
		List<Question> searchAllQuestionsFromQuestionnaire = questionnaireService
				.searchAllQuestionsFromQuestionnaire(questionnaire.getId());
		for (Question question : searchAllQuestionsFromQuestionnaire) {
			question.setOptions(questionnaireService
					.searchOptionsByQuesting(question.getId()));
			;
		}
		try {
			questionnaire.setQuestions(searchAllQuestionsFromQuestionnaire);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Question> questions = questionnaire.getQuestions();
		questionnaireSected = questionnaire;
		for (int i = 0; i < questions.size(); i++) {
			DynaFormRow row1 = model.createRegularRow();
			// Coloca titulo da pergunta
			DynaFormLabel label11 = row1.addLabel((i + 1) + " - "
					+ questions.get(i).getTitle());
			// caso seja um paragrafo
			if (questions.get(i).getType().equals(QuestionTypeEnum.PARAGRAPH)) {
				DynaFormRow row = model.createRegularRow();
				DynaFormControl control12 = row.addControl(
						new QuestionProperty(questions.get(i).getId() + "",
								questions.get(i).getObligatory()), "input");
				label11.setForControl(control12);
			} else if (questions.get(i).getType().equals(QuestionTypeEnum.TEXT)) {
				DynaFormRow row = model.createRegularRow();
				DynaFormControl control12 = row.addControl(
						new QuestionProperty(questions.get(i).getId() + "",
								questions.get(i).getObligatory()), "textarea");
				label11.setForControl(control12);
			} else if (questions.get(i).getType()
					.equals(QuestionTypeEnum.RADIO)) {
				List<SelectItem> pffan = new ArrayList<SelectItem>();
				List<Option> options = questions.get(i).getOptions();

				for (Option option4 : options) {
					pffan.add(new SelectItem(option4.getBody(), option4
							.getBody()));
				}

				DynaFormRow row = model.createRegularRow();

				row.addControl(new QuestionProperty(questions.get(i).getId()
						+ "", questions.get(i).getObligatory(), pffan),
						"radiochoice", 1, 1);

			} else if (questions.get(i).getType()
					.equals(QuestionTypeEnum.CHECKBOX)) {
				List<String> pffan = new ArrayList<String>();
				List<Option> options = questions.get(i).getOptions();
				for (Option option4 : options) {
					pffan.add(option4.getBody());
				}

				DynaFormRow row = model.createRegularRow();

				row.addControl(new QuestionProperty(questions.get(i).getId()
						+ "", questions.get(i).getObligatory(), pffan),
						"booleanchoice", 1, 1);

			} else if (questions.get(i).getType()
					.equals(QuestionTypeEnum.SPINNER)) {
				DynaFormRow row = model.createRegularRow();
				DynaFormControl control12 = row.addControl(
						new QuestionProperty(questions.get(i).getId() + "",
								questions.get(i).getObligatory()), "offset");
				label11.setForControl(control12);

			}

		}
	}

	public List<Inscription> getInscriptionsWithPunctuation() {
		return inscriptionsWithPunctuation;
	}

	public void setInscriptionsWithPunctuation(
			List<Inscription> inscriptionsWithPunctuation) {
		this.inscriptionsWithPunctuation = inscriptionsWithPunctuation;
	}

	public List<Answer> getAnswersOfInscriptions() {
		return answersOfInscriptions;
	}

	public void setAnswersOfInscriptions(List<Answer> answersOfInscriptions) {
		this.answersOfInscriptions = answersOfInscriptions;
	}

	public List<Answer> getAnswers(Inscription inscription) {
		answersOfInscriptions = null;
		answersOfInscriptions = new ArrayList<Answer>();
		Inscription inscriptionSearch = inscriptionService.buscarPorId(inscription.getId());
		List<Answer> answers = inscriptionSearch.getAnswers();
		for (Answer answer : answers) {
			answersOfInscriptions.add(answer);
		}
		return answersOfInscriptions;
	}
}
