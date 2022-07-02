/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Adrian Rojas, Javier Donato, Jafet Picado
 */
public class Player {
    private String id;
    private ArrayList<Card> hand;
    private ArrayList<Card> table;

    /**
     * Metodo constructor de player
     * @param id Nombre del jugador
     */
    public Player(String id) {
        this.id = id;
        hand = new ArrayList<>();
        table = new ArrayList<>();
    }
    
    /**
     * Metodo devuelve el id
     * @return id String
     */
    public String getId() {
        return id;
    }

    /**
     * Metodo establece el id
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Metodo devuelve la mano
     * @return hand Grupo de cartas
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * Metodo establece la mano
     * @param hand Grupo de cartas
     */
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    /**
     * Metodo devuelve la cartas de la mesa
     * @return table Grupo de cartas
     */
    public ArrayList<Card> getTable() {
        return table;
    }

    /**
     * Metodo establece la cartas de la mesa
     * @param table Grupo de cartas
     */
    public void setTable(ArrayList<Card> table) {
        this.table = table;
    }

    /**
     * Metodo para pasar cartas de la mano a la mesa y viceversa
     * @param card Carta seleccionada
     */
    public void selectCard(Card card){
        int position = -1;
        for (int i = 0; i < hand.size(); i++) {
            Card aux = hand.get(i);
            if(aux.getType() == card.getType() && aux.getValue() == card.getValue()){
                table.add(aux);
                position = i;
                break;
            }
        }
        if(position != -1){
            hand.remove(position);
        } else {
            for(int i = 0; i < table.size(); i++){
                Card aux = table.get(i);
                if(aux.getType() == card.getType() && aux.getValue() == card.getValue()){
                    hand.add(aux);
                    position = i;
                    break;
                }
            }
            if(position != -1){
                table.remove(position);
            }
        }
    }
    
    public Boolean checkTable(Player otherPlayer, Boolean round){
        ArrayList<Integer> values = new ArrayList<>();
        Boolean valid = false;
        if(round){
            valid = table.size()<=otherPlayer.getHand().size();
            switch (table.size()) {
                case 1: valid = true;
                    break;
                case 3: 
                        for (Card aux : table) {
                            values.add(aux.getValue());
                        }
                        Collections.sort(values);
                        if(Objects.equals(values.get(0), values.get(1)) || 
                                Objects.equals(values.get(1), values.get(2))){
                            valid = true;
                        }
                    break;

                case 5: 
                        for (Card aux : table) {
                            values.add(aux.getValue());
                        }
                        Collections.sort(values);
                        Map<Integer, Integer> countMap = new HashMap<>();
                        for (Integer item : values) {
                            if (countMap.containsKey(item)){
                                countMap.put(item, countMap.get(item) + 1);
                            }else{
                                countMap.put(item, 1);
                            }
                        }
                        int pairs = 0;
                        int trio = 0;
                        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                            if (null != entry.getValue()) {
                                switch (entry.getValue()) {
                                    case 4:
                                        pairs += 2;
                                    case 2:
                                        pairs++;
                                        break;
                                    case 3:
                                        trio++;
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        if(pairs == 2 || (pairs == 1 && trio == 1)){
                            valid = true;
                        }
                    break;

                default: valid = false;
                    break;
            }
        } else {
            valid = table.size()<=otherPlayer.getTable().size();
        }
        return valid;
    }
    
    public Boolean checkPlay(Player otherPlayer){
        return true;
    }
    
    /**
     * Metodo completar numero minimo de cartas
     * @param deck Mazo de cartas
     */
    public void fillHand(Deck deck){
        while(!deck.isEmpty() && hand.size() < 5){
            hand.add(deck.getNextCard());
        }
    }
}
