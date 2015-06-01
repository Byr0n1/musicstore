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
public abstract class GradeHandler {
    GradeHandler successor;
    public void setSuccessor(GradeHandler successor)
    {
        this.successor = successor;
    }
    
    public abstract void handleRequest(Album album);
}
