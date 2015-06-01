/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.app.conf.ConnectionConfig;
import com.startup.musicstore.domain.Album;
import com.startup.musicstore.domain.OrderItem;
import com.startup.musicstore.repository.AlbumRepository;
import com.startup.musicstore.repository.OrderItemRepository;
import java.math.BigDecimal;
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
public class OrderItemRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    
    private OrderItemRepository orderitemrepo;
    
    private static AlbumRepository albumRepository;
    
    private static Album album;

    public OrderItemRepositoryTest() {
    }
   
   
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createOrderItem() {
        orderitemrepo= ctx.getBean(OrderItemRepository.class); 
        OrderItem order = new OrderItem.Builder(5)
               .album(album)
               .build();
                
        orderitemrepo.save(order);
        id = order.getId();
        Assert.assertNotNull(order);

    }

    @Test(dependsOnMethods = "createOrderItem", enabled = true)
    public void readOrderItem() {
        orderitemrepo= ctx.getBean(OrderItemRepository.class);
        OrderItem order = orderitemrepo.findOne(id);
        Assert.assertEquals(order.getQuantity(), 5);

    }

    @Test(dependsOnMethods = "readOrderItem", enabled = true)
    private void updateOrderItem() {
        orderitemrepo= ctx.getBean(OrderItemRepository.class);
        
        OrderItem order = orderitemrepo.findOne(id);
       
        OrderItem updatedOrderItem = new  OrderItem.Builder(10)
                .album(album)
                .build();

       
        orderitemrepo.save(updatedOrderItem);
        OrderItem newOrderItem = orderitemrepo.findOne(id);
        Assert.assertEquals(newOrderItem.getQuantity(),5);

    }

    @Test(dependsOnMethods = "updateOrderItem", enabled = true)
    private void deleteOrderItem() {

        orderitemrepo= ctx.getBean(OrderItemRepository.class); 
        OrderItem order = orderitemrepo.findOne(id);
        orderitemrepo.delete(order);
        OrderItem deletedOrderItem = orderitemrepo.findOne(id);
        Assert.assertNull(deletedOrderItem);

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
       
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        
        albumRepository = ctx.getBean(AlbumRepository.class); 
        
        album = new Album.Builder("This is me!")
                .unitPrice(new BigDecimal(150.00))
                .inventory(7)
                .sales(5)
                .build();
        
        albumRepository.save(album);
        
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
