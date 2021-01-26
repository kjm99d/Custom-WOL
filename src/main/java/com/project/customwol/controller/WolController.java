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
import org.springframework.web.bind.annotation.RequestParam;

import java.io.PrintWriter;
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

    @GetMapping("/error")
    public String errorPage() {
        return "wol/error";
    }

    /**
     * 리스트 맵핑
     * @param model
     * @param authentication
     * @return
     */
    @GetMapping("/list")
    public String list(Model model, Authentication authentication) {
        /* 사용자 정보 가져오기 */
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);

        List<Wol> wols = wolRepository.findAllByUser_id(user.getId());

        model.addAttribute("wols", wols);
        return "wol/list";
    }

    @PostMapping("/form")
    public String list(Wol wol, Authentication authentication) {
        String username = authentication.getName();
        System.out.println(wol.getId() + ", " + wol.getMac() + ", " + wol.getDescription());

        wolService.save(username, wol);
        return "redirect:/wol/list";
    }

    /**
     * BindingResult 파라미터는 validator에서 처리한다.
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = true) Long id, Authentication authentication) {
        Wol wol = wolRepository.findById(id).orElse(null);
        model.addAttribute("wol", wol);


        String username = authentication.getName();
        User user = userRepository.findByUsername(username);

        if (wol.getUser().getId() != user.getId()) {
            return "redirect:/wol/error";
        }

        return "wol/form";
    }
}
