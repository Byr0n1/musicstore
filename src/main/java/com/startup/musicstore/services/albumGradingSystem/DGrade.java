/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services.albumGradingSystem;

import com.startup.musicstore.domain.Album;

/**
 *
 * @author 212157582
 */
public class DGrade extends GradeHandler {

    @Override
    public void handleRequest(Album album) {
        if(album.getMarketingInformation().getReview().getRating() < 100 && album.getMarketingInformation().getReview().getRating() >= 0)
        {
            System.out.println("D");
        }
        else
        {
            System.out.println("D handler doesn't handle "+ album.getMarketingInformation().getReview().getRating());
            if(successor != null)
                successor.handleRequest(album);
        }
    }
    
}
