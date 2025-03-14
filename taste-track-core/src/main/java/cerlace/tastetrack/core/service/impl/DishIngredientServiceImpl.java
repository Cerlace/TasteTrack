package cerlace.tastetrack.core.service.impl;

import cerlace.tastetrack.core.dto.DishIngredientDTO;
import cerlace.tastetrack.persistence.entity.DishIngredientEntity;
import cerlace.tastetrack.core.mapper.DishIngredientMapper;
import cerlace.tastetrack.persistence.repository.DishIngredientRepository;
import cerlace.tastetrack.core.service.DishIngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishIngredientServiceImpl implements DishIngredientService {

    private final DishIngredientRepository repository;
    private final DishIngredientMapper mapper;

    @Override
    public DishIngredientDTO saveOrUpdate(DishIngredientDTO dto) {
        DishIngredientEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public DishIngredientDTO get(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<DishIngredientDTO> getIngredientsByDish(Long dishId) {
        return mapper.toDTOList(repository.findByDishId(dishId));
    }
}

