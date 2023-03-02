package pl.edu.pjwstk;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import pl.edu.pjwstk.Data.description.Description;
import pl.edu.pjwstk.Data.recipes.Recipe;
import pl.edu.pjwstk.Data.recipes.RecipeRepository;

import java.util.Collection;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = true)
public class recipeRepositoryTest {
    @Autowired
    private RecipeRepository repo;

    @Test
    public void testAddNew(){
        Recipe recipe = new Recipe();
        recipe.setCreator("Jas");
        String str = "jajecznica";
        recipe.setName(str);
        recipe.setDescription("wyborna jajecznica");
        recipe.setMinutes(10);
        recipe.setPlates(2);
        recipe.setVege(false);
        recipe.setDescription_id(1);

        Recipe savedRecipe = repo.save(recipe);

        Assertions.assertNotNull(savedRecipe);
        Assertions.assertTrue(savedRecipe.getId() > 0);
        Assertions.assertEquals(str, savedRecipe.getName());
    }

    @Test
    public void testListAll(){
        Iterable<Recipe> recipes = repo.findAll();
        int recipesSize = ((Collection<?>) recipes).size();
        Assertions.assertTrue(recipesSize > 0);
        System.out.println(recipesSize);
    }

    @Test
    public void testUpdateById(){
        int recipeId = 1;
        Optional<Recipe> optionalRecipe = repo.findById(recipeId);
        Recipe recipe = optionalRecipe.get();
        recipe.setCreator("Maciek");
        repo.save(recipe);

        Recipe updatedRecipe = repo.findById(recipeId).get();
        Assertions.assertEquals("Maciek", updatedRecipe.getCreator());
    }

    @Test
    public void testGet(){
        int recipeId = 3;
        Optional<Recipe> optionalRecipe = repo.findById(recipeId);

        Assertions.assertTrue(optionalRecipe.isPresent());
        Assertions.assertEquals(3, optionalRecipe.get().getId());
    }

    @Test
    public void testDeleteById(){
        int recipeId = 2;
        repo.deleteById(recipeId);

        Optional<Recipe> optionalRecipe = repo.findById(recipeId);
        Assertions.assertTrue(optionalRecipe.isEmpty());
    }
}