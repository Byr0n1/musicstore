/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.services;

/*import com.startup.musicstore.domain.Album;
import com.startup.musicstore.domain.AlbumOrder;
import com.startup.musicstore.domain.Customer;
import com.startup.musicstore.domain.CustomerInvoice;
import com.startup.musicstore.domain.OrderItem;
import com.startup.musicstore.respository.AlbumRepository;
import com.startup.musicstore.respository.CustomerInvoiceRepository;
import com.startup.musicstore.respository.CustomerRepository;
import com.startup.musicstore.respository.OrderItemRepository;
import com.startup.musicstore.respository.OrderRepository;
import com.startup.musicstore.services.InventoryService;
import com.startup.musicstore.test.ConnectionConfigTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;*/

/**
 *
 * @author 212157582
 */
public class InventoryServiceTest {
   /* private Customer cust;
    private OrderItem orderItem;
    private AlbumOrder orderAlb;
    private CustomerInvoice custInvoice;
    public List<AlbumOrder> albOrderList = new ArrayList<>();
    private final List<OrderItem> orderItemList = new ArrayList<>();
    private static OrderRepository orderRepo;
    private static CustomerRepository custRepo;
    private static OrderItemRepository itemRepo;
    private static AlbumRepository albumRepo;
    private static CustomerInvoiceRepository invoiceRepo;
    private static ApplicationContext ctx;
    private long id;
     private long custid;
    public InventoryServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void testCreate() {
        orderRepo = ctx.getBean(OrderRepository.class);
        invoiceRepo = ctx.getBean(CustomerInvoiceRepository.class);
        custRepo = ctx.getBean(CustomerRepository.class);
        custInvoice = new CustomerInvoice.Builder("Done")
                //.albOrder(orderAlb)
                .orderAmnt(BigDecimal.valueOf(200))
                .build();
        invoiceRepo.save(custInvoice);
      
      albumRepo = ctx.getBean(AlbumRepository.class);
      Album  album = new Album.Builder("The Music")
                //.marketInfo(marketInfo)
                //.tracks(tracks)
                .unitPrice(BigDecimal.valueOf(100))
                .sales(2)
                .inventory(8)
                .build();
        albumRepo.save(album);
        
        orderItem = new OrderItem.Builder(12).album(album).build();
        orderItemList.add(orderItem);
        orderAlb = new AlbumOrder.Builder(1234556)
                .orderItem(orderItemList)
                //.Customer(cust)
                //.cusInvoice(custInvoice)
                .build();
        orderRepo.save(orderAlb);
        albOrderList.add(orderAlb);
        cust = new Customer.Builder("1235").orders(albOrderList).build();
        custRepo.save(cust);
        id=orderAlb.getId();
        custid = cust.getId();
    }*/
   /* @Test(dependsOnMethods="testCreate")
    public void testIventnory(){
        InventoryService inservice = ctx.getBean(InventoryService.class);
        String status = inservice.updateAlbum(6);
        Assert.assertEquals(status,"True");
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
    }*/
}
