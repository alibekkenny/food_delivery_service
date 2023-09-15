package com.project.fooddeliveryservice.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @ToString.Exclude
    @JsonIgnore
    private List<Order> orders;
}
