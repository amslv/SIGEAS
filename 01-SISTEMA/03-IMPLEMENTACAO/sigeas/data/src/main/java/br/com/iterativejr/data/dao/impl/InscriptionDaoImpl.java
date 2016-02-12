/**
 * 
 */
package br.com.iterativejr.data.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.iterativejr.data.dao.InscriptionDao;
import br.com.iterativejr.data.dao.QuestionnaireDao;
import br.com.iterativejr.domains.entidade.Inscription;
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
@Repository("inscriptionDao")
public class InscriptionDaoImpl extends GenericDaoImpl<Inscription, Long> implements InscriptionDao{

	/* (non-Javadoc)
	 * @see br.com.iterativejr.data.dao.InscriptionDao#studentAlreadyAnswered(java.lang.String)
	 */
	@Override
	public Boolean studentAlreadyAnswered(String registration) {
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.iterativejr.data.dao.InscriptionDao#questionnaireAnswered(java.lang.Long)
	 */
	@Override
	public List<Questionnaire> questionnaireAnswered(Long id) {
		Query query = this.entityManager
				.createNamedQuery("Inscription.questionnaireAnswered");

		@SuppressWarnings("unchecked")
		List<Questionnaire> resultado = query.getResultList();

		return resultado;
	}

}
