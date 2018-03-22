/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.security;

import edu.eci.pgr1.entremente.model.Familiar;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrador
 */
public class SecurityToken {
    private static final String SECRET_KEY = "Entr3m3nt3P4ssw0rd!@";
    private static final String TOKEN_HEADER = "Authorization";
    public static final String NOT_AUTHORIZED_MESSAGE = "NOT Authorized. HTTP Error 401. The requested resource requires user Authentication.";
    public static Token getToken(Familiar familiar){
        String jwtToken = "";
        String userName = familiar.getNombreUsuario();
        String id = familiar.getId().toString();
        jwtToken = Jwts.builder()
                .setSubject(userName)
                .claim( "rol", "F" )
                .claim( "usuario", userName )
                .claim( "id", id )
                .claim( "correo", familiar.getCorreo() )
                .setIssuedAt( new Date() ).signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                .compact();
        return new Token(jwtToken);
    }
    
    
    public static boolean isTokenValid(String token){
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token.replace("Bearer", "")) 
                    .getBody()
                    .getSubject();
            System.err.println("Usuario: "+user);
            return true;
        }
        return false;
    }
}
