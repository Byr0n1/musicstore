/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    private String albumTitle;
    private BigDecimal unitPrice;
    private int inventory;
    private int sales;
    
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name ="Album_ID" )
    private List<Track> track;
    
    @OneToOne
    private MarketingInformation marketingInformation;
    
    
    
    
    private Album()
    {
                
    }
    
    private Album(Builder builder)
    {
        this.id = builder.id;
        this.albumTitle =builder.albumTitle;
        this.inventory = builder.inventory;
        this.unitPrice =builder.unitPrice;
        this.sales = builder.sales;
        this.track = builder.track;
        this.marketingInformation = builder.marketingInformation;
    }
    
    public static class Builder
    {
        private Long id;
        private String albumTitle;
        private BigDecimal unitPrice;
        private int inventory;
        private int sales;
        private List<Track> track;
        private MarketingInformation marketingInformation;
       
        public Builder(String value)
        {
            this.albumTitle = value;
        }
        
         public Builder Id(Long id) {
            this.id = id;
            return this;
        }
          public Builder track(List<Track> track) {
            this.track = track;
            return this;
        }

        public Builder unitPrice(BigDecimal unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder inventory(int inventory) {
            this.inventory = inventory;
            return this;
        }

        public Builder sales(int sales) {
            this.sales = sales;
            return this;
        }
        
        public Builder marketingInformation(MarketingInformation marketingInformation)
        {
            this.marketingInformation = marketingInformation;
            return this;
        }
        
        public Builder Album(Album album)
        {
            this.albumTitle = album.getAlbumTitle();
            this.id = album.getId();
            this.inventory = album.getInventory();
            this.sales = album.getSales();
            this.unitPrice = album.getUnitPrice();
            this.track = album.getTrack();
            this.marketingInformation = album.getMarketingInformation();
            return this;
        }
        
        public Album build()
        {
            return new Album(this);
        }
      
        
    }

    public Long getId() {
        return id;
    }

    public List<Track> getTrack() {
        return track;
    }
    
     public String getAlbumTitle() {
        return albumTitle;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public int getInventory() {
        return inventory;
    }

    public int getSales() {
        return sales;
    }
    
    public MarketingInformation getMarketingInformation()
    {
        return marketingInformation;
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
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.Album[ id=" + id + " ]";
    }
    
}
