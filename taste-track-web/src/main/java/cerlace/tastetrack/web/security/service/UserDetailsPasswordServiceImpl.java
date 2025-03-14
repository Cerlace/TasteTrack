package cerlace.tastetrack.web.security.service;

import cerlace.tastetrack.persistence.entity.UserEntity;
import cerlace.tastetrack.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserDetailsPasswordServiceImpl implements UserDetailsPasswordService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        UserEntity entity = userRepository.findByUsername(user.getUsername()).orElseThrow();
        entity.setPassword(newPassword);
        userRepository.save(entity);
        return user;
    }
}
