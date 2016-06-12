package com.bov.dto;

import java.util.List;

public class Account {
	
	int id;
	String name;
	String accountOne;
	String accountTwo;
	String accountNumberOne;
	String accountNumberTwo;
	String loanType;
	String loanAmount;
	List<Stock> stockList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountOne() {
		return accountOne;
	}
	public void setAccountOne(String accountOne) {
		this.accountOne = accountOne;
	}
	public String getAccountTwo() {
		return accountTwo;
	}
	public void setAccountTwo(String accountTwo) {
		this.accountTwo = accountTwo;
	}
	public String getAccountNumberOne() {
		return accountNumberOne;
	}
	public void setAccountNumberOne(String accountNumberOne) {
		this.accountNumberOne = accountNumberOne;
	}
	public String getAccountNumberTwo() {
		return accountNumberTwo;
	}
	public void setAccountNumberTwo(String accountNumberTwo) {
		this.accountNumberTwo = accountNumberTwo;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	public List<Stock> getStockList() {
		return stockList;
	}
	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}

}
