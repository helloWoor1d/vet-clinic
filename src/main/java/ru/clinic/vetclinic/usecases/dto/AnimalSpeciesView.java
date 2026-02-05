package ru.clinic.vetclinic.usecases.dto;

import lombok.Builder;

/**
 * DTO для представления вида животного.
 * <p>
 * Используется для передачи информации о виде питомца
 * во внешние слои приложения (API).
 * </p>
 */
@Builder
public record AnimalSpeciesView(
        Long id,
        String species) {}
