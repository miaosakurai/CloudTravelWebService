package com.cloudtravel.cloudtravelwebservice.dto.request;

import lombok.Data;

/**
 * Created by yerunjie on 2018/2/15
 *
 * @author yerunjie
 */
@Data
public class UserLoginRequest {
    private String accountNumber;
    private String userPassword;
}
