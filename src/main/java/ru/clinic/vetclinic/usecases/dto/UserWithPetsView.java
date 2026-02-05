package ru.clinic.vetclinic.usecases.dto;

import lombok.Builder;

import java.util.List;

/**
 * DTO для полного представления пользователя с его питомцами.
 *
 * <p>
 * Используется для возврата детальной информации о пользователе,
 * включая список принадлежащих ему питомцев.
 * </p>
 */
@Builder
public record UserWithPetsView(
        Long id,

        String fullName,

        String phoneNumber,

        String email,

        List<PetView> pets) {}
