package ru.clinic.vetclinic.usecases.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

/**
 * DTO для создания пользователя.
 * <p>Используется при регистрации нового пользователя в системе.</p>
 */
@Builder
public record CreateUserDto(
        @NotBlank(message = "Введите ваше имя")
        String fullName,

        @NotBlank(message = "Укажите номер телефона")
        String phoneNumber,

        @NotBlank(message = "Укажите email")
        @Email(regexp = ".+[@].+[\\.].+", message = "Email не соответствует допустимому формату")
        String email) {}
