/**
 * 
 */
package br.com.iterativejr.service.negocio;

import java.util.List;

import br.com.iterativejr.data.dao.InscriptionDao;
import br.com.iterativejr.domains.entidade.Inscription;
import br.com.iterativejr.domains.entidade.Questionnaire;
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
public interface InscriptionService extends GenericService<Inscription, Long>{

	/**
	 * Seta DAO
	 * 
	 * @param dao
	 *            dao que sera setado
	 */
	void setDao(InscriptionDao dao);
	
	
	/**
	 * 
	 * @param registration
	 * @return
	 */
	void studentAlreadyAnswered(String registration, Long idQuestionnaire) throws SigeasException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	List<Long> questionnairesAnswered(String registration);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	List<String> inscriptionsOfQuestionnaire(Long idQuestionnaire);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Double calculatePunctuation(Long idQuestionnaire, String registration);
	
	Inscription searchForQuestionnaireAndRegistration(Long idQuestionnaire, String registration);

	List<Inscription> getPreClassification(Long idQuestionnaire);

	List<Inscription> getInscriptionsOfUser(String username);

	void removeInscriptionOfUser(String username, Questionnaire questionnaire);
	
}
