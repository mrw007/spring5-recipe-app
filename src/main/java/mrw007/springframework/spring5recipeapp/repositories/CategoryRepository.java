package mrw007.springframework.spring5recipeapp.repositories;

import mrw007.springframework.spring5recipeapp.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
