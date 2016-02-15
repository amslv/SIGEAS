/**
 * 
 */
package br.com.iterativejr.data.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.iterativejr.data.dao.InscriptionDao;
import br.com.iterativejr.domains.entidade.Answer;
import br.com.iterativejr.domains.entidade.Inscription;

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
@Repository("inscriptionDao")
public class InscriptionDaoImpl extends GenericDaoImpl<Inscription, Long> implements InscriptionDao{

	/* (non-Javadoc)
	 * @see br.com.iterativejr.data.dao.InscriptionDao#studentAlreadyAnswered(java.lang.String)
	 */
	@Override
	public Boolean studentAlreadyAnswered(String registration,
			Long idQuestionnaire) {
		Query query = this.entityManager
				.createNamedQuery("Inscription.studentAlreadyAnswered");
		query.setParameter("registration", registration);
		query.setParameter("idQuestionnaire", idQuestionnaire);
		Long result = (Long) query.getSingleResult();
		return result != 0;
	}

	@Override
	public List<Long> questionnairesAnswered(String registration) {
		Query query = this.entityManager
				.createNamedQuery("Inscription.questionnairesAnswered");
		query.setParameter("registration", registration);
		
		@SuppressWarnings("unchecked")
		List<Long> resultado = query.getResultList(); 
		return resultado;
	}

	@Override
	public List<String> inscriptionsOfQuestionnaire(Long idQuestionnaire) {
		Query query = this.entityManager
				.createNamedQuery("Inscription.inscriptionsOfQuestionnaire");
		query.setParameter("idQuestionnaire", idQuestionnaire);
		
		@SuppressWarnings("unchecked")
		List<String> resultado = query.getResultList(); 
		return resultado;
	}

	@Override
	public List<Answer> calculatePunctuation(Long idQuestionnaire, String registration) {
		Query query = this.entityManager
				.createNamedQuery("Inscription.selectAnswers");
		query.setParameter("idQuestionnaire", idQuestionnaire);
		query.setParameter("registration", registration);
		
		@SuppressWarnings("unchecked")
		List<Answer> resultList = query.getResultList();
		return resultList;
	}
	
	@Override
	public Inscription searchForQuestionnaireAndRegistration(Long idQuestionnaire, String registration) {
		Query query = this.entityManager
				.createNamedQuery("Inscription.searchForQuestionnaireAndRegistration");
		query.setParameter("idQuestionnaire", idQuestionnaire);
		query.setParameter("registration", registration);
		
		Inscription resultList = (Inscription) query.getSingleResult();
		return resultList;
	}

	@Override
	public List<Inscription> getInscriptionsOfUser(String registration) {
		Query query = this.entityManager
				.createNamedQuery("Inscription.getInscriptionsOfUser");
		query.setParameter("registration", registration);
		
		@SuppressWarnings("unchecked")
		List<Inscription> resultList = query.getResultList();
		return resultList;
	}

}
