/*
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
public interface CustomerInvoiceService extends Services<Customer,Long>{
    public String updateInvoice(String customerNumber,int orderNum,String creditCardNumber);
}
