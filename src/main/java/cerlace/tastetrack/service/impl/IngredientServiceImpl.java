package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dao.IngredientDAO;
import cerlace.tastetrack.dao.impl.IngredientDAOImpl;
import cerlace.tastetrack.dto.IngredientDTO;
import cerlace.tastetrack.entity.IngredientEntity;
import cerlace.tastetrack.mapper.IngredientMapper;
import cerlace.tastetrack.service.IngredientService;

public class IngredientServiceImpl extends AbstractService<IngredientDTO, IngredientEntity>
        implements IngredientService {
    private final IngredientDAO ingredientDAO;
    private final IngredientMapper ingredientMapper;

    public IngredientServiceImpl() {
        super(new IngredientDAOImpl(), IngredientMapper.INSTANCE);
        this.ingredientDAO = (IngredientDAO) super.getDao();
        this.ingredientMapper = (IngredientMapper) super.getMapper();
    }
}
