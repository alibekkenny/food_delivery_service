package com.project.fooddeliveryservice.util;

import com.project.fooddeliveryservice.data.CompanyFoodCategory;
import com.project.fooddeliveryservice.dto.CompanyFoodCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = CompanyFoodCategoryMapper.class)
public interface CompanyFoodCategoryMapper {
    CompanyFoodCategoryMapper INSTANCE = Mappers.getMapper(CompanyFoodCategoryMapper.class);

    CompanyFoodCategory companyFoodCategoryDtoToCompanyFoodCategory(CompanyFoodCategoryDto companyFoodCategoryDto);

    CompanyFoodCategoryDto companyFoodCategoryToCompanyFoodCategoryDto(CompanyFoodCategory companyFoodCategory);
}
