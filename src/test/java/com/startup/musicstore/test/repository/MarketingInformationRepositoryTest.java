/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.app.conf.ConnectionConfig;
import com.startup.musicstore.domain.Artistinformation;
import com.startup.musicstore.domain.MarketingInformation;
import com.startup.musicstore.domain.Review;
import com.startup.musicstore.repository.ArtistInformtionRepository;
import com.startup.musicstore.repository.MarketinginformationRepository;
import com.startup.musicstore.repository.ReviewRepository;
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
public class MarketingInformationRepositoryTest {
    
    public MarketingInformationRepositoryTest() {
    }

    public static ApplicationContext ctx;
    private Long id;
    
    private static ReviewRepository reviewRepo;
    
    private static ArtistInformtionRepository artistInfoRepo;
    
    private static MarketinginformationRepository marketingInforepo;
    
    
    private static Review review;
    
    private static Artistinformation astistInfo;
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test(enabled = true)
    public void createMarketingInformation() {
        marketingInforepo = ctx.getBean(MarketinginformationRepository.class);
        
        MarketingInformation marketingInfo = new MarketingInformation.Builder("Bad")
                .artistInformation(astistInfo)
                .review(review)
                .build();
               
                
        marketingInforepo.save(marketingInfo);
        id = marketingInfo.getId();
        Assert.assertNotNull(marketingInfo);

    }

    @Test(dependsOnMethods = "createMarketingInformation", enabled = true)
    public void readMarketingInformation() {
        marketingInforepo= ctx.getBean(MarketinginformationRepository.class);
        MarketingInformation marketinfo = marketingInforepo.findOne(id);
        Assert.assertEquals(marketinfo.getStatusInformation(), "Bad");

    }

    @Test(dependsOnMethods = "readMarketingInformation", enabled = true)
    private void updateMarketingInformation() {
        marketingInforepo= ctx.getBean(MarketinginformationRepository.class);
        
        MarketingInformation marketingInfo = marketingInforepo.findOne(id);
       
        MarketingInformation UpdatemarketingInfo = new MarketingInformation.Builder("Good")
                .MarketingInformation(marketingInfo)
                .artistInformation(astistInfo)
                .review(review)
                .build();

       
        marketingInforepo.save(UpdatemarketingInfo);
        MarketingInformation newMarketingInfo = marketingInforepo.findOne(id);
        Assert.assertEquals(newMarketingInfo.getStatusInformation(),"Bad");

    }

    @Test(dependsOnMethods = "updateMarketingInformation", enabled = true)
    private void deleteMarketingInformation() {

        marketingInforepo= ctx.getBean(MarketinginformationRepository.class); 
        MarketingInformation marketInfo = marketingInforepo.findOne(id);
        marketingInforepo.delete(marketInfo);
        
        MarketingInformation deletedMarketInfo = marketingInforepo.findOne(id);
        Assert.assertNull(deletedMarketInfo);

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
         ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        
         artistInfoRepo = ctx.getBean(ArtistInformtionRepository.class);
         
         astistInfo = new Artistinformation.Builder("James")
                 .surname("Brown")
                 .build();
                 
          artistInfoRepo.save(astistInfo);       
                 
        
         reviewRepo = ctx.getBean(ReviewRepository.class); 
         
         review = new Review.Builder("The Greatest Hits")
                 .rating(7)
                 .build();
         
       
         reviewRepo.save(review); 
        
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
