/**
 * 
 */
package br.com.iterativejr.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;
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
	public void deleteQuestion(Long id) {
		
		System.out.println(this.entityManager!=null);
		
	}

	/* (non-Javadoc)
	 * @see br.com.iterativejr.data.dao.QuestionnaireDao#addQuestion(br.com.iterativejr.domains.entidade.Question)
	 */
	@Override
	public void addQuestion(Question question) {
		System.out.println("addQuestion");
		
	}

	/* (non-Javadoc)
	 * @see br.com.iterativejr.data.dao.QuestionnaireDao#updateQuestion(br.com.iterativejr.domains.entidade.Question)
	 */
	@Override
	public Question updateQuestion(Question question) {
		System.out.println("updateQuestion");
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.iterativejr.data.dao.QuestionnaireDao#searchAllQuestions()
	 */
	@Override
	public List<Question> searchAllQuestions() {
		System.out.println();
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.iterativejr.data.dao.QuestionnaireDao#searchAllQuestionsFromQuestionnaire(java.lang.Long)
	 */
	@Override
	public List<Question> searchAllQuestionsFromQuestionnaire(
			Long idQuestionnaire) {
		System.out.println("searchAllQuestionsFromQuestionnaire");
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.iterativejr.data.dao.QuestionnaireDao#searchOptionsByQuesting(java.lang.Long)
	 */
	@Override
	public List<Option> searchOptionsByQuesting(Long id) {
		System.out.println("searchOptionsByQuesting");
		return null;
	}

	
}
