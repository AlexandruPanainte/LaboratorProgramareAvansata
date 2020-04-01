
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LenoVo
 */
public class Game {
    int nrTokens;
    int LengthGoal;
    int MaxTokenValue;
    int playerTurn;
    
    Board board;
    Player[] player=new Player[2];
    Thread[] threads = new Thread[2];
    public Player[] getPlayer()
    {
        return player;
    }
    public void setPlayer(Player[] player)
    {
        this.player = player;
        this.threads=new Thread[player.length];
        startGame();
    }
    public void nextPlayer()
    {
        playerTurn=(playerTurn+1)%2;
    }
    
    public Game(int nrTokens, int LengthGoal, int MaxTokenValue)
    {
        this.nrTokens = nrTokens;
        this.LengthGoal = LengthGoal;
        this.MaxTokenValue = MaxTokenValue;
    
    }

    public void setNrTokens(int nrTokens) {
        this.nrTokens = nrTokens;
    }

    public void setLengthGoal(int LengthGoal) {
        this.LengthGoal = LengthGoal;
    }

    public void setMaxTokenValue(int MaxTokenValue) {
        this.MaxTokenValue = MaxTokenValue;
    }
    
    public int getNrTokens()
    {
        return nrTokens;
    }
    public int getLengthGoal()
    {
        return LengthGoal;
    }
    private void startGame()
    {
        playerTurn=0;
        System.out.println("The game has started:");
        //init game board
        List<Token> gameTokens=new ArrayList<>();
        while(gameTokens.size()<nrTokens)
        {
            Token tk;
            int tempNR=(int) (Math.random()*10000)%(MaxTokenValue+1);
            if (tempNR==0) tk=new Token();
            else tk=new Token(tempNR);
            gameTokens.add(tk);
        }
        gameBoard=new Board(gameTokens, game: this);
        //start player threads
        for(int i=0;i<2;i++)
        {
            threads[i]=new Thread(player[i]);
            player[i].setGameOrder(i);
            threads[i].start();
        }
        
        while(gameBoard.tokens.size()>0){}
        System.out.println("Game Finished");
        System.exit(0);
    }
    
    
    
}
