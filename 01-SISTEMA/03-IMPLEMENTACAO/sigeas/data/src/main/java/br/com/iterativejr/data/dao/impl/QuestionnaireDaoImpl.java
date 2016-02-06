/**
 * 
 */
package br.com.iterativejr.data.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.iterativejr.data.dao.QuestionnaireDao;
import br.com.iterativejr.domains.entidade.Option;
import br.com.iterativejr.domains.entidade.Question;
import br.com.iterativejr.domains.entidade.Questionnaire;

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
@Repository("questionnaireDao")
public class QuestionnaireDaoImpl extends GenericDaoImpl<Questionnaire, Long> implements QuestionnaireDao{

	/* (non-Javadoc)
	 * @see br.com.iterativejr.data.dao.QuestionnaireDao#deleteQuestion(java.lang.Long)
	 */
	@Override
	public void deleteQuestion(Long id) {}


	/* (non-Javadoc)
	 * @see br.com.iterativejr.data.dao.QuestionnaireDao#searchAllQuestions()
	 */
	@Override
	public List<Question> searchAllQuestions() {
		Query query = this.entityManager
				.createNamedQuery("Question.searchAllQuestions");

		@SuppressWarnings("unchecked")
		List<Question> resultado = query.getResultList();

		return resultado;
	}

	/* (non-Javadoc)
	 * @see br.com.iterativejr.data.dao.QuestionnaireDao#searchAllQuestionsFromQuestionnaire(java.lang.Long)
	 */
	@Override
	public List<Question> searchAllQuestionsFromQuestionnaire(
			Long idQuestionnaire) {
		Query query = this.entityManager
				.createNamedQuery("Questionnaire.searchAllQuestionsFromQuestionnaire");
		query.setParameter("idQuestionnaire", idQuestionnaire);

		@SuppressWarnings("unchecked")
		List<Question> resultado = query.getResultList();

		return resultado;
	}

	/* (non-Javadoc)
	 * @see br.com.iterativejr.data.dao.QuestionnaireDao#searchOptionsByQuesting(java.lang.Long)
	 */
	@Override
	public List<Option> searchOptionsByQuesting(Long id) {
		Query query = this.entityManager
				.createNamedQuery("Option.searchOptionsByQuesting");
		query.setParameter("idQuestao", id);

		@SuppressWarnings("unchecked")
		List<Option> resultado = query.getResultList();

		return resultado;
	}

	
}
