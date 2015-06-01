/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author 212157582
 */
@Entity
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int orderNumber;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date orderDate;
    
    @OneToOne
    private CustomerInvoice customerInvoice;
    
    @OneToMany
    @JoinColumn(name ="ORDER_ID")
    private List<OrderItem> orderItem;
    
    
    private Orders()
    {
        
    }
    private Orders(Builder builder)
    {
        this.id = builder.id;
        this.orderNumber =builder.orderNumber;
        this.orderDate = builder.orderDate;
        this.customerInvoice = builder.customerInvoice;
        this.orderItem = builder.orderItem; 
    }
    
    
    public static class Builder
    {
          private int orderNumber;
          private Date orderDate;
          private Long id;
          private CustomerInvoice customerInvoice;
          private List<OrderItem> orderItem;
          
       public Builder(int value)
       {
           this.orderNumber = value;
       }
          

        public Builder orderDate(Date orderDate) {
            this.orderDate = orderDate;
            return this;
        }
        
         public Builder id(Long id) {
            this.id = id;
            return this;
        }
         
         public Builder customerInvoice(CustomerInvoice customerInvoice) {
            this.customerInvoice = customerInvoice ;
            return this;
        }
         
         public Builder orderItem(List<OrderItem> orderItem) {
            this.orderItem = orderItem ;
            return this;
        }
         
         
        
        public Builder Orders(Orders order)
        {
            this.id = order.getId();
            this.orderDate = order.getOrderDate();
            this.orderNumber = order.getOrderNumber();
            this.customerInvoice = order.getCustomerInvoice();
            this.orderItem = order.getOrderItem();
            
            return this;
        }

        
        public Orders build()
        {
            return new Orders(this);
        }
                
        
    }
    

    public int getOrderNumber() {
        return orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Long getId() {
        return id;
    }

    public CustomerInvoice getCustomerInvoice()
    {
        return customerInvoice;
    }
   
    public List<OrderItem> getOrderItem()
    {
        return orderItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.Order[ id=" + id + " ]";
    }
    
}
