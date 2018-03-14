package com.cloudtravel.cloudtravelwebservice.dto.request;

import lombok.Data;

@Data
public class SignUpRequest {
    private String accountNumber;
    private String userPassword;
}
