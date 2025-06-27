package com.beautyathome.beautyathome.auth.dto;

public record RegisterRequest(String nombre, String correo, String password, Rol rol) {}