package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dao.DishDAO;
import cerlace.tastetrack.dao.impl.DishDAOImpl;
import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.entity.DishEntity;
import cerlace.tastetrack.mapper.DishMapper;
import cerlace.tastetrack.service.DishService;

public class DishServiceImpl extends AbstractService<DishDTO, DishEntity, DishDAO>
        implements DishService {

    public DishServiceImpl() {
        super(new DishDAOImpl(), DishMapper.INSTANCE);
    }
}
