/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 * Clase para la colección de cartas
 * @author Adrian Rojas, Javier Donato, Jafet Picado
 */
public class DeckPanjpar extends GroupOfCards{
    private int trumpCard;
    private int counter;
    
    public DeckPanjpar(ArrayList<String> types, int max, int min){
        createCards(types, max, min);
        trumpCard = 1;
        counter = 1;
    }
    
    /**
     * Metodo devuelve la carta siguiente del deck
     * @return aux Carta
     */
    public Card getNextCard(){
        Card aux = null;
        if(!isEmpty()){
            if(counter < getCards().size()){
                aux = getCard(counter++);
            } else {
                aux = getCard(0);
                trumpCard = 0;
            }
        }
        return aux;
    }
    
    /**
     * Metodo devuelve si el deck esta vacio
     * @return aux Bool
     */
    @Override
    public Boolean isEmpty() {
        Boolean aux = false;
        if(counter == getCards().size() && trumpCard == 0){
            aux = true;
        }
        return aux;
    }
    
    /**
     * Metodo devuelve la carta "trampa"
     * @return card Posicion 0 del mazo
     */
    public Card getTrumpCard(){
        return getCard(0);
    }
    
    /**
     * Metodo devuelve el valor de trumpCard para definir si es 0 o 1
     * @return trumpCard
     */
    public int getTrumpCardNumber(){
        return trumpCard;
    }
    
    /**
     * Metodo que asigna el valor numerico a trumpCard
     * @param trumpCard int
     */
    public void setTrumpCard(int trumpCard){
        this.trumpCard = trumpCard;
    }
    
    /**
     * Retorna el tipo de la trump card
     * @return trumpType
     */
    public String getTrumpType(){
        return getCard(0).getType();
    }

    /**
     * Retorna el valor del contador de cartas
     * @return counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * Asigna el valor al contador de cartas
     * @param counter int
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }
}

