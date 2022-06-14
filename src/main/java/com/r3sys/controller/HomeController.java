package com.r3sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home()
	{
	System.out.println("This is home url..");
	return "index";
	}
	@RequestMapping("/withdraw")
	public String withdraw()
	{
	System.out.println("This is withdrawal");
	return "withdraw";
	}
	@RequestMapping("/deposite")
	public String deposite()
	{
	System.out.println("This is deposite");
	return "deposite";
	}
	@RequestMapping("/transfer")
	public String transfer()
	{
	System.out.println("This is transfer");
	return "transfer";
	}
	@RequestMapping("/createuser")
	public String logincontroller()
	{
	System.out.println("This is controller");
	return "createuser";
	}
	@RequestMapping("/viewuser")
	public String viewuser()
	{
	System.out.println("This is viewuser");
	return "viewuser";
	}

}
