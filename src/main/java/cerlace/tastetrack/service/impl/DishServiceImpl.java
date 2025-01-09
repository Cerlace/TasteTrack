package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dao.DishDAO;
import cerlace.tastetrack.dao.impl.DishDAOImpl;
import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.entity.DishEntity;
import cerlace.tastetrack.mapper.DishMapper;
import cerlace.tastetrack.service.DishService;

public class DishServiceImpl extends AbstractService<DishDTO, DishEntity>
        implements DishService {
    private final DishDAO dishDAO;
    private final DishMapper dishMapper;

    public DishServiceImpl() {
        super(new DishDAOImpl(), DishMapper.INSTANCE);
        this.dishDAO = (DishDAO) super.getDao();
        this.dishMapper = (DishMapper) super.getMapper();
    }
}
