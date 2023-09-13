package com.project.fooddeliveryservice.controller;

import com.project.fooddeliveryservice.data.Company;
import com.project.fooddeliveryservice.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SpringBootApplication
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final ICompanyService companyService;

    @GetMapping("/")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @PostMapping("/")
    public Company createCompany(@RequestBody Company company) {
        return companyService.createCompany(company);
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable("id") long id) {
        return companyService.getCompanyById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable("id") long id) {
        companyService.deleteCompanyById(id);
        return "Company successfully deleted!";
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable("id") long id, @RequestBody Company company) {
        return companyService.updateCompany(id, company);
    }

    public static void main(String[] args) {
        SpringApplication.run(CompanyController.class, args);
    }
}
