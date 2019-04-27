package com.uow.bank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uow.bank.model.Account;
import com.uow.bank.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	AccountService accSer;
	
	@InitBinder
	public void initBinder(WebDataBinder wdb) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		wdb.registerCustomEditor(String.class, ste);
	}

	@RequestMapping("/")
	public String homePage() {
		return "index";
	}

	@RequestMapping("/newAccountform")
	public String newAcountform(Model model) {
		model.addAttribute("account", new Account());
		return "accountForm";
	}

	@RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
	public String saveAccount(@Valid @ModelAttribute("account") Account acc, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "accountForm";
		}
		else {
			boolean flag = true;
			String message = "";
			try {
			flag = accSer.saveAccount(acc);
			} catch (Exception e) {
				message = e.getMessage();
				flag= false;
			}
			if(!flag) {
				model.addAttribute("message", message);
				return "accountForm";
			}
			return "redirect:/list";
			
		}
	}

	@RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
	public String updateAccount(@Valid @ModelAttribute("account") Account acc, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "accountForm";
		}
		else {
			accSer.updateAccount(acc);
			return "redirect:/list";
			
		}
	}

	@GetMapping("/list")
	public String listAccounts(Model model) {
		List<Account> accList = accSer.getAllAccount();
		model.addAttribute("accList", accList);
		return "listAccounts";
	}
	
	@GetMapping("/editAcc")
	public String updateAcc(@RequestParam("accNum") int accNum, Model model) {
		Account acc = accSer.getAccountById(accNum);
		model.addAttribute("account", acc);
		return "updateAccountForm";
	}
	
	@GetMapping("/deleteAcc")
	public String deletAcc(@RequestParam("accNum") int accNum) {
		accSer.deleteAccountById(accNum);
		return "redirect:/list";
	}
}
