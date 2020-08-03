package com.dxctrainning.entities;


public class RegularCustomer extends Customer{
	
	String houseAddress;
	
	public RegularCustomer(String name,String houseAddress){
		super(name);
		this.houseAddress=houseAddress;
	}
	public String getHouseAddress(){
		return houseAddress;	}
	
	void setHouseAddress(String houseAddress){
		this.houseAddress=houseAddress;

	}
}
