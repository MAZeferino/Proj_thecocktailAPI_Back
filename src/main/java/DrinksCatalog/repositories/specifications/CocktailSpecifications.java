package DrinksCatalog.repositories.specifications;

import DrinksCatalog.models.Cocktail;
import org.springframework.data.jpa.domain.Specification;

public class CocktailSpecifications {

    public static Specification<Cocktail> searchDrinksWith(String search) {
        return (root, query, builder) ->
                search != null ? builder.like(builder.lower(root.get("name")), "%" + search.toLowerCase() + "%") : null;
    }

    public static Specification<Cocktail> hasNameStartingWith(String letter) {
        return (root, query, builder) ->
                letter != null ? builder.like(root.get("name"), letter + "%") : null;
    }

    public static Specification<Cocktail> hasIngredient(String ingredient) {
        return (root, query, builder) ->
                ingredient != null ? builder.like(builder.lower(root.get("ingredients")), "%" + ingredient.toLowerCase() + ",%") : null;
    }

    public static Specification<Cocktail> isAlcoholic(String alcoholic) {
        return (root, query, builder) ->
                alcoholic != null ? builder.like(builder.lower(root.get("alcoholic")), alcoholic.toLowerCase()) : null;
    }

    public static Specification<Cocktail> hasCategory(String category) {
        return (root, query, builder) ->
                category != null ? builder.like(builder.lower(root.get("category")), "%" + category.toLowerCase() + "%") : null;
    }
}
