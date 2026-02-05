package ru.clinic.vetclinic.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.clinic.vetclinic.persistence.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
