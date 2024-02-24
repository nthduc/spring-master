package com.nthduc.companyms.company;

import com.nthduc.companyms.company.dto.ReviewMessage;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    String createCompany(CompanyRequest companyRequest);

    CompanyResponse updateCompany(Long id, CompanyRequest companyRequest);

    String deleteCompany(Long id);

    CompanyResponse findCompanyById(Long id);

}