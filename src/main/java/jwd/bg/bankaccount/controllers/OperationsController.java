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
import org.springframework.web.servlet.ModelAndView;

import jwd.bg.bankaccount.entities.Account;
import jwd.bg.bankaccount.entities.Operation;
import jwd.bg.bankaccount.services.AccountService;
import jwd.bg.bankaccount.services.OperationService;
import jwd.bg.bankaccount.constants.UrlConstants;

@Controller
public class OperationsController {

	@Autowired
	@Qualifier("operationServiceImpl")
	private OperationService operationService;
	
	@Autowired
	@Qualifier("accountServiceImpl")
	private AccountService accountService;

	@RequestMapping(value = UrlConstants.NEW_OPERATION_URL, method = RequestMethod.GET)
	public String newOperation(Model model,@ModelAttribute("operation") Operation operation, BindingResult result) {
		model.addAttribute("accounts", accountService.getAccounts());
		return "newOperation";
	}

	// from the jsp form(the model attribute = ModelAttribute from the spring form
	@RequestMapping(value = "/saveOperation", method = RequestMethod.POST)
	public String saveOperation( Model model, @Valid @ModelAttribute("operation") Operation operation,BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			model.addAttribute("accounts", accountService.getAccounts());
            return "newOperation";
		}

		if ("deposit".equals(operation.getOperation())) {
			operationService.deposit(operation.getAccountNumber(), operation.getAmount(), operation.getCurrency());
		} else {
			operationService.withdraw(operation.getAccountNumber(), operation.getAmount(),operation.getCurrency());
		}

		return "redirect:/";
	}
}
