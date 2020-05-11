package com.company;

public class Board {
    public int [][]board;
    public int mutari;//nr mutari totale
    public int rezultat;//1-Player1, 2-Player2, 3-Egal

    public Board() {
    }
    public void initBoard(){
        int i,j;
        for(i=0;i<100;i++)
            for(j=0;j<100;j++)
                board[i][j]=0;
            mutari=0;
            rezultat=0;
    }
    public void printBoard(){
        int i,j;
        for(i=0;i<100;i++)
        {
            for(j=0;j<100;j++)
                System.out.print(board[i][j]+" ");
            System.out.println();
        }
    }
    public void moveonBoard(int l,int c,int nrplayer,int winner){       
        board[l][c]=nrplayer;
        mutari++;//Se incrementeaza o noua mutare de fiecare data cand vine randul unui nou player
        //Se verifica daca mutarea actuala a adus victoria
        if(wingamecoloana(l,c,nrplayer)>=5)
            rezultat=nrplayer;
        if(wingamelinie(l,c,nrplayer)>=5)
            rezultat=nrplayer;
        if(wingamediagonala1(l,c,nrplayer)>=5)
            rezultat=nrplayer;
        if(wingamediagonala2(l,c,nrplayer)>=5)
            rezultat=nrplayer;
        if(rezultat==0)
        if(mutari==100*100)
            rezultat=3;//Nu mai sunt mutari posibile si cum prin aceasta ultima miscare nu a castigat nimeni s-a terminat jocul egal.
        winner=rezultat;
    }
    public int wingamecoloana(int l, int c, int nrplayer){
        
        int c1,c2;
        int ct1,ct2;
        int ok;
        //Se face verificarea in jos pe coloana, plecand de la coordonatele primite
        c1=c-1;
        ct1=0;
        while(c1>=0&&board[l][c1]==nrplayer)
        {
            c1--;
            ct1++;
        }
        //Se face verificarea in sus pe coloana, plecand de la coordonatele primite
        c2=c+1;
        ct2=0;
        while(c2<100&&board[l][c2]==nrplayer){
            c2++;
            ct2++;
        }
        ok=1+ct1+ct2;
        return ok;
    }
    public int wingamelinie(int l,int c,int nrplayer){
        int l1,l2;
        int ct1,ct2;
        int ok;
        //Se face verificarea in stanga pe linie, plecand de la coordonatele primite
        l1=l-1;
        ct1=0;
        while(l1>=0&&board[l1][c]==nrplayer)
        {
            ct1++;
            l1--;
        }
        //Se face verificarea in dreapta pe linie, plecand de la coordonatele primite
        l2=l+1;
        ct2=0;
        while(l2<100&&board[l2][c]==nrplayer){
            ct2++;
            l2++;
        }
        ok=1+ct1+ct2;
        return ok;
    }
    public int wingamediagonala1(int l,int c,int nrplayer){
        int c1,c2,l1,l2;
        int ct1,ct2;
        int ok;
        l1=l-1;
        c1=c-1;
        ct1=0;
        //Mergem spre inceputul diagonalei principale, plecand de la coordonatele primite
        while(l1>=0&&c1>=0&&board[l1][c1]==nrplayer)
        {
            l1--;
            c1--;
            ct1++;
        }
        l2=l+1;
        c2=c+1;
        ct2=0;
        //Mergem spre sfarsitul diagonalei principale, plecand de la coordonatele primite
        while(l2<100&&c2<100&&board[l2][c2]==nrplayer)
        {
            l2++;
            c2++;
            ct2++;
        }
        ok=1+ct1+ct2;
        return ok;
    }
    public int wingamediagonala2(int l,int c, int nrplayer){
        int c1,c2,l1,l2;
        int ct1,ct2;
        int ok;
        l1=l-1;
        c1=c+1;
        ct1=0;
        //Mergem spre inceputul diagonalei secundare, plecand de la coordonatele primite
        while(l1>=0&&c1<100&&board[l1][c1]==nrplayer){
            l1--;
            c1++;
            ct1++;
        }
        l2=l+1;
        c2=c-1;
        ct2=0;
         //Mergem spre finalul diagonalei secundare, plecand de la coordonatele primite
        while(l2<100&&c2>=0&&board[l2][c2]==nrplayer)
        {
            l2++;
            c2--;
            ct2++;
        }
        ok=1+ct1+ct2;
        return ok;
    }
    public void AiForComputer(int lmax,int cmax,int vmax){
        int i,j;
        int l,c,maxi=0;
        //Incercam sa gasim pozitia optima de a pune o noua valoare verificand fiecare linie coloana si diagonala
        for(i=0;i<100;i++)
            for(j=0;j<100;j++)
            {
                int nr;
                nr=wingamelinie(i,j,2);
                if(nr>maxi)
                {
                    maxi=nr;
                    lmax=i;
                    cmax=j;
                }
                nr=wingamecoloana(i,j,2);
                if(nr>maxi)
                {
                    maxi=nr;
                    lmax=i;
                    cmax=j;
                }
                nr=wingamediagonala1(i,j,2);
                if(nr>maxi)
                {
                    maxi=nr;
                    lmax=i;
                    cmax=j;
                }
                nr=wingamediagonala2(i,j,2);
                if(nr>maxi)
                {
                    maxi=nr;
                    lmax=i;
                    cmax=j;
                }
            }
        vmax=maxi;
    }
    public void moveonBoardvscomputer(int l,int c,int nrplayer,int winner){
        board[l][c]=nrplayer;
        mutari++;
        int lin = 0,col = 0,vm = 0;
        if(nrplayer==2){
            AiForComputer(lin,col,vm);
            l=lin;
            c=col;
        }
        //Se verifica daca a castigat jocul
        if(wingamecoloana(l,c,nrplayer)>=5)
            rezultat=nrplayer;
        if(wingamelinie(l,c,nrplayer)>=5)
            rezultat=nrplayer;
        if(wingamediagonala1(l,c,nrplayer)>=5)
            rezultat=nrplayer;
        if(wingamediagonala2(l,c,nrplayer)>=5)
            rezultat=nrplayer;
        //Daca tabla este plina se termina egal
        if(rezultat==0)
            if(mutari==100*100)
                rezultat=3;
        winner=rezultat;
    }
}
