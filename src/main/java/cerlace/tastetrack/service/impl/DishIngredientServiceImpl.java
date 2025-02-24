package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dto.DishIngredientDTO;
import cerlace.tastetrack.entity.DishIngredientEntity;
import cerlace.tastetrack.mapper.DishIngredientMapper;
import cerlace.tastetrack.repository.DishIngredientRepository;
import cerlace.tastetrack.service.DishIngredientService;
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
                .orElse(null);
    }

    @Override
    public List<DishIngredientDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<DishIngredientDTO> getAllIngredientsOfDish(Long dishId) {
        return mapper.toDTOList(repository.getAllByDishId(dishId));
    }
}

