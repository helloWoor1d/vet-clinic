package ru.clinic.vetclinic.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.clinic.vetclinic.usecases.UserService;
import ru.clinic.vetclinic.usecases.dto.CreateUserDto;
import ru.clinic.vetclinic.usecases.dto.UserWithPetsView;
import ru.clinic.vetclinic.usecases.dto.UserView;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * REST-контроллер для управления пользователями.
 *
 * <p>
 * Предоставляет API для создания пользователей,
 * получения информации о пользователе и его питомцах,
 * а также удаления пользователя.
 * </p>
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    /**
     * Создаёт нового пользователя.
     *
     * @param dto данные для создания пользователя {@link CreateUserDto}
     * @return пользователь {@link UserView}
     */
    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<UserView> create(@RequestBody @Valid CreateUserDto dto) {
        UserView user = userService.create(dto);
        log.info("User {} created", user.id());
        return ResponseEntity
                .status(CREATED).body(user);
    }

    /**
     * Возвращает информацию о пользователе и всех его питомцах.
     *
     * @param id идентификатор пользователя
     * @return пользователя вместе со списком питомцев {@link UserWithPetsView}
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserWithPetsView> getById(@PathVariable Long id) {
        log.info("Get user by id {}", id);
        return ResponseEntity
                .ok(userService.findById(id));
    }

    /**
     * Удаляет пользователя по идентификатору.
     *
     * @param id идентификатор пользователя
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long id) {
        log.info("User with id {} deleted", id);
        userService.deleteById(id);
    }
}
