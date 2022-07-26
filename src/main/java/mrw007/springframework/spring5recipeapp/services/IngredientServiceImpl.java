package mrw007.springframework.spring5recipeapp.services;

import lombok.extern.slf4j.Slf4j;
import mrw007.springframework.spring5recipeapp.commands.IngredientCommand;
import mrw007.springframework.spring5recipeapp.converters.IngredientToIngredientCommand;
import mrw007.springframework.spring5recipeapp.models.Recipe;
import mrw007.springframework.spring5recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        if (recipeOptional.isEmpty()) {
            //TODO impl error handling
            log.error("recipe id not found. ID: " + recipeId);
        }
        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredientToIngredientCommand::convert).findFirst();

        if (ingredientCommandOptional.isEmpty()) {
            //TODO impl error handling
            log.error("Ingredient not found. ID: " + ingredientId);
        }

        return ingredientCommandOptional.get();
    }
}
