/**
 *
 * @author Mustafa Adam & Bach Nguyen
 */
package PokerProject;

import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameInterface extends javax.swing.JFrame {
    int[] readyDeck = new int[51]; 
    int[] PlayerCards = new int[2];
    int[] computerCards = new int[2]; 
    int[] comunityCards = new int[5];
    int[] PlayerCardsFinal = new int[5];
    int[] computerCardsCardsFinal = new int[5];
    
    public GameInterface() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jButton1 = new javax.swing.JButton();
        computerBestHand = new javax.swing.JLabel();
        playerBestHand = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        computerDecision = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabelComputerCard4 = new javax.swing.JLabel();
        jButtonHelp = new javax.swing.JButton();
        jLabelPlayerCard1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabelComputerCard1 = new javax.swing.JLabel();
        difficultyLevel = new javax.swing.JComboBox<>();
        jLabelPlayerCard2 = new javax.swing.JLabel();
        jLabelComputerCard2 = new javax.swing.JLabel();
        computerDecision1 = new javax.swing.JLabel();
        jTextFieldComputerBet1 = new javax.swing.JTextField();
        jButtonFold1 = new javax.swing.JButton();
        jLabelComputerCard3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldDisplayWinner = new javax.swing.JLabel();
        jLabelCommunityCard1 = new javax.swing.JLabel();
        computerDecision2 = new javax.swing.JLabel();
        jTextFieldComputerBet3 = new javax.swing.JTextField();
        jTextFieldComputerBet2 = new javax.swing.JTextField();
        computerDecision3 = new javax.swing.JLabel();
        jLabelCommunityCard2 = new javax.swing.JLabel();
        jLabelPlayerName = new javax.swing.JLabel();
        jLabelCommunityCard3 = new javax.swing.JLabel();
        jLabelCommunityCard4 = new javax.swing.JLabel();
        jLabelCommunityCard5 = new javax.swing.JLabel();
        jButtonRaise = new javax.swing.JButton();
        jButtonFold = new javax.swing.JButton();
        jTextFieldPlayerBet = new javax.swing.JTextField();
        jTextFieldComputerBet = new javax.swing.JTextField();
        jButtonNewRound = new javax.swing.JButton();
        jButtonCall = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldWinner = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(240, 0, 0));
        jButton1.setText("Quit Gmae");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 120, -1));

        computerBestHand.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        computerBestHand.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.add(computerBestHand, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 100, 30));

        playerBestHand.setFont(new java.awt.Font("SimSun", 2, 18)); // NOI18N
        playerBestHand.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.add(playerBestHand, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 130, 30));

        jLabel19.setFont(new java.awt.Font("SimSun", 2, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Player's best hannd:");
        jLayeredPane1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 190, 20));

        computerDecision.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        computerDecision.setForeground(new java.awt.Color(255, 255, 240));
        computerDecision.setText("Raise");
        jLayeredPane1.add(computerDecision, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, 40));

        jLabel20.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Game Difficulty");
        jLayeredPane1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 150, 20));

        jLabel16.setFont(new java.awt.Font("SimSun", 2, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Computer 2 Best Hand:");
        jLayeredPane1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 200, 20));

        jLabelComputerCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/53.png"))); // NOI18N
        jLayeredPane1.add(jLabelComputerCard4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 100, 70));

        jButtonHelp.setBackground(new java.awt.Color(0, 0, 240));
        jButtonHelp.setForeground(new java.awt.Color(240, 240, 240));
        jButtonHelp.setText("Help?");
        jButtonHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHelpActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButtonHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        jLabelPlayerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelPlayerCard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 70, 100));

        jLabel17.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText(" Cards");
        jLayeredPane1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, 80, -1));

        jLabelComputerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/53.png"))); // NOI18N
        jLayeredPane1.add(jLabelComputerCard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 100, 70));

        difficultyLevel.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        difficultyLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Easy", "Mesium", "Hard" }));
        difficultyLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                difficultyLevelActionPerformed(evt);
            }
        });
        jLayeredPane1.add(difficultyLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 150, 30));

        jLabelPlayerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelPlayerCard2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 70, 100));

        jLabelComputerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/53.png"))); // NOI18N
        jLayeredPane1.add(jLabelComputerCard2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 70, 100));

        computerDecision1.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        computerDecision1.setForeground(new java.awt.Color(255, 255, 240));
        computerDecision1.setText("Decision");
        jLayeredPane1.add(computerDecision1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 80, 40));

        jTextFieldComputerBet1.setEditable(false);
        jTextFieldComputerBet1.setText("0");
        jTextFieldComputerBet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldComputerBet1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jTextFieldComputerBet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 50, 30));

        jButtonFold1.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jButtonFold1.setText("Check");
        jButtonFold1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFold1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButtonFold1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, -1));

        jLabelComputerCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/53.png"))); // NOI18N
        jLayeredPane1.add(jLabelComputerCard3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 70, 100));

        jLabel21.setFont(new java.awt.Font("SimSun", 2, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Computer's1 Best Hand:");
        jLayeredPane1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 210, 20));

        jLabel6.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Computer 1 Cards");
        jLayeredPane1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 160, -1));

        jTextFieldDisplayWinner.setFont(new java.awt.Font("SimSun", 2, 18)); // NOI18N
        jTextFieldDisplayWinner.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.add(jTextFieldDisplayWinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 100, 30));

        jLabelCommunityCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelCommunityCard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 70, 100));

        computerDecision2.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        computerDecision2.setForeground(new java.awt.Color(255, 255, 240));
        computerDecision2.setText("Decision");
        jLayeredPane1.add(computerDecision2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 90, 40));

        jTextFieldComputerBet3.setEditable(false);
        jTextFieldComputerBet3.setText("0");
        jTextFieldComputerBet3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldComputerBet3ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jTextFieldComputerBet3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 50, 30));

        jTextFieldComputerBet2.setEditable(false);
        jTextFieldComputerBet2.setText("0");
        jTextFieldComputerBet2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldComputerBet2ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jTextFieldComputerBet2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 50, 30));

        computerDecision3.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        computerDecision3.setForeground(new java.awt.Color(255, 255, 240));
        computerDecision3.setText("Raise");
        jLayeredPane1.add(computerDecision3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, 40));

        jLabelCommunityCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelCommunityCard2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 70, 100));

        jLabelPlayerName.setFont(new java.awt.Font("SimSun", 2, 18)); // NOI18N
        jLabelPlayerName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPlayerName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLayeredPane1.add(jLabelPlayerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 150, 30));

        jLabelCommunityCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelCommunityCard3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 70, 100));

        jLabelCommunityCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelCommunityCard4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 70, 100));

        jLabelCommunityCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelCommunityCard5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 70, 100));

        jButtonRaise.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jButtonRaise.setText("Raise");
        jButtonRaise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRaiseActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButtonRaise, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 320, -1, -1));

        jButtonFold.setBackground(new java.awt.Color(240, 240, 0));
        jButtonFold.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jButtonFold.setText("Fold");
        jButtonFold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFoldActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButtonFold, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 80, -1));

        jTextFieldPlayerBet.setEditable(false);
        jTextFieldPlayerBet.setText("0");
        jTextFieldPlayerBet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPlayerBetActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jTextFieldPlayerBet, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 50, 30));

        jTextFieldComputerBet.setEditable(false);
        jTextFieldComputerBet.setText("0");
        jTextFieldComputerBet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldComputerBetActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jTextFieldComputerBet, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 50, 30));

        jButtonNewRound.setBackground(new java.awt.Color(20, 200, 100));
        jButtonNewRound.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jButtonNewRound.setText("New Round");
        jButtonNewRound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewRoundActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButtonNewRound, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, 200, 50));

        jButtonCall.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jButtonCall.setText("Call");
        jLayeredPane1.add(jButtonCall, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 80, -1));

        jLabel13.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Pot");
        jLayeredPane1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, -1));

        jTextFieldWinner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTextFieldWinner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/gameInterfaceBackground.jpg"))); // NOI18N
        jLayeredPane1.add(jTextFieldWinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 830, 540));

        jLabel14.setFont(new java.awt.Font("SimSun", 2, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Winner:");
        jLayeredPane1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 70, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText(" Cards");
        jLayeredPane1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 50, -1));

        jScrollPane2.setViewportView(jTextPane1);

        jLayeredPane1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 80, -1));

        jTextField1.setText("jTextField1");
        jLayeredPane1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        setBounds(500, 250, 846, 549);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame frame = new JFrame("Exit Game");
        if(JOptionPane.showConfirmDialog(frame, "Confirm if you want Exit", "Exit", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldPlayerBetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPlayerBetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPlayerBetActionPerformed

    private void jTextFieldComputerBetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldComputerBetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldComputerBetActionPerformed

    private void jButtonNewRoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewRoundActionPerformed

    }//GEN-LAST:event_jButtonNewRoundActionPerformed

    private void jButtonFoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFoldActionPerformed
    
    }//GEN-LAST:event_jButtonFoldActionPerformed

    private void jButtonRaiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRaiseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRaiseActionPerformed

    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelpActionPerformed
        // TODO add your handling code here:
                JOptionPane.showMessageDialog(null, "Poker v1:\n\nEvery Player has two cards face downThroughout several betting rounds, five more cards are (eventually) dealt face up\n in the the table called community cards. Each player is free to use these community cards in combination  \nwith their cards to build a five-card poker hand.   \nCall: match the amount of the big blind \nRaise: increase the bet within the specific limits  of the game\n Check: To see the next card without raise the betting\n Fold: throw the hand away\n\n  Your mission is to construct your five-card poker hands using the best available five cards out of the seven total cards\n\"player two cards, and the community cards\". You can do that by using both your cards in combination with three community cards,\nYou have all the option of building five cards of these toal seven cards.  If there is only one player left because all other player fold\nhe/she will wine the game without having to show any cards. If two or more player left till the fivecomunity cards revealed the winer will \nbe whoever has the best hand and that go as following starting from least  hand.\n\n1. Royal flush\n2. Straight flush\n3. Four of a kind\n4. Full house\n5. Flush\n6. Straight\n7. Three of a kind\n8. Two pair\n9. Pair\n10. High Card");
    }//GEN-LAST:event_jButtonHelpActionPerformed

    private void jTextFieldComputerBet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldComputerBet1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldComputerBet1ActionPerformed

    private void jButtonFold1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFold1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFold1ActionPerformed

    private void jTextFieldComputerBet2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldComputerBet2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldComputerBet2ActionPerformed

    private void jTextFieldComputerBet3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldComputerBet3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldComputerBet3ActionPerformed

    private void difficultyLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_difficultyLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_difficultyLevelActionPerformed

    public void setPlayerCard1(int cardNmuber){
        jLabelPlayerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texasholdempoker/images/"+String.valueOf(cardNmuber)+".png")));
    }
    
    public void setPlayerCard2(int cardNmuber){
        jLabelPlayerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texasholdempoker/images/"+String.valueOf(cardNmuber)+".png")));
    }
    
    public void setComputerCard1(int cardNmuber){
        jLabelComputerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texasholdempoker/images/"+String.valueOf(cardNmuber)+".png")));
    }
    
    public void setComputerCard2(int cardNmuber){
        jLabelComputerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texasholdempoker/images/"+String.valueOf(cardNmuber)+".png")));
    }
    
    public void setCommunityCard1(int cardNmuber){
        jLabelCommunityCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texasholdempoker/images/"+String.valueOf(cardNmuber)+".png")));
    }
    public void setCommunityCard2(int cardNmuber){
        jLabelCommunityCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texasholdempoker/images/"+String.valueOf(cardNmuber)+".png")));
    }
    public void setCommunityCard3(int cardNmuber){
        jLabelCommunityCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texasholdempoker/images/"+String.valueOf(cardNmuber)+".png")));
    }
    public void setCommunityCard4(int cardNmuber){
        jLabelCommunityCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texasholdempoker/images/"+String.valueOf(cardNmuber)+".png")));
    }
    public void setCommunityCard5(int cardNmuber){
        jLabelCommunityCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texasholdempoker/images/"+String.valueOf(cardNmuber)+".png")));
    }
    
    public void addjButtonNewRound(ActionListener listener){
        jButtonNewRound.addActionListener(listener);
    }
    
    public void addjButtonRaise(ActionListener listener){
        jButtonRaise.addActionListener(listener);
    }
    public void addjButtonCall(ActionListener listener){
        jButtonCall.addActionListener(listener);
    }
    public void addjButtonFold(ActionListener listener){
        jButtonFold.addActionListener(listener);
    }

    
    public void setPlayerName(String name){
        jLabelPlayerName.setText(name);
    }
    public void setPlayerBestHand(String name){
        playerBestHand.setText(name);
    }
    public void setComputerBestHand(String name){
        computerBestHand.setText(name);
    }
    
    
    
    public void disableBetButtons(){
        jButtonRaise.setEnabled(false);
        jButtonCall.setEnabled(false);
        jButtonFold.setEnabled(false);
        
//        jTextFieldRaise.setEnabled(false);
    }
    
    public void enableBetButtons(){
        jButtonRaise.setEnabled(true);
        jButtonCall.setEnabled(true);
        jButtonFold.setEnabled(true);
        
//        jTextFieldRaise.setEnabled(true);
    }
    
//    public int getPlayerBet(){
////        return Integer.parseInt(jTextFieldRaise.getText());
//    }
    
    public void setPlayerBet(String bet){
        jTextFieldPlayerBet.setText(bet);
    }
    
    public void setComputerBet(String bet){
        jTextFieldComputerBet.setText(bet);
    }
    
    public void setDisplayWinner (String text){
        jTextFieldDisplayWinner.setText(text);
    }
    
    public void setcomputerDecision(String text){
        computerDecision.setText(text);
    }
    
    public String getDifficultyLevel(){
        return difficultyLevel.getSelectedItem().toString();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel computerBestHand;
    private javax.swing.JLabel computerDecision;
    private javax.swing.JLabel computerDecision1;
    private javax.swing.JLabel computerDecision2;
    private javax.swing.JLabel computerDecision3;
    private javax.swing.JComboBox<String> difficultyLevel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCall;
    private javax.swing.JButton jButtonFold;
    private javax.swing.JButton jButtonFold1;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JButton jButtonNewRound;
    private javax.swing.JButton jButtonRaise;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCommunityCard1;
    private javax.swing.JLabel jLabelCommunityCard2;
    private javax.swing.JLabel jLabelCommunityCard3;
    private javax.swing.JLabel jLabelCommunityCard4;
    private javax.swing.JLabel jLabelCommunityCard5;
    private javax.swing.JLabel jLabelComputerCard1;
    private javax.swing.JLabel jLabelComputerCard2;
    private javax.swing.JLabel jLabelComputerCard3;
    private javax.swing.JLabel jLabelComputerCard4;
    private javax.swing.JLabel jLabelPlayerCard1;
    private javax.swing.JLabel jLabelPlayerCard2;
    public javax.swing.JLabel jLabelPlayerName;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldComputerBet;
    private javax.swing.JTextField jTextFieldComputerBet1;
    private javax.swing.JTextField jTextFieldComputerBet2;
    private javax.swing.JTextField jTextFieldComputerBet3;
    private javax.swing.JLabel jTextFieldDisplayWinner;
    private javax.swing.JTextField jTextFieldPlayerBet;
    private javax.swing.JLabel jTextFieldWinner;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel playerBestHand;
    // End of variables declaration//GEN-END:variables
}
