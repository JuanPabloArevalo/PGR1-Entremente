/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.security;

import edu.eci.pgr1.entremente.model.Familiar;
import edu.eci.pgr1.entremente.model.Paciente;
import edu.eci.pgr1.entremente.model.PersonalSalud;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class SecurityToken {
    private static final String SECRET_KEY = "Entr3m3nt3P4ssw0rd!@";
    public static final String TOKEN_HEADER = "Authorization";
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
    
    public static Token getToken(Paciente paciente){
        String jwtToken = "";
        String userName = paciente.getNombreUsuario();
        String id = paciente.getId().toString();
        jwtToken = Jwts.builder()
                .setSubject(userName)
                .claim( "rol", "PA" )
                .claim( "usuario", userName )
                .claim( "id", id )
                .claim( "correo", paciente.getCorreo() )
                .setIssuedAt( new Date() ).signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                .compact();
        return new Token(jwtToken);
    }
    
    public static Token getToken(PersonalSalud personalSalud){
        String jwtToken = "";
        String userName = personalSalud.getNombreUsuario();
        String id = personalSalud.getId().toString();
        jwtToken = Jwts.builder()
                .setSubject(userName)
                .claim( "rol", "PS" )
                .claim( "usuario", userName )
                .claim( "id", id )
                .claim( "correo", personalSalud.getCorreo() )
                .setIssuedAt( new Date() ).signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                .compact();
        return new Token(jwtToken);
    }
    
    public static Token getToken(){
        String jwtToken = "";
        String userName = "Invitado";
        String id = "1";
        jwtToken = Jwts.builder()
                .setSubject(userName)
                .claim( "rol", "PS" )
                .claim( "usuario", userName )
                .claim( "id", id )
                .claim( "correo", "invitado@entremente.com" )
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
