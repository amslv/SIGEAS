/**
 * 
 */
package br.com.iterativejr.data.dao;

import java.util.List;

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
public interface InscriptionDao extends GenericDao<Inscription, Long>{

	Boolean studentAlreadyAnswered (String registration);
	
	List<Questionnaire> questionnaireAnswered (Long id);
	
}
