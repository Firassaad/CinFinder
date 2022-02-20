package com.example.sport.Controller;


import com.example.sport.Entity.Article;
import com.example.sport.Repository.ArticleLostRepository;
import com.example.sport.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Article")
public class ArticleControler {

    @Autowired
    ArticleRepository r;

    @Autowired
    ArticleLostRepository rL;
    
    
    @GetMapping("/getAll")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Article> getAll(){
        return r.findAll();
    }

    @PostMapping("/save")
    public Article  addArticle(Article a) {
        if(r.findArticleBynum(a.getNum())!=null){
            return null;
        }else {
            if (rL.findArticleLostBynum(a.getNum()) != null) {
                System.out.println("exists in the table article");
                a.setExist_id(rL.findArticleLostBynum(a.getNum()).getId());


                return r.save(a);
            }

            return r.save(a);
        }
    }


    @DeleteMapping(value = "/del/{id}")
    public void deletePost(@PathVariable Long id) {
        r.deleteById(id);

    }


}
