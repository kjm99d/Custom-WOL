package com.project.customwol.controller;

import com.project.customwol.domain.DataInfo;
import com.project.customwol.service.DataInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DataInfoController {
    private final DataInfoService dataInfoService;

    @Autowired
    public DataInfoController(DataInfoService dataInfoService) {
        this.dataInfoService = dataInfoService;
    }

    // PC 데이터 추가하는 페이지로 이동
    @GetMapping("/data/new")
    public String createData(HttpSession session, Model model) {
        String s = (String)session.getAttribute("Check");
        System.out.println(s);

        return "datasinfo/createDataForm";
    }

    // PC 데이터 추가하는 페이지로 이동
    @PostMapping("/data/new")
    public String create(DataInfo dataInfo) {
        // 데이터 체크
        // 동일 MAC Address 검색
        
        dataInfoService.add(dataInfo);
        return "redirect:/";
    }
}
