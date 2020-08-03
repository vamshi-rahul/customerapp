package com.dxctrainning.entities;

public class Account {
	double balance;
	String pancard;
	
	/* Account(double balance,String Pancard) {
		this.balance=balance;
		this.pancard=Pancard;
		
	}*/
	
	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public double getBalance() {
		return balance;
	}

	void setBalance( double balance){
		this.balance=balance;		
	}
	

}
