package com.example.sport.Repository;

import com.example.sport.Entity.ArticleLost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleLostRepository extends JpaRepository<ArticleLost,Long> {
    @Query("SELECT u FROM ArticleLost u where u.num = :num")
    public ArticleLost findArticleLostBynum(@Param("num") Long num);


}
