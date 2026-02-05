package ru.clinic.vetclinic.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clinic.vetclinic.api.exception.NotFoundException;
import ru.clinic.vetclinic.persistence.model.AnimalSpecies;
import ru.clinic.vetclinic.persistence.repository.AnimalSpeciesRepository;
import ru.clinic.vetclinic.usecases.mapper.AnimalSpeciesMapper;
import ru.clinic.vetclinic.usecases.AnimalSpeciesService;
import ru.clinic.vetclinic.usecases.dto.AnimalSpeciesView;

@Service
@RequiredArgsConstructor
public class AnimalSpeciesServiceImpl implements AnimalSpeciesService {
    private final AnimalSpeciesRepository speciesRepository;
    private final AnimalSpeciesMapper speciesMapper;

    @Override
    public AnimalSpeciesView create(AnimalSpecies animalSpecies) {
        AnimalSpecies species = speciesRepository.save(animalSpecies);
        return speciesMapper.toDto(species);
    }

    @Override
    public AnimalSpeciesView findById(Long id) {
        AnimalSpecies species = speciesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Animal species with id " + id + " not found"));
        return speciesMapper.toDto(species);
    }
}
