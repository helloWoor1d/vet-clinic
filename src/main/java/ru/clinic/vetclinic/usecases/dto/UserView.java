package ru.clinic.vetclinic.usecases.dto;

import lombok.Builder;

/**
 * DTO для краткого представления пользователя.
 *
 * <p>Используется в ответах API, где требуется базовая
 * информация о пользователе без связанных сущностей.</p>
 */
@Builder
public record UserView(
        Long id,

        String fullName,

        String phoneNumber,

        String email) {}
