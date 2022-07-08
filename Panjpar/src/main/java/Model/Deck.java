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
    private int trumpType;
    private int counter;
    
    public Deck(){
        deck = new ArrayList<>();
        trumpCard = 1;
        counter = 1;
    }
    
    /**
     * Metodo devuelve el deck
     * @return deck Mazo de cartas
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }
    
    /**
     * Metodo establece el deck
     * @param deck Mazo de cartas
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
            for(int j = 2; j < 15; j++){
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
     * @return aux Carta
     */
    public Card getNextCard(){
        Card aux = null;
        if(!isEmpty()){
            if(counter < deck.size()){
                aux = deck.get(counter++);
            } else {
                aux = deck.get(0);
                trumpCard = 0;
            }
        }
        return aux;
    }
    
    /**
     * Metodo devuelve si el deck esta vacio
     * @return aux Bool
     */
    public boolean isEmpty() {
        Boolean aux = false;
        if(counter == deck.size() && trumpCard == 0){
            aux = true;
        }
        return aux;
    }
    
    /**
     * Metodo devuelve la carta "trampa"
     * @return card Posicion 0 del mazo
     */
    public Card getTrumpCard(){
        return deck.get(0);
    }
    
    public int getTrumpCardNumber(){
        return trumpCard;
    }
    
    public void setTrumpCard(int trumpCard){
        this.trumpCard = trumpCard;
    }
    
    public int getTrumpType(){
        return trumpType;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
