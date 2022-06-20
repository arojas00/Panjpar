/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Player;
import Model.Deck;

/**
 *
 * @author adrian
 */
public class Panjpar {
    private Player playerOne;
    private Player playerTwo;
    private Deck deckPlayerOne;
    private Deck deckPlayerTwo;
    
    public Panjpar(){
        playerOne = new Player("playerOne");
        playerTwo = new Player("playerTwo");
        deckPlayerOne = new Deck();
        deckPlayerTwo = new Deck();
    }
    
    public void run() {
        startGame();
    }
    public void startGame(){
        prepareDeck(deckPlayerOne);
        playerOne.fillHand(deckPlayerOne);
        prepareDeck(deckPlayerTwo);
        playerTwo.fillHand(deckPlayerTwo);
    }
    public void prepareDeck(Deck playerDeck){
        playerDeck.createDeck();
        playerDeck.shuffle();
    }
}
