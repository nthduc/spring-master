package io.github.nthduc.springboot.springbootmaster.repositories;

import java.util.List;

import io.github.nthduc.springboot.springbootmaster.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
    public List<Todo> findByUsername(String username);
}