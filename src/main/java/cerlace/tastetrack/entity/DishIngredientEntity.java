package cerlace.tastetrack.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "dish_ingredient")
@IdClass(DishIngredientPK.class)
public class DishIngredientEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private DishEntity dish;
    @Id
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private IngredientEntity ingredient;
    @Column
    private Float amount;
}
