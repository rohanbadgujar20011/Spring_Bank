package com.r3sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.r3sys.controller.BankDao;

@Controller
public class withdrawusercontroller {
	@RequestMapping(path="/withdrawusercontroller",method=RequestMethod.POST)
	public String withdrawusercontroller(Model m,HttpServletRequest request){
		int acc=Integer.parseInt(request.getParameter("acc"));
		int bal=Integer.parseInt(request.getParameter("bal"));
		ApplicationContext context = new ClassPathXmlApplicationContext("com/r3sys/controller/config.xml");

		BankDao bankDao=context.getBean("bankDao",BankDao.class);
		Bank bank1= bankDao.getuser(acc);
		if(bal<=bank1.getAmount()){
		bal=(bank1.getAmount()-bal);
		bank1.setAmount(bal);
		
		bankDao.updateuser(bank1);
		return "dashbord";
		}
		else{
			return "withdraw";
		}
		
	}

}
