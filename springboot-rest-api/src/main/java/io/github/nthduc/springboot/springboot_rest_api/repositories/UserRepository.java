package io.github.nthduc.springboot.springboot_rest_api.repositories;

import io.github.nthduc.springboot.springboot_rest_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}