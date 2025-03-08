package cerlace.tastetrack.service.impl;

import cerlace.tastetrack.dto.PageSettings;
import cerlace.tastetrack.dto.UserDTO;

import cerlace.tastetrack.entity.UserEntity;
import cerlace.tastetrack.exception.PasswordConfirmException;
import cerlace.tastetrack.mapper.UserMapper;
import cerlace.tastetrack.repository.RoleRepository;
import cerlace.tastetrack.repository.UserRepository;
import cerlace.tastetrack.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    public static final String PASSWORD_CONFIRM_EXCEPTION_MESSAGE = "Password and confirm password don't match!";
    public static final String ROLE_USER = "ROLE_USER";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper mapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public UserDTO saveOrUpdate(UserDTO dto) {
        UserEntity entity = mapper.toEntity(dto);
        if (entity.getId() == null) {
            entity.setAuthorities(Collections.singleton(roleRepository.findByName(ROLE_USER)));
            entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
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

    @Transactional
    @Override
    public UserDTO changePassword(UserDTO dto) {
        UserEntity entity = userRepository.findByUsername(dto.getUsername()).orElseThrow();
        if (!Objects.equals(dto.getPassword(), dto.getPasswordConfirm()) ||
                !bCryptPasswordEncoder.matches(dto.getOldPassword(), entity.getPassword())) {
            throw new PasswordConfirmException(PASSWORD_CONFIRM_EXCEPTION_MESSAGE);
        }
        entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        return mapper.toDTO(userRepository.save(entity));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow();
    }
}
