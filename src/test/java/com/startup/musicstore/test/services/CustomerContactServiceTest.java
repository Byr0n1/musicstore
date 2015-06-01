/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.services;

import com.startup.musicstore.domain.Contact;
import com.startup.musicstore.domain.Customer;
import com.startup.musicstore.domain.CustomerAddress;
import com.startup.musicstore.repository.CustomerAddressRepository;
import com.startup.musicstore.repository.CustomerRepository;
import com.startup.musicstore.services.CustomerContactService;
import com.startup.musicstore.test.ConnectionConfigTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author 212157582
 */
public class CustomerContactServiceTest {
    
    public static ApplicationContext ctx;
    
    private CustomerContactService  customerContactService;
    
    private CustomerRepository customerRepository;
    
    private CustomerAddressRepository customerAddressRepository;
    
    public CustomerContactServiceTest() {
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void findCustomerContactDetails() {
     
         
         
         customerRepository = ctx.getBean(CustomerRepository.class);
         customerContactService = ctx.getBean(CustomerContactService.class);
         
         customerAddressRepository = ctx.getBean(CustomerAddressRepository.class);
         CustomerAddress customerAddress1 = new CustomerAddress.Builder("39 Pekeur Street Montagu 6720")
                .PostalAddress("Po.Box 69")
                .build();
         
         CustomerAddress customerAddress2 = new CustomerAddress.Builder("24 Chopin Road Belhar 7894")
                .PostalAddress("Po.Box 78")
                .build();
         
         CustomerAddress customerAddress3 = new CustomerAddress.Builder("01 JohnsonAve Toloko 7894")
                .PostalAddress("Po.Box 859")
                .build();
         
         
         
         
         customerAddressRepository.save(customerAddress1);
         customerAddressRepository.save(customerAddress2);
         customerAddressRepository.save(customerAddress3);
         
         
         Contact customerCell1 = new Contact.Builder("078 789 4561")
                .PhoneNumber("023 614 2597")
                .build();
         
         Contact customerCell2 = new Contact.Builder("079 456 852")
                .PhoneNumber("021 159 789")
                .build();
         
         Contact customerCell3 = new Contact.Builder("081 458 6589")
                 .PhoneNumber("023 614 1930")
                .build();
         
         
         Customer customer1 = new Customer.Builder("1002")
                 .address(customerAddress1)
                 .conatact(customerCell1)
                 .build();
         
        Customer customer2 = new Customer.Builder("1003")
                 .address(customerAddress2)
                  .conatact(customerCell2)
                 .build();
        
        Customer customer3 = new Customer.Builder("1004")
                 .address(customerAddress3)
                 .conatact(customerCell3)
                 .build();
         
         customerRepository.save(customer1);
         customerRepository.save(customer2);
         customerRepository.save(customer3);
         
        
        String customerAddress = customerContactService.findCustomerAddress("1002");
         
        Assert.assertEquals(customerAddress,"39 Pekeur Street Montagu 6720");
         
        String customerNumber = customerContactService.findCustomerCellNumber("1004");
         
        Assert.assertEquals(customerNumber,"081 458 6589");
     }
     
 
    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
       /* customerRepository = ctx.getBean(CustomerRepository.class);
        customerRepository.deleteAll();*/
        
    }
}
