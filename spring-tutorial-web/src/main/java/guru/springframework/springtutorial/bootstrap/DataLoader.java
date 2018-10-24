package guru.springframework.springtutorial.bootstrap;

import guru.springframework.springtutorial.model.Owner;
import guru.springframework.springtutorial.model.Pet;
import guru.springframework.springtutorial.model.PetType;
import guru.springframework.springtutorial.model.Vet;
import guru.springframework.springtutorial.services.OwnerService;
import guru.springframework.springtutorial.services.PetTypeService;
import guru.springframework.springtutorial.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        //owner1.setId(1L);
        owner1.setFirstName("Jose");
        owner1.setLastName("Xavier");
        owner1.setAddress("Rua Campos Sales");
        owner1.setCity("Rio de Janeiro");
        owner1.setTelephone("25679671");

        Pet godiva = new Pet();
        godiva.setPetType(savedDogPetType);
        godiva.setOwner(owner1);
        godiva.setBirthDate(LocalDate.now());
        godiva.setName("Godiva");

        owner1.getPets().add(godiva);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        //owner2.setId(2L);
        owner2.setFirstName("Vanessa");
        owner2.setLastName("Xavier");
        owner2.setAddress("Rua Campos Sales");
        owner2.setCity("Rio de Janeiro");
        owner2.setTelephone("25679671");

        Pet felix = new Pet();
        felix.setPetType(savedCatPetType);
        felix.setOwner(owner2);
        felix.setBirthDate(LocalDate.now());
        felix.setName("Gato Felix");

        owner2.getPets().add(felix);

        ownerService.save(owner2);

        System.out.println("-----------Loaded owners-----------------");

        Vet vet1 = new Vet();
        //vet1.setId(1L);
        vet1.setFirstName("Maria");
        vet1.setLastName("Cardoso");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        //vet2.setId(2L);
        vet2.setFirstName("Monica");
        vet2.setLastName("Cardoso");

        vetService.save(vet2);
        System.out.println("-------------Loaded vets--------------------");
    }
}