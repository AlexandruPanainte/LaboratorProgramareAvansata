/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.serverapplication;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author LenoVo
 */
public class ClientThread {
        public static void main(String[] args) throws IOException{
            GameServer clientNou = new GameServer();
            clientNou.newClient(4999);
            PrintStream p = new PrintStream(clientNou.ss.getOutputStream());
            do{
             Scanner sc= new Scanner(clientNou.ss.getInputStream());
             clientNou.command = sc.nextLine();
             p.println("Server received request...");
             }
             while(clientNou.command != "Stop");
            
             p.println("ServerStopped");
             clientNou.s1.close();
            
        }
}
