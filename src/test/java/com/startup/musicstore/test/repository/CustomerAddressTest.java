/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.app.conf.ConnectionConfig;
import com.startup.musicstore.domain.CustomerAddress;
import com.startup.musicstore.repository.CustomerAddressRepository;
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
public class CustomerAddressTest {
    
    public static ApplicationContext ctx;
    private Long id;
    
    private CustomerAddressRepository custAddressrepo;

    
    public CustomerAddressTest() {
    }
   
   
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createCustomerAddress() {
        custAddressrepo = ctx.getBean(CustomerAddressRepository.class); 
        CustomerAddress custAddress = new CustomerAddress.Builder("29 PekeurStreet")
                .PostalAddress("Po.Box 8000")
                .build();
                
        custAddressrepo.save(custAddress);
        id = custAddress.getId();
        Assert.assertNotNull(custAddress);

    }

    @Test(dependsOnMethods = "createCustomerAddress", enabled = true)
    public void readCustomerAddress() {
        custAddressrepo = ctx.getBean(CustomerAddressRepository.class);
        CustomerAddress customerAddress = custAddressrepo.findOne(id);
        Assert.assertEquals(customerAddress.getStreetAddress(), "29 PekeurStreet");

    }

    @Test(dependsOnMethods = "readCustomerAddress", enabled = true)
    private void updateCustomerAddress() {
        custAddressrepo = ctx.getBean(CustomerAddressRepository.class);
        
        CustomerAddress custAddress = custAddressrepo.findOne(id);
       
        CustomerAddress updatedCustomerAddress = new  CustomerAddress.Builder("29 PekeurStreet")
                .CustomerAddress(custAddress)
                .PostalAddress("Po.Box 8250")
                .build();

       
        custAddressrepo.save(updatedCustomerAddress);
        CustomerAddress newCustomerAddress = custAddressrepo.findOne(id);
        Assert.assertEquals(newCustomerAddress.getPostalAddress(), "Po.Box 8250");

    }

    @Test(dependsOnMethods = "updateCustomerAddress", enabled = true)
    private void deleteCustomerAddress() {

        custAddressrepo = ctx.getBean(CustomerAddressRepository.class); 
        CustomerAddress cust = custAddressrepo.findOne(id);
        custAddressrepo.delete(cust);
        CustomerAddress deletedCustomerAddress = custAddressrepo.findOne(id);
        Assert.assertNull(deletedCustomerAddress);

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
       
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        
    }
}
