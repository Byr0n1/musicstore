/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services;


import com.startup.musicstore.domain.Album;
import com.startup.musicstore.domain.Customer;
import java.util.List;

/**
 *
 * @author 212157582
 */
public interface OrderProcessingService extends Services<Album,Long>{
    public List<Album> getPendingOrders();
    public List<Customer> getPendingCustomers();
}
