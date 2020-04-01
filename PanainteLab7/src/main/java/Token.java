
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LenoVo
 */
public class Token implements Comparable<Token>{
    int value;
    Random rand = new Random(); 
    public Token(int value) {
        this.value = rand.nextInt(value);
    }

    @Override
    public int compareTo(Token o) {
        if(this.value > o.value)
            return 1;
        else if(this.value < o.value)
            return -1;
        else if(o.value == 0) return 1;
        else return 0;
                    
    
    }
    
}
