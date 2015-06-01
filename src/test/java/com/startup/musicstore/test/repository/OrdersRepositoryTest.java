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

package com.startup.musicstore.test.repository;

import com.startup.musicstore.app.conf.ConnectionConfig;
import com.startup.musicstore.domain.CustomerInvoice;
import com.startup.musicstore.domain.OrderItem;
import com.startup.musicstore.domain.Orders;
import com.startup.musicstore.repository.CustomerInvoiceRepository;
import com.startup.musicstore.repository.OrderItemRepository;
import com.startup.musicstore.repository.OrderRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class OrdersRepositoryTest {
    
    public static ApplicationContext ctx;
    private static Long id;
    private OrderRepository orderRepository;
    private static CustomerInvoiceRepository customerInvoiceRepository;
    private static OrderItemRepository orderItemRepository;
    private static CustomerInvoice customerInvoice;
    private static List<OrderItem> orderItem;
    private static OrderItem orderitem1;
    private static OrderItem orderitem2;
    
    
    public OrdersRepositoryTest() 
    {
    }
   
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createOrder() {
        orderRepository= ctx.getBean(OrderRepository.class); 
        Orders order = new Orders.Builder(21)
              .orderDate(new Date())
              .customerInvoice(customerInvoice)
              .orderItem(orderItem)
              .build();
                
        orderRepository.save(order);
        id = order.getId();
        Assert.assertNotNull(order);

    }

    @Test(dependsOnMethods = "createOrder", enabled = true)
    public void readOrder() {
        orderRepository= ctx.getBean(OrderRepository.class);
        Orders order = orderRepository.findOne(id);
        Assert.assertEquals(order.getOrderNumber(), 21);

    }

    @Test(dependsOnMethods = "readOrder", enabled = true)
    private void updateOrder() {
        orderRepository= ctx.getBean(OrderRepository.class);
        
        Orders order = orderRepository.findOne(id);
       
        Orders updatedOrder = new  Orders.Builder(12)
                .Orders(order)
                .orderDate(new Date())
                .customerInvoice(customerInvoice)
                .orderItem(orderItem)
                .build();

       
        orderRepository.save(updatedOrder);
        Orders newOrder = orderRepository.findOne(id);
        Assert.assertEquals(newOrder.getOrderNumber(), 21);

    }

    @Test(dependsOnMethods = "updateOrder", enabled = true)
    private void deleteOrder() {

        orderRepository= ctx.getBean(OrderRepository.class); 
        Orders order = orderRepository.findOne(id);
        orderRepository.delete(order);
        Orders deletedOrder = orderRepository.findOne(id);
        Assert.assertNull(deletedOrder);

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
       
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        
        customerInvoiceRepository = ctx.getBean(CustomerInvoiceRepository.class);
        customerInvoice = new CustomerInvoice.Builder(new Date())
                .orderAmount(new BigDecimal(800.00))
                .invoiceStatus("Paid")
                .build();
        
        customerInvoiceRepository.save(customerInvoice);
        
        orderItemRepository = ctx.getBean(OrderItemRepository.class);
        orderitem1 = new OrderItem.Builder(2)
                .build();
        
        orderitem2 = new OrderItem.Builder(1)
                .build();
        
        orderItem = new ArrayList<>();
        
        orderItem.add(orderitem1);
        orderItem.add(orderitem2);
        
        orderItemRepository.save(orderitem1);
        orderItemRepository.save(orderitem2);
        
        orderItemRepository.save(orderItem);
        
        
        
        
        
        
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
