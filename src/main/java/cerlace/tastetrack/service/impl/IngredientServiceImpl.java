package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dao.IngredientDAO;
import cerlace.tastetrack.dao.impl.IngredientDAOImpl;
import cerlace.tastetrack.dto.IngredientDTO;
import cerlace.tastetrack.entity.IngredientEntity;
import cerlace.tastetrack.mapper.IngredientMapper;
import cerlace.tastetrack.service.IngredientService;

public class IngredientServiceImpl extends AbstractService<IngredientDTO, IngredientEntity, IngredientDAO>
        implements IngredientService {

    public IngredientServiceImpl() {
        super(new IngredientDAOImpl(), IngredientMapper.INSTANCE);
    }
}
