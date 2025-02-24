package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.entity.DishEntity;
import cerlace.tastetrack.mapper.DishMapper;
import cerlace.tastetrack.repository.DishRepository;
import cerlace.tastetrack.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository repository;
    private final DishMapper mapper;

    @Override
    public DishDTO saveOrUpdate(DishDTO dto) {
        DishEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public DishDTO get(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<DishDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
