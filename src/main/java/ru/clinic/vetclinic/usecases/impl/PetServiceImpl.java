package ru.clinic.vetclinic.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clinic.vetclinic.api.exception.AccessDeniedException;
import ru.clinic.vetclinic.api.exception.NotFoundException;
import ru.clinic.vetclinic.persistence.model.AnimalSpecies;
import ru.clinic.vetclinic.persistence.model.Pet;
import ru.clinic.vetclinic.persistence.model.User;
import ru.clinic.vetclinic.persistence.repository.AnimalSpeciesRepository;
import ru.clinic.vetclinic.persistence.repository.PetRepository;
import ru.clinic.vetclinic.persistence.repository.UserRepository;
import ru.clinic.vetclinic.usecases.mapper.PetMapper;
import ru.clinic.vetclinic.usecases.PetService;
import ru.clinic.vetclinic.usecases.dto.CreatePetDto;
import ru.clinic.vetclinic.usecases.dto.PetView;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
    private final UserRepository userRepository;
    private final AnimalSpeciesRepository animalSpeciesRepository;
    private final PetRepository petRepository;
    private final PetMapper petMapper;

    @Override
    @Transactional
    public PetView create(Long ownerId, CreatePetDto dto) {
        AnimalSpecies species = getSpecies(dto.speciesId());
        User owner = getOwner(ownerId);

        Pet pet = petMapper.toEntity(dto);
        pet.setOwner(owner);
        pet.setSpecies(species);

        petRepository.save(pet);
        return petMapper.toDto(
                petRepository.save(pet));
    }

    @Override
    @Transactional
    public void delete(Long userId, Long patientId) {
        Pet pet = petRepository.findById(patientId)
                .orElseThrow(() -> new NotFoundException("Pet with id " + patientId + " not found"));
        if (!pet.getOwner().getId().equals(userId)) {
            throw new AccessDeniedException("User " + userId + " don't have permission to delete pet with id " + patientId);
        }
        petRepository.delete(pet);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PetView> findAll(Long userId) {
        List<Pet> pets = petRepository.findAllByOwnerId(userId);
        return petMapper.toDto(pets);
    }

    private AnimalSpecies getSpecies(Long speciesId) {
        return animalSpeciesRepository.findById(speciesId)
                .orElseThrow(() -> new NotFoundException("Species with id " + speciesId + " not found"));
    }

    private User getOwner(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User with id " + userId + " not found"));
    }
}
