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
public class GroupOfCards {
    private ArrayList<Card> cards;
    
    public GroupOfCards(){
        cards = new ArrayList<>();
    }

    /**
     * Getter de ArrayList de cartas
     * @return cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Setter de ArrayList de cartas
     * @param cards
     */
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    
    /**
     * Método para crear un grupo de cartas con los limites y valores seleccionados
     * @param types
     * @param end
     * @param start 
     */
    public void createCards(ArrayList<String> types, int end, int start){
        int idCounter = 0;
        for(String aux : types){
            for(int j = start; j <= end; j++){
                cards.add(new Card(idCounter++, aux, j));
            }
        }
    }
    
    /**
     * Método para revolver el grupo de cartas
     */
    public void shuffle(){
        Card aux = null;
        for(int i = 0; i < cards.size(); i++){
            int random = (int) (Math.random()*cards.size());
            aux = cards.get(i);
            cards.set(i, cards.get(random));
            cards.set(random, aux);
        }
    }
    
    /**
     * Método que verifica si el grupo de cartas está vacío
     * @return 
     */
    public Boolean isEmpty(){
        return cards.isEmpty();
    };
    
    /**
     * Método para obtener una carta del grupo en la posición indicada
     * @param index
     * @return Card
     */
    public Card getCard(int index){
        return getCards().get(index);
    }
}
