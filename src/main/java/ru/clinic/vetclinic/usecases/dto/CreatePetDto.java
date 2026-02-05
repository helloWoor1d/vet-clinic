package ru.clinic.vetclinic.usecases.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.LocalDate;

/**
 * DTO для создания нового питомца.
 * <p>
 * Используется при регистрации питомца пользователем.
 * </p>
 */
@Builder
public record CreatePetDto(
        @NotBlank(message = "Укажите имя вашего питомца")
        @Size(min = 2, max = 128, message = "Имя не может быть слишком коротким или слишком длинным")
        String name,

        @NotNull(message = "Укажите вид вашего питомца")
        @PositiveOrZero
        Long speciesId,

        @NotNull(message = "Укажите дату рождения")
        LocalDate birthdate) {}
