/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.Panjpar;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Pantalla principal del juego
 * @author Javier Donato, Jafet Picado, Adrian Rojas
 */
public final class MainView extends javax.swing.JFrame implements MouseListener{

    private final Panjpar game;
    private ArrayList<GroupOfCardView> group;
    private ArrayList<GroupOfBackView> groupBack;
    
    /**
     * Creates new form MainView
     * @param game Copia del controlador
     */
    public MainView(Panjpar game) {
        this.game = game;
        ImageIcon icon = new ImageIcon("./src/main/img/help.png");
        group = new ArrayList<>();
        group.add(new GroupOfCardView());
        group.add(new GroupOfCardView());
        group.add(new GroupOfCardView());
        group.add(new GroupOfCardView());
        groupBack = new ArrayList<>();
        groupBack.add(new GroupOfBackView());
        initComponents();
        this.setLocationRelativeTo(null);
        jButton1.setIcon(icon);
    }

    private MainView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * Creates actualiza el estado de la interfaz grafica
     */
    public void updateUI(){
       group.get(0).getCards().removeAll(group.get(0).getCards());
       group.get(1).getCards().removeAll(group.get(1).getCards());
       group.get(2).getCards().removeAll(group.get(2).getCards());
       group.get(3).getCards().removeAll(group.get(3).getCards());
       groupBack.get(0).getCards().removeAll(groupBack.get(0).getCards());
       jPanel1.removeAll();
       jPanel2.removeAll();
       jPanel3.removeAll();
       jPanel4.removeAll();
       if(game.getRound()){
        if(this.game.getAttacker() == this.game.getPlayerOne()){
            if(!this.game.getAttacker().getHand().isEmpty()){
                for(int i = 0; i < this.game.getAttacker().getHand().getCards().size(); i++){
                    group.get(0).getCards().add(new CardView(
                            this.game.getAttacker().getHand().getCard(i)));
                    group.get(0).getCards().get(i).addMouseListener(this);
                    jPanel1.add(group.get(0).getCards().get(i));
                }
            } else {
                for(int i = 0; i < 5; i++){
                   jPanel1.add(new VoidView());
               }
            }
            if(!this.game.getAttacker().getTable().isEmpty()){
                for(int i = 0; i < this.game.getAttacker().getTable().getCards().size(); i++){
                    group.get(1).getCards().add(new CardView(
                            this.game.getAttacker().getTable().getCard(i)));
                    group.get(1).getCards().get(i).addMouseListener(this);
                    jPanel2.add(group.get(1).getCards().get(i));
                }
            } else {
                for(int i = 0; i < 5; i++){
                   jPanel2.add(new VoidView());
                }
            }
            if(!this.game.getDefender().getHand().isEmpty()){
                for(int i = 0; i < this.game.getDefender().getHand().getCards().size(); i++){
                    groupBack.get(0).getCards().add(new BackCardView());
                    jPanel4.add(groupBack.get(0).getCards().get(i));
                }
            } else {
                for(int i = 0; i < 5; i++){
                   jPanel4.add(new VoidView());
                }
            }
        } else {
            if(!this.game.getAttacker().getHand().isEmpty()){
                for(int i = 0; i < this.game.getAttacker().getHand().getCards().size(); i++){
                    group.get(2).getCards().add(new CardView(
                            this.game.getAttacker().getHand().getCard(i)));
                    group.get(2).getCards().get(i).addMouseListener(this);
                    jPanel4.add(group.get(2).getCards().get(i));
                }
            } else {
                for(int i = 0; i < 5; i++){
                   jPanel4.add(new VoidView());
                }
            }
            if(!this.game.getAttacker().getTable().isEmpty()){
                for(int i = 0; i < this.game.getAttacker().getTable().getCards().size(); i++){
                    group.get(3).getCards().add(new CardView(
                            this.game.getAttacker().getTable().getCard(i)));
                    group.get(3).getCards().get(i).addMouseListener(this);
                    jPanel3.add(group.get(3).getCards().get(i));
                }
            } else {
                for(int i = 0; i < 5; i++){
                   jPanel3.add(new VoidView());
                }
            }
            if(!this.game.getDefender().getHand().isEmpty()){
                for(int i = 0; i < this.game.getDefender().getHand().getCards().size(); i++){
                    groupBack.get(0).getCards().add(new BackCardView());
                    jPanel1.add(groupBack.get(0).getCards().get(i));
                }
            } else {
                for(int i = 0; i < 5; i++){
                   jPanel1.add(new VoidView());
                }
            }
        }
       } else {
        if(this.game.getAttacker() == this.game.getPlayerOne()){
            if(!this.game.getDefender().getHand().isEmpty()){
                for(int i = 0; i < this.game.getDefender().getHand().getCards().size(); i++){
                    group.get(2).getCards().add(new CardView(
                            this.game.getDefender().getHand().getCard(i)));
                    group.get(2).getCards().get(i).addMouseListener(this);
                    jPanel4.add(group.get(2).getCards().get(i));
                }
            } else {
                for(int i = 0; i < 5; i++){
                   jPanel4.add(new VoidView());
               }
            }
            if(!this.game.getDefender().getTable().isEmpty()){
                for(int i = 0; i < this.game.getDefender().getTable().getCards().size(); i++){
                    group.get(3).getCards().add(new CardView(
                            this.game.getDefender().getTable().getCard(i)));
                    group.get(3).getCards().get(i).addMouseListener(this);
                    jPanel3.add(group.get(3).getCards().get(i));
                }
            } else {
                for(int i = 0; i < 5; i++){
                   jPanel3.add(new VoidView());
               }
            }
            for(int i = 0; i < this.game.getAttacker().getTable().getCards().size(); i++){
                group.get(1).getCards().add(new CardView(
                        this.game.getAttacker().getTable().getCard(i)));
                group.get(1).getCards().get(i).addMouseListener(this);
                jPanel2.add(group.get(1).getCards().get(i));
            }
            if(!this.game.getAttacker().getHand().isEmpty()){
                for(int i = 0; i < this.game.getAttacker().getHand().getCards().size(); i++){
                    groupBack.get(0).getCards().add(new BackCardView());
                    jPanel1.add(groupBack.get(0).getCards().get(i));
                }
            } else {
               for(int i = 0; i < 5; i++){
                   jPanel1.add(new VoidView());
               }
            }
        } else {
            if(!this.game.getDefender().getHand().isEmpty()){
                for(int i = 0; i < this.game.getDefender().getHand().getCards().size(); i++){
                    group.get(0).getCards().add(new CardView(
                            this.game.getDefender().getHand().getCard(i)));
                    group.get(0).getCards().get(i).addMouseListener(this);
                    jPanel1.add(group.get(0).getCards().get(i));
                }
            } else {
                for(int i = 0; i < 5; i++){
                   jPanel1.add(new VoidView());
               }
            }
            if(!this.game.getDefender().getTable().isEmpty()){
                for(int i = 0; i < this.game.getDefender().getTable().getCards().size(); i++){
                    group.get(1).getCards().add(new CardView(
                            this.game.getDefender().getTable().getCard(i)));
                    group.get(1).getCards().get(i).addMouseListener(this);
                    jPanel2.add(group.get(1).getCards().get(i));
                }
            }  else {
                for(int i = 0; i < 5; i++){
                   jPanel2.add(new VoidView());
               }
            }
            for(int i = 0; i < this.game.getAttacker().getTable().getCards().size(); i++){
                group.get(3).getCards().add(new CardView(
                        this.game.getAttacker().getTable().getCard(i)));
                group.get(3).getCards().get(i).addMouseListener(this);
                jPanel3.add(group.get(3).getCards().get(i));
            }
            if(!this.game.getAttacker().getHand().isEmpty()){
                for(int i = 0; i < this.game.getAttacker().getHand().getCards().size(); i++){
                    groupBack.get(0).getCards().add(new BackCardView());
                    jPanel4.add(groupBack.get(0).getCards().get(i));
                }
            } else {
                for(int i = 0; i < 5; i++){
                    jPanel4.add(new VoidView());
                }
            }
        }
       }
       if(this.game.getAttacker() == this.game.getPlayerOne()){
           jLabel2.setText("Attacker");
           jLabel3.setText("Defender");
       } else {
           jLabel3.setText("Attacker");
           jLabel2.setText("Defender");
       }
       this.validate();
       this.jPanel1.repaint();
       this.jPanel2.repaint();
       this.jPanel3.repaint();
       this.jPanel4.repaint();
    }
    
    /**
     * Metodo para mostrar mensaje de error
     */
    public void showError(){
         JOptionPane.showMessageDialog(null, "Oh no, you made an invalid move,"
                 + "check the rules to find out why ","Invalid Play", 1);
    }
    
    /**
    * Metodo para mostrar mensaje de victoria de defensor
    */
    public void defenderVictory(){
        JOptionPane.showMessageDialog(null, "The defender managed to beat all "
                + "of the attacker's cards","Defender Victory", 1);
    }
    
    /**
    * Metodo para mostrar mensaje de victoria de atacante
    */ 
    public void attackerVictory(){
        JOptionPane.showMessageDialog(null, "The defender failed to beat all "
                + "of the attacker's cards","Attacker Victory", 1);
    
    }
    
    /**
    * Metodo para mostrar mensaje de empate
    */ 
    public void tied(){
        JOptionPane.showMessageDialog(null, "The game is tied! None of the "
                + "players have cards left to play","Tied", 1);
    }
    
    /**
    * Metodo para mostrar mensaje de victoria de jugador 1
    */    
    public void playerOneWins(){
        JOptionPane.showMessageDialog(null, "Player one wins the game! The "
                + "player has no cards left to play","Player one wins", 1);
    }
    
    /**
    * Metodo para mostrar mensaje de victoria de jugador 2
    */    
    public void playerTwoWins(){
        JOptionPane.showMessageDialog(null, "Player two wins the game! The "
                + "player has no cards left to play","Player two wins", 1);
    }
    
    /**
    * Metodo para mostrar mensaje de juego guardado
    */ 
    public void saved(){
        JOptionPane.showMessageDialog(null, "The game has been saved"
                ,"Game saved", 1);
    }
    
    /**
    * Metodo para mostrar mensaje de juego cargado
    */ 
    public void loaded(){
        JOptionPane.showMessageDialog(null, "The game has been loaded"
                ,"Game loaded", 1);
    }
    
    /**
    * Metodo para mostrar mensaje de error al cargar o guardar el juego
    */ 
    public void showFileError(){
        JOptionPane.showMessageDialog(null, "Oh no, it looks like an error "
                + "occurred while saving or loading the file", "File Error", 1);
    }
    
    /**
    * Metodo para actualizar el panel con la trumpCard
    */ 
    public void updateTrumpCard(){
        jPanel5.removeAll();
        jPanel5.add(new CardView(this.game.getDeck().getTrumpCard()));
        jPanel5.repaint();
        jPanel5.revalidate();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panjpar");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new java.awt.GridLayout(1, 5, 2, 2));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(new java.awt.GridLayout(1, 5, 2, 2));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 102));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new java.awt.GridLayout(1, 20, 2, 2));
        jScrollPane1.setViewportView(jPanel1);

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(new java.awt.GridLayout(1, 20, 2, 2));
        jScrollPane2.setViewportView(jPanel4);

        jButton1.setBorder(null);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton2.setText("Play");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel5.setEnabled(false);
        jPanel5.setLayout(new java.awt.GridLayout(1, 1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("Trump Card");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton3.setText("New Game");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton4.setText("Save Game");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton5.setText("Load Game");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setText("Player One");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setText("Player Two");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jButton3))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(44, 44, 44))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(33, 33, 33)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(130, 130, 130))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Accion que muestar las reglas del juego al presionar el boton
     * @param evt evento que activa la accion
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(null, "Attackers: \n“Throw” or play 1, 3, "
                + "or 5 cards in their hand. This is done by placing the cards "
                + "side-by-side and face-up on the table.\n"
                + "  *In a single card attack, any card may be played.\n"
                + "  *On a three card attack, there must be a pair + "
                + "an odd card. For example, K-K-7. Or, they may play a "
                + "three of a kind, K-K-K.\n"
                + "  *Five card attacks can consist of two pairs + an odd "
                + "card (K-K-A-A-5) A full house is also legal 5 card play "
                + "(K-K-K-A-A), as is playing a four of a kind + "
                + "an odd card (5-5-5-5-2).\n\n"+"Defenders: \n"
                + "Have the chance to “kill” or beat these cards "
                + "played by playing cards from their hand on top of "
                + "attacking cards. Cards are beaten by a higher ranking "
                + "card of the same suit. Non-trump \ncards are beaten "
                + "by cards which are trumps (trump suit).\n\n"
                + "Attack cards that are successfully annihilated "
                + "and the cards used by the defender are put off "
                + "to the side and are not used in play until "
                + "the next deal. If a defender is able to \nbeat "
                + "all the cards played by the attacker, "
                + "they attack in the next round.\n"
                + "However, if the defender was unable to "
                + "beat all the attack cards, or none at all, "
                + "those cards are added to the defender’s hand. "
                + "The attacking player attacks again.\n"
                + "You are not required to beat all the "
                + "cards you can. You may strategically "
                + "lose to gain certain cards, like "
                + "trump cards.\n"+"This play continues "
                + "until the stock pile is exhausted. Players must "
                + "both have at least 5 cards in the hand prior to "
                + "an attack. This is for both attacking and defending. "
                + "In the event you \nhave less than 5 cards, draw the "
                + "remainder from the stock.\n\n"
                + "The End of the Game: \n"
                + "The last card drawn from the stock is the trump indicator "
                + "card. After, play continues without drawing "
                + "for a replacement.\n"
                + "You may not attack your opponent with more cards than they"
                + " have in hand. Once a player has no more cards, gameplay"
                + " ends after that battle. The player who still has cards "
                + "in hand is the loser.\n"
                + "However, if both players use all their cards in the "
                + "same battle, the game is considered to be a draw.", "Rules", 1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked
    
     /**
     * Accion que pasa de ronda y llama a updateUI al tocar el boton
     * @param evt evento que activa la accion
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!this.game.checkPlay()){
            showError();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.game.newGame();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.game.saveGame();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String fileName = JOptionPane.showInputDialog("Insert the number of the save file.");
        this.game.loadGame(fileName);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

     /**
     * Accion que permite seleccionar las cartas a jugar
     * @param e evento que activa la accion
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.game.getRound() == true){
            if(this.game.getAttacker() == this.game.getPlayerOne()){
                for(int i = 0; i < this.group.get(0).getCards().size(); i++){
                    if(e.getSource() == this.group.get(0).getCards().get(i)){
                        this.game.getAttacker().selectCard(
                                this.group.get(0).getCards().get(i).getCard());    
                        this.updateUI();
                    }
                }
                for(int i = 0; i < this.group.get(1).getCards().size(); i++){
                     if(e.getSource() == this.group.get(1).getCards().get(i)){
                        this.game.getAttacker().selectCard(
                                this.group.get(1).getCards().get(i).getCard());    
                        this.updateUI();
                    }
                }
            } else {
                for(int i = 0; i < this.group.get(2).getCards().size(); i++){
                    if(e.getSource() == this.group.get(2).getCards().get(i)){
                        this.game.getAttacker().selectCard(
                                this.group.get(2).getCards().get(i).getCard());    
                        this.updateUI();
                    }
                }
                for(int i = 0; i < this.group.get(3).getCards().size(); i++){
                     if(e.getSource() == this.group.get(3).getCards().get(i)){
                        this.game.getAttacker().selectCard(
                                this.group.get(3).getCards().get(i).getCard());    
                        this.updateUI();
                    }
                }
            }
        } else {
            if(this.game.getAttacker() != this.game.getPlayerOne()){
                for(int i = 0; i < this.group.get(0).getCards().size(); i++){
                    if(e.getSource() == this.group.get(0).getCards().get(i)){
                        this.game.getDefender().selectCard(
                                this.group.get(0).getCards().get(i).getCard());    
                        this.updateUI();
                    }
                }
                for(int i = 0; i < this.group.get(1).getCards().size(); i++){
                     if(e.getSource() == this.group.get(1).getCards().get(i)){
                        this.game.getDefender().selectCard(
                                this.group.get(1).getCards().get(i).getCard());    
                        this.updateUI();
                    }
                }
            } else {
                for(int i = 0; i < this.group.get(2).getCards().size(); i++){
                    if(e.getSource() == this.group.get(2).getCards().get(i)){
                        this.game.getDefender().selectCard(
                                this.group.get(2).getCards().get(i).getCard());    
                        this.updateUI();
                    }
                }
                for(int i = 0; i < this.group.get(3).getCards().size(); i++){
                     if(e.getSource() == this.group.get(3).getCards().get(i)){
                        this.game.getDefender().selectCard(
                                this.group.get(3).getCards().get(i).getCard());    
                        this.updateUI();
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
