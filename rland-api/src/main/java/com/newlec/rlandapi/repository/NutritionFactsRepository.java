package com.newlec.rlandapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newlec.rlandapi.entity.NutritionFacts;

public interface NutritionFactsRepository extends JpaRepository<NutritionFacts, Integer>{
    
}
