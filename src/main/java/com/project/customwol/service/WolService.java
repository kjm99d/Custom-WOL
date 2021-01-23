package com.project.customwol.service;

import com.project.customwol.domain.Wol;
import com.project.customwol.repository.WolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class WolService {
    @Autowired
    private WolRepository wolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Wol save(Wol wol){
        /*

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);


        Role role = new Role();
        role.setId(1l); // static value (?)
        user.getRoles().add(role);

        */
        return wolRepository.save(wol);
    }
}
