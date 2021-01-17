package com.project.customwol.controller;

import com.project.customwol.service.DataInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DataInfoController {
    private final DataInfoService dataInfoService;

    @Autowired
    public DataInfoController(DataInfoService dataInfoService) {
        this.dataInfoService = dataInfoService;
    }
}
