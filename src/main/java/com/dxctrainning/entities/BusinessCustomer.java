package com.dxctrainning.entities;

public class BusinessCustomer extends Customer {
	String businessAddress;

	public BusinessCustomer(String name,String businessAddress){
		super(name);
		this.businessAddress=businessAddress;
	}

	public String getBusinessAddress() {
		return businessAddress;
	}

	void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;

	}
}