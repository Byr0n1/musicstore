/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.util.Date;
import javax.persistence.Embeddable;

/**
 *
 * @author 212157582
 */
@Embeddable
public class Demographic {
    
    private String gender;
    private String race;
    private Date dateofBirth;
    
    private Demographic()
    {
        
    }
    private Demographic(Builder builder)
    {
        gender =builder.gender;
        race = builder.race;
        dateofBirth = builder.dateOfBirth;
    }
    
    
    public static class Builder
    {
          private String gender;
          private String race;
          private Date dateOfBirth;
          
       public Builder(String value)
       {
           this.gender = value;
       }
          

        public Builder race(String race) {
            this.race = race;
            return this;
        }
        
        public Builder dateofBirth(Date value) {
            this.dateOfBirth = value;
            return this;
        }
        
        
        public Builder Demographic(Demographic demographic)
        {
            this.race = demographic.getRace();
            this.gender = demographic.getRace();
            this.dateOfBirth = demographic.getDateOfBirth();
            return this;
        }

        
        public Demographic build()
        {
            return new Demographic(this);
        }
                
        

        
    }
    

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }
    
    public Date getDateOfBirth() {
        return dateofBirth;
    }
    
}
