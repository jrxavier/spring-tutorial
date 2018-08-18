package guru.springframework.springtutorial.services;

import guru.springframework.springtutorial.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLasName(String lasName);

}
