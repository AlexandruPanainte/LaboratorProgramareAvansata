package com.company;

public class Player{
    public String nume;
    public int valoare;
    public int linie;
    public int coloana;

  
    public String getNume() {
        return nume;
    }   
    public void setColoana(int coloana) {
        this.coloana = coloana;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setValoare(int valoare) {
        this.valoare = valoare;
    }

    public void setLinie(int linie) {
        this.linie = linie;
    }

    public int getValoare() {
        return valoare;
    }  
    public int getColoana() {
        return coloana;
    }
     public int getLinie() {
        return linie;
    }
    public void player(){
        ClientThread client1=new ClientThread();
        client1.run();
        setLinie(client1.getLinie());
        setColoana(client1.getColoana());
    }
}