package cerlace.tastetrack.requestmapper.impl;

import cerlace.tastetrack.dto.IngredientDTO;
import cerlace.tastetrack.enums.ProductType;
import cerlace.tastetrack.requestmapper.RequestMapper;
import cerlace.tastetrack.servlet.ServletConstants;
import cerlace.tastetrack.utils.RequestMapperUtil;

import javax.servlet.http.HttpServletRequest;

public class IngredientRequestMapper implements RequestMapper<IngredientDTO> {
    @Override
    public IngredientDTO getDTO(HttpServletRequest request) {
        return IngredientDTO.builder()
                .name(RequestMapperUtil.getStringParam(request, ServletConstants.INGREDIENT_NAME_PARAM))
                .productType(ProductType.valueOf(
                        RequestMapperUtil.getStringParam(request, ServletConstants.INGREDIENT_PRODUCT_TYPE_PARAM)))
                .build();
    }
}
