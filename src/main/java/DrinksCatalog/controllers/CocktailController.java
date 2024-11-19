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
    @GetMapping("/f/l/{letter}")
    public ResponseEntity<List<Cocktail>> getByLetter(@PathVariable String letter){
        List<Cocktail> list = service.getByLetter(letter);
        return ResponseEntity.ok().body(list);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/img/{path}")
    public ResponseEntity<String> getImage(@PathVariable String path){
        String img = service.getImage(path);
        System.err.println(img);
        return ResponseEntity.ok().body(img);
    }
}
