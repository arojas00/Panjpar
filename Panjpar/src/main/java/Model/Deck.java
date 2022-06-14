/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author jafet
 */
public class Deck {
    private ArrayList<Card> deck;
    private int trumpCard;
    private int counter;
    private int trumpType;
    
    public Deck(){
        deck = new ArrayList<>();
        trumpCard = 0;
        counter = 1;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }
    
    public void createDeck(){
        int idCounter = 0;
        for(int i = 1; i < 5; i++){
            for(int j = 1; j < 14; j++){
                deck.add(new Card(idCounter++, i, j));
            }
        }
        
    }
    
    public void shuffle(){
        Card aux = null;
        for(int i = 0; i < deck.size(); i++){
            int random = (int) (Math.random()*deck.size());
            aux = deck.get(i);
            deck.set(i, deck.get(random));
            deck.set(random, aux);
        }
        trumpType = deck.get(0).getType();
    }
    
    public Card getNextCard(){
        Card aux = null;
        if(!isEmpty()){
            if(counter < deck.size()){
                aux = deck.get(counter++);
            } else {
                aux = deck.get(0);
                trumpCard = -1;
            }
        }
        return aux;
    }
    
    public boolean isEmpty() {
        Boolean aux = false;
        if(counter == deck.size() && trumpCard == -1){
            aux = true;
        }
        return aux;
    }
    
}
