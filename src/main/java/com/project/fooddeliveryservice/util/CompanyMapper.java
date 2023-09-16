package com.project.fooddeliveryservice.util;

import com.project.fooddeliveryservice.data.Company;
import com.project.fooddeliveryservice.dto.CompanyDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = CompanyMapper.class)
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    Company companyDtoToCompany(CompanyDto companyDto);

    CompanyDto companyToCompanyDto(Company company);
}
