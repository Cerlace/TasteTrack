package cerlace.tastetrack.core.service.impl;

import cerlace.tastetrack.core.dto.PageSettings;
import cerlace.tastetrack.core.dto.UserDTO;

import cerlace.tastetrack.persistence.entity.UserEntity;
import cerlace.tastetrack.core.mapper.UserMapper;
import cerlace.tastetrack.persistence.repository.RoleRepository;
import cerlace.tastetrack.persistence.repository.UserRepository;
import cerlace.tastetrack.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    public static final String ROLE_USER = "ROLE_USER";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper mapper;

    @Transactional
    @Override
    public UserDTO saveOrUpdate(UserDTO dto) {
        UserEntity entity = mapper.toEntity(dto);
        if (entity.getId() == null) {
            entity.setAuthorities(Collections.singleton(roleRepository.findByName(ROLE_USER)));
        } else {
            UserEntity entityFromDb = userRepository.findById(entity.getId()).orElseThrow();
            entity.setAuthorities(entityFromDb.getAuthorities());
            entity.setPassword(entityFromDb.getPassword());
        }
        return mapper.toDTO(userRepository.save(entity));
    }

    @Override
    public UserDTO get(Long id) {
        return userRepository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow();
    }

    @Override
    public UserDTO getByUsername(String username) {
        return mapper.toDTO(userRepository.findByUsername(username).orElseThrow());
    }

    @Override
    public Page<UserDTO> getPage(PageSettings pageSettings) {
        Pageable pageable = PageRequest.of(
                pageSettings.getPage(),
                pageSettings.getSize(),
                Sort.by(Sort.Direction.fromString(
                        pageSettings.getSortDirection()), pageSettings.getSortField()));

        return userRepository.findAll(pageable).map(mapper::toDTO);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

    @Transactional
    @Override
    public UserDTO editDetails(UserDTO dto) {
        dto.setId(userRepository.findByUsername(dto.getUsername()).orElseThrow().getId());
        return saveOrUpdate(dto);
    }
}
