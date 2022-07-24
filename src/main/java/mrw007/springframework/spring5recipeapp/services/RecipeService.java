package mrw007.springframework.spring5recipeapp.services;

import mrw007.springframework.spring5recipeapp.commands.RecipeCommand;
import mrw007.springframework.spring5recipeapp.models.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
