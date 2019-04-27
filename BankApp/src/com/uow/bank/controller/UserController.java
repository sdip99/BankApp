package com.uow.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uow.bank.model.Account;
import com.uow.bank.service.AccountService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	AccountService accSer;
	
	@RequestMapping("/new")
	public String accountForm(Model model) {
		model.addAttribute("account", new Account());
		return "accountForm";
	}
}
