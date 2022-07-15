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
public class Player {
    private String id;
    private ArrayList<GroupOfCards> group;
    /**
     * Metodo constructor de player
     */
    public Player() {
        group = new ArrayList<>();
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
    
    public ArrayList<GroupOfCards> getGroup() {
        return group;
    }

    public void setGroup(ArrayList<GroupOfCards> group) {
        this.group = group;
    }
}
