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
    private cards[] burnCards;
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
        //setup Game
        setupGame();
        roundBetting(true);//first round bets
        dealnextFlop();
        roundBetting(false);//second round bets
        dealnextFlop();
        roundBetting(false);
        dealnextFlop();
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
        if(this.playerList.size() > 2){
            this.smallBlindPlayer.reduceFromBalance(this.smallBlind);
            this.betTotal[this.playerList.indexOf(smallBlindPlayer)] = this.smallBlind;
            this.bigBlindPlayer.reduceFromBalance(this.bigBlind);
            this.betTotal[this.playerList.indexOf(bigBlindPlayer)] = this.bigBlind;
        }
    }
    
    public void roundBetting(boolean preFlop){
        int playerIndex = this.playerList.indexOf(this.smallBlindPlayer);
        if (preFlop){
            playerIndex = this.playerList.indexOf(this.smallBlindPlayer) + 2;
        }
        else {
            playerIndex = this.playerList.indexOf(this.smallBlindPlayer);
        }
        int currentIndex = playerIndex;
        
        //ask all players to see if they wants to fold check or call
        for (int i = 0; i < this.playerList.size(); i++){
            currentIndex = betIndividual(currentIndex);
        }
        
        while(!equalBets()){
            currentIndex = betIndividual(currentIndex);
        }        
    }
    
    public void showRiver(){
        System.out.println("*--------------------------------------------------------*");
        if(this.theRiver[0] != null && this.theRiver[3] == null && this.theRiver[4] == null){
            System.out.println("The Flop:");
        }
        else if(this.theRiver[0] != null && this.theRiver[3] != null && this.theRiver[4] == null){
            System.out.println("The Turn:");        
        }
        else if(this.theRiver[0] != null && this.theRiver[3] != null && this.theRiver[4] != null){
            System.out.println("The River:");
        }
    }
    public void dealnextFlop(){
        if (this.theRiver[0] == null){
            this.theRiver[0] = this.Deck.nextCard();
            this.theRiver[1] = this.Deck.nextCard();
            this.theRiver[2] = this.Deck.nextCard();            
        }
        else if(this.theRiver[3] == null){
            this.burnCards[0] = this.Deck.nextCard();
            this.theRiver[3] = this.Deck.nextCard();            
        }
        else if(this.theRiver[4] == null){
            this.burnCards[1] = this.Deck.nextCard();
            this.theRiver[4] = this.Deck.nextCard();            
        }
                
        showRiver();
    }
    
    public int betIndividual(int currentIndex){
        String callOrCheck = equalBets() ? "check" : "call"; //if all bets are the same ask user to do check or call
        System.out.println("Player: " + this.playerList.get(currentIndex).toString() + 
                           "\n Do you want to fold, " + callOrCheck + " or raise");
        String playerResponse = getInput.next();
        if(playerResponse.toLowerCase().contains("fold")){
            foldFunction(this.playerList.get(currentIndex));
        }
        else if(playerResponse.toLowerCase().contains("call")){
            callFunction(this.playerList.get(currentIndex));
        }
        else if(playerResponse.toLowerCase().contains("raise")){
            raiseFunction(this.playerList.get(currentIndex));
        }
        currentIndex++;
        if (currentIndex == this.playerList.size()){
            currentIndex = 0; //if the index hits the size of the array then return it to zero
        }
        
        currentIndex++;
        if (currentIndex == this.playerList.size()){
            currentIndex = 0; //if the index hits the size of the array then return it to zero
        }
        return currentIndex;
    }
    
    public void foldFunction(Player player){
        player.setIsInGame(false);
    }
    
    public void callFunction(Player player){
        int highestBet = betHighest();
        int betDifference = highestBet - (this.betTotal[this.playerList.indexOf(player)]);
        player.reduceFromBalance(betDifference);
        this.betTotal[this.playerList.indexOf(player)] += betDifference;
        
    }
    
    public void raiseFunction(Player player){
        System.out.println(player.getName() + ", How much raise?");
        int raise = getInput.nextInt();
        callFunction(player);
        player.reduceFromBalance(raise);
        this.betTotal[this.playerList.indexOf(player)] += raise;
    }
    
    public boolean equalBets(){
        int highest = betHighest();
        for(int i=0; i < this.betTotal.length; i++){
            if(this.betTotal[i] > highest && this.playerList.get(i).getIsInGame()){
                return false;
            }            
        }
        return true;
    }    
    
    public int betHighest(){
        int highestBets = 0;
        for(int i=0; i < this.betTotal.length; i++){
            if(this.betTotal[i] < highestBets && this.playerList.get(i).getIsInGame()){
                highestBets = this.betTotal[i];
            }            
        }  
        return highestBets;
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
