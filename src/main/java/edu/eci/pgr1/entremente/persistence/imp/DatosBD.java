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
    public static final String SERVIDOR = "miinstancia.can9cy10ssrr.us-west-2.rds.amazonaws.com";
    public static final String PUERTO = "3306";
    public static final String USUARIO = "Admin";
    public static final String PASSWORD = "devSolutionCo2016!";
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String BD = "mysql";
    public static final String NOMBREDB = "entremente";
    public static final String CONECTOR = "jdbc:"+DatosBD.BD+"://"+DatosBD.SERVIDOR+":"+DatosBD.PUERTO+"/"+DatosBD.NOMBREDB+"?user="+DatosBD.USUARIO+"&password="+DatosBD.PASSWORD;
}
