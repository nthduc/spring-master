package io.github.nthduc.firstappjob.repositories;

import io.github.nthduc.firstappjob.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
