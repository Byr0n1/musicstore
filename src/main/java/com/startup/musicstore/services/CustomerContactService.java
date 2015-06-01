/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services;

import com.startup.musicstore.domain.Customer;

/**
 *
 * @author 212157582
 */

public interface CustomerContactService extends Services<Customer, Long>{
    
     public String findCustomerAddress(String address);
     public String findCustomerCellNumber(String number);
}
