package com.project.customwol.service;

import com.project.customwol.domain.User;
import com.project.customwol.domain.Wol;
import com.project.customwol.repository.UserRepository;
import com.project.customwol.repository.WolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class WolService {
    @Autowired
    private WolRepository wolRepository;

    @Autowired
    private UserRepository userRepository;

    public Wol save(String username, Wol wol){
        User user = userRepository.findByUsername(username);
        wol.setUser(user);

        return wolRepository.save(wol);
    }
}
