package com.dxctrainning.entities;

public class Customer {
	String id;
	String name;
	double balance;
	private Account account;

	public Customer(String name) {

		this.name = name;

	}

	/*public Customer(String id, String name, double balance, Account account) {
		this(id, name, balance);
		this.account = account;
	}*/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override

	public String toString() {
		String str = name + " " + id + " " + balance;
		return str;
	}

	@Override

	public int hashCode() {

		int hashcode = id.hashCode();

		return hashcode;

	}
}
