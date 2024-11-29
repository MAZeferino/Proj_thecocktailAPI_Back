package DrinksCatalog.controllers;
import DrinksCatalog.models.Cocktail;
import DrinksCatalog.services.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cocktail")
public class CocktailController {

    @Autowired
    private CocktailService service;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/filter/r")
    public ResponseEntity<List<Cocktail>> getRandonsDrinks(){
        List<Cocktail> list = service.getRandonsDrinks();
        return ResponseEntity.ok().body(list);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/filterby")
    public List<Cocktail> findCocktails(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String letter,
            @RequestParam(required = false) String ingredient,
            @RequestParam(required = false) String alcoholic,
            @RequestParam(required = false) String category) {
        return service.findDrinks(search, letter, ingredient, alcoholic, category);
    }


    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/img/{path}")
    public ResponseEntity<String> getImage(@PathVariable String path){
        String img = service.getImage(path);
        System.err.println(img);
        return ResponseEntity.ok().body(img);
    }
}
