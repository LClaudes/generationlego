package com.example.generationlego.controller;

import com.example.generationlego.service.PlaysetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chisiamo")

public class chisiamoController {
    @GetMapping
 public String getPage(Model model){return"chisiamo";}
}