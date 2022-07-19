/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jafet
 * @param <TypeOfPlayer>
 */
public abstract class Validator<TypeOfPlayer>{
    
    public abstract Boolean checkTable(TypeOfPlayer attacker, 
            TypeOfPlayer defender, Boolean round, String trumpType);
    
    public abstract Boolean checkPlay(TypeOfPlayer attacker, 
            TypeOfPlayer defender, String trumpType);
    
    public abstract int checkWinner(TypeOfPlayer one, TypeOfPlayer two);
    
}
