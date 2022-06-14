package com.r3sys.controller;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity //tells container a class can be map to a table
@Table(name="user_details") // name of database table to be used for mapping
@Component //create object automatically


public class Bank {
	@Id
	private int accno;
	
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public Bank(int accno, String name, int amount) {
		super();
		this.accno = accno;
		Name = name;
		Amount = amount;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	private String Name;
	private int Amount;
}