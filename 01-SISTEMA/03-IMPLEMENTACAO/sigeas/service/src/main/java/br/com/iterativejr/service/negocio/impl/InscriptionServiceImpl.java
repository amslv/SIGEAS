/**
 * 
 */
package br.com.iterativejr.service.negocio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.iterativejr.data.dao.InscriptionDao;
import br.com.iterativejr.data.dao.QuestionnaireDao;
import br.com.iterativejr.domains.entidade.Inscription;
import br.com.iterativejr.domains.entidade.Questionnaire;
import br.com.iterativejr.service.negocio.InscriptionService;
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
@Service("inscriptionService")
public class InscriptionServiceImpl extends GenericServiceImpl<Inscription, Long> implements InscriptionService{

	/**
	 * 
	 * @param dao
	 */
	@Autowired
	public InscriptionServiceImpl (InscriptionDao dao){
		this.dao = dao;
	}
	
	/* (non-Javadoc)
	 * @see br.com.iterativejr.service.negocio.InscriptionService#setDao(br.com.iterativejr.data.dao.InscriptionDao)
	 */
	@Override
	public void setDao(InscriptionDao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see br.com.iterativejr.service.negocio.InscriptionService#studentAlreadyAnswered(java.lang.String)
	 */
	@Override
	public Boolean studentAlreadyAnswered(String registration) {
		InscriptionDao inscriptionDao = (InscriptionDao) this.dao;
		return inscriptionDao.studentAlreadyAnswered(registration);
	}

	/* (non-Javadoc)
	 * @see br.com.iterativejr.service.negocio.InscriptionService#questionnaireAnswered(java.lang.Long)
	 */
	@Override
	public List<Questionnaire> questionnaireAnswered(Long id) {
		InscriptionDao inscriptionDao = (InscriptionDao) this.dao;
		return inscriptionDao.questionnaireAnswered(id);
	}

	
	
	

}
