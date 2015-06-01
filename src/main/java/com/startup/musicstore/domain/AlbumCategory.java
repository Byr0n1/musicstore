/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author 212157582
 */
@Entity
public class AlbumCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String categoryName;
    
    
    @OneToMany
    @JoinColumn(name="Album_ID")
    private List<Album> album;
   
    private AlbumCategory()
    {
        
    }
    private AlbumCategory(Builder builder)
    {
        id = builder.id;
        categoryName=builder.categoryName;
        album = builder.album;
    }
    
    
    public static class Builder
    {
          
          private Long id;
          private String categoryName;
          private List<Album> album;
          
       public Builder(String value)
       {
           this.categoryName = value;
       }
          

        
         public Builder id(Long id) {
            this.id = id;
            return this;
        }
         
         public Builder album(List<Album> album)
         {
             this.album = album;
             return this;
         }
        
        public Builder AlbumCategory(AlbumCategory albumCategory)
        {
            this.id =albumCategory.getId();
            this.categoryName = albumCategory.getGategoryName();
            this.album = albumCategory.getAlbum();
            return this;
        }

        
        public AlbumCategory build()
        {
            return new AlbumCategory(this);
        }
    }
    
    public List<Album> getAlbum()
    {
        return album;
    }

    public Long getId() {
        return id;
    }

    public String getGategoryName() {
        return categoryName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlbumCategory)) {
            return false;
        }
        AlbumCategory other = (AlbumCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.AlbumCategory[ id=" + id + " ]";
    }
    
}
