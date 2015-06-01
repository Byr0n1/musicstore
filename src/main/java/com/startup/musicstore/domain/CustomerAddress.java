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

/**
 *
 * @author 212157582
 */
@Entity
public class CustomerAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String streetAddress;
    private String postalAddress;

    
    
    
    
    private CustomerAddress()
    {
        
    }
    
    private CustomerAddress(Builder builder)
    {
        id = builder.id;
        streetAddress = builder.streetAddress;
        postalAddress = builder.postalAddress;
    }
    
    public static class Builder
    {
        private String streetAddress;
        private String postalAddress;
        private Long id;

        
        public Builder(String streetAddress)
        {
            this.streetAddress = streetAddress;
           
        }
        
        public Builder id(Long id) {
           this.id =id;
           return this;
        }

        
        
        public Builder PostalAddress(String postalAddress) {
            
            this.postalAddress = postalAddress;
            return this;
        }
        
        public Builder CustomerAddress(CustomerAddress cutomerAddress)
        {
            this.id = cutomerAddress.getId();
            this.postalAddress = cutomerAddress.getPostalAddress();
            this.streetAddress = cutomerAddress.getStreetAddress();
            
            return this;
        }

        public CustomerAddress build()
        {
            return new CustomerAddress(this);
        }
       

        
    }

    public Long getId() {
        return id;
    }
    
    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
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
        if (!(object instanceof CustomerAddress)) {
            return false;
        }
        CustomerAddress other = (CustomerAddress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.CustomerAddress[ id=" + id + " ]";
    }
    
}
