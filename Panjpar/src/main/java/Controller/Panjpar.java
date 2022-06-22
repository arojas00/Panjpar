/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Player;
import Model.Deck;
import View.MainView;
import View.WhoStartsView;

/**
 *
 * @author adrian
 */
public final class Panjpar {
    private Player playerOne;
    private Player playerTwo;
    private Player attacker;
    private Player defender;
    private Deck deck;
    private MainView viewM;
    private final WhoStartsView viewP;
    
    public Panjpar(){
        playerOne = new Player("playerOne");
        playerTwo = new Player("playerTwo");
        deck = new Deck();
        this.prepareDeck();
        viewM = new MainView(this);
        viewM.setVisible(false);
        viewP = new WhoStartsView(this);
        viewP.setVisible(false);
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
    
    public void setWhoStarts(int init){
        if(init == 1){
            attacker = playerOne;
            defender = playerTwo;
        } else if(init == 2){
            attacker = playerTwo;
            defender = playerOne;
        }
    }

    public Player getAttacker() {
        return attacker;
    }

    public void setAttacker(Player attacker) {
        this.attacker = attacker;
    }

    public Player getDefender() {
        return defender;
    }

    public void setDefender(Player defender) {
        this.defender = defender;
    }
    
    public void run() {
        viewM.setVisible(true);
        viewM.enable(false);
        viewP.setVisible(true);
        startGame();
    }
    
    public void startGame(){
        prepareDeck();
        playerOne.fillHand(deck);
        playerTwo.fillHand(deck);
    }
    
    public void prepareDeck(){
        deck.createDeck();
        deck.shuffle();
    }
    
    public void changeRol(){
        if(attacker == playerOne){
            attacker = playerTwo;
            defender = playerOne;
        } else {
            attacker = playerOne;
            defender = playerTwo;
        }
    }
    
    public static void main(String[] args){
        Panjpar game = new Panjpar();
        game.run();
    }
}
