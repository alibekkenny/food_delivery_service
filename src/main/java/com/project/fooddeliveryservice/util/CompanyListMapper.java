package com.project.fooddeliveryservice.util;

import com.project.fooddeliveryservice.data.Company;
import com.project.fooddeliveryservice.dto.CompanyDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = CompanyListMapper.class)
public interface CompanyListMapper {
    CompanyListMapper INSTANCE = Mappers.getMapper(CompanyListMapper.class);

    List<Company> companyDtoListToCompanyList(List<CompanyDto> companyDtoList);

    List<CompanyDto> companyListToCompanyDtoList(List<Company> companyList);
}
