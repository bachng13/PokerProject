/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PokerProject;

import java.util.*;
/**
 *
 * @author User 1
 */
public class deck {
    private ArrayList<cards> deck = new ArrayList<cards>();
    
    public deck(){
        reset(); // reset deck
        shuffle(); //shuffle cards
    }
    
    public void reset(){
        this.deck.clear();
        
        //add in all cards based on suits
        
        for(int i = 2; i < 15; i++){
            deck.add(new cards(i,"Hearts"));
        }
        
        for(int i = 2; i < 15; i++){
            deck.add(new cards(i,"Diamonds"));
        }
        
        for(int i = 2; i < 15; i++){
            deck.add(new cards(i,"Clubs"));
        }
        
        for(int i = 2; i < 15; i++){
            deck.add(new cards(i,"Spades"));
        }
        
    }
    
    public void shuffle(){
        ArrayList<cards> shuffledDeck = new ArrayList<>();
        while(this.deck.size() > 0){
            int randomizer = ((int) (Math.random()*100)) % this.deck.size();
            shuffledDeck.add(this.deck.remove(randomizer));
        }
        this.deck = shuffledDeck;
    }
    
    public cards nextCard(){
        return this.deck.remove(this.deck.size() - 1);
    }
    
    public int cardsRemaining(){
        return this.deck.size();
    }    
    
    public static void main(String[] args){
        
        //test
        deck newDeck = new deck();
        System.out.println(newDeck.deck.toString());
        System.out.println(newDeck.nextCard());
        System.out.println(newDeck.nextCard());
        System.out.println(newDeck.nextCard());
        System.out.println(newDeck.nextCard());
        System.out.println(newDeck.cardsRemaining());
    }
}
