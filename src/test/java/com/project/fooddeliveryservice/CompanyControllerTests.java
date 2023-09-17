package com.project.fooddeliveryservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.fooddeliveryservice.controller.CompanyController;
import com.project.fooddeliveryservice.data.Company;
import com.project.fooddeliveryservice.dto.CompanyDto;
import com.project.fooddeliveryservice.service.CompanyService;
import jakarta.persistence.Table;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CompanyController.class)
public class CompanyControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private CompanyService companyService;


    @Test
    public void itShouldCreateCompany() throws Exception {
        Company company = new Company();

        company.setName("KFC");
        company.setCategory("Fast Food Restaurant");

        CompanyDto companyDto = new CompanyDto();

        companyDto.setName("KFC");
        companyDto.setCategory("Fast Food Restaurant");

        when(companyService.createOrSaveCompany(any(Company.class))).thenReturn(company);
        mockMvc.perform(post("/companies")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(companyDto)))
                .andExpectAll(
                        status().is(200),
                        content().contentType(APPLICATION_JSON),
                        jsonPath("$.name").value(company.getName()));
    }

    @Test
    public void itShouldGetAllCompanies() throws Exception {
        Company company1 = new Company();
        company1.setName("KFC");
        Company company2 = new Company();
        company2.setName("McDonalds");
        var companies = List.of(company1, company2);
        when(companyService.getAllCompanies()).thenReturn(companies);

        mockMvc.perform(get("/companies"))
                .andExpect(status().is(200));
    }

    @Test
    public void itShouldGetCompanyById() throws Exception {
        Company company = new Company();

        company.setName("KFC");
        company.setCategory("Fast Food Restaurant");

        when(companyService.getCompanyById(1)).thenReturn(company);

        mockMvc.perform(get("/companies/{id}", 1))
                .andExpectAll(
                        status().is(200),
                        content().contentType(APPLICATION_JSON),
                        content().string(objectMapper.writeValueAsString(company)));
    }

    @Test
    public void itShouldDeleteCompanyById() throws Exception {
        Company company = new Company();

        company.setName("KFC");
        company.setCategory("Fast Food Restaurant");

        mockMvc.perform(delete("/companies/{id}", 1)).andExpect(status().isOk());
    }

    @Test
    public void itShouldUpdateCompany() throws Exception {
        Company company = new Company();
//        company.setId();
        company.setName("KFC");
        company.setCategory("Fast Food Restaurant");

        CompanyDto companyDto = new CompanyDto();
//        companyDto.setId(Long.parseLong("1"));
        companyDto.setName("KFC");
        companyDto.setCategory("Fast Food Restaurant");

        when(companyService.createOrSaveCompany(any(Company.class))).thenReturn(company);
        mockMvc.perform(put("/companies")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(companyDto)))
                .andExpectAll(
                        status().is(200),
                        content().contentType(APPLICATION_JSON),
                        jsonPath("$.name").value(company.getName()));
    }

}
