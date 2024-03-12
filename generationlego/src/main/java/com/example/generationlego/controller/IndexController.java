package com.example.generationlego.controller;

import com.example.generationlego.model.Playset;
import com.example.generationlego.service.PlaysetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private PlaysetService playsetService;
    @GetMapping
    public String getPage(Model model){
        List<Playset> playset = playsetService.getPlayset();
        model.addAttribute("playsets",playset);
        return "index";

    }
}
