package cerlace.tastetrack.entity;

import cerlace.tastetrack.enums.ProductType;
import cerlace.tastetrack.utils.interfaces.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(exclude = "dishIngredients")
@EqualsAndHashCode(exclude = "dishIngredients")
@Entity
@Table(name = "ingredient")
public class IngredientEntity implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "product_type", nullable = false)
    @Enumerated
    private ProductType productType;
    @Builder.Default
    @OneToMany(mappedBy = "dish")
    private Set<DishIngredientEntity> dishIngredients = new HashSet<>();
}
