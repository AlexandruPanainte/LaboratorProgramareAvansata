package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ClientThread extends Thread {

    private Socket socket = null ;
    private ServerSocket serverSocket=null;
    public int linie;
    public int coloana;
    Board boardgame;
    //Se memoreaza serverSocket pentru a putea inchide serverul in caz ca primim comanda "stop"
    public ClientThread (Socket socket, ServerSocket serverSocket,Board boardgame) {
        this.socket = socket;
        this.serverSocket=serverSocket;
        this.boardgame=boardgame;
    }

    public ClientThread(Socket socket, ServerSocket serverSocket) {
    }

    public void setlinie(int x)
    {
        this.linie=x;
    }
    public void setcoloana(int x)
    {
        this.coloana=x;
    }

    public int getColoana() {
        return coloana;
    }

    public int getLinie() {
        return linie;
    }
    public ClientThread() {

    }


    public void run () {
        try {
            
            while(true) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                if(request.equals("stop")) {
                    String raspuns ="Server stopped";
                    out.println(raspuns);
                    out.flush();
                    serverSocket.close();
                }
                else
                {   //S-au primit comenzile pentru linie si coloana
                    //Le vom separa pentru a putea face verificarile eficient
                    String []parts=request.split(" ");
                    String part1=parts[0];
                    String part2=parts[1];
                    int a;
                    a=Integer.parseInt(part1);
                    setlinie(a);
                    a=Integer.parseInt(part2);
                    setcoloana(a);
                    String raspuns = null;
                    for(int i=0;i<100;i++) {
                        for (int j = 0; j < 100; j++) {
                            raspuns = Integer.toString(boardgame.matrice[i][j]);
                            raspuns = raspuns + " ";
                        }
                        raspuns = raspuns + '\n';
                    }
                    //Se afiseaza pozitiile la care poate pune piesa
                    out.println(raspuns);
                    out.flush();
                }
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) { System.err.println (e); }
        }
    }

}