/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Adrian Rojas, Javier Donato, Jafet Picado
 * @param <TypeOfPlayer>
 */
public abstract class Validator<TypeOfPlayer>{
    
    /**
     * Metodo para verificar la validez de la mesa
     * @param playerOne
     * @param playerTwo
     * @param round
     * @param trumpType Argumento opcional, necesario para Panjpar
     * @return 
     */
    public abstract Boolean checkTable(TypeOfPlayer playerOne, 
            TypeOfPlayer playerTwo, Boolean round, String... trumpType);
    
    /**
     * Método para verificar la validez de la jugada y el resultado de esta
     * @param playerOne
     * @param playerTwo
     * @param trumpType Argumento opcional, necesario para Panjpar
     * @return 
     */
    public abstract Boolean checkPlay(TypeOfPlayer playerOne, 
            TypeOfPlayer playerTwo, String... trumpType);
    
    /**
     * Método para verificar si hay ganador
     * @param one
     * @param two
     * @return 
     */
    public abstract int checkWinner(TypeOfPlayer one, TypeOfPlayer two);
    
}
