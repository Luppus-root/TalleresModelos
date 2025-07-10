package com.beautyathome.backend.security;

public class SecurityConstants {

    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final long EXPIRACION_TOKEN = 1000 * 60 * 60 * 10; // 10 horas
    public static final String TIPO_ALGORITMO = "HS256";
    public static final String FORMATO_BEARER = "JWT";
}
