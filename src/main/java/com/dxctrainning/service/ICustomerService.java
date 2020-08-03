package com.dxctrainning.service;
import com.dxctrainning.entities.*;



import java.util.*;

public interface ICustomerService {
	 Customer findById(String id);



	    void add(Customer customer);



	    void delete(String id);



	    List<Customer> findAll();



	    Customer updateName(String id, String name);



	    RegularCustomer createRegularCustomer(String name, String houseAddress, String pancard);



	    BusinessCustomer createBusinessCustomer(String name, String office, String pancard);



	    Customer addAmount(String id,double amount);



	    Customer deductAmount(String id,double amount);







	}


