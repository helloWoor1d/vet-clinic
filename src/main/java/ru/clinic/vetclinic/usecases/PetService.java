package ru.clinic.vetclinic.usecases;

import org.springframework.stereotype.Service;
import ru.clinic.vetclinic.usecases.dto.CreatePetDto;
import ru.clinic.vetclinic.usecases.dto.PetView;

import java.util.List;

@Service
public interface PetService {
    PetView create(Long ownerId, CreatePetDto dto);

    void delete(Long userId, Long patientId);

    List<PetView> findAll(Long userId);
}
