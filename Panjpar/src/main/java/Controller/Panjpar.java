/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DeckPanjpar;
import Model.FilesPanjpar;
import Model.PlayerPanjpar;
import Model.ValidatorPanjpar;
import View.MainView;
import View.WhoStartsView;
import java.util.ArrayList;

/**
 * Controlador del juego
 * @author Adrian Rojas, Javier Donato, Jafet Picado
 */
public class Panjpar extends Game<DeckPanjpar, PlayerPanjpar>{
    private PlayerPanjpar attacker;
    private PlayerPanjpar defender;
    private ArrayList<String> types;
    
    public Panjpar(){
        validator = new ValidatorPanjpar();
        playerOne = new PlayerPanjpar("playerOne");
        playerTwo = new PlayerPanjpar("playerTwo");
        types = new ArrayList<>();
        types.add("1"); types.add("2"); types.add("3"); types.add("4");
        decks = new ArrayList<>();
        decks.add(new DeckPanjpar(types, 14, 2));
        round = true;
        files = new FilesPanjpar(this);
        viewM = new MainView(this);
        viewM.setVisible(false);
        viewP = new WhoStartsView(this);
        viewP.setVisible(false);
    }
    
    
    /**
     * Metodo devuelve el deck
     * @return deck mazo de cartas
     */
    public DeckPanjpar getDeck() {
        return decks.get(0);
    }
    
    /**
     * Metodo selecciona el jugador uno
     * @param deck Mazo de cartas
     */
    public void setDeck(DeckPanjpar deck) {
        decks.remove(0);
        decks.add(0, deck);
    }
    
    /**
     * Metodo establece que jugador comienza atacando
     * @param init Entero
     */
    @Override
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
    public PlayerPanjpar getAttacker() {
        return attacker;
    }
    
/**
     * Metodo selecciona al atacante
     * @param attacker Player
     */
    public void setAttacker(PlayerPanjpar attacker) {
        this.attacker = attacker;
    }
    
    /**
     * Metodo devuelve el defensor
     * @return defender Player
     */
    public PlayerPanjpar getDefender() {
        return defender;
    }
    
    /**
     * Metodo selecciona al defensor
     * @param defender Player
     */
    public void setDefender(PlayerPanjpar defender) {
        this.defender = defender;
    }
    
    @Override
    public void startGame(){
        playerOne.fillHand(decks.get(0));
        playerTwo.fillHand(decks.get(0));
    }
    
    @Override
    public void prepareDeck(){
        decks.get(0).shuffle();
    }
    /**
     * Metodo que alterna los roles de los jugadores
     */
    public void changeRol(){
        PlayerPanjpar aux = defender;
        defender = attacker;
        attacker = aux;
    }

    /**
     * Metodo que revisa las mesas y las jugadas de los jugadores
     * @return result Variable que define si la jugada fue o no valida
     */
    @Override
    public Boolean checkPlay(){
        Boolean result = false;
        if(getRound()){
            if((validator.checkTable(getAttacker(), getDefender(), getRound(),
                    decks.get(0).getTrumpType()))){
                changeRound();
                result = true;
            }
        } else {
            if(validator.checkTable(getAttacker(), getDefender(), getRound(), 
                decks.get(0).getTrumpType())){
                result = true;
                if(validator.checkPlay(getAttacker(), getDefender(), 
                        decks.get(0).getTrumpType())){
                    changeRol();
                    this.viewM.defenderVictory();
                } else {
                    this.viewM.attackerVictory();
                }
                getAttacker().fillHand(decks.get(0));
                getDefender().fillHand(decks.get(0));
                getAttacker().clearTable();
                getDefender().clearTable();
                changeRound();
            }
            if(decks.get(0).isEmpty() && (getAttacker().getHand().isEmpty() || 
                    getDefender().getHand().isEmpty())){
                int winner = validator.checkWinner(getAttacker(), getDefender());
                switch(winner){
                    case 1: viewM.tied();
                        break;
                    case 2: if(getAttacker() == getPlayerOne()){
                                viewM.playerOneWins();
                            } else {
                                viewM.playerTwoWins();
                            }
                        break;
                    case 3: if(getDefender() == getPlayerOne()){
                                viewM.playerOneWins();
                            } else {
                                viewM.playerTwoWins();
                            }
                        break;
                    default: 
                        break;
                }
            }
        }
        this.viewM.updateUI();
        return result;
    }
    
    /**
     * Metodo que genera un nuevo juego
     */
    public void newGame(){
        this.viewM.dispose();
        this.viewP.dispose();
        round = true;
        playerOne = new PlayerPanjpar("playerOne");
        playerTwo = new PlayerPanjpar("playerTwo");
        decks.remove(0);
        decks.add(0, new DeckPanjpar(types, 14, 2));
//        decks.get(0).createCards(types, 14, 1);
        prepareDeck();
        viewM = new MainView(this);
        viewM.setVisible(false);
        viewP = new WhoStartsView(this);
        viewP.setVisible(false);
        run();
    }
    
    /**
     * Metodo para cargar el estado de un juego
     * @param fileName String de numero de id del archivo
     */
    @Override
    public void loadGame(String fileName){
        if(files.readFile(fileName)){
            this.viewM.loaded();
            this.viewM.updateTrumpCard();
            this.viewM.updateUI();
        } else {
            this.viewM.showFileError();
        }
    }

}