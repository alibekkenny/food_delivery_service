package com.project.fooddeliveryservice.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "company_food_category")
@Data
public class CompanyFoodCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", nullable = false)
    @JsonIgnore
    @ToString.Exclude
    private Company company;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company_food_category")
    @JsonIgnore
    @ToString.Exclude
    private List<Food> foods;
}
