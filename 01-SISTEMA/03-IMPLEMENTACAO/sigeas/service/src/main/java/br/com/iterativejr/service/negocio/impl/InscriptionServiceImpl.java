/**
 * 
 */
package br.com.iterativejr.service.negocio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.iterativejr.data.dao.InscriptionDao;
import br.com.iterativejr.domains.entidade.Answer;
import br.com.iterativejr.domains.entidade.Inscription;
import br.com.iterativejr.domains.entidade.Questionnaire;
import br.com.iterativejr.service.negocio.InscriptionService;
import br.com.iterativejr.service.negocio.legacies.validations.SigeasException;

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
@Validated
@Service("inscriptionService")
public class InscriptionServiceImpl extends
		GenericServiceImpl<Inscription, Long> implements InscriptionService {

	/**
	 * 
	 * @param dao
	 */
	@Autowired
	public InscriptionServiceImpl(InscriptionDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.iterativejr.service.negocio.InscriptionService#setDao(br.com.
	 * iterativejr.data.dao.InscriptionDao)
	 */
	@Override
	public void setDao(InscriptionDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.iterativejr.service.negocio.InscriptionService#studentAlreadyAnswered
	 * (java.lang.String, java.lang.Long)
	 */
	@Transactional
	@Override
	public void studentAlreadyAnswered(String registration,
			Long idQuestionnaire) throws SigeasException {
		InscriptionDao inscriptionDao = (InscriptionDao) this.dao;
		if (inscriptionDao.studentAlreadyAnswered(registration,	idQuestionnaire)) {
			throw new SigeasException("Você já está inscrito neste questionário");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.iterativejr.service.negocio.InscriptionService#questionnairesAnswered
	 * (java.lang.String)
	 */
	@Override
	public List<Long> questionnairesAnswered(String registration) {
		InscriptionDao inscriptionDao = (InscriptionDao) this.dao;
		return inscriptionDao.questionnairesAnswered(registration);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.iterativejr.service.negocio.InscriptionService#
	 * inscriptionsOfQuestionnaire(java.lang.Long)
	 */
	@Override
	public List<String> inscriptionsOfQuestionnaire(Long idQuestionnaire) {
		InscriptionDao inscriptionDao = (InscriptionDao) this.dao;
		return inscriptionDao.inscriptionsOfQuestionnaire(idQuestionnaire);
	}

	@Override
	public Double calculatePunctuation(Long idQuestionnaire, String registration) {
		Double punctuation = 0d;
		InscriptionDao inscriptionDao = (InscriptionDao) this.dao;
		List<Answer> AnswerList = inscriptionDao.calculatePunctuation(idQuestionnaire, registration);
		for (Answer answer : AnswerList) {
			if (!answer.getPunctuationOption().equals(-1d)) {
				punctuation = punctuation + (answer.getPunctuationOption() * answer.getWeightOfQuestion());
			} else {
				punctuation = punctuation + (Integer.parseInt(answer.getBody()) * answer.getWeightOfQuestion());
			}
		}
		return punctuation;
	}
	
	@Override
	public Inscription searchForQuestionnaireAndRegistration(Long idQuestionnaire, String registration) {
		InscriptionDao inscriptionDao = (InscriptionDao) this.dao;
		return inscriptionDao.searchForQuestionnaireAndRegistration(idQuestionnaire, registration);
	}

	@Override
	public List<Inscription> getPreClassification(Long idQuestionnaire) {
		List<Inscription> inscriptions = new ArrayList<Inscription>();
		List<String> inscriptionsOfQuestionnaire = inscriptionsOfQuestionnaire(idQuestionnaire);
		for (String registration : inscriptionsOfQuestionnaire) {
			Double punctuation = calculatePunctuation(idQuestionnaire, registration);
			Inscription inscription = searchForQuestionnaireAndRegistration(idQuestionnaire, registration);
			inscription.setPunctuation(punctuation);
			inscriptions.add(inscription);
		}
		return inscriptions;
	}

	@Transactional
	@Override
	public List<Inscription> getInscriptionsOfUser(String registration) {
		InscriptionDao inscriptionDao = (InscriptionDao) this.dao;
		return inscriptionDao.getInscriptionsOfUser(registration);
		
	}

	@Transactional
	@Override
	public void removeInscriptionOfUser(String registration, Questionnaire questionnaire) {
		InscriptionDao inscriptionDao = (InscriptionDao) this.dao;
		for (Inscription inscription : getInscriptionsOfUser(registration)) {
			if (inscription.getIdQuestionnaire().equals(questionnaire.getId())) {
				inscriptionDao.apagar(inscription);
			}
		}
		
	}

}
