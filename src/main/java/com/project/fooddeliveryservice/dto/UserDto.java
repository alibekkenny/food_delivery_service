package com.project.fooddeliveryservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    //    @JsonProperty("firstName")
    private String firstName;
    //    @JsonProperty("lastName")
    private String lastName;
    private String phone;
    @JsonProperty(access = WRITE_ONLY)
    private String password;
    private String address;
    private int role;
    @JsonIgnore
    private List<OrderDto> orders;

}
