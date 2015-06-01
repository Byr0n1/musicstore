/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;


import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author 212157582
 */
@Entity
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
   @Embedded
   private Name name;
   
   @Embedded
   private Contact contact;
   
   @Embedded
   private Demographic demographic;
    
   @OneToOne
   private CustomerAddress address;
   
   @OneToMany
   @JoinColumn(name="CUST_ID")
   private List <CreditCard> creditcard;
   
   @OneToMany
   @JoinColumn(name="CUST_ID")
   private List <Orders> order;
   
 
   private String  customerNumber;

   
    
    private Customer()
    {
        
    }
    
    
    private Customer(Builder build)
    {
        this.id = build.id;
        this.customerNumber = build.customerNumber;
        this.name = build.name;
        this.address = build.address;
        this.contact = build.contact;
        this.demographic = build.demographic;
        this.creditcard = build.creditcard;
        this.order = build.order;
         
    }
    
    public static class Builder
    {
        private Long id;
        private String  customerNumber;
        private CustomerAddress address;
        private Name name;
        private Contact contact;
        private Demographic demographic;
        private List<CreditCard> creditcard;
        private List <Orders> order;
        
        public Builder(String customerNumber)
        {
            this.customerNumber = customerNumber;
        }
        
        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        
        public Builder address(CustomerAddress address) {
            this.address = address;
            return this;
        }
        
        public Builder name(Name name) {
            this.name = name;
            return this;
        }
        
        public Builder conatact(Contact contact) {
            this.contact = contact;
            return this;
        }
        
        public Builder demographic(Demographic demographic) {
            this.demographic = demographic;
            return this;
        }
        
        public Builder creditcard(List<CreditCard> creditcard)
        {
            this.creditcard = creditcard;
            return this;
        }
        
        public Builder order(List<Orders> order)
        {
            this.order = order;
            return this;
        }
        
        public Builder Customer(Customer customer)
        {
            this.customerNumber = customer.getCustomerNumber();
            this.id = customer.getId();
            this.address = customer.getAddress();
            this.name = customer.getName();
            this.contact = customer.getContact();
            this.demographic = customer.getDemographic();
            this.creditcard  = customer.getCreditCard();
            this.order = customer.getOrder();
            return this;

        }
        
        public Customer build()
        {
            return new Customer(this);
        }
        
        
    }
    
    

     public CustomerAddress getAddress() {
       return address;
    }


     
     public Name getName() {
       return name;
    }
     
     public Contact getContact() {
        return contact;
    }
    
    public String getCustomerNumber() {
        return customerNumber;
    }
    
    public Demographic getDemographic() {
        return demographic;
    }
    
    public List<CreditCard> getCreditCard()
    {
        return creditcard; 
    }
    
    public List<Orders> getOrder() {
        return order;
    }
    
   
    public Long getId() {
        return id;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.Customer[ id=" + id + " ]";
    }
    
}
