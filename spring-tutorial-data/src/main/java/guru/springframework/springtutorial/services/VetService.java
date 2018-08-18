package guru.springframework.springtutorial.services;

import guru.springframework.springtutorial.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet owner);
    Set<Vet> findAll();
}
