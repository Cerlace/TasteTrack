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

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    public static final String PASSWORD_CONFIRM_EXCEPTION_MESSAGE = "Password and confirm password don't match!";
    public static final String COULD_NOT_FIND_USER_MESSAGE = "Could not find user";
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper mapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO saveOrUpdate(UserDTO dto) {
        if (!Objects.equals(dto.getPassword(), dto.getPasswordConfirm())) {
            throw new PasswordConfirmException(PASSWORD_CONFIRM_EXCEPTION_MESSAGE);
        }
        UserEntity entity = mapper.toEntity(dto);
        if (entity.getId() == null) {
            entity.setRoles(Collections.singleton(roleRepository.findByName("ROLE_USER")));
        } else {
            UserEntity entityFromDb = userRepository.findById(entity.getId()).get();
            entity.setRoles(entityFromDb.getRoles());
            entity.setEncodedPassword(entityFromDb.getEncodedPassword());
        }
        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            entity.setEncodedPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        }
        return mapper.toDTO(userRepository.save(entity));
    }

    @Override
    public UserDTO get(Long id) {
        return userRepository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<UserDTO> getAll() {
        return mapper.toDTOList(userRepository.findAll());
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(COULD_NOT_FIND_USER_MESSAGE);
        }
        return user;
    }
}
