/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.app.conf.ConnectionConfig;
import com.startup.musicstore.domain.Album;
import com.startup.musicstore.domain.MarketingInformation;
import com.startup.musicstore.domain.Track;
import com.startup.musicstore.repository.AlbumRepository;
import com.startup.musicstore.repository.MarketinginformationRepository;
import com.startup.musicstore.repository.TrackRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author 212157582
 */
public class AlbumRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    
    private AlbumRepository albumrepo;
    
    private static TrackRepository trackRepo;
    
    private static List<Track> track;
    
    private static Track track1;
    private static Track track2;
    
    private static MarketinginformationRepository marketingInformationRepository;
    
    private static MarketingInformation marketinginformation;
    

    
    public AlbumRepositoryTest() {
    }
   
   
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createAlbum() {
        albumrepo = ctx.getBean(AlbumRepository.class); 
        Album album = new Album.Builder("I Must code")
                .unitPrice(BigDecimal.valueOf(36.99))
                .inventory(124)
                .sales(5)
                .track(track)
                .marketingInformation(marketinginformation)
                .build();
                
        albumrepo.save(album);
        id = album.getId();
        Assert.assertNotNull(album);

    }

    @Test(dependsOnMethods = "createAlbum", enabled = true)
    public void readAlbum() {
        albumrepo = ctx.getBean(AlbumRepository.class);
        Album creditcard = albumrepo.findOne(id);
        Assert.assertEquals(creditcard.getAlbumTitle(), "I Must code");

    }

    @Test(dependsOnMethods = "readAlbum", enabled = true)
    private void updateAlbum() {
        albumrepo = ctx.getBean(AlbumRepository.class);
        
        Album album = albumrepo.findOne(id);
       
        Album updatedAlbum = new Album.Builder("I Must code")
                .Album(album)
                .unitPrice(BigDecimal.valueOf(99.99))
                .inventory(124)
                .sales(5)
                .track(track)
                .marketingInformation(marketinginformation)
                .build();

       
        albumrepo.save(updatedAlbum);
        Album newAlbum = albumrepo.findOne(id);
        Assert.assertEquals(newAlbum.getUnitPrice(), BigDecimal.valueOf(99.99));

    }

    @Test(dependsOnMethods = "updateAlbum", enabled = true)
    private void deleteAlbum() {

        albumrepo = ctx.getBean(AlbumRepository.class); 
        Album album = albumrepo.findOne(id);
        albumrepo.delete(album);
        Album deletedAlbum = albumrepo.findOne(id);
        Assert.assertNull(deletedAlbum);

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
       
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        
        trackRepo = ctx.getBean(TrackRepository.class); 
        
        track1 = new Track.Builder("Stuck on you")
                .trackNumber(4)
                .build();
        
        trackRepo.save(track1);
        
        track2 = new Track.Builder("Dont Test me")
                .trackNumber(5)
                .build();
        
        trackRepo.save(track2);
        
        track = new ArrayList<>();
        
        track.add(track1);
        track.add(track2);
        
        trackRepo.save(track);
        
        marketingInformationRepository = ctx.getBean(MarketinginformationRepository.class); 
        
        marketinginformation = new MarketingInformation.Builder("Good")
                .build();
        
        marketingInformationRepository.save(marketinginformation);
        
        
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
