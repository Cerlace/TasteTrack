package cerlace.tastetrack.requestmapper.impl;

import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.enums.DishType;
import cerlace.tastetrack.requestmapper.RequestMapper;
import cerlace.tastetrack.servlet.ServletConstants;
import cerlace.tastetrack.utils.RequestMapperUtil;

import javax.servlet.http.HttpServletRequest;

public class DishRequestMapper implements RequestMapper<DishDTO> {
    @Override
    public DishDTO getDTO(HttpServletRequest request) {
        return DishDTO.builder()
                .name(RequestMapperUtil.getStringParam(request, ServletConstants.DISH_NAME_PARAM))
                .dishType(DishType.valueOf(
                        RequestMapperUtil.getStringParam(request, ServletConstants.DISH_TYPE_PARAM)))
                .calories(RequestMapperUtil.getFloatParam(request, ServletConstants.DISH_CALORIES_PARAM))
                .proteins(RequestMapperUtil.getFloatParam(request, ServletConstants.DISH_PROTEINS_PARAM))
                .fats(RequestMapperUtil.getFloatParam(request, ServletConstants.DISH_FATS_PARAM))
                .carbohydrates(RequestMapperUtil.getFloatParam(request, ServletConstants.DISH_CARBOHYDRATES_PARAM))
                .recipe(RequestMapperUtil.getStringParam(request, ServletConstants.DISH_RECIPE_PARAM))
                .build();
    }
}
