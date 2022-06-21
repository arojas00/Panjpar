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
public class Player {
    private String id;
    private ArrayList<Card> hand;
    private ArrayList<Card> table;

    public Player(String id) {
        this.id = id;
        hand = new ArrayList<>();
        table = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public ArrayList<Card> getTable() {
        return table;
    }

    public void setTable(ArrayList<Card> table) {
        this.table = table;
    }
    
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
    /*
    public Boolean checkTable(){
        Boolean valid = false;
        switch (table.size()) {
            case 1: valid = true;
                valid = true;
                break;
            case 3: if(table.get(0).getValue() == table.get(1).getValue() 
                    || table.get(0).getValue() == table.get(2).getValue()){
                        valid = true;
                    } else if(table.get(1).getValue() == 
                            table.get(2).getValue()){
                        valid = true;
                    }
                break;
            case 5: 
                    ArrayList<Integer> cardsPosition = new ArrayList<>();
                    for(int i = 0; i < table.size(); i++){
                        for(int j = 0; i < table.size(); j++){
                            if(i != j && !cardsPosition.contains(i) &&
                                    !cardsPosition.contains(j) && 
                                    table.get(i).getValue() == 
                                    table.get(j).getValue()){
                                cardsPosition.add(i);
                                cardsPosition.add(j);
                            }
                        }
                    }
                    if(cardsPosition.size() >= 4){
                        valid = true;
                    }
                break;
            default: valid = false;
                break;
        }
        return valid;
    }
    
    public void checkPlay(ArrayList<Card> otherTable){
        
    }*/
    
    public void fillHand(Deck deck){
        while(!deck.isEmpty() && hand.size() < 5){
            hand.add(deck.getNextCard());
        }
    }
}
