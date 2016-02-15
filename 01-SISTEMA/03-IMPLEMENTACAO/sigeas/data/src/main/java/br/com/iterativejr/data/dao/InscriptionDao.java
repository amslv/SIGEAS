/**
 * 
 */
package br.com.iterativejr.data.dao;

import java.util.List;

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
public interface InscriptionDao extends GenericDao<Inscription, Long>{

	Boolean studentAlreadyAnswered(String registration, Long idQuestionnaire);

	List<Long> questionnairesAnswered(String registration);
	
	List<String> inscriptionsOfQuestionnaire(Long id);

	List<Answer> calculatePunctuation(Long idQuestionnaire, String registration);
	
	Inscription searchForQuestionnaireAndRegistration(Long idQuestionnaire, String registration);

	List<Inscription> getInscriptionsOfUser(String registration);

}
