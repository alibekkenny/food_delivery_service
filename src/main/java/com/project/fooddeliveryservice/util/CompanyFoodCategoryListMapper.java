package com.project.fooddeliveryservice.util;

import com.project.fooddeliveryservice.data.CompanyFoodCategory;
import com.project.fooddeliveryservice.dto.CompanyFoodCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = CompanyFoodCategoryMapper.class)
public interface CompanyFoodCategoryListMapper {
    CompanyFoodCategoryListMapper INSTANCE = Mappers.getMapper(CompanyFoodCategoryListMapper.class);

    List<CompanyFoodCategory> companyFoodCategoryListDtoToCompanyFoodCategoryList(List<CompanyFoodCategoryDto> companyFoodCategoryDtoList);

    List<CompanyFoodCategoryDto> companyFoodCategoryListToCompanyFoodCategoryListDto(List<CompanyFoodCategory> companyFoodCategoryList);
}
