package com.KAYAN.KayanWeb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {

    private Integer id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Integer serviceID;

    private ServiceDto serviceEntity;
}
