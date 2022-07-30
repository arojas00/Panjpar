/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.ArrayList;

/**
 * Contenedor de grupos de vistas frontales de las cartas
 * @author Adrian Rojas, Javier Donato, Jafet Picado
 */
public class GroupOfCardView {
    private ArrayList<CardView> cards;

    public GroupOfCardView() {
        cards = new ArrayList<>();
    }

    public ArrayList<CardView> getCards() {
        return cards;
    }

    public void setCards(ArrayList<CardView> cards) {
        this.cards = cards;
    }
}
