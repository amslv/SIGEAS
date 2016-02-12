/**
 * 
 */
package br.com.iterativejr.visao.controller;

import java.io.Serializable;

import javax.faces.model.SelectItem;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * BookProperty
 *
 * @author Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
public class QuestionProperty implements Serializable {

    

    /**
	 * 
	 */
	private static final long serialVersionUID = -3472241265977641562L;
	private String name;
	private String[] selectedCheck;
	private List<String> checks;
    private Object value;
    private boolean required;
    private List<SelectItem> selectItems;  
    
    public QuestionProperty(String name, boolean required) {
        this.name = name;
        this.required = required;
    }
    

    public void addChecks(String check){
    	checks.add(check);
    }

    /**
	 * @param name
	 * @param required
	 * @param selectItems
	 */
	public QuestionProperty(String name, boolean required,
			List<SelectItem> selectItems) {
		super();
		this.name = name;
		this.required = required;
		this.selectItems = selectItems;
	}



	public QuestionProperty(String name, Object value, boolean required) {
        this.name = name;
        this.value = value;
        this.required = required;
    }

    /**
	 * @param string
	 * @param obligatory
	 * @param pffan
	 */
	public QuestionProperty(String name, Boolean required,
			List<String> checks) {
		super();
		this.name = name;
		this.required = required;
		this.checks = checks;
	}


	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    
    
    /**
	 * @return the selectItems
	 */
	public List<SelectItem> getSelectItems() {
		return selectItems;
	}

	/**
	 * @param selectItems the selectItems to set
	 */
	public void setSelectItems(List<SelectItem> selectItems) {
		this.selectItems = selectItems;
	}

	public Object getFormattedValue() {
        if (value instanceof Date) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMM yyyy");

            return simpleDateFormat.format(value);
        }

        return value;
    }

    
    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

	


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QuestionProperty [name=" + name + ", selectedCheck="
				+ Arrays.toString(selectedCheck) + ", checks=" + checks
				+ ", value=" + value + ", required=" + required
				+ "]";
	}


	/**
	 * @return the selectedCheck
	 */
	public String[] getSelectedCheck() {
		return selectedCheck;
	}


	/**
	 * @param selectedCheck the selectedCheck to set
	 */
	public void setSelectedCheck(String[] selectedCheck) {
		this.selectedCheck = selectedCheck;
	}


	/**
	 * @return the checks
	 */
	public List<String> getChecks() {
		return checks;
	}


	/**
	 * @param checks the checks to set
	 */
	public void setChecks(List<String> checks) {
		this.checks = checks;
	}
	
	
    
    
}
