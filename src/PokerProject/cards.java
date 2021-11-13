/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PokerProject;


import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author User 1
 */
public class cards {
    private int rank;
    private String suit;
    private String color;

    public cards(int rank, String suit){
        this.rank = rank;
        this.suit = suit;
        if(this.suit.equals("Hearts")|| this.suit.equals("Diamonds")){
            this.color = "Red";
        }
        if(this.suit.equals("Clubs")|| this.suit.equals("Spades")){
            this.color = "Black";
        }
    }
    
    public String rankToString(){
        switch(this.rank){
            case 1: return "ACE";
            case 2: return "TWO";
            case 3: return "THREE";
            case 4: return "FOUR";
            case 5: return "FIVE";
            case 6: return "SIX";
            case 7: return "SEVEN";
            case 8: return "EIGHT";
            case 9: return "NINE";
            case 10: return "TEN";
            case 11: return "JACK";
            case 12: return "QUEEN";
            case 13: return "KING";
            default: return "Error value";
        }
    }
    
    public int getRank(){
        return this.rank;
    }
    
    public String getSuit(){
        return this.suit;
    }
    
    public String getColor(){
        return this.color;
    }
    
    
    
    public static void shuffle(int card[], int n)
    {
          
        Random rand = new Random();
          
        for (int i = 0; i < n; i++)
        {
            // Random for remaining positions.
            int r = i + rand.nextInt(52 - i);
              
             //swapping the elements
             int temp = card[r];
             card[r] = card[i];
             card[i] = temp;
               
        }
    }
    
//    public String toString(){
//        String[] ranks = {"Ace", "2", "3", "4", "5", "6",
//               "7", "8", "9", "10", "Jack", "Queen", "King"};
//        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
//        String s = ranks[this.rank] + " " + suits[this.suit];
//    return s;
//    }
    
    
       
    public static void main(String[] main){
//        Random rand = new Random();
//        String[] deck = new String[51];
//        
//        
//    for(int i = 0; i < deck.length; i++){    
//        for(int j = 0; j < 12; j++){
//            for (int k = 0; k < 4; k++){
//                    cards card = new cards(j,k);
////                    System.out.println(card);
//                    deck[i] = card.toString();
//            }
//        }    
//    }
//        
//        
//        
//        // int ranks = rand.nextInt(13);
//        // int suits = rand.nextInt(4);
//        
//        // int ranks1 = rand.nextInt(13);
//        // int suits1 = rand.nextInt(4);
//        
//        // cards card1 = new cards(ranks, suits);
//        // cards card2 = new cards(ranks1, suits1);
//        
//        
//        // System.out.println(card1);
//        // System.out.println(card2);
//        for(int l = 0; l < deck.length; l++){
//            System.out.println(deck[l]+ " ");
//        }
        
    }
    
    
    
}

