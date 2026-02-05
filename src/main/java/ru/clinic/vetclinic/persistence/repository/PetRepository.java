package ru.clinic.vetclinic.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.clinic.vetclinic.persistence.model.Pet;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findAllByOwnerId(Long ownerId);
}
