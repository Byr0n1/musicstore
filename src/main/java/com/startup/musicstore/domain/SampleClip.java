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
public class SampleClip {
    
    private String sampleUrl;
    
    private SampleClip()
    {
        
    }
    
    private SampleClip(Builder builder)
    {
        this.sampleUrl =builder.sampleUrl;
    }
    
    
    public static class Builder
    {
          private String sampleUrl;
          
       public Builder(String value)
       {
           this.sampleUrl = value;
       }
          

       
        
        public Builder SampleClip(SampleClip sampleClip)
        {
            this.sampleUrl = sampleClip.getSampleUrl();
            
            return this;
            
        }

        
        public SampleClip build()
        {
            return new  SampleClip(this);
        }
                
        
    }
    

    public String getSampleUrl() {
        return sampleUrl;
    }

    
    
    
}
