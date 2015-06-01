/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.services;

import com.startup.musicstore.domain.Album;
import com.startup.musicstore.domain.MarketingInformation;
import com.startup.musicstore.domain.Review;
import com.startup.musicstore.repository.AlbumRepository;
import com.startup.musicstore.repository.MarketinginformationRepository;
import com.startup.musicstore.repository.ReviewRepository;
import com.startup.musicstore.services.AlbumRatingService;
import com.startup.musicstore.test.ConnectionConfigTest;
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
 * @author WAGGIE
 */
public class AlbumRatingServiceTest {
    
    
    public static ApplicationContext ctx;
    public ReviewRepository reviewRepository;
    public AlbumRatingService albumRatingService;
    public MarketinginformationRepository marketinginformationRepository;
    public AlbumRepository albumRepository;
    
    
    public AlbumRatingServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void AlbumRating() {
    
        
          reviewRepository = ctx.getBean(ReviewRepository.class);
          albumRatingService = ctx.getBean(AlbumRatingService.class);
         
          Review review1 = new Review.Builder("Awesome Album")
                  .rating(8)
                  .build();
         
          Review review2 = new Review.Builder("the album is a master piece")
                  .rating(10)
                  .build();
         
          Review review3 = new Review.Builder("this album sucked")
                  .rating(2)
                  .build();
         
         reviewRepository.save(review1);
         reviewRepository.save(review2);
         reviewRepository.save(review3);
         
         marketinginformationRepository = ctx.getBean(MarketinginformationRepository.class);
         
         MarketingInformation marketinginformation1 = new MarketingInformation.Builder("Good")
                 .review(review1)
                  .build();
         
          MarketingInformation marketinginformation2 = new MarketingInformation.Builder("Execellent")
                  .review(review2)
                  .build();
         
          MarketingInformation marketinginformation3 = new MarketingInformation.Builder("Bad")
                  .review(review3)
                  .build();
          
          marketinginformationRepository.save(marketinginformation1);
          marketinginformationRepository.save(marketinginformation2);
          marketinginformationRepository.save(marketinginformation3);
         
         
         albumRepository = ctx.getBean(AlbumRepository.class);
         
         Album album1 = new Album.Builder("John the Show Star")
                 .marketingInformation(marketinginformation1)
                  .build();
         
          Album album2 = new Album.Builder("Im in this for real")
                  .marketingInformation(marketinginformation2)
                  .build();
         
          Album album3 = new Album.Builder("I got your back")
                  .marketingInformation(marketinginformation3)
                  .build();
         
         albumRepository.save(album1);
         albumRepository.save(album2);
         albumRepository.save(album3);
         
         
         
          
          
        int albumrating = albumRatingService.getAlbumRatingOf("John the Show Star");
         
        Assert.assertEquals(albumrating,8);
    
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
        
        
        
        
       /* albumRepository = ctx.getBean(AlbumRepository.class);
        albumRepository.deleteAll();
        
        reviewRepository = ctx.getBean(ReviewRepository.class);
        reviewRepository.deleteAll();
        
        marketinginformationRepository = ctx.getBean(MarketinginformationRepository.class);
        marketinginformationRepository.deleteAll();*/
        
        
    }
}
