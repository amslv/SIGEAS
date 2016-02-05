/**
 * 
 */
package br.com.iterativejr.service.negocio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.iterativejr.data.dao.QuestionnaireDao;
import br.com.iterativejr.domains.entidade.Option;
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
@Validated
@Service("questionnaireService")
public class QuestionnaireServiceImpl extends GenericServiceImpl<Questionnaire, Long> implements QuestionnaireService{

	
	@Autowired
	public QuestionnaireServiceImpl(QuestionnaireDao dao) {
		this.dao = dao;
	}
	
	/** (non-Javadoc)
	 * @see br.com.iterativejr.service.negocio.QuestionnaireService#deleteQuestion(java.lang.Long)
	 */
	@Override
	public void deleteQuestion(Long id) {
		QuestionnaireDao questionnaireDao= (QuestionnaireDao) this.dao;
		questionnaireDao.deleteQuestion(id);
	}

	/** (non-Javadoc)
	 * @see br.com.iterativejr.service.negocio.QuestionnaireService#addQuestion(br.com.iterativejr.domains.entidade.Question)
	 */
	@Override
	public void addQuestion(Question question) {
	}

	/** (non-Javadoc)
	 * @see br.com.iterativejr.service.negocio.QuestionnaireService#updateQuestion(br.com.iterativejr.domains.entidade.Question)
	 */
	@Override
	public Question updateQuestion(Question question) {
		return null;
	}

	/** (non-Javadoc)
	 * @see br.com.iterativejr.service.negocio.QuestionnaireService#searchAllQuestions()
	 */
	@Override
	public List<Question> searchAllQuestions() {
		System.out.println("Entrou");
		return null;
	}

	/** (non-Javadoc)
	 * @see br.com.iterativejr.service.negocio.QuestionnaireService#searchAllQuestionsFromQuestionnaire(java.lang.Long)
	 */
	@Override
	public List<Question> searchAllQuestionsFromQuestionnaire(
			Long idQuestionnaire) {
		return null;
	}

	
	/** (non-Javadoc)
	 * @see br.com.iterativejr.service.negocio.QuestionnaireService#searchOptionsByQuesting(java.lang.Long)
	 */
	@Override
	public List<Option> searchOptionsByQuesting(Long id) {
		return null;
	}

	/** (non-Javadoc)
	 * @see br.com.iterativejr.service.negocio.QuestionnaireService#setDao(br.com.iterativejr.data.dao.QuestionnaireDao)
	 */
	@Override
	public void setDao(QuestionnaireDao dao) {
		this.dao = dao;
		
	}

}

