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
public class CGrade extends GradeHandler {

    @Override
    public void handleRequest(Album album) {
        if(album.getMarketingInformation().getReview().getRating() < 200 && album.getMarketingInformation().getReview().getRating() >= 100)
        {
            System.out.println("C");
        }
        else
        {
            System.out.println("C handler doesn't handle "+ album.getMarketingInformation().getReview().getRating());
            if(successor != null)
                successor.handleRequest(album);
        }
    }
    
}
