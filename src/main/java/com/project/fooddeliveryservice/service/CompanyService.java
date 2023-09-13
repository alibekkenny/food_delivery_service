package com.project.fooddeliveryservice.service;

import com.project.fooddeliveryservice.data.Company;
import com.project.fooddeliveryservice.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CompanyService implements ICompanyService {
    private final CompanyRepository companyRepo;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepo.save(company);
    }

    @Override
    public List<Company> getCompaniesByName(String name) {
        return companyRepo.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Company> getCompaniesByCategory(String category) {
        return companyRepo.findByCategoryContainingIgnoreCase(category);
    }

    @Override
    public Company getCompanyById(long id) {
        return companyRepo.findById(id);
    }

    @Override
    public Company updateCompany(long id, Company company) {
        Company foundCompany = companyRepo.findById(id);
        if (!Objects.equals(company.getName(), "")) {
            foundCompany.setName(company.getName());
        }
        if (!Objects.equals(company.getCategory(), "")) {
            foundCompany.setCategory(company.getCategory());
        }
        if (!Objects.equals(company.getLogoPath(), "")) {
            foundCompany.setLogoPath(company.getLogoPath());
        }
        return companyRepo.save(foundCompany);
    }

    @Override
    public void deleteCompanyById(long id) {
        companyRepo.deleteById(id);
    }

}
