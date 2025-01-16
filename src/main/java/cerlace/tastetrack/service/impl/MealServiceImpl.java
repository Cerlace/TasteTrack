package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dao.MealDAO;
import cerlace.tastetrack.dao.impl.MealDAOImpl;
import cerlace.tastetrack.dto.MealDTO;
import cerlace.tastetrack.entity.MealEntity;
import cerlace.tastetrack.mapper.MealMapper;
import cerlace.tastetrack.service.MealService;

import java.util.List;

public class MealServiceImpl extends AbstractService<MealDTO, MealEntity, MealDAO>
        implements MealService {

    public MealServiceImpl() {
        super(new MealDAOImpl(), MealMapper.INSTANCE);
    }

    @Override
    public List<MealDTO> getAllMealsOfUser(Long userId) {
        return getMapper().toDTOList(getDao().getAllMealsOfUser(userId));
    }
}
