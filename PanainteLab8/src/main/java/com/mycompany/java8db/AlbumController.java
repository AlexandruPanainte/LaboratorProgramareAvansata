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
public class AlbumController {
        Statement st;
        ResultSet rs;
        void create(String name, int artistID, int releaseYear){
            try{
            String query = "INSERT INTO 'albums' ('id', 'name', 'artis_id', 'release_year') VALUES (NULL, name, artistID, releaseYear);";
            st.executeQuery(query);
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        }
        void findByArtist(int artistID){
            try{
            int ID = artistID;
            String query = "SELECT * FROM 'albums' where artistID = ID;";
            rs = st.executeQuery(query);
            while(rs.next()){
                String nameout = rs.getString("name");
                String artistIDout = rs.getString("artistID");
                String releaseYear = rs.getString("releaseYear");
                System.out.println("Name: "+nameout+" ArtistID:"+artistIDout+" ReleaseYear:"+releaseYear);
            }
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        }
}
