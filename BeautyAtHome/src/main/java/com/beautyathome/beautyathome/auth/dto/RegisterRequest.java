package com.beautyathome.beautyathome.auth.dto;

// auth/dto/RegisterRequest.java
public record RegisterRequest(String nombre, String correo, String password, Rol rol) {}