/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Player;
import Model.Deck;
import View.MainView;

/**
 *
 * @author adrian
 */
public class Panjpar {
    private Player playerOne;
    private Player playerTwo;
    private Deck deck;
    private MainView viewM;
    
    public Panjpar(){
        playerOne = new Player("playerOne");
        playerTwo = new Player("playerTwo");
        deck = new Deck();
        viewM = new MainView(this);
        viewM.setVisible(false);
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public MainView getViewM() {
        return viewM;
    }

    public void setViewM(MainView viewM) {
        this.viewM = viewM;
    }
    
    public void run() {
        startGame();
        viewM.setVisible(true);
    }
    
    public void startGame(){
        prepareDeck(deck);
        playerOne.fillHand(deck);
        playerTwo.fillHand(deck);
        viewM.updateUI();
    }
    public void prepareDeck(Deck deck){
        deck.createDeck();
        deck.shuffle();
    }
    
    public static void main(String[] args){
        Panjpar game = new Panjpar();
        game.run();
    }
}
