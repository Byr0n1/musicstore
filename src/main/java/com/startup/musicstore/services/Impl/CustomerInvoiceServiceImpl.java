/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.services.Impl;

/*import com.startup.musicstore.domain.AlbumOrder;
import com.startup.musicstore.domain.CreditCard;
import com.startup.musicstore.domain.Customer;
import com.startup.musicstore.domain.CustomerInvoice;
import com.startup.musicstore.respository.CustomerRepository;
import com.startup.musicstore.respository.OrderRepository;
import com.startup.musicstore.services.CustomerInvoiceService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;*/

/**
 *
 * @author 212157582
 */

public class CustomerInvoiceServiceImpl {

    /*@Autowired
    CustomerRepository custRepo;
    @Autowired
    OrderRepository orderRepo;

    @Override
    public String updateInvoice(String customerNumber, int orderNum, String creditCardNumber) {
        List<Customer> custList = findAll();
        List<CreditCard> creditCards = new ArrayList<>();
        Customer currentCust = null;
        double balance = 0;
        double orderAmnt = 0;
        for (Customer cust : custList) {
            if (cust.getCustomerNumber().equalsIgnoreCase(customerNumber)) {
                currentCust = cust;
            }
        }
        creditCards = currentCust.getCreditCard();
        for (CreditCard card : creditCards) {
            if (card.getCreditNumber().equalsIgnoreCase(creditCardNumber)) {
                balance = card.getBalance().doubleValue();
            }
        }

        List<AlbumOrder> ordersList = orderRepo.findAll();
        for (AlbumOrder order : ordersList) {
            if (order.getOrderNumber() == orderNum) {
                orderAmnt = order.getInvoice().getOrderAmnt().doubleValue();
            }
            if (balance >= orderAmnt) {
               // CustomerInvoice custInvoice = order.getInvoice();
              //  AlbumOrder order = new AlbumOrder.Builder(order.getOrderNumber()).copier(order).cusInvoice(null).build();
            }
        }
        return null;

    }

    @Override
    public Customer persist(Customer entity) {
        return custRepo.save(entity);
    }

    @Override
    public Customer merge(Customer entity) {
        if (entity.getId() != null) {
            return custRepo.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Customer entity) {
        custRepo.delete(entity);
    }

    @Override
    public List<Customer> findAll() {
        return custRepo.findAll();
    }

    @Override
    public Customer find(Long id) {
        return custRepo.findOne(id);
    }
*/
}
