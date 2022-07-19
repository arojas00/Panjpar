/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.ArrayList;

/**
 *
 * @author jafet
 */
public class GroupOfBackView {
    private ArrayList<BackCardView> cards;

    public GroupOfBackView(){
        cards = new ArrayList<>();
    }

    public ArrayList<BackCardView> getCards() {
        return cards;
    }

    public void setCards(ArrayList<BackCardView> cards) {
        this.cards = cards;
    }
}
