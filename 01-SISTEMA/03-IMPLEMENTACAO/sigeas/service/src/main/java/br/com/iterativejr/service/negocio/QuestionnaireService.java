/**
 * 
 */
package br.com.iterativejr.service.negocio;

import java.util.List;

import javax.validation.constraints.NotNull;

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
public interface QuestionnaireService extends GenericService<Questionnaire, Long>{
	
	/**
	 * Seta DAO
	 * 
	 * @param dao
	 *            dao que sera setado
	 */
	void setDao(QuestionnaireDao dao);
	
	/**
	 * 
	 * @return
	 */
	List <Question> searchAllQuestions (); 
	/**
	 * 
	 * @param idQuestionnaire
	 * @return
	 */
	List <Question> searchAllQuestionsFromQuestionnaire (@NotNull Long idQuestionnaire); 
	/**
	 * 
	 * @param id
	 * @return
	 */
	List <Option> searchOptionsByQuesting (@NotNull Long id);
}
