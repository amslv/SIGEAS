/**
 * 
 */
package br.com.iterativejr.visao.controller;

import org.primefaces.context.RequestContext;
import org.primefaces.extensions.model.dynaform.DynaFormControl;
import org.primefaces.extensions.model.dynaform.DynaFormLabel;
import org.primefaces.extensions.model.dynaform.DynaFormModel;
import org.primefaces.extensions.model.dynaform.DynaFormRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import br.com.iterativejr.domains.entidade.Option;
import br.com.iterativejr.domains.entidade.Question;
import br.com.iterativejr.domains.entidade.Questionnaire;
import br.com.iterativejr.domains.entidade.enums.QuestionTypeEnum;
import br.com.iterativejr.service.negocio.QuestionnaireService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 * DynaFormController
 *
 * @author Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
@ManagedBean
@ViewScoped
public class DynaFormController implements Serializable {

	private static final long serialVersionUID = 5142845558054368230L;

	private DynaFormModel model = new DynaFormModel();

	
	@PostConstruct
	protected void initialize() {
		

		Questionnaire questionnaire = QuestionnaireController.QUESTION;

		
		System.out.println(questionnaire);
		// add rows, labels and editable controls
		// set relationship between label and editable controls to support
		// outputLabel with "for" attribute

		// 1. row
		List<Question> questions = questionnaire.getQuestions();
		for (int i = 0; i < questions.size(); i++) {
			DynaFormRow row1 = model.createRegularRow();
			//Coloca titulo da pergunta
			DynaFormLabel label11 = row1.addLabel((i+1)+" - "+questions.get(i).getTitle());
			//caso seja um paragrafo
			if (questions.get(i).getType().equals(QuestionTypeEnum.PARAGRAPH)){
				DynaFormRow row = model.createRegularRow();
				DynaFormControl control12 = row.addControl(new QuestionProperty("Paragraph",
						false), "input");
				label11.setForControl(control12);
			}
			else if (questions.get(i).getType().equals(QuestionTypeEnum.TEXT)){
				DynaFormRow row = model.createRegularRow();
				DynaFormControl control12 = row.addControl(new QuestionProperty("Text",
						false), "textarea");
				label11.setForControl(control12);
			}
			else if (questions.get(i).getType().equals(QuestionTypeEnum.RADIO)){
				List<SelectItem> pffan = new ArrayList<SelectItem>();  
				List<Option> options = questions.get(i).getOptions();
				
				for (Option option4 : options) {
					pffan.add(new SelectItem(option4.getBody(), option4.getBody()));  
				}
				
				DynaFormRow row = model.createRegularRow();
				
				row.addControl(new QuestionProperty("Radio", false, pffan), "radiochoice", 1, 1);
				
			}else if (questions.get(i).getType().equals(QuestionTypeEnum.CHECKBOX)){
				List<SelectItem> pffan = new ArrayList<SelectItem>(); 
				List<Option> options = questions.get(i).getOptions();
				for (Option option4 : options) {
					pffan.add(new SelectItem(option4.getBody(), option4.getBody()));  
				} 
				
				DynaFormRow row = model.createRegularRow(); 
				
				
				row.addControl(new QuestionProperty("Checkbox", false, pffan), "booleanchoice", 1, 1);
				
				
			}else if (questions.get(i).getType().equals(QuestionTypeEnum.SPINNER)){
				DynaFormRow row = model.createRegularRow();
				DynaFormControl control12 = row.addControl(new QuestionProperty("Spinner",
						false), "offset");
				label11.setForControl(control12);
				
			}
			
			
		}
		
	}

	
	public DynaFormModel getModel() {
		return model;
	}

	public List<QuestionProperty> getquestionProperties() {
		if (model == null) {
			return null;
		}

		List<QuestionProperty> questionProperties = new ArrayList<QuestionProperty>();
		for (DynaFormControl dynaFormControl : model.getControls()) {
			questionProperties.add((QuestionProperty) dynaFormControl.getData());
		}

		return questionProperties;
	}

	public String submitForm() {
		System.out.println("Entrou");
		FacesMessage.Severity sev = FacesContext.getCurrentInstance()
				.getMaximumSeverity();
		boolean hasErrors = (sev != null && (FacesMessage.SEVERITY_ERROR
				.compareTo(sev) >= 0));

		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.addCallbackParam("isValid", !hasErrors);

		return null;
	}

}
