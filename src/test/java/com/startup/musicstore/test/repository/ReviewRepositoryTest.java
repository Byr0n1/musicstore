/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.app.conf.ConnectionConfig;
import com.startup.musicstore.domain.Review;
import com.startup.musicstore.repository.ReviewRepository;
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
 * @author WAGGIE
 */
public class ReviewRepositoryTest {
    
        public static ApplicationContext ctx;
        private Long id;
     
        private static ReviewRepository reviewRepo;
    
    public ReviewRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createReview() {
        reviewRepo = ctx.getBean(ReviewRepository.class); 
        Review review = new Review.Builder("The Best Hits")
                .rating(7)
                .build();
                
                
        reviewRepo.save(review);
        id = review.getId();
        Assert.assertNotNull(review);

    }

    @Test(dependsOnMethods = "createReview", enabled = true)
    public void readReview() {
        reviewRepo = ctx.getBean(ReviewRepository.class); 
        Review reviewDescription = reviewRepo.findOne(id);
        Assert.assertEquals(reviewDescription.getDescription(), "The Best Hits");

    }

    @Test(dependsOnMethods = "readReview", enabled = true)
    private void updateReview() {
        reviewRepo = ctx.getBean(ReviewRepository.class); 
        
        Review review = reviewRepo.findOne(id);
       
        Review upadteReview = new Review.Builder("The Best")
                .Review(review)
                .rating(8)
                .build();

       
        reviewRepo.save(upadteReview);
        Review newReview = reviewRepo.findOne(id);
        Assert.assertEquals(newReview.getRating(), 8);

    }

    @Test(dependsOnMethods = "updateReview", enabled = true)
    private void deleteReview() {

        reviewRepo = ctx.getBean(ReviewRepository.class);
        
        Review review = reviewRepo.findOne(id);
        
        reviewRepo.delete(review);
        Review deleteReview = reviewRepo.findOne(id);
        Assert.assertNull(deleteReview);

    }
    @BeforeClass
    public static void setUpClass() throws Exception {
        
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
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
