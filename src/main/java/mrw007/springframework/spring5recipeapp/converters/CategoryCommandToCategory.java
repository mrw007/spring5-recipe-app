package mrw007.springframework.spring5recipeapp.converters;

import lombok.Synchronized;
import mrw007.springframework.spring5recipeapp.commands.CategoryCommand;
import mrw007.springframework.spring5recipeapp.models.Category;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        if (source == null) {
            return null;
        }

        final Category category = new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}