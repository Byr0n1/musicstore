/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.services.Impl;

/*import com.startup.musicstore.domain.AlbumCategory;
import com.startup.musicstore.respository.AlbumCategoryRepository;
import com.startup.musicstore.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;*/

/**
 *
 * @author 212157582
 */
public class CategoryServicesImpl {

    /*@Autowired
    AlbumCategoryRepository catRepo;

    @Override
    public List<AlbumCategory> getBestCategory() {
        List<AlbumCategory> catList = findAll();
        AlbumCategory largest = null;
        long max = 0;
        for(AlbumCategory cat: catList){
            if(cat.getAlbs().size() > max)
            {
                largest = cat;
            }
        }
        catList.add(largest);
        
        return catList;
    }

    @Override
    public AlbumCategory find(Long id) {
        return catRepo.findOne(id);
    }

    @Override
    public AlbumCategory persist(AlbumCategory entity) {
        return catRepo.save(entity);
    }

    @Override
    public AlbumCategory merge(AlbumCategory entity) {
        if (entity.getId() != null) {
            return catRepo.save(entity);
        }
        return null;
    }

    @Override
    public void remove(AlbumCategory entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AlbumCategory> findAll() {
        return catRepo.findAll();
    }*/

}
