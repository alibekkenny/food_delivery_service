package com.project.fooddeliveryservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
    private long id;
    private String name;
    @JsonProperty("logo_path")
    private String logoPath;
    private String category;
    @JsonProperty("company_id")
    private long companyId;
}
