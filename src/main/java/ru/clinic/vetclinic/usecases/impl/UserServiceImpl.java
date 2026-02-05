package ru.clinic.vetclinic.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clinic.vetclinic.api.exception.NotFoundException;
import ru.clinic.vetclinic.persistence.model.Pet;
import ru.clinic.vetclinic.persistence.model.User;
import ru.clinic.vetclinic.persistence.repository.PetRepository;
import ru.clinic.vetclinic.persistence.repository.UserRepository;
import ru.clinic.vetclinic.usecases.dto.CreateUserDto;
import ru.clinic.vetclinic.usecases.dto.UserWithPetsView;
import ru.clinic.vetclinic.usecases.mapper.UserMapper;
import ru.clinic.vetclinic.usecases.UserService;
import ru.clinic.vetclinic.usecases.dto.UserView;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PetRepository petRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserView create(CreateUserDto dto) {
        User user = userMapper.toEntity(dto);
        userRepository.save(user);

        return userMapper.toView(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserWithPetsView findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with id " + id + " not found"));
        List<Pet> userPets = petRepository.findAllByOwnerId(id);

        return userMapper.toView(user, userPets);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
