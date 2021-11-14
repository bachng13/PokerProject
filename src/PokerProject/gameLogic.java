/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PokerProject;

import java.util.*;
import java.util.Scanner;
/**
 *
 * @author User 1
 */
public class gameLogic {
    
    private ArrayList<Player> playerList;
    private deck Deck;
    private cards[] theRiver;
    private int smallBlind;
    private int bigBlind;
    private int pot;
    private Player dealer;
    private Player smallBlindPlayer; 
    private Player bigBlindPlayer;
    private int[] betTotal;
    
    Scanner getInput = new Scanner(System.in);
    
    
    public gameLogic(){
        this.playerList = new ArrayList<>();
        this.Deck = new deck();
        this.theRiver = new cards[5];
        this.pot = 0; 
        this.smallBlind = smallBlind; //needed to start the game
        this.bigBlind = this.smallBlind * 2; // twice the amount of big blind
        this.dealer = dealer;
        setupGame();
    }
    
    public void setupGame(){
        boolean addAnotherPlayer = true;
        while (addAnotherPlayer) {
            addAnotherPlayer = false;
            addPlayer();
            System.out.println("Do you want to add another player? (Y/N)");
            if (getInput.next().toLowerCase().contains("y")) {
                addAnotherPlayer = true;
            }
        }
        this.dealer = playerList.get(0);
        if(playerList.size() > 2){
            this.smallBlindPlayer = playerList.get(1);
            this.bigBlindPlayer = playerList.get(2);
        }
        this.betTotal = new int[playerList.size()];
        
        
    }
    
    public void payOutBlinds(){
        this.smallBlindPlayer.reduceFromScore(this.smallBlind);
        this.betTotal[this.playerList.indexOf(smallBlindPlayer)] = this.smallBlind;
        this.bigBlindPlayer.reduceFromScore(this.bigBlind);
        this.betTotal[this.playerList.indexOf(bigBlindPlayer)] = this.bigBlind;
    }
    
    public void roundBetting(){
        int playerIndex = this.playerList.indexOf(this.smallBlindPlayer);
        int currentIndex = playerIndex;
        for (int i = 0; i < this.playerList.size(); i++){
            String callOrCheck = equalBets() ? "check" : "call"; //if all bets are the same ask user to do check or call
            
        }
    }
    
    public boolean equalBets(){
        int highest = 0;
        for(int i=0; i < this.betTotal.length; i++){
            if(this.betTotal[i] > highest && this.playerList.get(i).getIsInGame()){
                highest = this.betTotal[i];
            }
            
        }
        for(int i=0; i < this.betTotal.length; i++){
            if(this.betTotal[i] < highest && this.playerList.get(i).getIsInGame()){
                return false;
            }
            
        }
        
        
        return true;
    }
    
    public void addPlayer(){
        System.out.println("Enter player's name:");
        String name = getInput.next();
        System.out.println("Enter Starting Balance:");
        int playerBalance = getInput.nextInt();
        cards[] playerCards = {Deck.nextCard(), Deck.nextCard()};
        System.out.println(Arrays.toString(playerCards));
        playerList.add(new Player(name, playerBalance, playerCards));
        System.out.println(playerList.get(playerList.size()-1).toString());
    }  
    
    
    
    public static void main(String[] args){
        
        gameLogic ng = new gameLogic();
        
    }

    
    
}
