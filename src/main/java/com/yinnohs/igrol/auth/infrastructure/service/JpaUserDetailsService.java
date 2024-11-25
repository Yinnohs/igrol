package com.yinnohs.igrol.auth.infrastructure.service;

import com.yinnohs.igrol.user.domain.model.User;
import com.yinnohs.igrol.user.domain.port.out.UserRepository;
import com.yinnohs.igrol.user.infrastructure.document.UserDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        return UserDocument.fromUserModel(user);
    }
}
