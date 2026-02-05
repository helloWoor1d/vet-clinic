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
import ru.clinic.vetclinic.usecases.PetService;
import ru.clinic.vetclinic.usecases.dto.CreatePetDto;
import ru.clinic.vetclinic.usecases.dto.PetView;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * REST-контроллер для управления питомцами пользователей.
 *
 * <p>
 * Предоставляет API для создания, получения и удаления питомцев,
 * закреплённых за конкретным пользователем.
 * </p>
 */
@RestController
@RequestMapping("/users/{userId}/pets")
@RequiredArgsConstructor
@Slf4j
public class PetController {
    private final PetService petService;

    /**
     * Создаёт нового питомца и привязывает его к пользователю.
     *
     * @param userId идентификатор владельца питомца
     * @param dto объект запроса для создания питомца {@link CreatePetDto}
     * @return добавленного питомца ({@link PetView}) с HTTP статусом 201 (Created).
     */
    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<PetView> addPet(@PathVariable Long userId,
                                          @RequestBody @Valid CreatePetDto dto) {
        PetView view = petService.create(userId, dto);
        log.debug("Add new pet {}", view);
        return ResponseEntity
                .status(CREATED)
                .body(view);
    }

    /**
     * Удаляет питомца, принадлежащего указанному пользователю.
     *
     * @param userId идентификатор владельца
     * @param petId идентификатор питомца
     */
    @DeleteMapping("/{petId}")
    @ResponseStatus(NO_CONTENT)
    public void deletePet(@PathVariable Long userId,
                          @PathVariable Long petId) {
        petService.delete(userId, petId);
        log.debug("Deleted pet {} by {}", petId, userId);
    }

    /**
     * Возвращает список всех питомцев пользователя.
     *
     * @param userId идентификатор пользователя
     * @return список питомцев пользователя {@link PetView}
     */
    @GetMapping
    public ResponseEntity<List<PetView>> getPet(@PathVariable Long userId) {
        List<PetView> pets = petService.findAll(userId);
        log.debug("Get all user {} pets", userId);
        return ResponseEntity.ok(pets);
    }
}
