package cerlace.tastetrack.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "dish_ingredient")
public class DishIngredientEntity extends BaseEntity {
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "dish_id", nullable = false)
    private DishEntity dish;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private IngredientEntity ingredient;
    @Column(nullable = false)
    private Float amount;
}
