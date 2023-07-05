package com.homedecor.rest.dto;

import javax.annotation.sql.DataSourceDefinition;

import lombok.Data;
@Data
public class LoginDto {
    private String usernameOrEmail;
    private String password;
}
