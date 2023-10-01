package com.project.fooddeliveryservice.util;

import com.project.fooddeliveryservice.data.CompanyFoodCategory;
import com.project.fooddeliveryservice.dto.CompanyFoodCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = CompanyFoodCategoryMapper.class)
public interface CompanyFoodCategoryMapper {
    CompanyFoodCategoryMapper INSTANCE = Mappers.getMapper(CompanyFoodCategoryMapper.class);

    @Mapping(source = "companyId", target = "company.id")
    CompanyFoodCategory companyFoodCategoryDtoToCompanyFoodCategory(CompanyFoodCategoryDto companyFoodCategoryDto);

    @Mapping(source = "company.id", target = "companyId")
    CompanyFoodCategoryDto companyFoodCategoryToCompanyFoodCategoryDto(CompanyFoodCategory companyFoodCategory);
}
