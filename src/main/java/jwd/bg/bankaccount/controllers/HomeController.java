package jwd.bg.bankaccount.controllers;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jwd.bg.bankaccount.constants.*;
import jwd.bg.bankaccount.services.AccountService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	@Qualifier("accountServiceImpl")
	private AccountService accountService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("accounts", accountService.getAccounts());
		model.addAttribute("newAccountUrl", UrlConstants.NEW_ACCOUNT_URL);
		model.addAttribute("newOperationUrl", UrlConstants.NEW_OPERATION_URL);
		return "home";
	}
}
