package com.example.petclinic.repositories;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
