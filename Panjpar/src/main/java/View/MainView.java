/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.Panjpar;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jafet
 */
public final class MainView extends javax.swing.JFrame implements MouseListener{

    private final String helpPath;
    private final Panjpar game;
    private ArrayList<CardView> playerOne;
    private ArrayList<CardView> playerTwo;
    private ArrayList<CardView> oneTable;
    private ArrayList<CardView> twoTable;
    private ArrayList<BackCardView> back;
    private Boolean round;
    
    /**
     * Creates new form MainView
     * @param game
     */
    public MainView(Panjpar game) {
        this.round = true;
        this.game = game;
        this.helpPath = new File("src/main/img/help.png").getAbsolutePath();
        playerOne = new ArrayList<>();
        playerTwo = new ArrayList<>();
        oneTable = new ArrayList<>();
        twoTable = new ArrayList<>();
        back = new ArrayList<>();
        initComponents();
        this.setLocationRelativeTo(null);
        jPanel5.add(new CardView(this.game.getDeck().getTrumpCard()));
    }

    private MainView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void updateUI(){
       jPanel1.removeAll();
       jPanel2.removeAll();
       jPanel3.removeAll();
       jPanel4.removeAll();
       playerOne.removeAll(playerOne);
       playerTwo.removeAll(playerTwo);
       oneTable.removeAll(oneTable);
       twoTable.removeAll(twoTable);
       back.removeAll(back);
       if(round){
        if(this.game.getAttacker() == this.game.getPlayerOne()){
            for(int i = 0; i < this.game.getAttacker().getHand().size(); i++){
                playerOne.add(new CardView(this.game.getAttacker().getHand()
                        .get(i)));
                playerOne.get(i).addMouseListener(this);
                jPanel1.add(playerOne.get(i));
            }
            for(int i = 0; i < this.game.getAttacker().getTable().size(); i++){
                oneTable.add(new CardView(this.game.getAttacker().getTable()
                        .get(i)));
                oneTable.get(i).addMouseListener(this);
                jPanel2.add(oneTable.get(i));
            }
            for(int i = 0; i < this.game.getDefender().getHand().size(); i++){
                back.add(new BackCardView());
                jPanel4.add(back.get(i));
            }
        } else {
            for(int i = 0; i < this.game.getAttacker().getHand().size(); i++){
                playerTwo.add(new CardView(this.game.getAttacker().getHand()
                        .get(i)));
                playerTwo.get(i).addMouseListener(this);
                jPanel4.add(playerTwo.get(i));
            }
            for(int i = 0; i < this.game.getAttacker().getTable().size(); i++){
                twoTable.add(new CardView(this.game.getAttacker().getTable()
                        .get(i)));
                twoTable.get(i).addMouseListener(this);
                jPanel3.add(oneTable.get(i));
            }
            for(int i = 0; i < this.game.getDefender().getHand().size(); i++){
                back.add(new BackCardView());
                jPanel1.add(back.get(i));
            }
        }
       } else {
        if(this.game.getAttacker() == this.game.getPlayerOne()){
            for(int i = 0; i < this.game.getDefender().getHand().size(); i++){
                playerTwo.add(new CardView(this.game.getDefender().getHand()
                        .get(i)));
                playerTwo.get(i).addMouseListener(this);
                jPanel4.add(playerTwo.get(i));
            }
            for(int i = 0; i < this.game.getDefender().getTable().size(); i++){
                twoTable.add(new CardView(this.game.getDefender().getTable()
                        .get(i)));
                twoTable.get(i).addMouseListener(this);
                jPanel3.add(twoTable.get(i));
            }
            for(int i = 0; i < this.game.getAttacker().getTable().size(); i++){
                oneTable.add(new CardView(this.game.getAttacker().getTable()
                        .get(i)));
                oneTable.get(i).addMouseListener(this);
                jPanel2.add(oneTable.get(i));
            }
            for(int i = 0; i < this.game.getAttacker().getHand().size(); i++){
                back.add(new BackCardView());
                jPanel1.add(back.get(i));
            }
        } else {
            for(int i = 0; i < this.game.getDefender().getHand().size(); i++){
                playerOne.add(new CardView(this.game.getDefender().getHand()
                        .get(i)));
                playerOne.get(i).addMouseListener(this);
                jPanel1.add(playerOne.get(i));
            }
            for(int i = 0; i < this.game.getDefender().getTable().size(); i++){
                oneTable.add(new CardView(this.game.getDefender().getTable()
                        .get(i)));
                oneTable.get(i).addMouseListener(this);
                jPanel2.add(oneTable.get(i));
            }
            for(int i = 0; i < this.game.getAttacker().getTable().size(); i++){
                twoTable.add(new CardView(this.game.getAttacker().getTable()
                        .get(i)));
                twoTable.get(i).addMouseListener(this);
                jPanel3.add(twoTable.get(i));
            }
            for(int i = 0; i < this.game.getAttacker().getHand().size(); i++){
                back.add(new BackCardView());
                jPanel4.add(back.get(i));
            }
        }
       }
       this.validate();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panjpar");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new java.awt.GridLayout(1, 5, 2, 2));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(new java.awt.GridLayout(1, 5, 2, 2));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 102));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new java.awt.GridLayout(1, 15, 2, 2));
        jScrollPane1.setViewportView(jPanel1);

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(new java.awt.GridLayout(1, 15, 2, 2));
        jScrollPane2.setViewportView(jPanel4);

        jButton1.setIcon(new javax.swing.ImageIcon(this.helpPath));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(33, 33, 33)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(70, 70, 70)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(120, 120, 120))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        round = !round;
        updateUI();
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        for(int i = 0; i < playerOne.size(); i++){
            if(e.getSource() == playerOne.get(i)){
                System.out.println("Carta Player 1: "+playerOne.get(i).getCard().toString());
            }
        }
        for(int i = 0; i < playerTwo.size(); i++){
            if(e.getSource() == playerTwo.get(i)){
                System.out.println("Carta Player 2: "+playerTwo.get(i).getCard().toString());
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
