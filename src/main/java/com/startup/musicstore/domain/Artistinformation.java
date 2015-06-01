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
public class Artistinformation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String surname;
    
    private Artistinformation()
    {
        
    }
    private Artistinformation(Builder builder)
    {
        id = builder.id;
        name =builder.name;
        surname = builder.surname;
    }
    
    
    public static class Builder
    {
          private Long id;
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
        
        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }
        
        public Builder Artistinformation(Artistinformation artistInformation)
        {
            this.name = artistInformation.getName();
            this.surname = artistInformation.getSurname();
            this.id = artistInformation.getId();
            return this;
        }

        
        public Artistinformation build()
        {
            return new Artistinformation(this);
        }
                
        
    }
    

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    public Long getId()
    {
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
        if (!(object instanceof Artistinformation)) {
            return false;
        }
        Artistinformation other = (Artistinformation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.Artistinformation[ id=" + id + " ]";
    }
    
}
