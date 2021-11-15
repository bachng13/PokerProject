/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PokerProject;


import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author User 1
 */
public class cards {
    private int rank;
    private String suit;
    private String color;

    
    //Constructs for cards with color 
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
    
    //Switch Cases for card ranks
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
    
    //Get the card's ranks
    public int getRank(){
        return this.rank;
    }
    
    //Get the Cards' Suits
    public String getSuit(){
        return this.suit;
    }
    
    //Get color of the cards
    public String getColor(){
        return this.color;
    }
    
    @Override
    public String toString(){
        return rankToString() + " " + this.suit;
    }
    
    
    
           
    public static void main(String[] main){
    
    //Test
        
    }
    
    
    
}

