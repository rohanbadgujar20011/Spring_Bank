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
public class Transferusercontroller {
	@RequestMapping(path="/Transferusercontroller",method=RequestMethod.POST)
	public String Transferusercontroller(Model m,HttpServletRequest request){
		int acc=Integer.parseInt(request.getParameter("acc"));
		int acc2=Integer.parseInt(request.getParameter("acc2"));
		int bal=Integer.parseInt(request.getParameter("bal"));
		ApplicationContext context = new ClassPathXmlApplicationContext("com/r3sys/controller/config.xml");
		BankDao bankDao=context.getBean("bankDao",BankDao.class);
		Bank bank3= bankDao.getuser(acc);
		Bank bank4= bankDao.getuser(acc2);
		int first=bank3.getAmount();
		int second=bank4.getAmount();
		if(first>=bal){
			first=first-bal;
			bank3.setAmount(first);
			second=second+bal;
			bank4.setAmount(second);
			bankDao.updateuser(bank3);
			bankDao.updateuser(bank4);
			return "dashbord";
			
		}
		else{
			return "transfer";
		}
		

		
	}

}
