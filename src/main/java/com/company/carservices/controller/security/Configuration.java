package com.company.carservices.controller.security;

public class Configuration {
    public static final String SECRET = "carservicesSecret";
    public static final String USER_ID_CLAIM = "userId";
    public static final long EXPIRATION_TIME = 90000000; // 1d
    public static final String BEARER_PREFIX = "Bearer ";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";
}
