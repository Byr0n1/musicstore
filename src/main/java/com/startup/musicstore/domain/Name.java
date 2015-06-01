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
public class Name {
    
    private String name;
    private String surname;
    
    private Name()
    {
        
    }
    private Name(Builder builder)
    {
        name =builder.name;
        surname = builder.surname;
    }
    
    
    public static class Builder
    {
          private String name;
          private String surname;
          
       public Builder(String value)
       {
           this.name = value;
       }
          

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }
        
        public Builder Name(Name name)
        {
            this.surname = name.getName();
            this.name = name.getSurname();
            return this;
        }

        
        public Name build()
        {
            return new Name(this);
        }
                
        
    }
    

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    
}
