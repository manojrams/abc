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
       /* customer.setCutomerId(customerIdCount);// this we are doing because we are not passing the customerId but we are generating
        customerList.add(customer);
        customerIdCount++;
        return customer;
        */// here we are not using database so use above code
       return customerDAO.save(customer);


    }
// method 2 to get list of customers
    public List<Customer> getCustomers(){
        return customerDAO.findAll();

        //return customerList;
    }

//method 3 to get customer by ID
    public Customer getCustomer(int customerId){
        // here we are using stream api to get the first customer by passing the customerId
       /* return customerList
                .stream()
                .filter(e-> e.getCutomerId() == customerId)
                .findFirst()
                .get();*/
       Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
       if(!optionalCustomer.isPresent()){
           throw new CustomerNotFoundException("customer record is not present......");
       }
       return optionalCustomer.get();
    }


    // method 4 to update the customer by passing cutomerId
    public Customer updateCustomer(int customerId,Customer customer){
       /* customerList.stream()
                .forEach(c-> {
                            if (c.getCutomerId() == customerId){
                                c.setCustomerFirstName(customer.getCustomerFirstName());
                                c.setCustomerLastName(customer.getCustomerLastName());
                                c.setCustomerEmail(customer.getCustomerEmail());
                            }

                        }

                        );
        return customerList
                .stream()
                .filter(c-> c.getCutomerId() == customerId)
                .findFirst()
                .get();*/
       customer.setCutomerId(customerId);
       return customerDAO.save(customer);
    }

    // method 5 to delete the customer by passing cutomerId
    public void deleteCustomer(int customerId){
        /*customerList
                .stream()
                .forEach(c-> {
                    if(c.getCutomerId() == customerId){
                        customerList.remove(c);
                    }
                });*/
         customerDAO.deleteById(customerId);
    }





}
