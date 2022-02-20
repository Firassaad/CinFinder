package com.example.sport.Repository;
import com.example.sport.Entity.Article;
import com.example.sport.Entity.ArticleLost;
import com.example.sport.Entity.Founded;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface FoundedRepository extends JpaRepository<Founded , Long> {

    @Query("SELECT u FROM ArticleLost u where u.exist_id <> 0 ")
    public List<ArticleLost> findAllFounded();

    @Query("SELECT u FROM Article u where u.exist_id <> 0 ")
    public List<Article> findAllLost();

    @Query("SELECT u FROM Founded u where u.id_Lost = :idL and u.id_found=:idF")
    public Founded getFoundByIds(@Param("idL") Long idL , @Param("idF") Long idF );

}
