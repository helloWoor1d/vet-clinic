package ru.clinic.vetclinic.usecases.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.clinic.vetclinic.persistence.model.Pet;
import ru.clinic.vetclinic.usecases.dto.CreatePetDto;
import ru.clinic.vetclinic.usecases.dto.PetView;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetMapper {
    @Mapping(target = "species", ignore = true)
    @Mapping(target = "owner", ignore = true)
    @Mapping(target = "id", ignore = true)
    Pet toEntity(CreatePetDto dto);

    PetView toDto(Pet pet);

    List<PetView> toDto(List<Pet> pets);
}
