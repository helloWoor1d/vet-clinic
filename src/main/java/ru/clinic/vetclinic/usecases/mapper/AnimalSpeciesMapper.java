package ru.clinic.vetclinic.usecases.mapper;

import org.mapstruct.Mapper;
import ru.clinic.vetclinic.persistence.model.AnimalSpecies;
import ru.clinic.vetclinic.usecases.dto.AnimalSpeciesView;

@Mapper(componentModel = "spring")
public interface AnimalSpeciesMapper {
    AnimalSpeciesView toDto(AnimalSpecies animalSpecies);

    AnimalSpecies toEntity(AnimalSpeciesView animalSpeciesView);
}
