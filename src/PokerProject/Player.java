package PokerProject;

import java.util.Arrays;

/**
 *
 * @author Mustafa Adam & Bach Nguyen
 */
public class Player {
    private String playerName;
    private int balance;
    private cards[] playerCards = new cards[2];
    private boolean isInGame;
    
    public Player(String name, int balance, cards[] playerCards){
        this.playerName = name;
        this.balance = balance;
        this.playerCards = playerCards;
        this.isInGame = true;
    }
    
    public String getName(){
        return this.playerName;
    }
    
    public void setName(String nameString){
        this.playerName = nameString;
    }
    
    public int getBalance(){
        return this.balance;
    }
    
    public void addToBalance(int additionAmount){
        this.balance += additionAmount;
    }
    
    public void reduceFromBalance(int reduceAmount){
        this.balance -= reduceAmount;
    }
    
    public cards[] getplayerCards(){
        return this.playerCards;
    }
    
    public boolean getIsInGame(){
        return this.isInGame;
    }
    
    public void setIsInGame(boolean isInGame){
        this.isInGame = isInGame;
    }
    
    public void resetCards(cards[] playerCards){
        this.playerCards = playerCards;
    }
    
    @Override
    public String toString(){
        return(this.playerName);
    }
    
    public static void main(String[] args){
        
        
        
    }
    
}
