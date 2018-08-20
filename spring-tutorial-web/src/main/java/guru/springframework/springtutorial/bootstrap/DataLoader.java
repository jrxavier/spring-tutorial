package guru.springframework.springtutorial.bootstrap;

import guru.springframework.springtutorial.model.Owner;
import guru.springframework.springtutorial.model.Vet;
import guru.springframework.springtutorial.services.OwnerService;
import guru.springframework.springtutorial.services.VetService;
import guru.springframework.springtutorial.services.map.OwnerServiceMap;
import guru.springframework.springtutorial.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Jose");
        owner1.setLastName("Xavier");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Vanessa");
        owner2.setLastName("Xavier");

        ownerService.save(owner2);

        System.out.println("-----------Loaded owners-----------------");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Maria");
        vet1.setLastName("Cardoso");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Monica");
        vet2.setLastName("Cardoso");

        vetService.save(vet2);
        System.out.println("-------------Loaded vets--------------------");
    }
}