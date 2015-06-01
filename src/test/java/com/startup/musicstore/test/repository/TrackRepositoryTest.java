package com.startup.musicstore.test.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.startup.musicstore.app.conf.ConnectionConfig;
import com.startup.musicstore.domain.SampleClip;
import com.startup.musicstore.domain.Track;
import com.startup.musicstore.repository.TrackRepository;
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
public class TrackRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    
    private TrackRepository trackrepo;
   
    
    private static SampleClip sampleClip;

    
    public TrackRepositoryTest() {
    }
   
   
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createTrack() {
        trackrepo= ctx.getBean(TrackRepository.class); 
        Track track = new Track.Builder("Man in the mirror")
               .trackNumber(5)
               .sampleClip(sampleClip)
               .build();
                
        trackrepo.save(track);
        id = track.getId();
        Assert.assertNotNull(track);

    }

    @Test(dependsOnMethods = "createTrack", enabled = true)
    public void readTrack() {
        trackrepo= ctx.getBean(TrackRepository.class);
        Track track = trackrepo.findOne(id);
        Assert.assertEquals(track.getTrackTitle(), "Man in the mirror");

    }

    @Test(dependsOnMethods = "readTrack", enabled = true)
    private void updateTrack() {
        trackrepo= ctx.getBean(TrackRepository.class);
        
        Track track = trackrepo.findOne(id);
       
        Track updatedTrack =new Track.Builder("Man in the mirror")
                .Track(track)
               .trackNumber(4)
               .sampleClip(sampleClip)
               .build();

       
        trackrepo.save(updatedTrack);
        Track newTrack = trackrepo.findOne(id);
        Assert.assertEquals(newTrack.getTrackNumber(), 4);

    }

    @Test(dependsOnMethods = "updateTrack", enabled = true)
    private void deleteTrack() {

        trackrepo= ctx.getBean(TrackRepository.class); 
        Track track = trackrepo.findOne(id);
        trackrepo.delete(track);
        Track deletedTrack = trackrepo.findOne(id);
        Assert.assertNull(deletedTrack);

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
       
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        
        sampleClip = new SampleClip.Builder("www.MySong.co.za")
                .build();
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
