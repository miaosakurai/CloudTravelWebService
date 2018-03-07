package com.cloudtravel.cloudtravelwebservice.exception;


public class InvalidTokenException extends AuthenticationFailureException {

    public InvalidTokenException(String token) {
        super("invalid token:" + token);
    }
}
