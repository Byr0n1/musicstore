/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.app.conf.ConnectionConfig;
import com.startup.musicstore.domain.Artistinformation;
import com.startup.musicstore.repository.ArtistInformtionRepository;
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
public class ArtistInformationRepositoryTest {
    
     public static ApplicationContext ctx;
     private Long id;
     
     private ArtistInformtionRepository artistInfoRepo;
     
     
    
    public ArtistInformationRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createArtistinformation() {
        artistInfoRepo = ctx.getBean(ArtistInformtionRepository.class); 
        Artistinformation artistInfo = new Artistinformation.Builder("Johnny")
                .surname("Santana")
                .build();
                
        artistInfoRepo.save(artistInfo);
        id = artistInfo.getId();
        Assert.assertNotNull(artistInfo);

    }

    @Test(dependsOnMethods = "createArtistinformation", enabled = true)
    public void readArtistinformation() {
        artistInfoRepo = ctx.getBean(ArtistInformtionRepository.class); 
        Artistinformation artistName = artistInfoRepo.findOne(id);
        Assert.assertEquals(artistName.getName(), "Johnny");

    }

    @Test(dependsOnMethods = "readArtistinformation", enabled = true)
    private void updateArtistinformation() {
        artistInfoRepo = ctx.getBean(ArtistInformtionRepository.class);
        
        Artistinformation artistInfo = artistInfoRepo.findOne(id);
       
        Artistinformation UpdateartistInfo = new Artistinformation.Builder("Johnny")
                .Artistinformation(artistInfo)
                .surname("Brown")
                .build();

       
        artistInfoRepo.save(UpdateartistInfo);
        Artistinformation newArtistInfo = artistInfoRepo.findOne(id);
        Assert.assertEquals(newArtistInfo.getSurname(), "Brown");

    }

    @Test(dependsOnMethods = "updateArtistinformation", enabled = true)
    private void deleteArtistinformation() {

        artistInfoRepo = ctx.getBean(ArtistInformtionRepository.class);
        
        Artistinformation artistinformation = artistInfoRepo.findOne(id);
        artistInfoRepo.delete(artistinformation);
        Artistinformation deletedArtistinformation = artistInfoRepo.findOne(id);
        Assert.assertNull(deletedArtistinformation);

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
