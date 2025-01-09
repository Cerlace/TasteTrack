package cerlace.tastetrack.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
class DishIngredientPK implements Serializable {
    private DishEntity dish;
    private IngredientEntity ingredient;
}