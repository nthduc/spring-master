package io.github.nthduc.springboot.springboot_rest_api.repositories;

import io.github.nthduc.springboot.springboot_rest_api.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}