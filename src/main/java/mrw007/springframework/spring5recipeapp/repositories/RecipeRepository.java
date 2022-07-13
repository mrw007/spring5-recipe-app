package mrw007.springframework.spring5recipeapp.repositories;

import mrw007.springframework.spring5recipeapp.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {

}
