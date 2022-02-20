package com.example.sport.Repository;

import com.example.sport.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article,Long> {

    @Query("SELECT u FROM Article u where u.num = :num")
    public Article  findArticleBynum(@Param("num") Long num);
}
