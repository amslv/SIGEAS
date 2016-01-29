package br.com.iterativejr.visao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
 * @author <a href="https://github.com/LuizAntonioPS">Luiz Pereira</a>
 *
 */

@Controller
public class AccessController {

	@RequestMapping(value="/", method= RequestMethod.GET)
	public String login(Model model, @RequestParam(required=false) String message) {
		return "login";
	}
	
	@RequestMapping(value = "/denied", method= RequestMethod.GET)
 	public String denied() {
		return "denied";
	}
	
	@RequestMapping(value = "/loginFailure", method= RequestMethod.GET)
 	public String loginFailure(ModelMap model) {
		model.addAttribute("message", "Acesso Negado. Tente Novamente.");
		return "login";
	}
	
	@RequestMapping(value = "/logoutSuccess", method= RequestMethod.GET)
 	public String logoutSuccess(ModelMap model) {
		model.addAttribute("messageSuccess", "Você saiu do sistema.");
		return "login";
	}
}