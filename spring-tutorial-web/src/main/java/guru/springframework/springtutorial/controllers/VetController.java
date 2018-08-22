package guru.springframework.springtutorial.controllers;

import guru.springframework.springtutorial.model.Vet;
import guru.springframework.springtutorial.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
    public String listVets(Model model) {

        Set<Vet> vetSet = vetService.findAll();

        model.addAttribute("vets", vetSet);

        return "vets/index";
    }
}
