package ru.clinic.vetclinic.usecases;

import ru.clinic.vetclinic.persistence.model.AnimalSpecies;
import ru.clinic.vetclinic.usecases.dto.AnimalSpeciesView;

public interface AnimalSpeciesService {
    AnimalSpeciesView create(AnimalSpecies animalSpecies);

    AnimalSpeciesView findById(Long id);
}
