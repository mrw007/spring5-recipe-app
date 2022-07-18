package mrw007.springframework.spring5recipeapp.models;

import lombok.*;
import mrw007.springframework.spring5recipeapp.enums.Difficulty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer preptime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    @Lob
    private String directions;
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients = new HashSet<>();
    @Lob
    private Byte[] image;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Notes notes;
    @ManyToMany
    @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }
}
