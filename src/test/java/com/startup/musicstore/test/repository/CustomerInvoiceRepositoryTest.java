/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.app.conf.ConnectionConfig;
import com.startup.musicstore.domain.CustomerInvoice;
import com.startup.musicstore.repository.CustomerInvoiceRepository;
import java.math.BigDecimal;
import java.util.*;
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
public class CustomerInvoiceRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    
    private CustomerInvoiceRepository custrepo;

    
    public CustomerInvoiceRepositoryTest() {
    }
   
   
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createCustomerInvoice() {
        custrepo= ctx.getBean(CustomerInvoiceRepository.class); 
        CustomerInvoice custinvoice = new CustomerInvoice.Builder(new Date("03/08/2014"))
              .invoiceStatus("Pending")
              .orderAmount(BigDecimal.valueOf(456.65))
              .build();
                
        custrepo.save(custinvoice);
        id = custinvoice.getId();
        Assert.assertNotNull(custinvoice);

    }

    @Test(dependsOnMethods = "createCustomerInvoice", enabled = true)
    public void readCustomerInvoice() {
        custrepo= ctx.getBean(CustomerInvoiceRepository.class);
        CustomerInvoice custinvoice = custrepo.findOne(id);
        Assert.assertEquals(custinvoice.getInvoicedate(),new Date("03/08/2014"));

    }

    @Test(dependsOnMethods = "readCustomerInvoice", enabled = true)
    private void updateCustomerInvoice() {
        custrepo= ctx.getBean(CustomerInvoiceRepository.class);
        
        CustomerInvoice custinvoice = custrepo.findOne(id);
       
        CustomerInvoice updatedCustomerInvoice = new CustomerInvoice.Builder(new Date("03/08/2014"))
              .CustomerInvoice(custinvoice)
              .orderAmount(BigDecimal.valueOf(499.99))
              .build();

       
        custrepo.save(updatedCustomerInvoice);
        CustomerInvoice newCustomerInvoice = custrepo.findOne(id);
        Assert.assertEquals( newCustomerInvoice.getOrderAmount(),BigDecimal.valueOf(499.99));

    }

    @Test(dependsOnMethods = "updateCustomerInvoice", enabled = true)
    private void deleteCustomerInvoice() {

        custrepo= ctx.getBean(CustomerInvoiceRepository.class); 
        CustomerInvoice cust = custrepo.findOne(id);
        custrepo.delete(cust);
        CustomerInvoice deletedCustomerInvoice = custrepo.findOne(id);
        Assert.assertNull(deletedCustomerInvoice);

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
