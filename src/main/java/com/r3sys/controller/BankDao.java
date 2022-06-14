package com.r3sys.controller;

import javax.transaction.Transactional;


import org.springframework.orm.hibernate5.HibernateTemplate;

public class BankDao {
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Transactional //for making transaction with database like insert, delete, update
	public int insert(Bank bank) {
	// insert
	Integer i = (Integer) this.hibernateTemplate.save(bank);
	return i;
	}
	public Bank getuser(int accno) {
		Bank bank = this.hibernateTemplate.get(Bank.class, accno);
		return bank;
		}
	@Transactional //for making transaction with database like insert, delete, update
	public void updateuser(Bank bank) {
	this.hibernateTemplate.update(bank);
	}

}
