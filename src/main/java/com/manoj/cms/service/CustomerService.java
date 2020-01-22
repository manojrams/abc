package com.manoj.cms.service;

import com.manoj.cms.dao.CustomerDAO;
import com.manoj.cms.exception.CustomerNotFoundException;
import com.manoj.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
/// service layer where business logic is implemented

@Component
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList();// here we are using a customerList to hold the customer object

    // method 1 to add customer
    public Customer addCustomer(Customer customer)
    {
       return customerDAO.save(customer);

    }

// method 2 to get list of customers
    public List<Customer> getCustomers(){
        return customerDAO.findAll();
    }

//method 3 to get customer by ID
    public Customer getCustomer(int customerId){
       Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
       if(!optionalCustomer.isPresent()){
           throw new CustomerNotFoundException("customer record is not present,Please try to add the record......");
       }
       return optionalCustomer.get();
    }


    // method 4 to update the customer by passing cutomerId
    public Customer updateCustomer(int customerId,Customer customer){
       customer.setCutomerId(customerId);
       return customerDAO.save(customer);
    }

    // method 5 to delete the customer by passing cutomerId
    public void deleteCustomer(int customerId){
         customerDAO.deleteById(customerId);
    }





}
