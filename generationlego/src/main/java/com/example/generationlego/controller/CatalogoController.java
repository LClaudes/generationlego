package com.example.generationlego.controller;

import com.example.generationlego.model.Brand;
import com.example.generationlego.model.Playset;
import com.example.generationlego.service.BrandService;
import com.example.generationlego.service.PlaysetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        if(nome == null && eta == null && prezzo == null) {
            List<Playset> playsetList = playsetService.getPlayset();
            model.addAttribute("playsets",playsetList);
            System.out.println("Ciao sono un unico maschione");
            }
        if(nome != null && eta == null && prezzo == null){
            List<Playset> playsetList = playsetService.getByBrand(nome);
            model.addAttribute("playsets",playsetList);
        }
        if(nome != null && eta !=null && prezzo == null){
            List<Playset> playsetList = playsetService.getByBrandAndEta(nome,eta);
            System.out.println("Ciao nome2" + playsetList);
            model.addAttribute("playsets",playsetList);
        }
        if(nome != null && eta !=null && prezzo != null){
            List<Playset> playsetList = playsetService.getByBrandAndEtaAndPrezzo(nome,eta,prezzo);
            System.out.println("Ciao nome2" + playsetList);
            model.addAttribute("playsets",playsetList);
        }
        if(nome == null && eta !=null && prezzo == null){
            List<Playset> playsetList = playsetService.getByEta(eta);
            model.addAttribute("playsets",playsetList);
        }
        if(nome == null && eta !=null && prezzo != null){
            List<Playset> playsetList = playsetService.getByEtaAndPrezzo(eta, prezzo);
            model.addAttribute("playsets",playsetList);
            System.out.println("Ciao nome3" + playsetList);
        }
        if(nome != null && eta == null && prezzo != null){
            List<Playset> playsetList = playsetService.getByBrandAndPrezzo(nome, prezzo);
            model.addAttribute("playsets",playsetList);
            System.out.println("Ciao nome4" + playsetList);
        }
        if(nome == null && eta == null && prezzo != null){
            List<Playset> playsetList = playsetService.getByPrice(prezzo);
            model.addAttribute("playsets",playsetList);
            System.out.println("Ciao nome4" + playsetList);
        }
            return "catalogo";

    }

    @PostMapping
    public String filtri(Model model,
                         @RequestParam(name = "nome", required = false)String nome,
                         @RequestParam(name = "eta", required = false)String eta,
                         @RequestParam(name = "prezzo", required = false) Float prezzo){
        if (nome == null && eta==null && prezzo == null){
            System.out.println("Ciao");
            return "redirect:/catalogo";
        }
        if(nome != null && eta==null && prezzo == null){
            System.out.println("Ciao nome1");
            return "redirect:/catalogo?nome="+ nome;
        }
        if(nome != null && eta !=null && prezzo == null){
            return "redirect:/catalogo?nome="+ nome +"&eta=" + eta;
        }
        if(nome != null && eta !=null && prezzo != null){
            System.out.println("aiuto");
            return "redirect:/catalogo?nome="+ nome +"&eta=" + eta + "&prezzo="+prezzo;
        }
        if(nome == null && eta !=null && prezzo != null){
            return "redirect:/catalogo?eta=" + eta + "&prezzo="+prezzo;
        }
        if(nome == null && eta !=null && prezzo == null){
            return "redirect:/catalogo?eta=" + eta;
        }
        if(nome != null && eta==null && prezzo != null){
            return "redirect:/catalogo?nome="+ nome + "&prezzo="+prezzo;
        }
        if(nome == null && eta==null && prezzo != null){
            return "redirect:/catalogo?prezzo="+prezzo;
        }
        return "catalogo";
    }
}
