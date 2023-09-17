package com.project.fooddeliveryservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private Long id;
    private String name;
    //    @JsonProperty("logoPath")
    private String logoPath;
    private String category;
    //    @JsonProperty("companyId")
    private Long companyId;
}
