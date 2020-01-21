package com.manoj.cms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    // I am adding all attributes which acts as entity
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)// this step will generate the customer Id
    @JsonProperty("id") // here I am using json property to hide my attribute names
    private int cutomerId;
    @JsonProperty("FirstName")
    private String customerFirstName;
    @JsonProperty("LastName")
    private String customerLastName;
    @JsonProperty("Email")
    private String customerEmail;

    public int getCutomerId() {
        return cutomerId;
    }

    public void setCutomerId(int cutomerId) {
        this.cutomerId = cutomerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
