/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 212157582
 */
@Entity
public class Track implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
   
    
    private String trackTitle;
    
    private int trackNumber;
    
    @Embedded
    private SampleClip sampleClip;
    
    private Track()
    {
        
    }
    private Track(Builder builder)
    {
        id = builder.id;
        trackTitle =builder.trackTitle;
        trackNumber= builder.trackNumber;
        sampleClip = builder.sampleClip;
    }
    
    
    public static class Builder
    {
          private Long id;
          private String trackTitle;
          private int trackNumber;
          private SampleClip sampleClip;
          
       public Builder(String value)
       {
           this.trackTitle = value;
       }
          

        public Builder trackNumber(int trackNumber) {
            this.trackNumber = trackNumber;
            return this;
        }
        
        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }
        
        public Builder sampleClip(SampleClip sampleClip)
        {
            this.sampleClip = sampleClip;
            return this;
        }
        
        public Builder Track(Track track)
        {
            this.trackTitle = track.getTrackTitle();
            this.trackNumber = track.getTrackNumber();
            this.id = track.getId();
            this.sampleClip = track.getSampleClip();
            return this;
        }

        
        public Track build()
        {
            return new Track(this);
        }
                
        
    }
    

    public String getTrackTitle() {
        return trackTitle;
    }

    public int getTrackNumber() {
        return trackNumber;
    }
    public Long getId()
    {
        return id;
    }
    
    public SampleClip getSampleClip()
    {
        return sampleClip;
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
        if (!(object instanceof Track)) {
            return false;
        }
        Track other = (Track) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.Track[ id=" + id + " ]";
    }
    
}
