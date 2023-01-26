package com.techelevator.tenmo.dao;



import com.techelevator.tenmo.model.Customer;

import java.util.List;

public interface CustomerDao {

    public List<Customer> getAllCustomers();

    public Customer getCustomerById(int id);

    public Customer addNewCustomer(Customer customer);

    public void updateCustomer(Customer customer);


}
