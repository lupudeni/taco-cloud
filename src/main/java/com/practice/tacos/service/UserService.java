package com.practice.tacos.service;

import com.practice.tacos.domain.RegistrationForm;
import com.practice.tacos.domain.User;
import com.practice.tacos.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow((() -> new UsernameNotFoundException("User '" + username + "' not found")));
    }

    public User formToUser(RegistrationForm form) {
        return new User(
                form.getUsername(),
                passwordEncoder.encode(form.getPassword()),
                form.getFullName(),
                form.getStreet(),
                form.getCity(),
                form.getState(),
                form.getZip(),
                form.getPhone()
        );
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void saveUserFromForm(RegistrationForm form) {
        saveUser(formToUser(form));
    }


}
