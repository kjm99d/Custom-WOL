package com.project.customwol.controller;

import com.project.customwol.domain.Member;
import com.project.customwol.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setId(form.getId());
        member.setPassword(form.getPassword());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members/login")
    public String loginPage() {
        return "members/memberLogin";
    }

    @PostMapping("/members/login")
    public String login(HttpSession httpSession, Model model,MemberForm form) {
        System.out.println("LOGIN ID : " + form.getId());
        System.out.println("LOGIN PW : " + form.getPassword());

        Member member = new Member();
        member.setId(form.getId());
        member.setPassword(form.getPassword());

        try {
            String s = memberService.findById(member);
            System.out.println("LOGIN Success ");
            httpSession.setAttribute("sess", member.getId());
            model.addAttribute("status", "true");
        } catch (NoSuchElementException e) {
            System.out.println("LOGIN Failed ");
            model.addAttribute("status", "false");
        }

        return "home";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
