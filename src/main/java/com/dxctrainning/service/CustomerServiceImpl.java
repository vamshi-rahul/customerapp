package com.dxctrainning.service;

import com.dxctrainning.dao.*;
import com.dxctrainning.entities.*;
import com.dxctrainning.exceptions.*;
import java.util.*;

public class CustomerServiceImpl implements ICustomerService {
	private ICustomerDao dao = new CustomerDaoImpl();

	@Override
	public Customer findById() {
		validateId(id);
		Customer customer = dao.findById(id);
		return customer;

	}

	@Override
	public void add(Customer customer) {
		dao.add(customer);
	}

	@Override
	public RegularCustomer createRegularCustomer(String name, String houseAddress, String panCard) {
		RegularCustomer customer = new RegularCustomer(name, houseAddress);
		Account account = new Account();
		account.setPancard(panCard);

		customer.setAccount(account);

		dao.add(customer);

		return customer;
	}

	@Override
	public BusinessCustomer createBusinessCustomer(String name, String businessAddress, String panCard) {
		BusinessCustomer customer = new BusinessCustomer(name, businessAddress);
		Account account = new Account();
		account.setPancard(panCard);

		customer.setAccount(account);

		dao.add(customer);

		return customer;
	}

	@Override

	public void delete(String id) {

		validateId(id);

		dao.delete(id);

	}

	@Override
	public List<Customer> findAll() {
		List<Customer> list = dao.findAll();
		return list;

	}

	@Override
	public Customer addAmount(String id, double amount) {
		validateId(id);
		validateAmount(amount);
		Customer customer = dao.findById(id);
		Account account = customer.getAccount();
		double balance = account.getBalance();
		balance = balance + amount;
		account.setBalance(balance);
		return customer;
	}

	@Override
	public Customer deductAmount(String id, double amount) {
		validateId(id);
		validateAmount(amount);
		Customer customer = dao.findById(id);
		Account account = customer.getAccount();
		double balance = account.getBalance();
		if (balance < amount) {
			throw new InsufficientBalanceException("transaction failed due to insuficient funds");
		}
		balance = balance - amount;
		account.setBalance(balance);
		return customer;
	}

	public void validateAmount(double amount) {

		if (amount < 0) {

			throw new InvalidAmountException("amount can't be zero or less than");

		}

	}

	public void validateName(String name) {

		if (name == null || name.isEmpty()) {

			throw new InvalidCustomerArgumentException("name can't be  empty");

		}

	}

	public void validateId(String id) {

		if (id == null || id.isEmpty()) {

			throw new InvalidCustomerArgumentException("id can't be empty");

		}

	}

	public void validateCustomer(Customer customer) {

		if (customer == null) {

			throw new InvalidCustomerArgumentException("customer can't be empty");

		}

	}

}
