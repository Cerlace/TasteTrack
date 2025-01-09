package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dao.DishIngredientDAO;
import cerlace.tastetrack.dao.impl.DishIngredientDAOImpl;
import cerlace.tastetrack.dto.DishIngredientDTO;
import cerlace.tastetrack.entity.DishIngredientEntity;
import cerlace.tastetrack.entity.DishIngredientPK;
import cerlace.tastetrack.mapper.DishIngredientMapper;
import cerlace.tastetrack.service.DishIngredientService;

import java.util.List;

public class DishIngredientServiceImpl implements DishIngredientService {
    private final DishIngredientDAO dishIngredientDAO = new DishIngredientDAOImpl();
    private final DishIngredientMapper dishIngredientMapper = DishIngredientMapper.INSTANCE;


    @Override
    public DishIngredientDTO save(DishIngredientDTO dto) {
        DishIngredientEntity entity = dishIngredientMapper.toEntity(dto);
        return dishIngredientMapper.toDTO(dishIngredientDAO.save(entity));
    }

    @Override
    public DishIngredientDTO get(DishIngredientPK id) {
        return dishIngredientMapper.toDTO(dishIngredientDAO.get(id));
    }

    @Override
    public List<DishIngredientDTO> getAll() {
        return dishIngredientMapper.toDTOList(dishIngredientDAO.getAll());
    }

    @Override
    public boolean delete(DishIngredientPK id) {
        return dishIngredientDAO.delete(id);
    }

    @Override
    public void closeDao() {
        dishIngredientDAO.close();
    }
}
