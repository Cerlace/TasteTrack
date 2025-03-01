package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dto.PageSettings;
import cerlace.tastetrack.dto.UserDTO;

import cerlace.tastetrack.entity.UserEntity;
import cerlace.tastetrack.mapper.UserMapper;
import cerlace.tastetrack.repository.UserRepository;
import cerlace.tastetrack.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserDTO saveOrUpdate(UserDTO dto) {
        UserEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public UserDTO get(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<UserDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public Page<UserDTO> getPage(PageSettings pageSettings) {
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
