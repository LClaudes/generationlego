package com.example.generationlego.controller;

import com.example.generationlego.model.Playset;
import com.example.generationlego.service.PlaysetService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private PlaysetService playsetService;
    @GetMapping
    public String getPage(Model model){
        List<Playset> playset = playsetService.findFirst6Playset();
        model.addAttribute("playsets",playset);
        return "index";

    }
    @GetMapping("/aggiungi")
    public String add(@RequestParam( "id")int id,
                      HttpSession session){
        if(!playsetService.aggiungiAlCarrello(id,session))
            return "redirect:/dettaglio?id=" + id + "&add=n";
        return "redirect:/dettaglio?id=" + id + "&add=y";

    }


}
