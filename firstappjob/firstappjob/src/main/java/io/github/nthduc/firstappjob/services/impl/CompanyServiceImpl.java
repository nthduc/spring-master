package io.github.nthduc.firstappjob.services.impl;

import io.github.nthduc.firstappjob.models.Company;
import io.github.nthduc.firstappjob.models.Job;
import io.github.nthduc.firstappjob.repositories.CompanyRepository;
import io.github.nthduc.firstappjob.services.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company updateCompany, Long id) {
        Optional<Company> companyOptional  = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company company = companyOptional.get();
            company.setName(updateCompany.getName());
            company.setDescription(updateCompany.getDescription());
            company.setJobs(updateCompany.getJobs());
            companyRepository.save(company);
            return true;

        } else {

        return false;
    }
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }else {
            return false;

        }
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }


}
