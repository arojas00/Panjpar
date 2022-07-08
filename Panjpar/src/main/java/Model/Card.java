/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Clase para las Cartas
 * @author Adrian Rojas, Javier Donato, Jafet Picado
 */
public class Card {
    private int id;
    private int type;
    private int value;

    public Card(int id, int type, int value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }
    
    /**
     * Metodo devuelve el id
     * @return id int
     */
    public int getId() {
        return id;
    }
    
    /**
     * Metodo establece el id
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Metodo devuelve el tipo
     * @return type int
     */
    public int getType() {
        return type;
    }
    
    /**
     * Metodo establece el tipo
     * @param type int
     */
    public void setType(int type) {
        this.type = type;
    }
    
    /**
     * Metodo devuelve el valor
     * @return value int
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Metodo establece el valor
     * @param value int
     */
    public void setValue(int value) {
        this.value = value;
    }
    
    /**
     *
     * @return String
     */
    @Override
    public String toString(){
        return "C[ "+id+" ]T[ "+type+" ]V[ "+value+" ]";
    }
    
}
