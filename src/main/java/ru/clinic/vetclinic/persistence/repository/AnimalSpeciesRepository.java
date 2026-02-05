package ru.clinic.vetclinic.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.clinic.vetclinic.persistence.model.AnimalSpecies;

@Repository
public interface AnimalSpeciesRepository extends JpaRepository<AnimalSpecies, Long> {
}
