package com.project.fooddeliveryservice.service;

import java.util.List;

import com.project.fooddeliveryservice.data.Company;

public interface ICompanyService {
    Company createCompany(Company company);

    Company updateCompany(long id, Company company);

    void deleteCompanyById(long id);

    List<Company> getAllCompanies();

    List<Company> getCompaniesByName(String name);

    List<Company> getCompaniesByCategory(String category);

    Company getCompanyById(long id);
}
