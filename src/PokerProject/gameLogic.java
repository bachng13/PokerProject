package PokerProject;

import java.util.*;
import java.util.Scanner;
/**
 *
 * @author Mustafa Adam & Bach Nguyen
 */
public class gameLogic {
    
    private ArrayList<Player> playerList;
    private deck Deck;
    private cards[] theCommunityCards;
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
        this.theCommunityCards = new cards[5];
        this.pot = 0; 
        this.smallBlind = smallBlind; //needed to start the game
        this.bigBlind = this.smallBlind * 2; // twice the amount of big blind
        this.dealer = dealer;
        //setup Game
        setupGame();
        dealnextFlop();
        roundBetting(true);//first round bets
        dealnextFlop();
        roundBetting(false);//second round bets
        dealnextFlop();
        roundBetting(false);//third round bets
        dealnextFlop();
        winnerFunction();
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
            playerIndex = this.playerList.indexOf(this.smallBlindPlayer) + 1;
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
        if(this.theCommunityCards[0] != null && this.theCommunityCards[3] == null && this.theCommunityCards[4] == null){
            System.out.println("The Flop:");
        }
        else if(this.theCommunityCards[3] != null && this.theCommunityCards[4] == null){
            System.out.println("The Turn:");        
        }
        else if(this.theCommunityCards[4] != null){
            System.out.println("The River:");
        }
        System.out.println(Arrays.toString(this.theCommunityCards));
    }
    
    public void dealnextFlop(){
        if (this.theCommunityCards[0] == null){
            this.theCommunityCards[0] = this.Deck.nextCard();
            this.theCommunityCards[1] = this.Deck.nextCard();
            this.theCommunityCards[2] = this.Deck.nextCard();            
        }
        else if(this.theCommunityCards[3] == null){
//            this.burnCards[0] = this.Deck.nextCard();
            this.theCommunityCards[3] = this.Deck.nextCard();            
        }
        else if(this.theCommunityCards[4] == null){
//            this.burnCards[1] = this.Deck.nextCard();
            this.theCommunityCards[4] = this.Deck.nextCard();            
        }
                
        showRiver();
    }
    
    public Player[] winnerFunction(){
        ArrayList<Player> winnerDetermine = new ArrayList<Player>();
        return (Player[]) winnerDetermine.toArray();
    }
    
    public ArrayList<Player> royalFlush(){
        ArrayList<Player> winner = new ArrayList<Player>();
        for(int i = 0; i < this.playerList.size(); i++){
            Player currentPlayer = this.playerList.get(i);
            if(currentPlayer.getIsInGame()){
                ArrayList<cards> currentPlayerCards = getAllCards(this.playerList.get(i));
                System.out.println("Winning Hand" + currentPlayerCards);
            }
        }
        return winner;
    }
    
    public ArrayList<cards> getAllCards(Player player){
        ArrayList<cards> allCards = new ArrayList<cards>();
        for (int i = 0; i < this.theCommunityCards.length; i++) {
            allCards.add(this.theCommunityCards[i]);
        }
        allCards.add(player.getplayerCards()[0]);
        allCards.add(player.getplayerCards()[1]);
        allCards = sort(allCards);
        return allCards;        
    }

    public gameLogic(ArrayList<Player> playerList, deck Deck, cards[] theRiver, cards[] burnCards, int smallBlind, int bigBlind, int pot, Player dealer, Player smallBlindPlayer, Player bigBlindPlayer, int[] betTotal) {
        this.playerList = playerList;
        this.Deck = Deck;
        this.theCommunityCards = theRiver;
        this.burnCards = burnCards;
        this.smallBlind = smallBlind;
        this.bigBlind = bigBlind;
        this.pot = pot;
        this.dealer = dealer;
        this.smallBlindPlayer = smallBlindPlayer;
        this.bigBlindPlayer = bigBlindPlayer;
        this.betTotal = betTotal;
    }
    
    
    public int betIndividual(int currentIndex){
        String callOrCheck = equalBets() ? "check" : "call"; //if all bets are the same ask user to do check or call
        showRiver();
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
    
    public ArrayList<cards> sort(ArrayList<cards> cardsList){
        ArrayList<cards> sortCards = new ArrayList<cards>();
        while(cardsList.size() > 0){
            int lowestCards = 15;
            int removedIndex = -1;
            for (int i = 0; i < sortCards.size(); i++) {
                if(sortCards.get(i).getRank() < lowestCards){
                    removedIndex = i;
                }
                
            }
            if (removedIndex != -1){
                sortCards.add(cardsList.remove(removedIndex));
            }
        }
        
        return sortCards;
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
