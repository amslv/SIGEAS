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

	
	/**
	 * Inicia dao
	 * @param dao dao de acordo do Autowired
	 */
	@Autowired
	public QuestionnaireServiceImpl(QuestionnaireDao dao) {
		this.dao = dao;
	}
	
	
	/** (non-Javadoc)
	 * @see br.com.iterativejr.service.negocio.QuestionnaireService#searchAllQuestions()
	 */
	@Override
	public List<Question> searchAllQuestions() {
		QuestionnaireDao questionnaireDao= (QuestionnaireDao) this.dao;
		return questionnaireDao.searchAllQuestions();
	}

	/** (non-Javadoc)
	 * @see br.com.iterativejr.service.negocio.QuestionnaireService#searchAllQuestionsFromQuestionnaire(java.lang.Long)
	 */
	@Override
	public List<Question> searchAllQuestionsFromQuestionnaire(
			Long idQuestionnaire) {
		QuestionnaireDao questionnaireDao= (QuestionnaireDao) this.dao;
		return questionnaireDao.searchAllQuestionsFromQuestionnaire(idQuestionnaire);
	}

	
	/** (non-Javadoc)
	 * @see br.com.iterativejr.service.negocio.QuestionnaireService#searchOptionsByQuesting(java.lang.Long)
	 */
	@Override
	public List<Option> searchOptionsByQuesting(Long id) {
		QuestionnaireDao questionnaireDao= (QuestionnaireDao) this.dao;
		return questionnaireDao.searchOptionsByQuesting(id);
	}

	/** (non-Javadoc)
	 * @see br.com.iterativejr.service.negocio.QuestionnaireService#setDao(br.com.iterativejr.data.dao.QuestionnaireDao)
	 */
	@Override
	public void setDao(QuestionnaireDao dao) {
		this.dao = dao;
		
	}


	@Override
	public void publicQuestionnaire(Questionnaire questionnaire) {
		QuestionnaireDao questionnaireDao= (QuestionnaireDao) this.dao;
		questionnaire.setPublished(true);
		questionnaireDao.atualizar(questionnaire);
	}

}

