package guru.springframework.springtutorial.controllers;

import guru.springframework.springtutorial.model.Owner;
import guru.springframework.springtutorial.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwner(Model model) {

        Set<Owner> ownerSet = ownerService.findAll();

        model.addAttribute("owners", ownerSet);

        return "owners/index";
    }
}
