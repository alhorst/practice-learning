package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.CustomerDao;
import com.techelevator.tenmo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;


    /**
     * Return All Customer
     *
     * @return a list of all customers in the system
     */
    @PreAuthorize("permitAll")
    @RequestMapping(path = "/customers", method = RequestMethod.GET)
    public List<Customer> list() {
        return customerDao.getAllCustomers();
    }

    /**
     * Return customer information
     *
     * @param id the id of the customer
     * @return all info for a given customer
     */
    @RequestMapping(path = "/customer/{id}", method = RequestMethod.GET)
    public Customer get(@PathVariable int id) {

        return customerDao.getCustomerById(id);
    }

    @PostMapping("/newCustomer")
    public Customer createNewCustomer(@RequestBody Customer customer){
        System.out.println(customer.getCustomerName());
        return customerDao.addNewCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    public void  updateCustomer(@RequestBody Customer customer) {
        customerDao.updateCustomer(customer);
    }


}
