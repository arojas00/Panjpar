/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Files;
import Model.Validator;
import View.MainView;
import View.WhoStartsView;
import java.util.ArrayList;

/**
 *
 * @author jafet
 * @param <TypeOfDeck>
 * @param <TypeOfPlayer>
 */
public abstract class Game<TypeOfDeck, TypeOfPlayer> {
    public TypeOfPlayer playerOne;
    public TypeOfPlayer playerTwo;
    public ArrayList<TypeOfDeck> decks;
    public WhoStartsView viewP;
    public MainView viewM;
    public Boolean round;
    public Files files;
    public Validator validator;

    public TypeOfPlayer getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(TypeOfPlayer playerOne) {
        this.playerOne = playerOne;
    }

    public TypeOfPlayer getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(TypeOfPlayer playerTwo) {
        this.playerTwo = playerTwo;
    }

    public ArrayList<TypeOfDeck> getDecks() {
        return decks;
    }

    public void setDecks(ArrayList<TypeOfDeck> decks) {
        this.decks = decks;
    }

    public WhoStartsView getViewP() {
        return viewP;
    }

    public void setViewP(WhoStartsView viewP) {
        this.viewP = viewP;
    }

    public MainView getViewM() {
        return viewM;
    }

    public void setViewM(MainView viewM) {
        this.viewM = viewM;
    }

    public Boolean getRound() {
        return round;
    }

    public void setRound(Boolean round) {
        this.round = round;
    }

    public Files getFiles() {
        return files;
    }

    public void setFiles(Files files) {
        this.files = files;
    }
    
    public abstract void setWhoStarts(int init);
    
    /**
     * Metodo ejecuta el juego
     */
    public void run() {
        prepareDeck();
        viewM.updateTrumpCard();
        viewM.setVisible(true);
        viewM.enable(false);
        viewP.setVisible(true);
        startGame();
    } 
    
    /**
     * Inicializa el juego
     */
    public abstract void startGame();
    
        /**
     * Metodo prepara el deck
     */
    public abstract void prepareDeck();
    
    public abstract Boolean checkPlay();
    
    public void saveGame(){
        if(files.saveGame()){
            this.viewM.saved();
        } else {
            this.viewM.showFileError();
        }
    }
   
    
    /**
     * Metodo para cargar el estado de un juego
     * @param fileName String de numero de id del archivo
     */
    public void loadGame(String fileName){
        if(files.readFile(fileName)){
            this.viewM.loaded();
            this.viewM.updateUI();
        } else {
            this.viewM.showFileError();
        }
    }
    /**
     * Metodo que invierte el valor de round
     */
    public void changeRound(){
        this.round = !this.round;
    }
}
