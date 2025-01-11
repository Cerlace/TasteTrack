package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dao.DishIngredientDAO;
import cerlace.tastetrack.dao.impl.DishIngredientDAOImpl;
import cerlace.tastetrack.dto.DishIngredientDTO;
import cerlace.tastetrack.entity.DishIngredientEntity;
import cerlace.tastetrack.mapper.DishIngredientMapper;
import cerlace.tastetrack.service.DishIngredientService;

public class DishIngredientServiceImpl
        extends AbstractService<DishIngredientDTO, DishIngredientEntity, DishIngredientDAO>
        implements DishIngredientService {

    public DishIngredientServiceImpl() {
        super(new DishIngredientDAOImpl(), DishIngredientMapper.INSTANCE);
    }
}

