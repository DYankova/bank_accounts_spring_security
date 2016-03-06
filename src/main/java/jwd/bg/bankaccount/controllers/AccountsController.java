package jwd.bg.bankaccount.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jwd.bg.bankaccount.entities.Account;
import jwd.bg.bankaccount.services.AccountService;
import jwd.bg.bankaccount.constants.UrlConstants;

@Controller
public class AccountsController {

	@Autowired
	@Qualifier("accountServiceImpl")
	private AccountService accountService;

	@RequestMapping(value = UrlConstants.NEW_ACCOUNT_URL, method = RequestMethod.GET)
	public String newAccount(Model model, @ModelAttribute("account") Account account, BindingResult result) {
		return "newAccount";
	}
	
	@RequestMapping(value = "/saveAccount", method = RequestMethod.POST)//from the jsp form(the model attribute = ModelAttribute
	public String saveAccounts(Model model,@Valid @ModelAttribute("account") Account account, BindingResult result, HttpServletRequest request ) {
		if(result.hasErrors()) {
			return "newAccount";
		}
		accountService.newAccount(account);
		return "redirect:/";
		
	}
}