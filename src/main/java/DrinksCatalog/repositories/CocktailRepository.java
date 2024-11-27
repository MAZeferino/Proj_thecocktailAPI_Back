package DrinksCatalog.repositories;

import DrinksCatalog.models.Cocktail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Long>, JpaSpecificationExecutor<Cocktail> {

    @Modifying
    @Transactional
    @Query("SELECT c FROM Cocktail c ORDER BY RANDOM() LIMIT 40")
    List<Cocktail> getRandonsDrinks();
}
