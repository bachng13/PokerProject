/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PokerProject;

/**
 *
 * @author User 1
 */
public class Player {
    private String playerName;
    private int balance;
    private cards[] holeCards = new cards[2];
    private boolean isInGame;
    
    public Player(String name, int balance, cards[] holeCards){
        this.playerName = name;
        this.balance = balance;
        this.holeCards = holeCards;
        this.isInGame = true;
    }
    
    public String getName(){
        return this.playerName;
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
    
    public cards[] getHoleCards(){
        return this.holeCards;
    }
    
    public boolean getIsInGame(){
        return this.isInGame;
    }
    
    public void setIsInGame(boolean isInGame){
        this.isInGame = isInGame;
    }
    
    public String toString(){
        return("Player: " + this.playerName + " has a balance of " + this.balance
                + ". Hole cards " + this.holeCards[0] + " " + this.holeCards[1] + ".\n In the game:" + this.isInGame);
    }
    
    public static void main(String[] args){
        cards[] holeCards = {new cards(1,"Hearts"), new cards(2,"Hearts")};
        Player player1 = new Player("Timmy", 140, holeCards);
    }
    
}
