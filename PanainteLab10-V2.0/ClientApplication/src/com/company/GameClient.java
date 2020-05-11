package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class GameClient {

    public GameClient () throws IOException {
        String serverAddress = "127.0.0.1"; 
        int PORT = 8100;
        try {
                Socket socket = new Socket(serverAddress, PORT);
                while(true) {
                    Scanner read=new Scanner(System.in);
                    System.out.println("Dati comanda:");
                    String comanda=read.next();
                    PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader (
                        new InputStreamReader(socket.getInputStream()));
                    if(comanda.equals("exit")) //in cazul in care primim "exit" inchidem clientul
                        break;
                    

            String raspuns=in.readLine();
            System.out.println(raspuns);
            if(comanda.equals("stop"))// in cazul in care primim "stop" oprim serverul
                break;}
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}
