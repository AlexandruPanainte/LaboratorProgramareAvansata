
import java.util.TreeSet;
import java.util.Set;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LenoVo
 */
public class Board {
   int n;
   public Set<Token> gameTokens=new TreeSet<>();
    
    public Board(int n) {
        this.n = n;
        while (gameTokens.size() < n)
        {
            gameTokens.add(new Token(n*3));
        }
        
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Set<Token> getGameTokens() {
        return gameTokens;
    }

    public void setGameTokens(Set<Token> gameTokens) {
        this.gameTokens = gameTokens;
    }
    

    

    
   
}
