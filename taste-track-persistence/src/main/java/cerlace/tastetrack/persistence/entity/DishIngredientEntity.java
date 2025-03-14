package cerlace.tastetrack.persistence.entity;

import cerlace.tastetrack.persistence.enums.MeasureUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

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
