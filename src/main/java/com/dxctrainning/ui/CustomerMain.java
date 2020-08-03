package com.dxctraining.ui;

import com.dxctrainning.dao.*;
import com.dxctrainning.entities.*;
import com.dxctrainning.exceptions.*;
import com.dxctrainning.service.*;
import java.util.*;

public class CustomerMain {

	private ICustomerService customerService = new CustomerServiceImpl();

	public static void main(String[] args) {

		CustomerMain ui = new CustomerMain();

		ui.runUi();

	}

	public void runUi() {

		try {

			BusinessCustomer customer1 = customerService.createBusinessCustomer("Rahul", "banglore-office", "abcf673");

			BusinessCustomer customer2 = customerService.createBusinessCustomer("pranay", "mumbai-office", "abcf673");

			RegularCustomer customer3 = customerService.createRegularCustomer("harish", "delhi-home", "6732hbdcba");

			RegularCustomer customer4 = customerService.createRegularCustomer("neeraj", "goa-home", "98uhjaejaw");

			String id1 = customer1.getId();

			String id2 = customer2.getId();

			customerService.addAmount(id1, 1310);

			customerService.addAmount(id2, 2340);

			customerService.deductAmount(id2, 3450);

			displayAll();

		}

		catch (CustomerNotFoundException e) {

			String msg = e.getMessage();

			System.out.println(msg);

		}

		catch (InvalidCustomerArgumentException e) {

			String msg = e.getMessage();

			System.out.println(msg);

		}

		catch (InvalidAmountException exception) {

			// exception.printStackTrace();

			String msg = exception.getMessage();

			System.out.println(msg);

		}

		catch (InsufficientBalanceException e) {

			String msg = e.getMessage();

			System.out.println(msg);

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void displayAll() {

		List<Customer> list = customerService.findAll();

		for (Customer customer : list) {

			display(customer);

		}

	}

	public void display(Customer customer) {

		System.out.println("*******customer*************");

		System.out.println("custome " + customer.getId() + " " + customer.getName());

		Account account = customer.getAccount();

		System.out.println("pancard " + account.getPancard() + " balance=" + account.getBalance());

		if (customer instanceof RegularCustomer) {

			RegularCustomer regularCustomer = (RegularCustomer) customer;

			System.out.println("House " + regularCustomer.getHouseAddress());

		}

		if (customer instanceof BusinessCustomer) {

			BusinessCustomer businessCustomer = (BusinessCustomer) customer;

			System.out.println("office address " + businessCustomer.getBusinessAddress());

		}

	}

}