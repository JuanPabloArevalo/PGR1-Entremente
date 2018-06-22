/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pgr1.entremente.persistence.imp;

/**
 *
 * @author Administrador
 */
public class DatosBD {
    public static final String SERVIDOR = "localhost";
    public static final String PUERTO = "3307";
    public static final String USUARIO = "root";
    public static final String PASSWORD = "devSolutionCo2016";
    public static final String DRIVER = "org.mariadb.jdbc.Driver";
    public static final String BD = "mariadb";
    public static final String NOMBREDB = "entremente";
    public static final String CONECTOR = "jdbc:"+DatosBD.BD+"://"+DatosBD.SERVIDOR+":"+DatosBD.PUERTO+"/"+DatosBD.NOMBREDB+"?user="+DatosBD.USUARIO+"&password="+DatosBD.PASSWORD;
}
