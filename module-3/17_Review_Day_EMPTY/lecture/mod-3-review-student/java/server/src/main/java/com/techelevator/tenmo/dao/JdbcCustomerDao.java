package com.techelevator.tenmo.dao;


import com.techelevator.tenmo.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCustomerDao implements CustomerDao{

    JdbcTemplate jdbcTemplate;

    public JdbcCustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = new ArrayList<>();
        String sql = "SELECT customer_id, name, address, phone FROM customer";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            allCustomers.add(mapRowToCustomer(results));
        }
        return allCustomers;
    }

    @Override
    public Customer getCustomerById(int id) {
        String sql = "SELECT customer_id, name, address, phone FROM customer WHERE customer_id = ?";
        Customer customer = null;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()){
            customer = (mapRowToCustomer(results));
        }
        return customer;
    }

    @Override
    public Customer addNewCustomer(Customer customer) {
        String sql = "INSERT into customer (name, address, phone) "+
                "VALUES (?, ?, ?) RETURNING customer_id";
        int cust_id = jdbcTemplate.queryForObject(sql, Integer.class, customer.getCustomerName(),
                customer.getCustomerAddress(), customer.getPhoneNumber());

        Customer returnedCustomer = getCustomerById(cust_id);
        return returnedCustomer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        String sql = "UPDATE customer SET name = ?, address=?, phone=? WHERE customer_id = ?";
        jdbcTemplate.update(sql, customer.getCustomerName(), customer.getCustomerAddress(), customer.getPhoneNumber(), customer.getCustomerId());
    }

    private Customer mapRowToCustomer(SqlRowSet results){
        Customer customer = new Customer();
        customer.setCustomerId(results.getInt("customer_id"));
        customer.setCustomerName(results.getString("name"));
        customer.setCustomerAddress(results.getString("address"));
        customer.setPhoneNumber(results.getString("phone"));

        return customer;
    }
}
