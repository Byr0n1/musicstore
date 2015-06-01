/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services.Impl;

import com.startup.musicstore.domain.Customer;
import com.startup.musicstore.domain.CustomerAddress;
import com.startup.musicstore.repository.CustomerAddressRepository;
import com.startup.musicstore.repository.CustomerRepository;
import com.startup.musicstore.services.CustomerContactService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 212157582
 */
@Service
public class CustormerContactServiceImpl implements CustomerContactService{

    
    @Autowired
    private  CustomerRepository customerRepository;

    
    @Override
     public String findCustomerAddress(String number) {
        String customerAddress = "";
        List<Customer> all = customerRepository.findAll();
        for(Customer cust : all)
        {
            if(cust.getCustomerNumber().equalsIgnoreCase(number))
            {
                customerAddress = cust.getAddress().getStreetAddress();
            }
        }
        return customerAddress;
    }
     
     
     
    
    @Override
    public String findCustomerCellNumber(String number) {
        String customerNumber = "";
        List<Customer> all = customerRepository.findAll();
        for(Customer c : all)
        {
            if(c.getCustomerNumber().equalsIgnoreCase(number))
            {
                customerNumber = c.getContact().getCellNumber();
            }
        }
        
        return customerNumber;
        
    }
    

   

    @Override
    public Customer find(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer persist(Customer entity) {
        return customerRepository.save(entity);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer merge(Customer entity) {
         if (entity.getId() != null) {
            return customerRepository.save(entity);
        }
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Customer entity) {
        customerRepository.delete(entity);
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> findAll() {
         return customerRepository.findAll(); //To change body of generated methods, choose Tools | Templates.
    }
}
