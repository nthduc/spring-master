package io.github.nthduc.firstappjob.repositories;

import io.github.nthduc.firstappjob.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
