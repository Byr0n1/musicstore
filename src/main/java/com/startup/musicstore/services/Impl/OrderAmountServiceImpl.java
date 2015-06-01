/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.services.Impl;

/*import com.startup.musicstore.domain.AlbumOrder;
import com.startup.musicstore.domain.CustomerInvoice;
import com.startup.musicstore.domain.OrderItem;
import com.startup.musicstore.respository.OrderRepository;
import com.startup.musicstore.services.OrderAmountService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static sun.java2d.loops.SurfaceType.Custom;*/

/**
 *
 * @author 212157582
 */
public class OrderAmountServiceImpl  {

   /* @Autowired
    OrderRepository orderRepo;

    @Override
    public double getOrderAmnt(int orderNum) {
        List<AlbumOrder> orders = findAll();
        double amount = 0;
        List<OrderItem> orderItems = new ArrayList<>();
        for(AlbumOrder order: orders)
        {
           if(order.getOrderNumber()==orderNum)
           {
               CustomerInvoice inv;
               orderItems= order.getOrderItem();
               for(OrderItem item: orderItems)
               {
                  amount = item.getQuality() *item.getAlbum().getUnitPrice().doubleValue();
               }

           }
        }
        return amount;
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
    }
*/
}
