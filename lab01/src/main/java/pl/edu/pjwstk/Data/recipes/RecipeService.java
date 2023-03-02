package pl.edu.pjwstk.Data.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository repo;

    public List<Recipe> listAll(){
        return (List<Recipe>) repo.findAll();
    }

    public List<Recipe> listVege(){
        List<Recipe> recipes = (List<Recipe>) repo.findAll();
        return recipes.stream().filter(Recipe::isVege).collect(Collectors.toList());
    }

    public List<Recipe> listFast(){
        List<Recipe> recipes = (List<Recipe>) repo.findAll();
        return recipes.stream().filter(x -> x.getMinutes() <= 15).collect(Collectors.toList());
    }
}
