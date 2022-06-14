package com.r3sys.controller;

import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.r3sys.controller.Bank;

@Controller
public class logincontroller {
	@RequestMapping(path="/logincontroller",method=RequestMethod.POST)
	public String login(Model m,HttpServletRequest request)
	
	{
		String uemail=request.getParameter("uemail");
		String psw=request.getParameter("psw");
		m.addAttribute("uemail",uemail);
		m.addAttribute("psw",psw);
		if(uemail.equals("admin@123") && psw.equals("admin")){
			return "dashbord";
			
		}
		else{
			return "index";
		}
		
		
		
	}

}
