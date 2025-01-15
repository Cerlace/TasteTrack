package cerlace.tastetrack.requestmapper.impl;

import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.dto.DishIngredientDTO;
import cerlace.tastetrack.dto.IngredientDTO;
import cerlace.tastetrack.requestmapper.RequestMapper;
import cerlace.tastetrack.servlet.ServletConstants;
import cerlace.tastetrack.utils.RequestMapperUtil;

import javax.servlet.http.HttpServletRequest;

public class DishIngredientRequestMapper implements RequestMapper<DishIngredientDTO> {
    @Override
    public DishIngredientDTO getDTO(HttpServletRequest request) {
        return DishIngredientDTO.builder()
                .dish(DishDTO.builder()
                        .id(RequestMapperUtil.getLongParam(request, ServletConstants.DISH_ID_PARAM))
                        .build())
                .ingredient(IngredientDTO.builder()
                        .id(RequestMapperUtil.getLongParam(request, ServletConstants.INGREDIENT_ID_PARAM))
                        .build())
                .amount(RequestMapperUtil.getFloatParam(request, ServletConstants.DISH_INGREDIENT_AMOUNT_PARAM))
                .build();
    }
}
