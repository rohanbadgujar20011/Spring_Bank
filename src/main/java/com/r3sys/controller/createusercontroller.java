package com.r3sys.controller;

import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.r3sys.controller.BankDao;


@Controller
public class createusercontroller {
	@RequestMapping(path="/createusercontroller",method=RequestMethod.POST)
	public String createusercontroller(Model m,HttpServletRequest request){
		int acc=Integer.parseInt(request.getParameter("acc"));
		String name=request.getParameter("name");
		int bal=Integer.parseInt(request.getParameter("bal"));
		ApplicationContext context = new ClassPathXmlApplicationContext("com/r3sys/controller/config.xml");

		BankDao bankDao=context.getBean("bankDao",BankDao.class);
		Scanner sc=new Scanner(System.in);
		Bank s = context.getBean("bank", Bank.class);
		System.out.println(acc+name+bal);
		s.setAccno(acc);
	    s.setName(name);
	    s.setAmount(bal);
	    
	
		int p=bankDao.insert(s);
		return "dashbord";

		
		
	}

}
