package cerlace.tastetrack.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString(exclude = "dishIngredients")
@EqualsAndHashCode(exclude = "dishIngredients", callSuper = true)
@Entity
@Table(name = "dish")
public class DishEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Float calories;
    @Column(nullable = false)
    private Float proteins;
    @Column(nullable = false)
    private Float fats;
    @Column(nullable = false)
    private Float carbohydrates;
    @Column(nullable = false)
    @Lob
    private String recipe;
    @Builder.Default
    @OneToMany(mappedBy = "ingredient")
    private Set<DishIngredientEntity> dishIngredients = new HashSet<>();
}
