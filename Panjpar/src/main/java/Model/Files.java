/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author jafet
 */
public class Files {
    public Files(){}
    
    public void saveGame(Player one, Player two, Deck deck, Boolean round,
        Boolean attacker){
        try {
            Boolean foundName = false;
            File myObj;
            FileWriter myWriter;
            int counter = 0;
            String fileName = "../SaveFiles/PanjparGame"+(counter++)+".txt";
            do{
                myObj = new File(fileName);
                if (myObj.createNewFile()) {
                    foundName = true;
                } else {
                   fileName = "../SaveFiles/PanjparGame"+(counter++)+".txt";  
                }
            }while(!foundName);
            String aux = "";
            myWriter = new FileWriter(fileName);
            myWriter.write("PlayerOne\n");
            myWriter.write(playerString(one));
            myWriter.write("PlayerTwo\n");
            myWriter.write(playerString(two));
            myWriter.write("Deck\n");
            myWriter.write(deckString(deck));
            myWriter.write("GameState\n");
            if(round){
                myWriter.write("1\n");
            } else {
                myWriter.write("0\n");
            }
            if(attacker){
                myWriter.write("1\n");
            } else {
                myWriter.write("0\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    
    private String playerString(Player player){
        String aux = "";
        aux += player.getId()+"\n";
        if(!player.getHand().isEmpty()){
            for (Card hand : player.getHand()) {
                if(hand != player.getHand().get(player.getHand().size()-1)){
                    aux += hand.toString()+" ";
                } else {
                    aux += hand.toString()+"\n";
                }
            }
        } else {
            aux += "X\n";
        }
        if(!player.getTable().isEmpty()){
            for (Card table : player.getTable()) {
                if(table != player.getTable().get(player.getTable().size()-1)){
                    aux += table.toString()+" ";
                } else {
                    aux += table.toString()+"\n";
                }
            }
        } else {
            aux += "X\n";
        }
        return aux;
    }
    
    private String deckString(Deck deck){
        String aux = "";
        for(Card card: deck.getDeck()){
            if(card != deck.getDeck().get(deck.getDeck().size()-1)){
                aux += card.toString()+" ";
            } else {
                aux += card.toString()+"\n";
            }
        }
        aux += deck.getCounter()+"\n";
        aux += deck.getTrumpCardNumber()+"\n";
        return aux;
    }
}
