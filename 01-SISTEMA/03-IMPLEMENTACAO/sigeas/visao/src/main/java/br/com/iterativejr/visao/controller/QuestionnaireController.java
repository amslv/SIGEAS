/**
 * 
 */
package br.com.iterativejr.visao.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import br.com.iterativejr.data.dao.QuestionnaireDao;
import br.com.iterativejr.domains.entidade.Option;
import br.com.iterativejr.domains.entidade.Question;
import br.com.iterativejr.domains.entidade.Questionnaire;
import br.com.iterativejr.domains.entidade.enums.QuestionTypeEnum;
import br.com.iterativejr.service.negocio.PermissionEmployeeService;
import br.com.iterativejr.service.negocio.QuestionnaireService;

import javax.faces.bean.ManagedBean;

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
@Controller 
@ManagedBean (name="questionnaireController")
@RequestScoped
public class QuestionnaireController {
	
	@Autowired
	@Qualifier("questionnaireService")
	private QuestionnaireService questionnaireService;
	
	private String text;

	public String getText() {
		return text;
	}

	public String getTest() {
		/**
		 *  Notebook noteA = new Notebook();
            noteA.setSerialNumber("A0123");
            Notebook noteB = new Notebook();
            noteB.setSerialNumber("B0123");
            Notebook noteC = new Notebook();
            noteC.setSerialNumber("C0123");
 
            List notebooks = new ArrayList();
            notebooks.add(noteA);
            notebooks.add(noteB);
            notebooks.add(noteC);
 
            Person person = new Person();
            person.setName("Zorro");
            person.setNotebooks(notebooks);
		 */
		List <Question> questions = new ArrayList<>();
		Question question = new Question("Como faz 3:", Boolean.TRUE, 70d, QuestionTypeEnum.CHECKBOX);
		question.addOption(new Option("Corpo",70d, false, question));
		questions.add(question);
		questions.add(question);
		questionnaireService.criar(new Questionnaire("Nova1", true, new Date(), new Date(), questions));
		
		
		return text;
	}	
	
	
	
	public void setText(String text) {
		this.text = text;
	}
}
