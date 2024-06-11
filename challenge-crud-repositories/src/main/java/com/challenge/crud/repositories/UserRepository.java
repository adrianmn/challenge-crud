package com.challenge.crud.repositories;

import com.challenge.crud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
}
