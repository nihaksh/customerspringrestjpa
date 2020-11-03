package com.cg.customerjparest.dao;


import org.springframework.stereotype.Repository;

import com.cg.customerjparest.entities.Customer;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerDaoImpl implements ICustomerDao {
 

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer add(Customer customer) {
        entityManager.persist(customer);
		return customer;
	}
    @Override
    public Customer findById(long id){
       Customer customer = entityManager.find(Customer.class, id);
                return customer;
    }

   @Override
    public Customer update(Customer customer) {
        customer = entityManager.merge(customer);
        return customer;
    }

  



}
