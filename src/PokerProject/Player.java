/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PokerProject;

import java.util.Arrays;

/**
 *
 * @author User 1
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
        return("Player: " + this.playerName + " has a score of " + this.balance
                + ". player cards " + Arrays.toString(this.playerCards) + ".\n In the game:" + this.isInGame);
    }
    
    public static void main(String[] args){
        
        //test
        cards[] playerCards = {new cards(1,"Hearts"), new cards(2,"Hearts")};
        Player player1 = new Player("Steve", 150, playerCards);
        
        
        System.out.println(player1.getName());
        System.out.println(player1.getBalance());
        player1.addToBalance(5);
        System.out.println(player1.getBalance());
        System.out.println(Arrays.toString(player1.getplayerCards()));
        System.out.println(player1.toString());
        
    }
    
}
