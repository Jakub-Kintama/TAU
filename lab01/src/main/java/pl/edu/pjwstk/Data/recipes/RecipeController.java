package pl.edu.pjwstk.Data.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RecipeController {
    @Autowired
    private RecipeService service;

    @GetMapping("/all")
    public String showAllRecipes(Model model){
        List<Recipe> recipeList = service.listAll();
        model.addAttribute("recipeList", recipeList);

        return "recipes";
    }

    @GetMapping("/vege")
    public String showVegeRecipes(Model model){
        List<Recipe> recipeList = service.listVege();
        model.addAttribute("recipeList", recipeList);

        return "recipes";
    }

    @GetMapping("/fast")
    public String showFastRecipes(Model model){
        List<Recipe> recipeList = service.listFast();
        model.addAttribute("recipeList", recipeList);

        return "recipes";
    }
}
