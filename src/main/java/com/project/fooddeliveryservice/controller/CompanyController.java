package com.project.fooddeliveryservice.controller;

import com.project.fooddeliveryservice.data.Company;
import com.project.fooddeliveryservice.dto.CompanyDto;
import com.project.fooddeliveryservice.service.ICompanyService;
import com.project.fooddeliveryservice.util.CompanyListMapper;
import com.project.fooddeliveryservice.util.CompanyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SpringBootApplication
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final ICompanyService companyService;

    @GetMapping("/")
    public List<CompanyDto> getAllCompanies() {
        return CompanyListMapper.INSTANCE.companyListToCompanyDtoList(companyService.getAllCompanies());
    }

    @PostMapping("/")
    public CompanyDto createCompany(@RequestBody CompanyDto company) {
        return CompanyMapper.INSTANCE.companyToCompanyDto(
                companyService.createOrSaveCompany(CompanyMapper.INSTANCE.companyDtoToCompany(company))
        );
    }

    @GetMapping("/{id}")
    public CompanyDto getCompanyById(@PathVariable("id") long id) {
        return CompanyMapper.INSTANCE.companyToCompanyDto(companyService.getCompanyById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable("id") long id) {
        companyService.deleteCompanyById(id);
//        return "Company successfully deleted!";
    }

    @PutMapping("/")
    public CompanyDto updateCompany(@RequestBody CompanyDto company) {
        return CompanyMapper.INSTANCE.companyToCompanyDto(
                companyService.createOrSaveCompany(CompanyMapper.INSTANCE.companyDtoToCompany(company))
        );
    }


}
