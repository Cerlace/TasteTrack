package cerlace.tastetrack.entity;

import cerlace.tastetrack.enums.MeasureUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "dish_ingredient", uniqueConstraints =
@UniqueConstraint(columnNames = {"dish_id", "ingredient_id"}))
public class DishIngredientEntity extends BaseEntity {
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "dish_id", nullable = false)
    private DishEntity dish;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private IngredientEntity ingredient;
    @Column(nullable = false)
    private Float amount;
    @Column(name = "measure_unit", nullable = false)
    @Enumerated
    private MeasureUnit measureUnit;
}
