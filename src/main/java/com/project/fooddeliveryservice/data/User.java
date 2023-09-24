package com.project.fooddeliveryservice.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.boot.jackson.JsonComponent;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    private String firstName;
    private String lastName;
    private String phone;
    @JsonProperty(access = WRITE_ONLY)
    private String password;
    private String address;
    private Integer role; // 1-administrator staff, 2-company employee, 3-deliveryman, 4-customer
    @OneToMany(mappedBy = "user")
    @ToString.Exclude
//    @JoinColumn(name = "user_id", nullable = true)
    @JsonIgnore
    private List<Order> orders;
}
