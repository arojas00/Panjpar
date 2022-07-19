/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Panjpar;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jafet
 */
public class FilesPanjpar extends Files{
    private Panjpar game;
    
    public FilesPanjpar(Panjpar game){
        this.game = game;
    }

    public Panjpar getGame() {
        return game;
    }

    public void setGame(Panjpar game) {
        this.game = game;
    }
    
    @Override
    public Boolean saveGame() {
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
            myWriter.write(playerString(game.getPlayerOne()));
            myWriter.write("PlayerTwo\n");
            myWriter.write(playerString(game.getPlayerTwo()));
            myWriter.write("Deck\n");
            myWriter.write(groupOfCardsString(game.getDeck()));
            myWriter.write(game.getDeck().getCounter()+"\n");
            myWriter.write(game.getDeck().getTrumpCardNumber()+"\n");
            myWriter.write("GameState\n");
            if(game.getRound()){
                myWriter.write("1\n");
            } else {
                myWriter.write("0\n");
            }
            if(game.getAttacker() == game.getPlayerOne()){
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

    @Override
    public Boolean readFile(String fileName) {
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
                    game.getPlayerOne().setHandCards(readCards(myReader));
                    game.getPlayerOne().setTableCards(readCards(myReader));
                }
                aux = myReader.nextLine();
                if(aux.equals("PlayerTwo")){
                    game.getPlayerTwo().setId(myReader.nextLine());
                    game.getPlayerTwo().setHandCards(readCards(myReader));
                    game.getPlayerTwo().setTableCards(readCards(myReader));
                }
                aux = myReader.nextLine();
                if(aux.equals("Deck")){
                    game.getDeck().setCards(readCards(myReader));
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
                return false;
            }
        } catch (FileNotFoundException e){
            result = false;
            System.out.println("An error Occurred.");
        }
        return result;   
    }
    
}
