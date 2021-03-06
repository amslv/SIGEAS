/**
 * 
 */
package br.com.iterativejr.data.dao;

import java.util.List;

import javax.validation.constraints.NotNull;

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
public interface QuestionnaireDao extends GenericDao<Questionnaire, Long>{

	/**
	 * 
	 * @param id
	 */
	void deleteQuestion (@NotNull Long id);
	
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
	
	/**
	 * 
	 * @return lista de todos os questionários abertos
	 */
	List<Questionnaire> searchAllQuestinnairesPublished();
	
}
