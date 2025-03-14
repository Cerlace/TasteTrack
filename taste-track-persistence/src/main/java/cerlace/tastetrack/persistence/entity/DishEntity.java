package cerlace.tastetrack.persistence.entity;

import cerlace.tastetrack.persistence.enums.DishType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString(exclude = {"dishIngredients", "meals"})
@EqualsAndHashCode(exclude = {"dishIngredients", "meals"}, callSuper = true)
@Entity
@Table(name = "dish")
public class DishEntity extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
    @Column(name = "dish_type", nullable = false)
    @Enumerated
    private DishType dishType;
    @Column(nullable = false)
    private Float calories;
    @Column(nullable = false)
    private Float proteins;
    @Column(nullable = false)
    private Float fats;
    @Column(nullable = false)
    private Float carbohydrates;
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    @Lob
    private String recipe;
    @Builder.Default
    @OneToMany(mappedBy = "dish", cascade = CascadeType.REMOVE)
    private Set<DishIngredientEntity> dishIngredients = new HashSet<>();
    @Builder.Default
    @OneToMany(mappedBy = "dish")
    private Set<MealEntity> meals = new HashSet<>();
}
