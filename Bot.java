
package PokerProject;

import java.util.Random;

/**
 *
author Mustafa Adam & Bach Nguyen */
public class Bot extends HumanPlayer {
    private int decision;
    private String difficulty;
        public void setDifficultyLevel(String level){
        this.difficulty = level;
    }
    public int decide(){
        Random rand = new Random(); 
        return  rand.nextInt(100);
    }
    
    public String getDifficultyLevel(){
        return this.difficulty;
    }
    

}
