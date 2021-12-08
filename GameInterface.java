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
       int[] PlayerCardsFinal = new int[5];
    int[] computerCardsCardsFinal = new int[5];
    int[] comunityCards = new int[5];

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
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabelComputerCard4 = new javax.swing.JLabel();
        jButtonHelp = new javax.swing.JButton();
        jLabelPlayerCard1 = new javax.swing.JLabel();
        jLabelComputerCard1 = new javax.swing.JLabel();
        difficultyLevel = new javax.swing.JComboBox<>();
        jLabelPlayerCard2 = new javax.swing.JLabel();
        jLabelComputerCard2 = new javax.swing.JLabel();
        jTextFieldComputerBet1 = new javax.swing.JTextField();
        jButtonCheck = new javax.swing.JButton();
        jLabelComputerCard3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldDisplayWinner = new javax.swing.JLabel();
        jLabelCommunityCard1 = new javax.swing.JLabel();
        computerDecision3 = new javax.swing.JLabel();
        jLabelCommunityCard2 = new javax.swing.JLabel();
        jLabelPlayerName = new javax.swing.JLabel();
        jLabelCommunityCard3 = new javax.swing.JLabel();
        jLabelCommunityCard4 = new javax.swing.JLabel();
        jLabelCommunityCard5 = new javax.swing.JLabel();
        jButtonRaise = new javax.swing.JButton();
        jButtonFold = new javax.swing.JButton();
        jTextFieldRaise = new javax.swing.JTextField();
        jTextFieldPlayerBet = new javax.swing.JTextField();
        jTextFieldComputerBet = new javax.swing.JTextField();
        jButtonNewRound = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldWinner = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

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
        jLayeredPane1.add(computerBestHand, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 170, 40));

        playerBestHand.setFont(new java.awt.Font("SimSun", 2, 18)); // NOI18N
        playerBestHand.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.add(playerBestHand, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 230, 30));

        jLabel19.setFont(new java.awt.Font("SimSun", 2, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Player's best hand");
        jLayeredPane1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 190, 30));

        computerDecision.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        computerDecision.setForeground(new java.awt.Color(255, 255, 240));
        computerDecision.setText("Bot 1 Dicision");
        jLayeredPane1.add(computerDecision, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, 40));
        jLayeredPane1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, -1, -1));

        jLabel20.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Game Difficulty");
        jLayeredPane1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 150, 20));

        jLabel16.setFont(new java.awt.Font("SimSun", 2, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Computer's 2 best hand:");
        jLayeredPane1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 150, 240, 20));

        jLabelComputerCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/53.png"))); // NOI18N
        jLayeredPane1.add(jLabelComputerCard4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 70, 100));

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
        jLayeredPane1.add(jLabelPlayerCard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 70, 100));

        jLabelComputerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/53.png"))); // NOI18N
        jLayeredPane1.add(jLabelComputerCard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 70, 100));

        difficultyLevel.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        difficultyLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Easy", "Mesium", "Hard" }));
        difficultyLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                difficultyLevelActionPerformed(evt);
            }
        });
        jLayeredPane1.add(difficultyLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 100, 30));

        jLabelPlayerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelPlayerCard2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 70, 100));

        jLabelComputerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/53.png"))); // NOI18N
        jLayeredPane1.add(jLabelComputerCard2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 70, 100));

        jTextFieldComputerBet1.setEditable(false);
        jTextFieldComputerBet1.setText("0");
        jTextFieldComputerBet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldComputerBet1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jTextFieldComputerBet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 50, 30));

        jButtonCheck.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jButtonCheck.setText("Check");
        jButtonCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButtonCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, -1, -1));

        jLabelComputerCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/53.png"))); // NOI18N
        jLayeredPane1.add(jLabelComputerCard3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 70, 100));

        jLabel21.setFont(new java.awt.Font("SimSun", 2, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Computer's 1 best hand:");
        jLayeredPane1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 250, 40));

        jLabel6.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Computer 1 Cards");
        jLayeredPane1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 160, -1));

        jTextFieldDisplayWinner.setFont(new java.awt.Font("SimSun", 2, 18)); // NOI18N
        jTextFieldDisplayWinner.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.add(jTextFieldDisplayWinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 230, 30));

        jLabelCommunityCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelCommunityCard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 70, 100));

        computerDecision3.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        computerDecision3.setForeground(new java.awt.Color(255, 255, 240));
        computerDecision3.setText("Bot 2 Dicision");
        jLayeredPane1.add(computerDecision3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, 40));

        jLabelCommunityCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelCommunityCard2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 70, 100));

        jLabelPlayerName.setFont(new java.awt.Font("SimSun", 2, 18)); // NOI18N
        jLabelPlayerName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPlayerName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLayeredPane1.add(jLabelPlayerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 150, 30));

        jLabelCommunityCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelCommunityCard3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 70, 100));

        jLabelCommunityCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelCommunityCard4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, 70, 100));

        jLabelCommunityCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelCommunityCard5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 70, 100));

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
        jLayeredPane1.add(jButtonFold, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 80, -1));

        jTextFieldRaise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRaiseActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jTextFieldRaise, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 60, 20));

        jTextFieldPlayerBet.setEditable(false);
        jTextFieldPlayerBet.setText("0");
        jTextFieldPlayerBet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPlayerBetActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jTextFieldPlayerBet, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, 50, 30));

        jTextFieldComputerBet.setEditable(false);
        jTextFieldComputerBet.setText("0");
        jTextFieldComputerBet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldComputerBetActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jTextFieldComputerBet, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 50, 30));

        jButtonNewRound.setBackground(new java.awt.Color(20, 200, 100));
        jButtonNewRound.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jButtonNewRound.setText("New Round");
        jButtonNewRound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewRoundActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButtonNewRound, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 430, 200, 50));

        jLabel14.setFont(new java.awt.Font("SimSun", 2, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Winner Is:");
        jLayeredPane1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));

        jTextFieldWinner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/background.jpg"))); // NOI18N
        jLayeredPane1.add(jTextFieldWinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 840, 530));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "EASY", "MEDIUM", "HARD" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLayeredPane1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 110, 60));

        jLabel13.setText("jLabel13");
        jLayeredPane1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText(" Cards");
        jLayeredPane1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 50, -1));

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
        JFrame frame = new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame, "Confirem if you want Exit", "Exit", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
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

    private void jTextFieldRaiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRaiseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRaiseActionPerformed

    private void jButtonRaiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRaiseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRaiseActionPerformed

    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelpActionPerformed
        // TODO add your handling code here:
                JOptionPane.showMessageDialog(null, "Poker v1:\n\nEvery Player has two cards face downThroughout several betting rounds, five more cards are (eventually) dealt face up\n in the the table called community cards. Each player is free to use these community cards in combination  \nwith their cards to build a five-card poker hand.   \nCall: match the amount of the big blind \nRaise: increase the bet within the specific limits  of the game\n Check: To see the next card without raise the betting\n Fold: throw the hand away\n\n  Your mission is to construct your five-card poker hands using the best available five cards out of the seven total cards\n\"player two cards, and the community cards\". You can do that by using both your cards in combination with three community cards,\nYou have all the option of building five cards of these toal seven cards.  If there is only one player left because all other player fold\nhe/she will wine the game without having to show any cards. If two or more player left till the fivecomunity cards revealed the winer will \nbe whoever has the best hand and that go as following starting from least  hand.\n\n1. Royal flush\n2. Straight flush\n3. Four of a kind\n4. Full house\n5. Flush\n6. Straight\n7. Three of a kind\n8. Two pair\n9. Pair\n10. High Card");
    }//GEN-LAST:event_jButtonHelpActionPerformed

    private void difficultyLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_difficultyLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_difficultyLevelActionPerformed

    private void jTextFieldComputerBet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldComputerBet1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldComputerBet1ActionPerformed

    private void jButtonCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCheckActionPerformed
    public void communityCard1(int CardNum){
        jLabelCommunityCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/"+String.valueOf(CardNum)+".png")));
    }
    public void communityCard2(int CardNum){
        jLabelCommunityCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/"+String.valueOf(CardNum)+".png")));
    }
    public void communityCard3(int CardNum){
        jLabelCommunityCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/"+String.valueOf(CardNum)+".png")));
    }
    public void communityCard4(int CardNum){
        jLabelCommunityCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/"+String.valueOf(CardNum)+".png")));
    }
    public void communityCard5(int CardNum){
        jLabelCommunityCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/"+String.valueOf(CardNum)+".png")));
    }
    public void PCard1(int CardNum){
        jLabelPlayerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/"+String.valueOf(CardNum)+".png")));
    }
    
    public void PCard2(int CardNum){
        jLabelPlayerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/"+String.valueOf(CardNum)+".png")));
    }
    
    public void ComCard1(int CardNum){
        System.out.println("1Images/"+String.valueOf(CardNum)+".png");
        jLabelComputerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/"+String.valueOf(CardNum)+".png")));
    }
    
    public void ComCard2(int CardNum){
                System.out.println("2Images/"+String.valueOf(CardNum)+".png");
        jLabelComputerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/"+String.valueOf(CardNum)+".png")));
    }
    
    public void addjButtonNewRound(ActionListener listener){
        jButtonNewRound.addActionListener(listener);
    }
    
    public void addjButtonRaise(ActionListener listener){
        jButtonRaise.addActionListener(listener);
    }
    
    public void addjButtonCheck(ActionListener listener){
        jButtonCheck.addActionListener(listener);
    }
    public void addjButtonFold(ActionListener listener){
        jButtonFold.addActionListener(listener);
    }

        public void computerBestHand(String name){
        computerBestHand.setText(name);
    }
    public void playerName(String name){
        jLabelPlayerName.setText(name);
    }
    public void playerBestHand(String name){
        playerBestHand.setText(name);
    }
    public void enableBetButton(){
        jButtonRaise.setEnabled(true);
        jButtonFold.setEnabled(true);
        jTextFieldRaise.setEnabled(true);
        jButtonCheck.setEnabled(true);
    }
    public  void restbet(){
        jTextFieldPlayerBet.setText("");
        jTextFieldRaise.setText("");
        jTextFieldComputerBet1.setText("");
        jTextFieldComputerBet.setText("");
    }
    public void disableBetButton(){
        jButtonRaise.setEnabled(false);
        jButtonFold.setEnabled(false);
        jTextFieldRaise.setEnabled(false);
        jButtonCheck.setEnabled(false);
    }
    public int getPlayerBetAmount(){
        if("".equals(jTextFieldRaise.getText()))
            return 0;
        else
        return Integer.parseInt(jTextFieldRaise.getText());
    }
        public void setComputerBet(String bet){
        jTextFieldComputerBet.setText(bet);
    }
    public void setPlayerBet(String bet){
        jTextFieldPlayerBet.setText(bet);
    }    
    public void displayWinner (String text){
        jTextFieldDisplayWinner.setText(text);
    }
    
    public void setcomputerDecision(String text){
        computerDecision.setText(text);
    }
    
    public String difficultyLevel(){
        return difficultyLevel.getSelectedItem().toString();
    }
public void disable2dBot(){
jTextFieldComputerBet1.setVisible(false);
computerDecision3.setVisible(false);
jLabel16.setVisible(false);
jLabelComputerCard3.setVisible(false);
jLabelComputerCard4.setVisible(false);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel computerBestHand;
    private javax.swing.JLabel computerDecision;
    private javax.swing.JLabel computerDecision3;
    private javax.swing.JComboBox<String> difficultyLevel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCheck;
    private javax.swing.JButton jButtonFold;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JButton jButtonNewRound;
    private javax.swing.JButton jButtonRaise;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldComputerBet;
    private javax.swing.JTextField jTextFieldComputerBet1;
    private javax.swing.JLabel jTextFieldDisplayWinner;
    private javax.swing.JTextField jTextFieldPlayerBet;
    private javax.swing.JTextField jTextFieldRaise;
    private javax.swing.JLabel jTextFieldWinner;
    private javax.swing.JLabel playerBestHand;
    // End of variables declaration//GEN-END:variables
}