package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.dto.DishFilter;
import cerlace.tastetrack.dto.PageSettings;
import cerlace.tastetrack.entity.DishEntity;
import cerlace.tastetrack.mapper.DishMapper;
import cerlace.tastetrack.repository.DishRepository;
import cerlace.tastetrack.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static cerlace.tastetrack.specification.DishSpecifications.*;
import static org.springframework.data.jpa.domain.Specification.*;

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
    public Page<DishDTO> getPage(PageSettings pageSettings) {
        Pageable pageable = PageRequest.of(
                pageSettings.getPage(),
                pageSettings.getSize(),
                Sort.by(Sort.Direction.fromString(
                        pageSettings.getSortDirection()), pageSettings.getSortField()));

        return repository.findAll(pageable).map(mapper::toDTO);
    }

    @Override
    public Page<DishDTO> getFilteredPage(PageSettings pageSettings, DishFilter filter) {
        fixCaloriesRange(filter);

        Pageable pageable = PageRequest.of(
                pageSettings.getPage(),
                pageSettings.getSize(),
                Sort.by(Sort.Direction.fromString(
                        pageSettings.getSortDirection()), pageSettings.getSortField()));

        Specification<DishEntity> specification = where(hasNameLike(filter.getName()))
                .and(hasTypeIn(filter.getDishTypes()))
                .and(hasMinCalories(filter.getMinCalories()))
                .and(hasMaxCalories(filter.getMaxCalories()));

        return repository.findAll(specification, pageable).map(mapper::toDTO);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Корректирует диапазон калорий в фильтре, чтобы минимальное значение не превышало максимальное.
     * Если оба значения {@code minCalories} и {@code maxCalories} заданы (не {@code null}),
     * и {@code minCalories > maxCalories}, метод меняет их местами.
     * Если хотя бы одно из значений равно {@code null}, корректировка не выполняется.
     *
     * @param filter фильтр, содержащий настройки диапазона калорий. Изменения применяются напрямую к этому объекту.
     */
    private void fixCaloriesRange(DishFilter filter) {
        Integer min = filter.getMinCalories();
        Integer max = filter.getMaxCalories();

        if (min != null && max != null && min > max) {
            filter.setMaxCalories(min);
            filter.setMinCalories(max);
        }
    }
}
