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
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/riservataadmin")
public class RiservataAdminController
{
    @Autowired
    private PlaysetService playsetService;

    @Autowired
    private BrandService brandService;

    private Playset playset;

    private Map<String, String> errori;

    @GetMapping
    public String getPage(
            Model model,
            @RequestParam(name = "id", required = false) Integer id)
    {
        List<Playset> playset = playsetService.getPlayset();
        List<Brand> brand = brandService.getBrand();
        if(errori == null)
            playset = (List<Playset>) (id == null ? new Playset() : playsetService.getPlaysetById(id));
        model.addAttribute("playset", playset);
        model.addAttribute("brand", brand);
        model.addAttribute("playset", playset);
        model.addAttribute("errori", errori);
        return "riservataadmin";
    }

    @SuppressWarnings("unchecked")
    @PostMapping
    public String formManager(
            @RequestParam("nome") String nome,
            @RequestParam("prezzo") float prezzo,
            @RequestParam("brand") int id_brand,
            @RequestParam("eta") String eta,
            @RequestParam("numero pezzi") int numero_pezzi,
            @RequestParam("descrizione") String descrizione,
            @RequestParam(name = "immagine", required = false) MultipartFile immagine,
            @RequestParam("scorte") int scorte
    )
    {
        Object risultatoValidazione = playsetService.validaPlayset(playset, nome, id_brand, eta, numero_pezzi, prezzo, descrizione);
        // se abbiamo errori di validazione
        if(risultatoValidazione != null)
        {
            playset = (Playset) ((Object[])risultatoValidazione)[0];
            errori = (Map<String, String>) ((Object[])risultatoValidazione)[1];
            return "redirect:/riservataadmin";
        }



        playsetService.registraPlayset(playset, nome, id_brand, eta, numero_pezzi, prezzo, descrizione, immagine, scorte);
        return "redirect:/riservataadmin";
    }

    @GetMapping("/elimina")
    public String eliminaLibro(@RequestParam("id") int id)
    {
        playsetService.cancellaPlayset(id);
        return "redirect:/riservataadmin";
    }
}