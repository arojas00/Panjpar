/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Game;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase para guardar y cargar archivos de juego
 * @author Adrian Rojas, Javier Donato, Jafet Picado
 */
public abstract class Files {
    /**
     * Metodo que guarda el estado del juego en un archivo de texto 
     * @return boolean
     */
    public abstract Boolean saveGame();
               
    /**
     * Metodo que carga el estado de un juego
     * @return boolean
     */
    public abstract Boolean readFile(String fileName);
    
    /**
     * Metodo que lee las cartas en el formato del archivo de guardado
     * @param player
     * @param myReader Scanner
     * @return ArrayList<Card>
     *//*
    private ArrayList<Card> readCards(Scanner myReader){
        ArrayList<Card> cardArray = new ArrayList<>();
        String aux = myReader.nextLine();
        if(!aux.equals("X")){
            while(true){
                String aux2 = aux;
                String[] arrOfStr = aux2.split(" ", 7);
                cardArray.add(new Card(Integer.parseInt(arrOfStr[1])
                        , Integer.parseInt(arrOfStr[3])
                        , Integer.parseInt(arrOfStr[5])));
                if(aux.contains("].")){
                    break;
                }
                aux = myReader.nextLine();
            }
        }
        return cardArray;
    }
        
    /**
     * Metodo que asigna toda la información del jugador en un String
     * @param player Player
     * @return String
     */
    public String playerString(Player player){
        String aux = "";
        aux += player.getId()+"\n";
        for(GroupOfCards group : player.getGroup()){
            aux += groupOfCardsString(group);
        }
        return aux;
    }
    
    /**
     * Metodo que asigna todas las cartas del deck a un String, junto a su
     * contador y el valor de trumpCard
     * @param group
     * @return String
     */
    public String groupOfCardsString(GroupOfCards group){
        String aux = "";
        if(!group.isEmpty()){
            for(Card card: group.getCards()){
                if(card != group.getCard(group.getCards().size()-1)){
                    aux += card.toString()+"\n";
                } else {
                    aux += card.toString()+".\n";
                }
            }
        } else {
            aux += "X\n";
        }
        return aux;
    }
    
    public ArrayList<Card> readCards(Scanner myReader){
        ArrayList<Card> cardArray = new ArrayList<>();
        String aux = myReader.nextLine();
        if(!aux.equals("X")){
            while(true){
                String aux2 = aux;
                String[] arrOfStr = aux2.split(" ", 7);
                cardArray.add(new Card(Integer.parseInt(arrOfStr[1])
                        , arrOfStr[3], Integer.parseInt(arrOfStr[5])));
                if(aux.contains("].")){
                    break;
                }
                aux = myReader.nextLine();
            }
        }
        return cardArray;
    }
}