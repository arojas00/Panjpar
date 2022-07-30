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
 * @author Adrian Rojas, Javier Donato, Jafet Picado
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

    /**
     * Getter PlayerOne
     * @return PlayerOne
     */
    public TypeOfPlayer getPlayerOne() {
        return playerOne;
    }

    /**
     * Setter PlayerOne
     * @param playerOne
     */
    public void setPlayerOne(TypeOfPlayer playerOne) {
        this.playerOne = playerOne;
    }

    /**
     * Getter PlayerTwo
     * @return PlayerTwo
     */
    public TypeOfPlayer getPlayerTwo() {
        return playerTwo;
    }

    /**
     * Setter PlayerTwo
     * @param playerTwo
     */
    public void setPlayerTwo(TypeOfPlayer playerTwo) {
        this.playerTwo = playerTwo;
    }

    /**
     * Getter GroupOfDecks
     * @return decks
     */
    public ArrayList<TypeOfDeck> getDecks() {
        return decks;
    }

    /**
     * Setter GroupOfDecks
     * @param decks
     */
    public void setDecks(ArrayList<TypeOfDeck> decks) {
        this.decks = decks;
    }

    /**
     * Getter ViewP
     * @return viewP
     */
    public WhoStartsView getViewP() {
        return viewP;
    }

    /**
     * Setter ViewP
     * @param viewP
     */
    public void setViewP(WhoStartsView viewP) {
        this.viewP = viewP;
    }
    
    /**
     * Getter ViewM
     * @return viewM
     */
    public MainView getViewM() {
        return viewM;
    }

    /**
     * Setter ViewM
     * @param viewM
     */
    public void setViewM(MainView viewM) {
        this.viewM = viewM;
    }

    /**
     * Setter round
     * @return round
     */
    public Boolean getRound() {
        return round;
    }

    /**
     * Setter round
     * @param round 
     */
    public void setRound(Boolean round) {
        this.round = round;
    }

    /**
     * Getter Files
     * @return files
     */
    public Files getFiles() {
        return files;
    }

    /**
     * Setter Files
     * @param files
     */
    public void setFiles(Files files) {
        this.files = files;
    }
    
    /**
     * Método abstracto para definir que usuario inicia
     * @param init 
     */
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
