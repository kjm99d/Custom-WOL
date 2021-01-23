package com.project.customwol.controller;

import com.project.customwol.domain.Wol;
import com.project.customwol.repository.WolRepository;
import com.project.customwol.service.UserService;
import com.project.customwol.service.WolService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/list")
    public String list(Model model) {
        List<Wol> wols = wolRepository.findAll();
        model.addAttribute("wols", wols);
        return "wol/list";
    }

    @PostMapping("/list")
    public String list(Wol wol) {
        wolService.save(wol);
        return "redirect:/list";
    }
}
