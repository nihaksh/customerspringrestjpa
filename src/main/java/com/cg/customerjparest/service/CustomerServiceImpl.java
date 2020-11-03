package com.cg.customerjparest.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.customerjparest.dao.*;
import com.cg.customerjparest.entities.Customer;
import com.cg.customerjparest.util.ValidationUtil;

import javax.persistence.EntityManager;

@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService {
    
    @Autowired
    private ICustomerDao dao;


    @Override
    public Customer register(Customer customer) {
        customer = dao.add(customer);
        return customer;
    }


	@Override
	public Customer updateName(long id, String name) {
		Customer customer=dao.findById(id);
		customer.setName(name);
		customer=dao.update(customer);
        return customer;
	}


	@Override
	public Customer findById(long id) {
		Customer customer = dao.findById(id);
        return customer;
	}



}
