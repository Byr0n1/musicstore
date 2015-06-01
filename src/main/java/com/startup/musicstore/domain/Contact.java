/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import javax.persistence.Embeddable;

/**
 *
 * @author 212157582
 */
@Embeddable
public class Contact {
    
    private String phoneNumber;
    private String cellNumber;
    
    private Contact()
    {
        
    }
    private Contact(Builder builder)
    {
        this.phoneNumber =builder.phoneNumber;
        this.cellNumber = builder.cellNumber;
    }
    
    
    public static class Builder
    {
          private String phoneNumber;
          private String cellNumber;
          
       public Builder(String value)
       {
           this.cellNumber = value;
       }
          

        public Builder PhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        
        public Builder Contact(Contact contact)
        {
            this.cellNumber = contact.getCellNumber();
            this.phoneNumber = contact.getPhoneNumber();
            return this;
        }

        
        public Contact build()
        {
            return new Contact(this);
        }
                
        

        
    }
    

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCellNumber() {
        return cellNumber;
    }
    
    
    
    
    
}
