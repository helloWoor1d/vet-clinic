package ru.clinic.vetclinic.usecases.dto;

import lombok.Builder;

import java.time.LocalDate;

/**
 * DTO для представления питомца.
 *
 * <p>Используется для возврата информации о питомце
 * во внешние слои приложения.</p>
 */
@Builder
public record PetView(
        Long id,

        String name,

        UserView owner,

        AnimalSpeciesView species,

        LocalDate birthdate) {}
