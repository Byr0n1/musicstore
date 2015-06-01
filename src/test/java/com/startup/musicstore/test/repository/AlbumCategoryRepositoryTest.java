/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.app.conf.ConnectionConfig;
import com.startup.musicstore.domain.Album;
import com.startup.musicstore.domain.AlbumCategory;
import com.startup.musicstore.repository.AlbumCategoryRepository;
import com.startup.musicstore.repository.AlbumRepository;
import java.math.BigDecimal;
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
public class AlbumCategoryRepositoryTest {
    
    
    public static ApplicationContext ctx;
    private Long id;
    private AlbumCategoryRepository albumCategoryrepo;
    private static AlbumRepository albumrepo;
    private static List<Album> album;
    private static Album album1;
    private static Album album2;
    
    public AlbumCategoryRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(enabled = true)
    public void createAlbumCategory() {
        
        albumCategoryrepo = ctx.getBean(AlbumCategoryRepository.class); 
        AlbumCategory albumCategory = new AlbumCategory.Builder("Blues")
                .album(album)
                .build();
                
        albumCategoryrepo.save(albumCategory);
        id = albumCategory.getId();
        Assert.assertNotNull(albumCategory);

    }

    @Test(dependsOnMethods = "createAlbumCategory", enabled = true)
    public void readAlbumCategory() {
        albumCategoryrepo = ctx.getBean(AlbumCategoryRepository.class);
        AlbumCategory albumCategory = albumCategoryrepo.findOne(id);
        Assert.assertEquals(albumCategory.getGategoryName(), "Blues");

    }

    @Test(dependsOnMethods = "readAlbumCategory", enabled = true)
    private void updateAlbumCategory() {
        albumCategoryrepo = ctx.getBean(AlbumCategoryRepository.class); 
        
        AlbumCategory albumCategory = albumCategoryrepo.findOne(id);
        
        AlbumCategory albumCategoryUpadte = new AlbumCategory.Builder("Blues")
                .AlbumCategory(albumCategory)
                .album(album)
                .build();

       
        albumCategoryrepo.save(albumCategoryUpadte);
        
        AlbumCategory newAlbumCategory = albumCategoryrepo.findOne(id);
        Assert.assertEquals(newAlbumCategory.getGategoryName(),"Blues");
  

    }

    @Test(dependsOnMethods = "updateAlbumCategory", enabled = true)
    private void deleteAlbumCategory() {

        albumCategoryrepo = ctx.getBean(AlbumCategoryRepository.class); 
        AlbumCategory albumcategory = albumCategoryrepo.findOne(id);
        albumCategoryrepo.delete(albumcategory);
        
        AlbumCategory deletedAlbumCategory = albumCategoryrepo.findOne(id);
        Assert.assertNull(deletedAlbumCategory);

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
      ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        
        albumrepo = ctx.getBean(AlbumRepository.class); 
        album1 = new Album.Builder("Try me")
                .unitPrice(new BigDecimal(150.00))
                .inventory(8)
                .sales(5)
                .build();
        
         albumrepo.save(album1);
        
        album2 = new Album.Builder("Im me")
                .unitPrice(new BigDecimal(50.00))
                .inventory(4)
                .sales(2)
                .build();
        
         albumrepo.save(album2);
        
        
        album = new ArrayList<>();
        
        album.add(album1);
        album.add(album2);
        
        
        albumrepo.save(album);
        
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
