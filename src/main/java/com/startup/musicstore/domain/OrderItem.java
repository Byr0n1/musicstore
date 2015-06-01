/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author 212157582
 */
@Entity
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int quantity;
    
    @OneToOne
    private Album album;
    
    private OrderItem()
    {
        
    }
    private OrderItem(Builder builder)
    {
        id = builder.id;
        quantity =builder.quantity;
        album = builder.album;
    }
    
    
    public static class Builder
    {
          private Long id;
          private int quantity;
          private Album album;
          
       public Builder(int value)
       {
           this.quantity = value;
       }
          
        
         public Builder id(Long id) {
            this.id = id;
            return this;
        }
         
         public Builder album(Album album)
         {
             this.album = album;
             return this;
         }
        
        public Builder Orderitem(OrderItem orderitem)
        {
           this.id=orderitem.getId();
           this.quantity = orderitem.getQuantity();
           this.album = orderitem.getAlbum();
          
           return this;
        }

        
        public OrderItem build()
        {
            return new OrderItem(this);
        }
    }

    public int getQuantity() {
        return quantity;
    }
    
    

    public Long getId() {
        return id;
    }
    
    public Album getAlbum()
    {
        return album;
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
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.OrderItem[ id=" + id + " ]";
    }
    
}
