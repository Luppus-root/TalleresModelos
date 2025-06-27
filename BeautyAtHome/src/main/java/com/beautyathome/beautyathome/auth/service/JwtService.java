package com.beautyathome.beautyathome.auth.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private static final String CLAVE_SECRETA = "mi_clave_secreta_super_segura";
    private static final long EXPIRACION = 86400000; // 24 horas

    public String generarToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("rol", userDetails.getAuthorities().stream()
                        .findFirst().map(GrantedAuthority::getAuthority).orElse("USER"))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRACION))
                .signWith(SignatureAlgorithm.HS256, CLAVE_SECRETA)
                .compact();
    }

    public String extraerUsername(String token) {
        return obtenerClaims(token).getSubject();
    }

    public boolean esTokenValido(String token, UserDetails userDetails) {
        String username = extraerUsername(token);
        return username.equals(userDetails.getUsername()) && !estaExpirado(token);
    }

    private Claims obtenerClaims(String token) {
        return Jwts.parser()
                .setSigningKey(CLAVE_SECRETA)
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean estaExpirado(String token) {
        return obtenerClaims(token).getExpiration().before(new Date());
    }
}
