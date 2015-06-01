/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.app.conf.ConnectionConfig;
import com.startup.musicstore.domain.Contact;
import com.startup.musicstore.domain.CreditCard;
import com.startup.musicstore.domain.Customer;
import com.startup.musicstore.domain.CustomerAddress;
import com.startup.musicstore.domain.Demographic;
import com.startup.musicstore.domain.Name;
import com.startup.musicstore.domain.Orders;
import com.startup.musicstore.repository.CreditCardRepository;
import com.startup.musicstore.repository.CustomerAddressRepository;
import com.startup.musicstore.repository.CustomerRepository;
import com.startup.musicstore.repository.OrderRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author 212157582
 */
public class CustomerRepositoryTest {
    
    public static ApplicationContext ctx;
    private static Long id;
    private CustomerRepository customerRepository;
    private static CustomerAddressRepository customerAddressRepository;
    private static CreditCardRepository creditCardRepository;
    private static OrderRepository orderRepository;
    private static CustomerAddress address;
    private static Name name;
    private static Contact contact;
    private static Demographic demographic;
    private static List<CreditCard> creditcardlist;
    private static CreditCard creditcard1;
    private static CreditCard creditcard2;
    private static List<Orders> orderList;
    private static Orders order1;
    private static Orders order2;
    
    public CustomerRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createCustomer() {
        
       customerRepository = ctx.getBean(CustomerRepository.class);
        Customer customer = new Customer.Builder("1008")
                .name(name)
                .conatact(contact)
                .demographic(demographic)
                .address(address)
                .creditcard(creditcardlist)
                .order(orderList)
                .build();
        
        customerRepository.save(customer);
        id = customer.getId();
        
        Assert.assertNotNull(customer);

    }
    
    @Test(dependsOnMethods = "createCustomer", enabled = true)
    public void readCustomer() {
        customerRepository= ctx.getBean(CustomerRepository.class);
        Customer customer = customerRepository.findOne(id);
        Assert.assertEquals(customer.getCustomerNumber(), "1008");

    }

    @Test(dependsOnMethods = "readCustomer", enabled = true)
    private void updateCustomer() {
        customerRepository= ctx.getBean(CustomerRepository.class);
        
        Customer customer = customerRepository.findOne(id);
       
        Customer Updatecustomer = new Customer.Builder("205")
                .name(name)
                .conatact(contact)
                .demographic(demographic)
                .address(address)
                .creditcard(creditcardlist)
                .order(orderList)
                .build();

       
        customerRepository.save(Updatecustomer);
        Customer newCustomer = customerRepository.findOne(id);
        Assert.assertEquals(newCustomer.getCustomerNumber(), "1008");

    }

    @Test(dependsOnMethods = "updateCustomer", enabled = true)
    private void deleteCustomer() {

        customerRepository= ctx.getBean(CustomerRepository.class);
        
        Customer customer = customerRepository.findOne(id);
        customerRepository.delete(customer);
        Customer customerOrder = customerRepository.findOne(id);
        Assert.assertNull(customerOrder);

    }

    
    

    @BeforeClass
    public static void setUpClass() throws Exception {
       ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
       
       name = new Name.Builder("Muneem")
               .surname("Waggie")
               .build();
       
       contact = new Contact.Builder("074 809 0176")
               .PhoneNumber("023-614 2597")
               .build();
       
       demographic = new Demographic.Builder("Male")
               .race("All Kind")
               .dateofBirth(new Date("7/15/1989"))
               .build();
       
       
       customerAddressRepository = ctx.getBean(CustomerAddressRepository.class);
       address = new CustomerAddress.Builder("39 PekeurStreet Montagu 6720")
               .PostalAddress("Po.Box 8060")
               .build();
       
       customerAddressRepository.save(address);
       id = address.getId();
       
       
       creditCardRepository = ctx.getBean(CreditCardRepository.class);
       creditcard1 = new CreditCard.Builder("012568 01259 7895")
               .expiryDate(new Date())
               .nameOnCreditCard("Waggie M")
               .balance(new BigDecimal(5000.00))
               .build();
       
       creditcard2 = new CreditCard.Builder("12345 14586 1596")
               .expiryDate(new Date())
               .nameOnCreditCard("Muneem W")
               .balance(new BigDecimal(10000.00))
               .build();
       
       
       
       creditcardlist = new ArrayList<>();
       
       creditcardlist.add(creditcard1);
       creditcardlist.add(creditcard2);
       
       creditCardRepository.save(creditcardlist);
       
       
      orderRepository = ctx.getBean(OrderRepository.class);
        order1 = new Orders.Builder(1)
               .orderDate(new Date("6/25/2014"))
               .build();
       
        order2 = new Orders.Builder(2)
               .orderDate(new Date("7/25/2014"))
               .build();
        
       orderList = new ArrayList<>();
       
      
       orderList.add(order1);
       orderList.add(order2);
       
       orderRepository.save(order1);
       orderRepository.save(order2);
       
       orderRepository.save(orderList);
       
       
       
       
       
       
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
