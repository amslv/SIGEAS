package br.com.iterativejr.visao.controller.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Mostra mensagens
 * 
 * @author <a href="https://github.com/LuizAntonioPS">Luiz Pereira</a>
 *
 */
public class JsfUtil {

	/**
	 * Contrutor de classe vazio
	 */
    private JsfUtil(){
    }

    /**
     * Adciona uma mesagem de sucesso
     * @param message
     * 		mesagem de sucesso
     */
    public static void addSuccessMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        message, message));
    }

    /**
     * Adciona uma mesagem de erro
     * @param message
     * 		mesagem de erro
     */
    public static void addErrorMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        message, message));
    }

    /**
     * Redirecionar para determinado local
     * 
     * @param locate locate
     */
    public static void redirect(String locate) {

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(locate);
        } catch (IOException ex) {
            Logger.getLogger(JsfUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
