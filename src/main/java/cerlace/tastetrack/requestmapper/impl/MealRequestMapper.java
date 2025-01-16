package cerlace.tastetrack.requestmapper.impl;

import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.dto.MealDTO;
import cerlace.tastetrack.dto.UserDTO;
import cerlace.tastetrack.enums.MealTime;
import cerlace.tastetrack.requestmapper.RequestMapper;
import cerlace.tastetrack.servlet.ServletConstants;
import cerlace.tastetrack.utils.RequestMapperUtil;

import javax.servlet.http.HttpServletRequest;

public class MealRequestMapper implements RequestMapper<MealDTO> {
    @Override
    public MealDTO getDTO(HttpServletRequest request) {
        return MealDTO.builder()
                .date(RequestMapperUtil.getDateParam(request, ServletConstants.MEAL_DATE_PARAM))
                .mealTime(MealTime.valueOf(RequestMapperUtil.getStringParam(request, ServletConstants.MEAL_TIME_PARAM)))
                .user(UserDTO.builder()
                        .id(RequestMapperUtil.getLongParam(request, ServletConstants.USER_ID_PARAM))
                        .build())
                .dish(DishDTO.builder()
                        .id(RequestMapperUtil.getLongParam(request, ServletConstants.DISH_ID_PARAM))
                        .build())
                .build();
    }
}
