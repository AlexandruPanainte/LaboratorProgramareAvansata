/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientapplication;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author LenoVo
 */
public class GameClient {

    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        String command;
        Scanner sc= new Scanner(System.in);
        Socket s = new Socket("localhost",4999);
        Scanner sc1= new Scanner(s.getInputStream());
        do{
        System.out.println("Enter any command");
        command = sc.nextLine();

        }
        while(command != "exit");
        s.close();
        
    }
    
}
