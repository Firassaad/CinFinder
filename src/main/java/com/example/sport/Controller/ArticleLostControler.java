package com.example.sport.Controller;

import com.example.sport.Entity.ArticleLost;
import com.example.sport.Repository.ArticleLostRepository;
import com.example.sport.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/ArticleLost")
public class ArticleLostControler {
    @Autowired
    ArticleLostRepository repoArticleLost ;

    @Autowired
    ArticleRepository repArticle;

    @GetMapping("/getLostArticles")
    public List<ArticleLost> getAll(){
        return repoArticleLost.findAll();
    }

    @PostMapping("/saveLost")
    public ArticleLost add(ArticleLost Al){
        if(repoArticleLost.findArticleLostBynum(Al.getNum())!=null){
            return null;
        }else {
        if(repArticle.findArticleBynum(Al.getNum())!= null){
            Al.setExist_id(repArticle.findArticleBynum(Al.getNum()).getId());
            return repoArticleLost.save(Al);
        }

        return repoArticleLost.save(Al);
    }
    }
}
