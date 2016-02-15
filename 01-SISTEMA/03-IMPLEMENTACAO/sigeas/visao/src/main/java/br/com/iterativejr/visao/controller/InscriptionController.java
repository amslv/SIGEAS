/**
 * 
 */
package br.com.iterativejr.visao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import br.com.iterativejr.domains.entidade.Questionnaire;
import br.com.iterativejr.service.negocio.InscriptionService;
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
 * @author <a href="https://github.com/LuizAntonioPS">Luiz Antonio</a>
 *
 */
@Controller
@ManagedBean(name = "inscriptionController")
@ViewScoped
public class InscriptionController {

	@Autowired
	@Qualifier("inscriptionService")
	private InscriptionService inscriptionService;
	
	@Autowired
	@Qualifier("questionnaireService")
	private QuestionnaireService questionnaireService;
	
	List<Questionnaire> questionnairesAnswered;
	
	/**
	 * Inicia dados
	 */
	@PostConstruct
	public void init() {
	}

	public InscriptionService getInscriptionService() {
		return inscriptionService;
	}

	public void setInscriptionService(InscriptionService inscriptionService) {
		this.inscriptionService = inscriptionService;
	}
	
	public List<Questionnaire> questionnairesAnswered() {
		List<Questionnaire> listQuestionnairesAnswered = new ArrayList<Questionnaire>();
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		List<Long> questionnaires = inscriptionService.questionnairesAnswered(user.getUsername());
		for (Long idQuestionnaire : questionnaires) {
			listQuestionnairesAnswered.add(questionnaireService.buscarPorId(idQuestionnaire));
		}
		return listQuestionnairesAnswered;
	}
	
	public void removeInscription(Questionnaire questionnaire) {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		inscriptionService.removeInscriptionOfUser(user.getUsername(), questionnaire);
	}

	public QuestionnaireService getQuestionnaireService() {
		return questionnaireService;
	}

	public void setQuestionnaireService(QuestionnaireService questionnaireService) {
		this.questionnaireService = questionnaireService;
	}

	public List<Questionnaire> getQuestionnairesAnswered() {
		questionnairesAnswered = questionnairesAnswered();
		return questionnairesAnswered;
	}

	public void setQuestionnairesAnswered(List<Questionnaire> questionnairesAnswered) {
		this.questionnairesAnswered = questionnairesAnswered;
	}

}
