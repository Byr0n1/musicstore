/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.repository;

import com.startup.musicstore.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 212157582
 */
public interface ReviewRepository extends JpaRepository<Review,Long> {
    
}
