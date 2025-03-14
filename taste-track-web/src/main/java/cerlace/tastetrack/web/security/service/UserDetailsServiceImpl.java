package cerlace.tastetrack.web.security.service;

import cerlace.tastetrack.persistence.repository.UserRepository;
import cerlace.tastetrack.web.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    public static final String COULD_NOT_FIND_USER_MESSAGE = "Could not find user";
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDetailsImpl(userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(COULD_NOT_FIND_USER_MESSAGE)));
    }
}
