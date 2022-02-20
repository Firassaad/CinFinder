package com.example.sport.Controller;

import com.example.sport.Entity.Article;
import com.example.sport.Entity.ArticleLost;
import com.example.sport.Entity.Founded;
import com.example.sport.Repository.FoundedRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/Founded")
public class FoundedControler  {


    public static final Logger logger = LoggerFactory.getLogger(FoundedControler.class);
    @Autowired
    FoundedRepository FoundedRepo;

    @GetMapping("/getFound")
    public List<ArticleLost> getFounded(){
        return FoundedRepo.findAllFounded();
    }
    @GetMapping("/getLost")
    public List<Article> getlost(){
        return FoundedRepo.findAllLost();
    }

    @GetMapping("/getAllLostFound")
    public List<Founded> getAllLF(){
        return FoundedRepo.findAll();
    }

    @PostMapping("/saveLostFound")
    public Set<Founded> saveFounded(){
        List<ArticleLost> l = getFounded();
        List<Article> l1 = getlost();
//A Set is a Collection that cannot contain duplicate elements
        Set<Founded> lf = new HashSet<>();

        for (ArticleLost i : l){
            if(FoundedRepo.getFoundByIds(i.getId() , i.getExist_id())== null){
                System.out.println("list elmt " + i.getFullname());
                Long art = i.getId();
                Long artFound = i.getExist_id();
                Founded f = new Founded();
                f.setId_Lost(art);
                f.setId_found(artFound);
                f.setMsg("déclaration (trouvé) avant la déclaration (perdu)");
                lf.add(FoundedRepo.save(f));

            }
        }
        for (Article k : l1){
            if(FoundedRepo.getFoundByIds(k.getId() , k.getExist_id())== null){
                Long art = k.getId();
                Long artFound = k.getExist_id();
                Founded f = new Founded();
                f.setId_Lost(art);
                f.setId_found(artFound);
                f.setMsg("déclaration (perdu) avant la déclaration (trouvé)");
                lf.add(FoundedRepo.save(f));

            }
        }
        return lf;


    }

}
