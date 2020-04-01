
import java.util.Set;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LenoVo
 */
public class Player implements Runnable{
    String name;
    Game game;
    int score;
    Set<Token> playerTokens;
    private Player(){}
    
    public Player(String name, Game game)
    {
        this.name = name;
        this.game = game;
        this.score=0;
        this.playerTokens = new TreeSet<>();
    }
    public int getScore()
    {
        return score;       
    }
    public void setScore(int score)
    {
        this.score = score;
    }
    public String getName()
    {
        return name;
    }
    @Override
    public void run()
    {
        //System.out.println("YO MOM GAY "+ getName());
        while (game.gameBoard.tokens.size()>0)
        {
            game.gameBoard.drawPiece(this);
        }
    }
    
}
