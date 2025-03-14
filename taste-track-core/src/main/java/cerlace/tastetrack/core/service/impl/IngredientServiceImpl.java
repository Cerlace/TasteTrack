package cerlace.tastetrack.core.service.impl;

import cerlace.tastetrack.core.dto.IngredientDTO;
import cerlace.tastetrack.core.dto.PageSettings;
import cerlace.tastetrack.persistence.entity.IngredientEntity;
import cerlace.tastetrack.core.mapper.IngredientMapper;
import cerlace.tastetrack.persistence.repository.IngredientRepository;
import cerlace.tastetrack.core.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository repository;
    private final IngredientMapper mapper;

    @Override
    public IngredientDTO saveOrUpdate(IngredientDTO dto) {
        IngredientEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public IngredientDTO get(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow();
    }

    @Override
    public List<IngredientDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public Page<IngredientDTO> getPage(PageSettings pageSettings) {
        Pageable pageable = PageRequest.of(
                pageSettings.getPage(),
                pageSettings.getSize(),
                Sort.by(Sort.Direction.fromString(
                        pageSettings.getSortDirection()), pageSettings.getSortField()));

        return repository.findAll(pageable).map(mapper::toDTO);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
