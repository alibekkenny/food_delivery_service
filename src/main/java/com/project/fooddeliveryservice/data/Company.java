package com.project.fooddeliveryservice.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "companies")
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String logoPath;
    private String category;

    @OneToMany(mappedBy = "company")
    @ToString.Exclude
    @JsonIgnore
    private List<CompanyFoodCategory> companyFoodCategoryList;
}
