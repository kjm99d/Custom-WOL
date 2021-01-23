package com.project.customwol.service;

import com.project.customwol.domain.Role;
import com.project.customwol.domain.User;
import com.project.customwol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);


        Role role = new Role();
        role.setId(1l); // static value (?)
        user.getRoles().add(role);
        return userRepository.save(user);
    }
}
