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
public class GroupOfCards {
    private ArrayList<Card> cards;
    
    public GroupOfCards(){
        cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    
    public void createCards(ArrayList<String> types, int start, int end){
        int idCounter = 0;
        for(String aux : types){
            for(int j = start; j < end; j++){
                cards.add(new Card(idCounter++, aux, j));
            }
        }
    }
    
    public void shuffle(){
        Card aux = null;
        for(int i = 0; i < cards.size(); i++){
            int random = (int) (Math.random()*cards.size());
            aux = cards.get(i);
            cards.set(i, cards.get(random));
            cards.set(random, aux);
        }
    }
    
    public Boolean isEmpty(){
        return cards.isEmpty();
    };
    
    public Card getCard(int index){
        if(index > 0 && index < getCards().size()){
            return getCards().get(index);
        }
        return null;
    }
}
