package com.example.generationlego.controller;

import com.example.generationlego.model.Playset;
import com.example.generationlego.service.PlaysetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {
    @Autowired
    private PlaysetService playsetService;
    @GetMapping
    public String getPage(Model model,
                          @RequestParam(name = "nome", required = false) String nome){
        if(nome == null){
        List<Playset> playset = playsetService.getPlayset();
        model.addAttribute("playsets",playset);
        return "catalogo";}
        else {
            List<Playset> playset = playsetService.getByBrand(nome);
            model.addAttribute("playsets",playset);
            return "catalogo";
        }

    }


}
