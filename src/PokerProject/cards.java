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
            case 1: return "Ace";
            case 2: return "2";
            case 3: return "3";
            case 4: return "4";
            case 5: return "5";
            case 6: return "6";
            case 7: return "7";
            case 8: return "8";
            case 9: return "9";
            case 10: return "10";
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
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
        return rankToString() + this.suit;
    }
    
    
           
    public static void main(String[] main){
    
    //Test
        cards newCard = new cards(14, "Hearts");
        System.out.println(newCard);
    }
    
    
    
}

