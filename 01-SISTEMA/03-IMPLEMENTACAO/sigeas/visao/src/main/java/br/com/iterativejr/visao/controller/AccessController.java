package br.com.iterativejr.visao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author <a href="https://github.com/LuizAntonioPS">Luiz Pereira</a>
 *
 */

@Controller
public class AccessController {

	/**
	 * Método que retorna página de login para o requestMapping do Spring
	 * 
	 * @param model
	 * @param message
	 * @return
	 * 		referência à página de login
	 */
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}
	
	/**
	 * Método que retorna página de acesso negado para o requestMapping do Spring
	 * 
	 * @param model
	 * @param message
	 * @return
	 * 		referência à página de acesso negado
	 */
	@RequestMapping(value = "/denied", method= RequestMethod.GET)
 	public String denied() {
		return "denied";
	}
	
	/**
	 * Método que retorna página de falha no login para o requestMapping do Spring
	 * 
	 * @param model
	 * @param message
	 * @return
	 * 		referência à página de falha de login
	 */
	@RequestMapping(value = "/loginFailure", method= RequestMethod.GET)
 	public String loginFailure(ModelMap model) {
		model.addAttribute("message", "Acesso Negado. Tente Novamente.");
		return "login";
	}
	
	/**
	 * Método que retorna página de logout com sucesso para o requestMapping do Spring
	 * 
	 * @param model
	 * @param message
	 * @return
	 * 		referência à página de logout com sucesso
	 */
	@RequestMapping(value = "/logoutSuccess", method= RequestMethod.GET)
 	public String logoutSuccess(ModelMap model) {
		model.addAttribute("messageSuccess", "Você saiu do sistema.");
		return "login";
	}
}