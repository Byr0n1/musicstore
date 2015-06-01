/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.util.List;
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
public class MarketingInformation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String statusOfinformation;
    
    @OneToOne
    private Review review;
    
    @OneToOne
    private Artistinformation artistInformation;
    
    private MarketingInformation()
    {
    
    }
    
    private MarketingInformation(Builder builder)
    {
        this.id = builder.id;
        this.statusOfinformation =builder.statusOfinformation;
        this.review = builder.review;
        this.artistInformation = builder.artistInformation;
        
    }
    
    
    public static class Builder
    {
          private Long id;
          private String statusOfinformation;
          private Review review;
          private Artistinformation artistInformation;
          
        public Builder (String statusOfinformation) 
        {
            
            this.statusOfinformation = statusOfinformation;
            
        }
        
        public Builder Id(Long id) 
        {
            this.id = id;
            return this;
        }
          
        public Builder review(Review review)
        {
            this.review = review;
            return this;
        }
        
        public Builder artistInformation(Artistinformation artistInformation)
        {
            this.artistInformation = artistInformation;
            return this;
        }

        
        public Builder MarketingInformation(MarketingInformation marketingInformation)
        {
            this.id = marketingInformation.getId();
            this.statusOfinformation = marketingInformation.getStatusInformation();
            this.review = marketingInformation.getReview();
            this.artistInformation = marketingInformation.getArtistInformation();
 
            return this;
        }
        

        
        public MarketingInformation build()
        {
            return new MarketingInformation(this);
        }
    }

    public Long getId() {
        return id;
    }
    
     public String getStatusInformation() {
        return statusOfinformation;
    }
     
     public Review getReview()
     {
         return review;
     }
     
     public Artistinformation getArtistInformation()
     {
         return artistInformation;
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
        if (!(object instanceof MarketingInformation)) {
            return false;
        }
        MarketingInformation other = (MarketingInformation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.MarketingInformation[ id=" + id + " ]";
    }
    
}
