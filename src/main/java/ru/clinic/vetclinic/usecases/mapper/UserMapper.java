package ru.clinic.vetclinic.usecases.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Import;
import ru.clinic.vetclinic.persistence.model.Pet;
import ru.clinic.vetclinic.persistence.model.User;
import ru.clinic.vetclinic.usecases.dto.UserWithPetsView;
import ru.clinic.vetclinic.usecases.dto.CreateUserDto;
import ru.clinic.vetclinic.usecases.dto.UserView;

import java.util.List;

@Mapper(componentModel = "spring")
@Import(PetMapper.class)
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    User toEntity(CreateUserDto createUserDto);

    UserView toView(User user);

    @Mapping(target = "pets", source = "pets")
    UserWithPetsView toView(User user, List<Pet> pets);
}
