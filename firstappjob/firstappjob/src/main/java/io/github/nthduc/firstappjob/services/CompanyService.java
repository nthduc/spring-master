package io.github.nthduc.firstappjob.services;

import io.github.nthduc.firstappjob.models.Company;
import io.github.nthduc.firstappjob.models.Job;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Company company, Long id);

    void createCompany(Company company);
    boolean deleteCompanyById(Long id);

    Company getCompanyById(Long id);

}
