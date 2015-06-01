/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services.Impl;

import com.startup.musicstore.domain.Album;
import com.startup.musicstore.domain.Track;
import com.startup.musicstore.repository.AlbumRepository;
import com.startup.musicstore.repository.TrackRepository;
import com.startup.musicstore.services.UrlService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WAGGIE
 */
@Service
public class UrlServiceImpl implements UrlService{

    @Autowired
    private AlbumRepository albumRepository;
    
    @Override
    public String getAlbumUrl(String albumTitle) {
        String url="";
        List<Album> all = albumRepository.findAll();
        for(Album album : all)
        {
            
            
                // System.out.println(album.getAlbumTitle());
                for(int i = 0; i <= album.getTrack().size(); i++)
                {
                    if(album.getAlbumTitle().equalsIgnoreCase(albumTitle))
                    {
                        System.out.println(album.getTrack().get(i).getSampleClip().getSampleUrl());
                        url = album.getTrack().get(i).getSampleClip().getSampleUrl();
                    
                    }  
                }
               // url = album.getTrack().get(1).getSampleClip().getSampleUrl();
        }
        return url;
    }

    @Override
    public Album find(Long id) {
        return albumRepository.findOne(id);
    }

    @Override
    public Album persist(Album entity) {
        return albumRepository.save(entity);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Album merge(Album entity) {
         if (entity.getId() != null) {
            return albumRepository.save(entity);
        }
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Album entity) {
        albumRepository.delete(entity);
        //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
