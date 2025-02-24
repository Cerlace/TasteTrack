package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dto.MealDTO;
import cerlace.tastetrack.entity.MealEntity;
import cerlace.tastetrack.mapper.MealMapper;
import cerlace.tastetrack.repository.MealRepository;
import cerlace.tastetrack.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {

    private final MealRepository repository;
    private final MealMapper mapper;

    @Override
    public MealDTO saveOrUpdate(MealDTO dto) {
        MealEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public MealDTO get(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<MealDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<MealDTO> getAllMealsOfUser(Long userId) {
        return mapper.toDTOList(repository.getAllByUserId(userId));
    }
}
