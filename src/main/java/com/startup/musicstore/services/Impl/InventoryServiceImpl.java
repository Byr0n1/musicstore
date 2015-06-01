/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.services.Impl;

/*import com.startup.musicstore.domain.Album;
import com.startup.musicstore.domain.AlbumOrder;
import com.startup.musicstore.domain.Customer;
import com.startup.musicstore.domain.OrderItem;
import com.startup.musicstore.respository.AlbumRepository;
import com.startup.musicstore.respository.CustomerRepository;
import com.startup.musicstore.services.InventoryService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;*/

/**
 *
 * @author 212157582
 */

public class InventoryServiceImpl  {

   /* @Autowired
    AlbumRepository albumRepo;
    @Autowired
    CustomerRepository custRepository;

    @Override
    public String updateAlbum(long id) {
        String status = "False";
        Customer cust = custRepository.findOne(id);
        List<AlbumOrder> ordersList = cust.getOrders();
        List<OrderItem> orderItems = new ArrayList<>();
        for(AlbumOrder alb : ordersList)
        {
            orderItems.addAll(alb.getOrderItem());
        }
        if(!orderItems.isEmpty()){
            for(OrderItem item: orderItems)
            {
             Album album = item.getAlbum();
             Album newAlb = new Album.Builder(album.getAlbumTitle())
                     .copier(album)
                     .inventory(album.getInventory()-1)
                     .sales(album.getSales() + 1)
                     .build();
             albumRepo.save(newAlb);
            }
            return "True";
        }
        return status;
     }

    @Override
    public Album find(Long id) {
        return albumRepo.findOne(id);
    }

    @Override
    public Album persist(Album entity) {
        return albumRepo.save(entity);
    }

    @Override
    public Album merge(Album entity) {
        if (entity.getId() != null) {
            return albumRepo.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Album entity) {
        albumRepo.delete(entity);
    }

    @Override
    public List<Album> findAll() {
        return albumRepo.findAll();
    }*/

}
