/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.services;

import com.startup.musicstore.domain.Album;
import com.startup.musicstore.domain.SampleClip;
import com.startup.musicstore.domain.Track;
import com.startup.musicstore.repository.AlbumRepository;
import com.startup.musicstore.repository.TrackRepository;
import com.startup.musicstore.services.UrlService;
import com.startup.musicstore.test.ConnectionConfigTest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author 212157582
 */

    

public class UrlServiceTest {
    
    public static ApplicationContext ctx;
    public UrlService urlService;
    public TrackRepository trackrepository;
    public AlbumRepository albumRepository;
    public static List<Track> track;
    
    
    public UrlServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void AlbumUrl() {
    
        
          
          urlService = ctx.getBean(UrlService.class);
          
          SampleClip url1 = new SampleClip.Builder("www.music.com")
                  .build();
          
          SampleClip url2 = new SampleClip.Builder("www.myHouse.com")
                  .build();
          
          SampleClip url3 = new SampleClip.Builder("www.DroptheMusic.com")
                  .build();
          
          trackrepository = ctx.getBean(TrackRepository.class);
          
          Track track1 = new Track.Builder("This is me")
                  .trackNumber(4)
                  .sampleClip(url1)
                  .build();
         
          Track track2 = new Track.Builder("So im not")
                  .trackNumber(5)
                  .sampleClip(url2)
                  .build();
         
          Track track3 = new Track.Builder("the Show Stopper")
                  .trackNumber(10)
                  .sampleClip(url3)
                  .build();
         
         trackrepository.save(track1);
         trackrepository.save(track2);
         trackrepository.save(track3);
         
         track =new ArrayList<>();
         
         track.add(track1);
         track.add(track2);
         track.add(track3);
         
         
         albumRepository = ctx.getBean(AlbumRepository.class);
         
         Album album1 = new Album.Builder("John the Show Star")
                 .track(track)
                 .build();
         
          Album album2 = new Album.Builder("Im in this for real")
                  .track(track)
                  .build();
         
          Album album3 = new Album.Builder("I got your back")
                  .track(track)
                  .build();
         
         albumRepository.save(album1);
         albumRepository.save(album2);
         albumRepository.save(album3);
         
         
         
          
          
     // String albumUrl = urlService.getAlbumUrl("John the Show Star");
         
     // Assert.assertEquals(albumUrl,"www.music.com");
    
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
