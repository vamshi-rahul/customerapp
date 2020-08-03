package com.dxctrainning.dao;

import com.dxctrainning.entities.*;
import java.util.List;

public interface ICustomerDao {
	Customer findById(String id);

	void add(Customer customer);

	void delete(String id);

	List<Customer> findAll();

	Customer updateName(String id, String name);

}
