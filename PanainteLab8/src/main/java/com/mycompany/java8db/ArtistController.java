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
public class ArtistController {
        Statement st;
        ResultSet rs;
        void create(String name, String country){
            try{
            String query = "INSERT INTO 'artists' ('id', 'name', 'country') VALUES (NULL, name, country);";
            st.executeQuery(query);
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        }
        void findByName(String name){
            try{
            String nume = name;
            String query = "SELECT * FROM 'artists' where name = nume;";
            rs = st.executeQuery(query);
            while(rs.next()){
                String nameout = rs.getString("name");
                String countryout = rs.getString("country");
                System.out.println("Name: "+nameout+" Country:"+countryout);
            }
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        }
}
