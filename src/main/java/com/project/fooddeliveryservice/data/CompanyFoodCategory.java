package com.project.fooddeliveryservice.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "companyFoodCategories")
@Data
public class CompanyFoodCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne
    @MapsId("companyId")
    @JoinColumn(name = "company_id", nullable = false)
//    @JsonIgnore
    @ToString.Exclude
    private Company company;

    @OneToMany(mappedBy = "companyFoodCategory")
//    @JsonIgnore
    @ToString.Exclude
    private List<Food> foods;
}
