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
    
    //Shuffle deck Funtion
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
    
    
    
       
    public static void main(String[] main){
    
    //Test
        cards card = new cards(1,"Clubs");
        System.out.println(card);
        int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 8,
                   9, 10, 11, 12, 13, 14, 15,
                   16, 17, 18, 19, 20, 21, 22,
                   23, 24, 25, 26, 27, 28, 29,
                   30, 31, 32, 33, 34, 35, 36,
                   37, 38, 39, 40, 41, 42, 43,
                   44, 45, 46, 47, 48, 49, 50, 
                   51};
       
        shuffle(a, 52);
        System.out.println(Arrays.toString(a));
    }
    
    
    
}

