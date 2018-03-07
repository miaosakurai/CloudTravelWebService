package com.cloudtravel.cloudtravelwebservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private Integer userId;

    private String userName;

    private String password;

    private String email;

}