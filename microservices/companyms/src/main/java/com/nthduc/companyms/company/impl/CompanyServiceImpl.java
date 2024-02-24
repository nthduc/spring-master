package com.nthduc.companyms.company.impl;

import com.nthduc.companyms.company.*;
import com.nthduc.companyms.company.dto.ReviewMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public String createCompany(CompanyRequest companyRequest) {
        Company company = Company.builder()
                .name(companyRequest.getName())
                .description(companyRequest.getDescription())
                .build();
        companyRepository.save(company);
        return company.toString();
    }

    @Override
    public CompanyResponse updateCompany(Long id, CompanyRequest companyRequest) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()){
            Company company = companyOptional.get();
            company.setName(companyRequest.getName());
            company.setDescription(companyRequest.getDescription());
            companyRepository.save(company);
            return mapToCompanyResponse(company);
        }else {
            throw new NoSuchElementException("Company with ID " + id + " not found");
        }
    }

    @Override
    public String deleteCompany(Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()){
            Company company = companyOptional.get();
            companyRepository.delete(company);
            return "Company Deleted";
        }else{
            throw new NoSuchElementException("Company with ID " + id + " not found");
        }
    }

    @Override
    public CompanyResponse findCompanyById(Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company company = companyOptional.get();
            return mapToCompanyResponse(company);
        }else {
            throw new NoSuchElementException("Company with ID " + id + " not found");
        }
    }

    private CompanyResponse mapToCompanyResponse(Company company) {
        return CompanyResponse.builder()
                .id(company.getId())
                .name(company.getName())
                .description(company.getDescription())
                .build();
    }
}