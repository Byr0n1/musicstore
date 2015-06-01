/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.gradingSystem;



import com.startup.musicstore.domain.Album;
import com.startup.musicstore.domain.Artistinformation;
import com.startup.musicstore.domain.MarketingInformation;
import com.startup.musicstore.domain.Review;
import com.startup.musicstore.domain.SampleClip;
import com.startup.musicstore.domain.Track;
import com.startup.musicstore.services.albumGradingSystem.AGrade;
import com.startup.musicstore.services.albumGradingSystem.BGrade;
import com.startup.musicstore.services.albumGradingSystem.CGrade;
import com.startup.musicstore.services.albumGradingSystem.DGrade;
import com.startup.musicstore.services.albumGradingSystem.GradeHandler;
import com.startup.musicstore.services.albumGradingSystem.GradeHandlerSetUpChain;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
public class GradingSystemTest {
    private static Album album;
    private static MarketingInformation marketingInformation;
    private static Review review;
    private static Artistinformation artistInformation;
    private static Track track1;
    private static Track track2;
    private static List<Track> trackLIST;
    private static SampleClip sampleClip;
    private static SampleClip sampleClip2;
    
    public GradingSystemTest() {
    }

     
            
     @Test
    public void gradingTest() {
        
        GradeHandler chain = GradeHandlerSetUpChain.setUpChain();
        
        chain.handleRequest(album);
        
        Assert.assertEquals(chain, chain);
        
        
    }
    
    
    
   
    @BeforeClass
    public static void setUpClass() throws Exception
    {
        review = new Review.Builder("House")
                .rating(400)
                .build();
        
        artistInformation = new Artistinformation.Builder("Jill")
                .surname("Grifton")
                .build();
        
        marketingInformation = new MarketingInformation.Builder("GOOD")
                .artistInformation(artistInformation)
                .review(review)
                .build();
        
        sampleClip = new SampleClip.Builder("www.mymusic.com")
                .build();
        
        sampleClip2 = new SampleClip.Builder("www.thisIsHouse.com")
                .build();
        
        track1 = new Track.Builder("01")
                .trackNumber(10)
                .sampleClip(sampleClip)
                .build();
        
        
        //track1 = new Track.Builder("Track 01").surtrackTitle(1).SampleClip(sampleClip).build();
        track2 = new Track.Builder("02").trackNumber(5)
                .sampleClip(sampleClip2)
                .build();
        
        trackLIST = new ArrayList<>();
        trackLIST.add(track1);
        trackLIST.add(track2);
        
        album = new Album.Builder("")
                .unitPrice(new BigDecimal("700.00"))
                .marketingInformation(marketingInformation)
                .track(trackLIST)
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
