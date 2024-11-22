package DrinksCatalog.repositories;

import DrinksCatalog.models.Cocktail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  CocktailRepository extends JpaRepository<Cocktail, Long>{

    @Modifying
    @Transactional
    @Query("SELECT c FROM Cocktail c WHERE c.name LIKE :letter%")
    List<Cocktail> findByLetter(String letter);

    @Modifying
    @Transactional
    @Query("SELECT c FROM Cocktail c WHERE c.ingredients ILIKE %:ingredient%")
    List<Cocktail> findByIngredient(String ingredient);

    @Modifying
    @Transactional
    @Query("SELECT c FROM Cocktail c WHERE c.alcoholic ILIKE :alcoholic")
    List<Cocktail> findByAlcoholic(String alcoholic);
}
