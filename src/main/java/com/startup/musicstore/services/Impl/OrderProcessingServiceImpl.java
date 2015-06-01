/*/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.services.Impl;

/*import com.startup.musicstore.domain.AlbumOrder;
import com.startup.musicstore.domain.Customer;
import com.startup.musicstore.respository.CustomerRepository;
import com.startup.musicstore.respository.OrderRepository;
import com.startup.musicstore.services.OrderProcessingService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;*/

/**
 *
 * @author 212157582
 */
public class OrderProcessingServiceImpl  {

   /* @Autowired
    CustomerRepository custRepo;
    @Autowired
    OrderRepository orderRepo;

    @Override
    public List<AlbumOrder> getPendingOrders() {
       
        List<AlbumOrder> albOrders_all = findAll();
        List<AlbumOrder> albOrders_pending = new ArrayList<>();
        for (AlbumOrder album : albOrders_all) {
            if(album.getInvoice().getInvoiceStatus().equalsIgnoreCase("UNPAID"))
                albOrders_pending.add(album);
        }
        return albOrders_pending;
    }

    @Override
    public List<Customer> getPendingCustomers() {
       
        List<AlbumOrder> albOrders_pending = getPendingOrders();
        List<Customer>  orderCust = new ArrayList<>();
        for (AlbumOrder alb : albOrders_pending) {
            orderCust.add(alb.getCustomer());
        }
        return orderCust;
    }

    @Override
    public AlbumOrder find(Long id) {
        return orderRepo.findOne(id);
    }

    @Override
    public AlbumOrder persist(AlbumOrder entity) {
        return orderRepo.save(entity);
    }

    @Override
    public AlbumOrder merge(AlbumOrder entity) {
        if (entity.getId() != null) {
            return orderRepo.save(entity);
        }
        return null;
    }

    @Override
    public void remove(AlbumOrder entity) {
        orderRepo.delete(entity);
    }

    @Override
    public List<AlbumOrder> findAll() {
        return orderRepo.findAll();
    }*/

}
