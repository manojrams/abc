package com.manoj.cms.dao;

import com.manoj.cms.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends CrudRepository<Customer,Integer> {

    @Override
    List<Customer> findAll(); // this finall should return List instaed of itertable Customer Object

}
