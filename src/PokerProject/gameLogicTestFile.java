package PokerProject;

import java.util.*;
import java.util.Scanner;

/**
 *
 * @author Mustafa Adam & Bach Nguyen
 */

//test gameLogics
public class gameLogicTestFile {

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

    public gameLogicTestFile() {
        this.playerList = new ArrayList<>();
        this.Deck = new deck();
        this.theCommunityCards = new cards[5];
        this.pot = 0;
        this.smallBlind = smallBlind; //needed to start the game
        this.bigBlind = this.smallBlind * 2; // twice the amount of big blind
        this.dealer = dealer;
              
    }

    public void setupGame() {
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
        if (playerList.size() == 2) {
            this.smallBlindPlayer = playerList.get(1);
            this.bigBlindPlayer = playerList.get(2);
        }
        this.betTotal = new int[playerList.size()];

    }

    public void payOutBlinds() {
        if (this.playerList.size() > 2) {
            this.smallBlindPlayer.reduceFromBalance(this.smallBlind);
            this.betTotal[this.playerList.indexOf(smallBlindPlayer)] = this.smallBlind;
            this.bigBlindPlayer.reduceFromBalance(this.bigBlind);
            this.betTotal[this.playerList.indexOf(bigBlindPlayer)] = this.bigBlind;
        }
    }

    public void roundBetting(boolean preFlop) {
        int playerIndex = this.playerList.indexOf(this.smallBlindPlayer);
        if (preFlop) {
            playerIndex = this.playerList.indexOf(this.smallBlindPlayer) + 1;
        } else {
            playerIndex = this.playerList.indexOf(this.smallBlindPlayer);
        }
        int currentIndex = playerIndex;

        //ask all players to see if they wants to fold check or call
        for (int i = 0; i < this.playerList.size(); i++) {
            currentIndex = betIndividual(currentIndex);
        }

        while (!equalBets()) {
            currentIndex = betIndividual(currentIndex);
        }
    }

    public void showRiver() {        
        if (this.theCommunityCards[0] != null && this.theCommunityCards[3] == null && this.theCommunityCards[4] == null) {
            System.out.println("The Flop:");
        } else if (this.theCommunityCards[3] != null && this.theCommunityCards[4] == null) {
            System.out.println("The Turn:");
        } else if (this.theCommunityCards[4] != null) {
            System.out.println("The River:");
        }
        System.out.println(Arrays.toString(this.theCommunityCards));
    }

    public void dealnextFlop() {
        if (this.theCommunityCards[0] == null) {
            this.theCommunityCards[0] = this.Deck.nextCard();
            this.theCommunityCards[1] = this.Deck.nextCard();
            this.theCommunityCards[2] = this.Deck.nextCard();
        } else if (this.theCommunityCards[3] == null) {
            this.theCommunityCards[3] = this.Deck.nextCard();
        } else if (this.theCommunityCards[4] == null) {
            this.theCommunityCards[4] = this.Deck.nextCard();
        }
        showRiver();
    }
    
    public void payOutWinner(ArrayList<Player> winner){
        int tempWinner = this.pot/winner.size();
        for(int i=0; i < winner.size(); i++){
            winner.get(i).addToBalance(tempWinner);
        }
        this.pot = 0;
    }
    
    public void whoWon(){
        ArrayList<Player> winner = new ArrayList<>();
        winner = royalFlush();
        if(winner.size()>0){
            payOutWinner(winner);
            return;
        }
        winner = straightFlush();
        if(winner.size()>0){
            payOutWinner(winner);
            return;
        }
        winner = fourOfaKind();
        if(winner.size()>0){
            payOutWinner(winner);
            return;
        }
        winner = straight();
        if(winner.size()>0){
            payOutWinner(winner);
            return;
        }
        winner = fullHouse();
        if(winner.size()>0){
            payOutWinner(winner);
            return;
        }
        winner = Flush();
        if(winner.size()>0){
            payOutWinner(winner);
            return;
        }
        winner = straight();
        if(winner.size()>0){
            payOutWinner(winner);
            return;
        }
        winner = threeOfaKind();
        if(winner.size()>0){
            payOutWinner(winner);
            return;
        }
        winner = twoPairs();
        if(winner.size()>0){
            payOutWinner(winner);
            return;
        }
        winner = onePair();
        if(winner.size()>0){
            payOutWinner(winner);
            return;
        }
        winner = highCard();
        if(winner.size()>0){
            payOutWinner(winner);
            return;
        }
               
    }

    public ArrayList<Player> royalFlush() {
        ArrayList<Player> winner = new ArrayList<>();
        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            int hearts = 0;
            int diamonds = 0;
            int spades = 0;
            int clubs = 0;
            if (currentPlayer.getIsInGame()) {
                ArrayList<Integer> currentPlayerCards = new ArrayList<>();
                ArrayList<cards> allCards = getAllCards(this.playerList.get(i));

                for (int j = 0; j < allCards.size(); j++) {
                    if (allCards.get(j).getSuit().contains("Hearts")) {
                        hearts++;
                    }
                    if (allCards.get(j).getSuit().contains("Diamonds")) {
                        diamonds++;
                    }
                    if (allCards.get(j).getSuit().contains("Spades")) {
                        spades++;
                    }
                    if (allCards.get(j).getSuit().contains("Clubs")) {
                        clubs++;
                    }
                }
                if (hearts >= 5) {
                    currentPlayerCards = getCardsSuits(allCards, "Hearts");
                } else if (diamonds >= 5) {
                    currentPlayerCards = getCardsSuits(allCards, "Diamonds");
                } else if (clubs >= 5) {
                    currentPlayerCards = getCardsSuits(allCards, "Clubs");
                } else if (spades >= 5) {
                    currentPlayerCards = getCardsSuits(allCards, "Spades");
                }

                if (currentPlayerCards.contains(10) && currentPlayerCards.contains(11)
                        && currentPlayerCards.contains(12) && currentPlayerCards.contains(13)
                        && currentPlayerCards.contains(14)) {
                    winner.add(currentPlayer);
                }
            }
        }
        return winner;
    }

    public ArrayList<Player> straightFlush() {
        ArrayList<Player> winner = new ArrayList<Player>();
        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            int hearts = 0;
            int diamonds = 0;
            int spades = 0;
            int clubs = 0;
            if (currentPlayer.getIsInGame()) {
                ArrayList<Integer> currentPlayerCards = new ArrayList<>();
                ArrayList<cards> allCards = getAllCards(this.playerList.get(i));

                for (int j = 0; j < allCards.size(); j++) {
                    if (allCards.get(j).getSuit().contains("Hearts")) {
                        hearts++;
                    }
                    if (allCards.get(j).getSuit().contains("Diamonds")) {
                        diamonds++;
                    }
                    if (allCards.get(j).getSuit().contains("Spades")) {
                        spades++;
                    }
                    if (allCards.get(j).getSuit().contains("Clubs")) {
                        clubs++;
                    }
                }
                if (hearts >= 5) {
                    currentPlayerCards = getCardsSuits(allCards, "Hearts");
                } else if (diamonds >= 5) {
                    currentPlayerCards = getCardsSuits(allCards, "Diamonds");
                } else if (clubs >= 5) {
                    currentPlayerCards = getCardsSuits(allCards, "Clubs");
                } else if (spades >= 5) {
                    currentPlayerCards = getCardsSuits(allCards, "Spades");
                }
                Collections.sort(currentPlayerCards);
                int lowestValue = 15;
                int secondHighestValue = 15;
                int thirdHighestValue = 15;
                if (currentPlayerCards.size() >= 5) {
                    lowestValue = currentPlayerCards.get(0);
                    secondHighestValue = currentPlayerCards.get(1);
                    thirdHighestValue = currentPlayerCards.get(2);
                    if (currentPlayerCards.contains(lowestValue + 1) && currentPlayerCards.contains(lowestValue + 2)
                            && currentPlayerCards.contains(lowestValue + 3) && currentPlayerCards.contains(lowestValue + 4)) {
                        winner.add(currentPlayer);
                    }
                }
                if (currentPlayerCards.size() >= 6) {
                    if (currentPlayerCards.contains(secondHighestValue + 1) && currentPlayerCards.contains(secondHighestValue + 2)
                            && currentPlayerCards.contains(secondHighestValue + 3) && currentPlayerCards.contains(secondHighestValue + 4)) {
                        winner.add(currentPlayer);
                    }
                }
                if (currentPlayerCards.size() >= 7) {
                    if (currentPlayerCards.contains(thirdHighestValue + 1)
                            && currentPlayerCards.contains(thirdHighestValue + 2)
                            && currentPlayerCards.contains(thirdHighestValue + 3)
                            && currentPlayerCards.contains(thirdHighestValue + 4)) {
                        winner.add(currentPlayer);
                    }
                }

            }
        }
        return winner;
    }

    public ArrayList<Player> Flush() {
        ArrayList<Player> winner = new ArrayList<>();
        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            int hearts = 0;
            int diamonds = 0;
            int spades = 0;
            int clubs = 0;
            if (currentPlayer.getIsInGame()) {
                ArrayList<cards> allCards = getAllCards(this.playerList.get(i));

                for (int j = 0; j < allCards.size(); j++) {
                    if (allCards.get(j).getSuit().contains("Hearts")) {
                        hearts++;
                    }
                    if (allCards.get(j).getSuit().contains("Diamonds")) {
                        diamonds++;
                    }
                    if (allCards.get(j).getSuit().contains("Spades")) {
                        spades++;
                    }
                    if (allCards.get(j).getSuit().contains("Clubs")) {
                        clubs++;
                    }
                }
                if (hearts >= 5 || diamonds >= 5 || clubs >= 5 || spades >= 5) {

                }
            }
            winner.add(currentPlayer);
        }
        return winner;
    }

    public ArrayList<Player> straight() {
        ArrayList<Player> winner = new ArrayList<>();
        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            if (currentPlayer.getIsInGame()) {
                ArrayList<cards> allCardsinPlay = getAllCards(currentPlayer);
                ArrayList<Integer> currentPlayerCards = getAllRanksofCards(allCardsinPlay);
                Collections.sort(currentPlayerCards);
                int lowestValue = 15;
                int secondHighestValue = 15;
                int thirdHighestValue = 15;
                if (currentPlayerCards.size() >= 5) {
                    lowestValue = currentPlayerCards.get(0);
                    secondHighestValue = currentPlayerCards.get(1);
                    thirdHighestValue = currentPlayerCards.get(2);
                    if (currentPlayerCards.contains(lowestValue + 1) && currentPlayerCards.contains(lowestValue + 2)
                            && currentPlayerCards.contains(lowestValue + 3) && currentPlayerCards.contains(lowestValue + 4)) {
                        winner.add(currentPlayer);
                    }
                }
                if (currentPlayerCards.size() >= 6) {
                    if (currentPlayerCards.contains(secondHighestValue + 1) && currentPlayerCards.contains(secondHighestValue + 2)
                            && currentPlayerCards.contains(secondHighestValue + 3) && currentPlayerCards.contains(secondHighestValue + 4)) {
                        winner.add(currentPlayer);
                    }
                }
                if (currentPlayerCards.size() >= 7) {
                    if (currentPlayerCards.contains(thirdHighestValue + 1) && currentPlayerCards.contains(thirdHighestValue + 2)
                            && currentPlayerCards.contains(thirdHighestValue + 3) && currentPlayerCards.contains(thirdHighestValue + 4)) {
                        winner.add(currentPlayer);
                    }
                }
            }
        }
        return winner;
    }

    public ArrayList<Player> fullHouse() {
        ArrayList<Player> winner = new ArrayList<>();
        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            if (currentPlayer.getIsInGame()) {
                int[] allRanks = new int[13];
                boolean threeSameRanks = false;
                boolean twoSameRanks = false;

                ArrayList<cards> allCards = getAllCards(this.playerList.get(i));
                for (int l = 0; l < allCards.size(); l++) {
                    allRanks[allCards.get(l).getRank() - 2]++;
                }
                for (int m = 0; m < allRanks.length; m++) {
                    if (allRanks[m] >= 3) {
                        threeSameRanks = true;
                    } else if (allRanks[m] >= 2) {
                        twoSameRanks = true;
                    }
                }
                if (threeSameRanks && twoSameRanks) {
                    winner.add(currentPlayer);
                }
            }
        }
        return winner;
    }

    public ArrayList<Player> fourOfaKind() {
        ArrayList<Player> winner = new ArrayList<>();
        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            int[] allRanks = new int[13];
            ArrayList<cards> allCards = getAllCards(this.playerList.get(i));
            for (int l = 0; l < allCards.size(); l++) {
                allRanks[allCards.get(l).getRank() - 2]++;
            }
            for (int m = 0; m < allCards.size(); m++) {
                if (allRanks[m] >= 4) {
                    winner.add(currentPlayer);
                }
            }
        }
        return winner;
    }

    public ArrayList<Player> threeOfaKind() {
        ArrayList<Player> winner = new ArrayList<>();
        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            if (currentPlayer.getIsInGame()) {
                int[] allRanks = new int[13];
                ArrayList<cards> allCards = getAllCards(currentPlayer);
                for (int j = 0; j < allCards.size(); j++) {
                    allRanks[allCards.get(j).getRank() - 2]++;
                }
                for (int k = 0; k < allRanks.length; k++) {
                    if (allRanks[k] >= 3) {
                        winner.add(currentPlayer);
                    }
                }
            }
        }
        return winner;
    }

    public ArrayList<Player> twoPairs() {
        ArrayList<Player> winner = new ArrayList<>();
        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            if (currentPlayer.getIsInGame()) {
                int[] allRanks = new int[13];
                int pairs = 0;
                ArrayList<cards> allCards = getAllCards(currentPlayer);
                for (int j = 0; j < allCards.size(); j++) {
                    allRanks[allCards.get(j).getRank() - 2]++;
                }
                for (int k = 0; k < allRanks.length; k++) {
                    if (allRanks[k] >= 2) {
                        pairs++;
                        if (pairs == 2) {
                            winner.add(currentPlayer);
                        }

                    }
                }
            }
        }
        return winner;
    }

    public ArrayList<Player> onePair() {
        ArrayList<Player> winner = new ArrayList<>();
        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            if (currentPlayer.getIsInGame()) {
                int[] allRanks = new int[13];
                ArrayList<cards> allCards = getAllCards(currentPlayer);
                for (int j = 0; j < allCards.size(); j++) {
                    allRanks[allCards.get(j).getRank() - 2]++;
                }
                for (int k = 0; k < allRanks.length; k++) {
                    if (allRanks[k] >= 2 && !winner.contains(currentPlayer)) {
                        winner.add(currentPlayer);
                    }
                }
            }
        }
        return winner;
    }

    public ArrayList<Player> highCard() {
        ArrayList<Player> winner = new ArrayList<>();
        int[][] sortedPlayersAllCards = new int[this.playerList.size()][2];
        // The first highest card
        int highestCardColTwo = 0;
        // The second highest card
        int highestCardColOne = 0;
        boolean tie = false;

        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            if (currentPlayer.getIsInGame()) {
                ArrayList<Integer> playerCurrentCards = new ArrayList<>();
                playerCurrentCards.add(currentPlayer.getplayerCards()[0].getRank());
                playerCurrentCards.add(currentPlayer.getplayerCards()[1].getRank());
                Collections.sort(playerCurrentCards);
                if (playerCurrentCards.get(1) > highestCardColTwo) {
                    highestCardColTwo = playerCurrentCards.get(1);
                    winner.clear();
                    winner.add(currentPlayer);
                    sortedPlayersAllCards = new int[this.playerList.size()][2];
                    sortedPlayersAllCards[i][0] = i;
                    sortedPlayersAllCards[i][1] = playerCurrentCards.get(0);
                } else if (playerCurrentCards.get(1) == highestCardColTwo) {
                    winner.add(currentPlayer);
                    tie = true;
                    // Saves the index of the player and the value of the players second highest card
                    sortedPlayersAllCards[i][0] = i;
                    sortedPlayersAllCards[i][1] = playerCurrentCards.get(0);
                }
            }
        }
        if (tie) {
            winner.clear();
            for (int[] sortedPlayersAllCard : sortedPlayersAllCards) {
                if (sortedPlayersAllCard[1] > highestCardColOne) {
                    highestCardColOne = sortedPlayersAllCard[1];
                }
            }
            for (int l = 0; l < sortedPlayersAllCards.length; l++) {
                if (sortedPlayersAllCards[l][1] == highestCardColOne) {
                    winner.add(this.playerList.get(l));
                }
            }
        }
        return winner;
    }

    public gameLogicTestFile(ArrayList<Player> playerList, deck Deck, cards[] theRiver, cards[] burnCards, int smallBlind, int bigBlind, int pot, Player dealer, Player smallBlindPlayer, Player bigBlindPlayer, int[] betTotal) {
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

    public int betIndividual(int currentIndex) {
        String callOrCheck = equalBets() ? "check" : "call"; //if all bets are the same ask user to do check or call
        showRiver();       
        String playerResponse = getInput.next();
        if (playerResponse.toLowerCase().contains("fold")) {
            foldFunction(this.playerList.get(currentIndex));
        } else if (playerResponse.toLowerCase().contains("call")) {
            callFunction(this.playerList.get(currentIndex));
        } else if (playerResponse.toLowerCase().contains("raise")) {
            raiseFunction(this.playerList.get(currentIndex));
        }
        currentIndex++;
        if (currentIndex == this.playerList.size()) {
            currentIndex = 0; //if the index hits the size of the array then return it to zero
        }

        currentIndex++;
        if (currentIndex == this.playerList.size()) {
            currentIndex = 0; //if the index hits the size of the array then return it to zero
        }
        return currentIndex;
    }

    public void foldFunction(Player player) {
        player.setIsInGame(false);
    }

    public void callFunction(Player player) {
        int highestBet = betHighest();
        int betDifference = highestBet - (this.betTotal[this.playerList.indexOf(player)]);
        player.reduceFromBalance(betDifference);
        this.betTotal[this.playerList.indexOf(player)] += betDifference;

    }

    public ArrayList<cards> sort(ArrayList<cards> cardsList) {
        ArrayList<cards> sortCards = new ArrayList<>();
        while (cardsList.size() > 0) {
            int lowestCards = 15;
            int removedIndex = -1;
            for (int i = 0; i < sortCards.size(); i++) {
                if (sortCards.get(i).getRank() < lowestCards) {
                    removedIndex = i;
                }

            }
            if (removedIndex != -1) {
                sortCards.add(cardsList.remove(removedIndex));
            }
        }

        return sortCards;
    }

    public void raiseFunction(Player player) {
        System.out.println(player.getName() + ", How much raise?");
        int raise = getInput.nextInt();
        callFunction(player);
        player.reduceFromBalance(raise);        
        this.betTotal[this.playerList.indexOf(player)] += raise;
    }

    public boolean equalBets() {
        int highest = betHighest();
        for (int i = 0; i < this.betTotal.length; i++) {
            if (this.betTotal[i] > highest && this.playerList.get(i).getIsInGame()) {
                return false;
            }
        }
        return true;
    }

    public int betHighest() {
        int highestBets = 0;
        for (int i = 0; i < this.betTotal.length; i++) {
            if (this.betTotal[i] < highestBets && this.playerList.get(i).getIsInGame()) {
                highestBets = this.betTotal[i];
            }
        }
        return highestBets;
    }

    public void addPlayer() {
        System.out.println("Enter player's name:");
        String name = getInput.next();
        System.out.println("Enter Starting Balance:");
        int playerBalance = getInput.nextInt();
        cards[] playerCards = {Deck.nextCard(), Deck.nextCard()};
        System.out.println(Arrays.toString(playerCards));
        playerList.add(new Player(name, playerBalance, playerCards));
        System.out.println(playerList.get(playerList.size() - 1).toString());
    }

    public ArrayList<Integer> getCardsSuits(ArrayList<cards> playerCards, String suit) {
        ArrayList<Integer> suits = new ArrayList<>();
        for (int i = 0; i < playerCards.size(); i++) {
            if (playerCards.get(i).getSuit().contains(suit)) {
                suits.add(playerCards.get(i).getRank());
            }
        }
        return suits;
    }

    public ArrayList<cards> getAllCards(Player player) {
        ArrayList<cards> allCards = new ArrayList<>();
        allCards.addAll(Arrays.asList(this.theCommunityCards));
        allCards.add(player.getplayerCards()[0]);
        allCards.add(player.getplayerCards()[1]);
        return allCards;
    }
    
    public ArrayList<Integer> getAllRanksofCards(ArrayList<cards> playerCardsAll){
        ArrayList<Integer> allCardsRanks = new ArrayList<>();
        for(int i=0; i < playerCardsAll.size(); i++){
            allCardsRanks.add(playerCardsAll.get(i).getRank());
        }
        return allCardsRanks;
    }
    
    public static void main(String[] args) {

        gameLogicTestFile ng = new gameLogicTestFile();

    }

}
