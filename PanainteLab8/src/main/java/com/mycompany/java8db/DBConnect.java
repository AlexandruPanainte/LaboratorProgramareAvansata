/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.java8db;

import java.sql.*;

/**
 *
 * @author LenoVo
 */
public class DBConnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    public DBConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MusicAlbums","dba","sql");
            st = con.createStatement();
        }catch(Exception ex){
            System.out.println("Erro: " + ex);
        }
    }
    
    
    }

