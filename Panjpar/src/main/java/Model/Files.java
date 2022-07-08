/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Panjpar;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jafet
 */
public class Files {
    public Files(){}
    
    public Boolean saveGame(Player one, Player two, Deck deck, Boolean round,
        Boolean attacker){
        Boolean result = true;
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
            result = false;
            System.out.println("An error occurred.");
        }
        return result;
    }
               
    public Boolean readFile(Panjpar game, String fileName){
            Boolean result = true;
            Panjpar gameCopy = new Panjpar();
            gameCopy.setPlayerOne(game.getPlayerOne());
            gameCopy.setPlayerTwo(game.getPlayerTwo());
            gameCopy.setAttacker(game.getAttacker());
            gameCopy.setDefender(game.getDefender());
            gameCopy.setViewM(game.getViewM());
            gameCopy.setRound(game.getRound());
        try{  
            File myObj = new File("../SaveFiles/PanjparGame"+fileName+".txt");
            Scanner myReader;
            myReader = new Scanner(myObj);
            String aux = myReader.nextLine();
            try{
                if(aux.equals("PlayerOne")){
                    game.getPlayerOne().setId(myReader.nextLine());
                    game.getPlayerOne().setHand(readCards(myReader));
                    game.getPlayerOne().setTable(readCards(myReader));
                }
                aux = myReader.nextLine();
                if(aux.equals("PlayerTwo")){
                    game.getPlayerTwo().setId(myReader.nextLine());
                    game.getPlayerTwo().setHand(readCards(myReader));
                    game.getPlayerTwo().setTable(readCards(myReader));
                }
                aux = myReader.nextLine();
                if(aux.equals("Deck")){
                    game.getDeck().setDeck(readCards(myReader));
                    game.getDeck().setCounter(Integer.parseInt(myReader.nextLine()));
                    game.getDeck().setTrumpCard(Integer.parseInt(myReader.nextLine()));
                }
                aux = myReader.nextLine();
                if(aux.equals("GameState")){
                    aux = myReader.nextLine();
                    game.setRound(aux.equals("1"));
                    aux = myReader.nextLine();
                    if(aux.equals("0")){
                        game.setAttacker(game.getPlayerTwo());
                        game.setDefender(game.getPlayerOne());
                    } else {
                        game.setAttacker(game.getPlayerOne());
                        game.setDefender(game.getPlayerTwo());
                    }
                }
                myReader.close();
            } catch(Exception e){
                game = gameCopy;
                System.out.println("An error occurred.");
                return false;
            }
        } catch (FileNotFoundException e){
            result = false;
            System.out.println("An error Occurred.");
        }
        return result;
    }
    
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
        
    private String playerString(Player player){
        String aux = "";
        aux += player.getId()+"\n";
        if(!player.getHand().isEmpty()){
            for (Card hand : player.getHand()) {
                if(hand != player.getHand().get(player.getHand().size()-1)){
                    aux += hand.toString()+"\n";
                } else {
                    aux += hand.toString()+".\n";
                }
            }
        } else {
            aux += "X\n";
        }
        if(!player.getTable().isEmpty()){
            for (Card table : player.getTable()) {
                if(table != player.getTable().get(player.getTable().size()-1)){
                    aux += table.toString()+"\n";
                } else {
                    aux += table.toString()+".\n";
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
                aux += card.toString()+"\n";
            } else {
                aux += card.toString()+".\n";
            }
        }
        aux += deck.getCounter()+"\n";
        aux += deck.getTrumpCardNumber()+"\n";
        return aux;
    }
}