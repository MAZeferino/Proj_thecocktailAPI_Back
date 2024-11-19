package DrinksCatalog.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "cocktails")
public class Cocktail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_drink;
    private String name;
    private String category;
    private String alcoholic;
    private String ingredients;
    @Column(name = "instructions", columnDefinition = "TEXT")
    private String instructions;
    private String image_url;

    public Cocktail() {}
    public Cocktail(Long id_drink, String name, String category, String alcoholic, String ingredients, String instructions, String image_url) {
        this.id_drink = id_drink;
        this.name = name;
        this.category = category;
        this.alcoholic = alcoholic;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.image_url = image_url;
    }

    public Long getId() {
        return id;
    }
    public Long getId_drink() {
        return id_drink;
    }
    public void setId_drink(Long id_drink) {
        this.id_drink = id_drink;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getAlcoholic() {
        return alcoholic;
    }
    public void setAlcoholic(String alcoholic) {
        this.alcoholic = alcoholic;
    }
    public String getIngredients() {
        return ingredients;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public String getInstructions() {
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    public String getImage_url() {
        return image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cocktail cocktail = (Cocktail) o;
        return Objects.equals(id, cocktail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
