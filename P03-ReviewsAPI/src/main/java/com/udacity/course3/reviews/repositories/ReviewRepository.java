package com.udacity.course3.reviews.repositories;


import com.udacity.course3.reviews.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ReviewRepository extends JpaRepository<Review,Integer> {

    @Query("SELECT r from Review r where r.product.productId = :productId")
    List<Review> findAllByProductId(Integer productId);
}
