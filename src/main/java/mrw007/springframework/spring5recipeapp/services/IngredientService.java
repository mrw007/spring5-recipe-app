package mrw007.springframework.spring5recipeapp.services;

import mrw007.springframework.spring5recipeapp.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand ingredientCommand);

    void deleteIngredientByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
