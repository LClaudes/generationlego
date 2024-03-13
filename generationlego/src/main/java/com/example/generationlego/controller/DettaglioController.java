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

// localhost:8080/dettaglio?id=...
@Controller
@RequestMapping("/dettaglio")
public class DettaglioController
{
    @Autowired
    private PlaysetService playsetService;

    @GetMapping
    public String getPage(
            @RequestParam("id") int id,
            Model model,
            @RequestParam(name = "add", required = false) String result
    )
    {
        Playset playset = playsetService.getPlaysetById(id);
        model.addAttribute("playset", playset);
        model.addAttribute("result", result);
        return "dettaglio";
    }

    @GetMapping("/aggiungi")
    public String add(
            @RequestParam("id") int id,
            HttpSession session
    )
    {
        if(!playsetService.aggiungiAlCarrello(id,session))
            return "redirect:/dettaglio?id=" + id + "&add=n";
        return "redirect:/dettaglio?id=" + id + "&add=y";
    }
}