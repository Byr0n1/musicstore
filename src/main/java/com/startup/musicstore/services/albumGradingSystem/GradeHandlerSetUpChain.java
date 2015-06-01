/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services.albumGradingSystem;

/**
 *
 * @author WAGGIE
 */
public class GradeHandlerSetUpChain {
    
    public static GradeHandler setUpChain()
    {
        GradeHandler aGrade = new AGrade();
        GradeHandler bGrade = new BGrade();
        GradeHandler cGrade = new CGrade();
        GradeHandler dGrade = new DGrade();
        
        aGrade.setSuccessor(bGrade);
        bGrade.setSuccessor(cGrade);
        dGrade.setSuccessor(dGrade);
       
        return aGrade;
    }
    
}
