/**
 * 
 */
package br.com.iterativejr.service.negocio;

import java.util.List;

import br.com.iterativejr.data.dao.InscriptionDao;
import br.com.iterativejr.domains.entidade.Inscription;
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
	Boolean studentAlreadyAnswered(String registration);

	/**
	 * 
	 * @param id
	 * @return
	 */
	List<Questionnaire> questionnaireAnswered(Long id);
	
}
