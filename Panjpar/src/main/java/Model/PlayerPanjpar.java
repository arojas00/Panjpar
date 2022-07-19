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
public class PlayerPanjpar extends Player{
    /**
     *
     * @param id
     */
    public PlayerPanjpar(String id){
        group = new ArrayList<>();
        group.add(new GroupOfCards());
        group.add(new GroupOfCards());
        setId(id);
    }
    
    /**
     * Metodo devuelve la mano
     * @return hand Grupo de cartas
     */
    public GroupOfCards getHand() {
       return getGroup().get(0);
    }

    /**
     * Metodo establece la mano
     * @param hand Grupo de cartas
     */
    public void setHand(GroupOfCards hand) {
        getGroup().remove(0);
        getGroup().add(0, hand);
    }
    
    /**
     * Metodo devuelve la cartas de la mesa
     * @return table Grupo de cartas
     */
    public GroupOfCards getTable() {
        return getGroup().get(1);
    }

    /**
     * Metodo establece la cartas de la mesa
     * @param table Grupo de cartas
     */
    public void setTable(GroupOfCards table) {
        getGroup().remove(1);
        getGroup().add(1, table);
    }
    
    /**
     * Metodo para pasar cartas de la mano a la mesa y viceversa
     * @param card Carta seleccionada
     */
    public void selectCard(Card card){
        int position = -1;
        for (int i = 0; i < getHand().getCards().size(); i++) {
            Card aux = getHand().getCard(i);
            if(aux.getType().equals(card.getType()) && aux.getValue() 
                    == card.getValue()){
                getTable().getCards().add(aux);
                position = i;
                break;
            }
        }
        if(position != -1){
            getHand().getCards().remove(position);
        } else {
            for(int i = 0; i < getTable().getCards().size(); i++){
                Card aux = getTable().getCard(i);
                if(aux.getType().equals(card.getType()) && aux.getValue() 
                        == card.getValue()){
                    getHand().getCards().add(aux);
                    position = i;
                    break;
                }
            }
            if(position != -1){
                getTable().getCards().remove(position);
            }
        }
    }
    
     /**
     * Metodo completar numero minimo de cartas
     * @param deck Mazo de cartas
     */
    public void fillHand(DeckPanjpar deck){
        while(!deck.isEmpty() && getHand().getCards().size() < 5){
            getHand().getCards().add(deck.getNextCard());
        }
    }
    
     /**
     * Metodo que limpia la tabla del jugador
     */
    public void clearTable(){
        getTable().getCards().removeAll(getTable().getCards());
    }
    
    public void setHandCards(ArrayList<Card> cards){
        group.get(0).setCards(cards);
    }
    
    public void setTableCards(ArrayList<Card> cards){
        group.get(1).setCards(cards);
    }
    
}
