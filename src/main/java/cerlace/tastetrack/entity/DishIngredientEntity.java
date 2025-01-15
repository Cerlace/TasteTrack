package cerlace.tastetrack.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private DishEntity dish;
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private IngredientEntity ingredient;
    @Column
    private Float amount;
}
