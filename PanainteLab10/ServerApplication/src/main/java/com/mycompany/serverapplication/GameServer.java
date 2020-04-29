/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.serverapplication;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author LenoVo
 */
public class GameServer {
    public String command;
    public ServerSocket s1;
    public Socket ss;
    
    public void newClient(int port) throws IOException{
        // TODO code application logic here

        s1 = new ServerSocket(port);
        ss = s1.accept();    
        /*
        PrintStream p = new PrintStream(ss.getOutputStream());
        p.println(command + "caca");       */                 
    }

    public String getCommand() throws IOException {
        Scanner sc= new Scanner(ss.getInputStream());
        command = sc.nextLine();
        return command;
    }
    public void Print(boolean h) throws IOException
    {
        PrintStream p = new PrintStream(ss.getOutputStream());
        if(h)
            p.println("ServerStopped");
            else p.println("Server received request...");
    }

    
    
    
}