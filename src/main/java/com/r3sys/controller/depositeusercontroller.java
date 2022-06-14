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
public class depositeusercontroller {
	@RequestMapping(path="/depositeusercontroller",method=RequestMethod.POST)
	public String depositeusercontroller(Model m,HttpServletRequest request){
		int acc=Integer.parseInt(request.getParameter("acc"));
		int bal=Integer.parseInt(request.getParameter("bal"));
		ApplicationContext context = new ClassPathXmlApplicationContext("com/r3sys/controller/config.xml");

		BankDao bankDao=context.getBean("bankDao",BankDao.class);
		
		Bank bank2= bankDao.getuser(acc);

		int Depositeamount=(bank2.getAmount()+bal);
		bank2.setAmount(Depositeamount);
	    bankDao.updateuser(bank2);
	    return "dashbord";
	
		
		
	}


}
