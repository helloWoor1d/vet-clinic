package ru.clinic.vetclinic.usecases;

import ru.clinic.vetclinic.usecases.dto.CreateUserDto;
import ru.clinic.vetclinic.usecases.dto.UserWithPetsView;
import ru.clinic.vetclinic.usecases.dto.UserView;

public interface UserService {
    UserView create(CreateUserDto createUserDto);

    UserWithPetsView findById(Long id);

    void deleteById(Long id);
}
