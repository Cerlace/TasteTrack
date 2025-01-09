package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dao.MealDAO;
import cerlace.tastetrack.dao.impl.MealDAOImpl;
import cerlace.tastetrack.dto.MealDTO;
import cerlace.tastetrack.entity.MealEntity;
import cerlace.tastetrack.mapper.MealMapper;
import cerlace.tastetrack.service.MealService;

public class MealServiceImpl extends AbstractService<MealDTO, MealEntity>
        implements MealService {
    private final MealDAO mealDAO;
    private final MealMapper mealMapper;

    public MealServiceImpl() {
        super(new MealDAOImpl(), MealMapper.INSTANCE);
        this.mealDAO = (MealDAO) super.getDao();
        this.mealMapper = (MealMapper) super.getMapper();
    }
}
