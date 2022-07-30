/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 * Clase para los jugadores
 * @author Adrian Rojas, Javier Donato, Jafet Picado
 */
public abstract class Player {
    private String id;
    protected ArrayList<GroupOfCards> group;
    
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
     * Getter de ArrayList de GroupOfCards
     * @return group
     */
    public ArrayList<GroupOfCards> getGroup() {
        return group;
    }

    /**
     * Setter de ArrayList de GroupOfCards
     * @param group 
     */
    public void setGroup(ArrayList<GroupOfCards> group) {
        this.group = group;
    }
    
    /**
     * Método abstracto para seleccionar una carta
     * @param card 
     */
    public abstract void selectCard(Card card);
    
}
