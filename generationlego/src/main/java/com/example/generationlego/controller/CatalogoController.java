package com.example.generationlego.controller;

import com.example.generationlego.model.Brand;
import com.example.generationlego.model.Playset;
import com.example.generationlego.service.BrandService;
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
    @Autowired
    private BrandService brandService;
    @GetMapping
    public String getPage(Model model,
                          @RequestParam(name = "nome", required = false) String nome,
                          @RequestParam(name = "eta", required = false) String eta,
                          @RequestParam(name="prezzo", required = false) Float prezzo) {
        List<Brand> brands = brandService.getBrand();
        model.addAttribute("brands",brands);
        if (nome == null && eta == null && prezzo == null) {
            List<Playset> playset = playsetService.getPlayset();
            model.addAttribute("playsets", playset);
            System.out.println("sono entrato in catalogo");
            return "catalogo";
        }
        if(nome!= null && eta!= null){
            List<Playset>playset = playsetService.getByBrandAndEta(nome, eta);
            model.addAttribute("playsets", playset);
            System.out.println("sono entrato in concatenata");
            return "catalogo";
        }
        if(prezzo != null ){
            List<Playset>playset = playsetService.getByPrice(prezzo);
            model.addAttribute("playsets", playset);
            System.out.println("sono entrato in prezzo");
            return "catalogo";
        }
        if (nome != null) {
            List<Playset> playset = playsetService.getByBrand(nome);
            model.addAttribute("playsets", playset);
            return "catalogo";
        }
        if (eta != null) {
            List<Playset> playset = playsetService.getByEta(eta);
            model.addAttribute("playsets", playset);
            System.out.println("sono entrato qui dentro");
            return "catalogo";
        }
        else{
            return "catalogo";
        }
    }
}
