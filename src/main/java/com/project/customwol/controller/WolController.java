package com.project.customwol.controller;

import com.project.customwol.domain.User;
import com.project.customwol.domain.Wol;
import com.project.customwol.repository.UserRepository;
import com.project.customwol.repository.WolRepository;
import com.project.customwol.service.WolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/wol")
public class WolController {
    @Autowired
    private WolService wolService;

    @Autowired
    private WolRepository wolRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list")
    public String list(Model model, Authentication authentication) {
        /* 사용자 정보 가져오기 */
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);

        List<Wol> wols = wolRepository.findAllByUser_id(user.getId());

        for (Wol wol: wols) {
            System.out.println(wol.getId());
            System.out.println(wol.getMac());
            System.out.println(wol.getDescription());

        }

        model.addAttribute("wols", wols);
        return "wol/list";
    }

    @PostMapping("/list")
    public String list(Wol wol, Authentication authentication) {
        String username = authentication.getName();
        wolService.save(username, wol);
        return "redirect:/list";
    }
}
