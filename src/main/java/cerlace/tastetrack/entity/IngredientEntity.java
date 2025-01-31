package cerlace.tastetrack.entity;

import cerlace.tastetrack.enums.ProductType;
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
import javax.persistence.Enumerated;
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
@Table(name = "ingredient")
public class IngredientEntity extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
    @Column(name = "product_type", nullable = false)
    @Enumerated
    private ProductType productType;
    @Builder.Default
    @OneToMany(mappedBy = "ingredient")
    private Set<DishIngredientEntity> dishIngredients = new HashSet<>();
}
