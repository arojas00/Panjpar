/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Adrian Rojas, Javier Donato, Jafet Picado
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
    
    /**
     * Metodo devuelve el deck
     * @return deck
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }
    
    /**
     * Metodo establece el deck
     * @param deck
     */
    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }
    
    /**
     * Metodo crea el deck
     */
    public void createDeck(){
        int idCounter = 0;
        for(int i = 1; i < 5; i++){
            for(int j = 1; j < 14; j++){
                deck.add(new Card(idCounter++, i, j));
            }
        }
        
    }
    
    /**
     * Metodo mezcla el deck
     */
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
    
    /**
     * Metodo devuelve la carta siguiente del deck
     * @return aux
     */
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
    
    /**
     * Metodo devuelve si el deck esta vacio
     * @return bool
     */
    public boolean isEmpty() {
        Boolean aux = false;
        if(counter == deck.size() && trumpCard == -1){
            aux = true;
        }
        return aux;
    }
    
    /**
     * Metodo devuelve la carta "trampa"
     * @return card
     */
    public Card getTrumpCard(){
        return deck.get(0);
    }
    
}
