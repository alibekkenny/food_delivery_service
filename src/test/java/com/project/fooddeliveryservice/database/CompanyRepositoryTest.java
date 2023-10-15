package com.project.fooddeliveryservice.database;

import com.project.fooddeliveryservice.data.Company;
import com.project.fooddeliveryservice.repository.CompanyRepository;
import com.project.fooddeliveryservice.service.CompanyService;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyRepositoryTest {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyRepository companyRepository;

    private Company createCompany(String name, String category, String logoPath) {
        Company company = new Company();
        company.setCategory(category);
        company.setName(name);
        company.setLogoPath(logoPath);
        return company;
    }

    @Test
    @DisplayName("Create company")
    public void itShouldCreateOrSaveCompany() {
        Company company = createCompany("ProperTwelve", "Bar", "www.example.com/images/image.png");
        companyRepository.save(company);
        boolean condition = companyRepository.existsById(company.getId());
        assertTrue(condition);
    }

    //    List<Company> findByNameContainingIgnoreCase(@Param("name") String name);
    @Test
    @DisplayName("Find Companies by name")
    public void itShouldFindCompaniesByName() {
        Company company = createCompany("ProperTwelve", "Bar", "www.example.com/images/image.png");
        companyRepository.save(company);
        List<Company> foundCompanies = companyRepository.findByNameContainingIgnoreCase("twelve");
        boolean condition = foundCompanies.get(foundCompanies.size() - 1).toString().equals(company.toString());
        assertTrue(condition);
    }

    //
//    Company findById(@Param("id") long id);
    @Test
    @DisplayName("Find Company by id")
    public void itShouldFindCompanyById() {
        Company company = createCompany("ProperTwelve", "Bar", "www.example.com/images/image.png");
        companyRepository.save(company);
        boolean condition = companyRepository.findById(company.getId()).toString().equals(company.toString());
        assertTrue(condition);
    }

    //    List<Company> findByCategoryContainingIgnoreCase(@Param("category") String category);
    @Test
    @DisplayName("Find Company by Category")
    public void itShouldFindCompaniesByCategory() {
        Company company = createCompany("ProperTwelve", "Bar", "www.example.com/images/image.png");
        companyRepository.save(company);
        List<Company> foundCompanies = companyRepository.findByCategoryContainingIgnoreCase("bar");
        boolean condition = foundCompanies.get(foundCompanies.size() - 1).toString().equals(company.toString());
        assertTrue(condition);
    }
}
