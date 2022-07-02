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
 * @author Adrian Rojas, Javier Donato, Jafet Picado
 */
public final class Panjpar {
    private Player playerOne;
    private Player playerTwo;
    private Player attacker;
    private Player defender;
    private Deck deck;
    private MainView viewM;
    private final WhoStartsView viewP;
    private Boolean round;
    
    public Panjpar(){
        round = true;
        playerOne = new Player("playerOne");
        playerTwo = new Player("playerTwo");
        deck = new Deck();
        this.prepareDeck();
        viewM = new MainView(this);
        viewM.setVisible(false);
        viewP = new WhoStartsView(this);
        viewP.setVisible(false);
    }
    
    /**
     * Metodo devuelve el jugador uno
     * @return playerOne Jugador uno
     */

    public Player getPlayerOne() {
        return playerOne;
    }
    
    /**
     * Metodo selecciona el jugador uno
     * @param playerOne Player
     */
    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }
    
    /**
     * Metodo devuelve el jugador dos
     * @return playerTwo jugador dos
     */
    public Player getPlayerTwo() {
        return playerTwo;
    }
    
    /**
     * Metodo selecciona el jugador dos
     * @param playerTwo Player
     */
    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }
    
    /**
     * Metodo devuelve el deck
     * @return deck mazo de cartas
     */
    public Deck getDeck() {
        return deck;
    }
    
    /**
     * Metodo selecciona el jugador uno
     * @param deck Mazo de cartas
     */
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    /**
     * Metodo devuelve la interfaz utilizada
     * @return viewM MainView
     */
    public MainView getViewM() {
        return viewM;
    }

    /**
     * Metodo establece la interfaz
     * @param viewM MainView
     */
    public void setViewM(MainView viewM) {
        this.viewM = viewM;
    }
    
    /**
     * Metodo establece que jugador comienza atacando
     * @param init Entero
     */
    public void setWhoStarts(int init){
        if(init == 1){
            attacker = playerOne;
            defender = playerTwo;
        } else if(init == 2){
            attacker = playerTwo;
            defender = playerOne;
        }
    }
    
    /**
     * Metodo devuelve el atacante
     * @return attacker Player
     */
    public Player getAttacker() {
        return attacker;
    }
    
/**
     * Metodo selecciona al atacante
     * @param attacker Player
     */
    public void setAttacker(Player attacker) {
        this.attacker = attacker;
    }
    
    /**
     * Metodo devuelve el defensor
     * @return defender Player
     */
    public Player getDefender() {
        return defender;
    }
    
    /**
     * Metodo selecciona al defensor
     * @param defender Player
     */
    public void setDefender(Player defender) {
        this.defender = defender;
    }
    
    /**
     * Metodo ejecuta el juego
     */
    public void run() {
        viewM.setVisible(true);
        viewM.enable(false);
        viewP.setVisible(true);
        startGame();
    }
    /**
     * Inicializa el juego
     */
    public void startGame(){
        prepareDeck();
        playerOne.fillHand(deck);
        playerTwo.fillHand(deck);
    }
    
    /**
     * Metodo prepara el deck
     */
    public void prepareDeck(){
        deck.createDeck();
        deck.shuffle();
    }
    
    /**
     * Metodo que alterna los rles de los jugadores
     */
    public void changeRol(){
        Player aux = defender;
        defender = attacker;
        attacker = aux;
    }

    public Boolean getRound() {
        return round;
    }

    public void setRound(Boolean round) {
        this.round = round;
    }
    
    public void changeRound(){
        this.round = !this.round;
    }
    
    public Boolean checkPlay(){
        Boolean result = false;
        if(getRound()){
            if(getAttacker().checkTable(getDefender(), getRound(), 
                    deck.getTrumpType())){
                changeRound();
                result = true;
                this.viewM.updateUI();
            }
        } else {
            if(getDefender().checkTable(getAttacker(), getRound(), 
                    deck.getTrumpType())){
                result = true;
                if(getDefender().checkPlay(getAttacker(), deck.getTrumpType())){
                    getAttacker().fillHand(deck);
                    getDefender().fillHand(deck);
                    getAttacker().clearTable();
                    getDefender().clearTable();
                    System.out.println(getAttacker().getTable().size()+" : "+getDefender().getTable().size());
                    changeRol();
                    changeRound();
                    this.viewM.defenderVictory();
                } else {
                    getAttacker().fillHand(deck);
                    getDefender().fillHand(deck);
                    getAttacker().clearTable();
                    getDefender().clearTable();
                    System.out.println(getAttacker().getTable().size()+" : "+getDefender().getTable().size());
                    changeRound();
                    this.viewM.attackerVictory();
                }
                this.viewM.updateUI();
            }
        }
        return result;
    }
    
    /**
     * Metodo main
     * @param args String[]
     */
    public static void main(String[] args){
        Panjpar game = new Panjpar();
        game.run();
    }
}
