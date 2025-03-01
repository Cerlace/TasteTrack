package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dto.DishIngredientDTO;
import cerlace.tastetrack.dto.PageSettings;
import cerlace.tastetrack.entity.DishIngredientEntity;
import cerlace.tastetrack.mapper.DishIngredientMapper;
import cerlace.tastetrack.repository.DishIngredientRepository;
import cerlace.tastetrack.service.DishIngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<DishIngredientDTO> getIngredientsByDish(Long dishId) {
        return mapper.toDTOList(repository.findByDishId(dishId));
    }

    @Override
    public Page<DishIngredientDTO> getPageOfIngredientsByDish(PageSettings pageSettings, Long dishId) {
        Pageable pageable = PageRequest.of(
                pageSettings.getPage(),
                pageSettings.getSize(),
                Sort.by(Sort.Direction.fromString(
                        pageSettings.getSortDirection()), pageSettings.getSortField()));

        return repository.findByDishId(pageable, dishId).map(mapper::toDTO);
    }
}

