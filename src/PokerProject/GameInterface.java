/**
 *
 * @author Mustafa Adam & Bach Nguyen
 */
package PokerProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameInterface extends javax.swing.JFrame {

    private ArrayList<Player> playerList;
    private deck Deck;
    private cards[] theCommunityCards;
    private cards[] burnCards;
    private int smallBlind;
    private int bigBlind;
    private int pot;
    private Player dealer;
    private Player smallBlindPlayer;
    private Player bigBlindPlayer;
    private int[] betTotal;

    cards[] playersCards = new cards[2];
    cards[] bot1Cards = new cards[2];
    cards[] bot2Cards = new cards[2];
    int balanceInitial = 500;

    public GameInterface() {
        initComponents();
//        this.newPlayer = new Player(String.valueOf(PlayerName.getText()), balance, playersCards);
        this.playerList = new ArrayList<>();
        this.Deck = new deck();
        this.theCommunityCards = new cards[5];
        this.pot = 0;
        this.smallBlind = 25; //needed to start the game
        this.bigBlind = this.smallBlind * 2; // twice the amount of big blind
        this.dealer = dealer;
//        setupGame();
        Deck.shuffle();        
        cards[] playerCards = {Deck.nextCard(), Deck.nextCard()};
        cards[] bot1Cards = {Deck.nextCard(), Deck.nextCard()};
        cards[] bot2Cards = {Deck.nextCard(), Deck.nextCard()};
        Player player1 = new Player(PlayerName.getText(), balanceInitial, playerCards);
        Player bot1 = new Player("Peter", balanceInitial, bot1Cards);
        Player bot2 = new Player("Polly", balanceInitial, bot2Cards);
        
        //add each player in ArrayList to easier manage
        playerList.add(player1);
        playerList.add(bot1);
        playerList.add(bot2);
        
        
        
        setupGame();
        pot = smallBlind + bigBlind * 2;
        player1.reduceFromBalance(bigBlind);
        bot1.reduceFromBalance(bigBlind);
        bot2.reduceFromBalance(bigBlind);
        
        jTextField1.setText(String.valueOf(pot));
        //First round betting
        
        roundBetting(true);
        
        jButtonNewRound.addActionListener((ActionEvent ae) -> {            
            playerBalance.setText(String.valueOf(playerList.get(0).getBalance()));
            bot1Balance.setText(String.valueOf(playerList.get(1).getBalance()));
            bot2Balance.setText(String.valueOf(playerList.get(2).getBalance()));
            jLabelPlayerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/" + String.valueOf(playerList.get(0).getplayerCards()[0]) + ".png")));
            jLabelPlayerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/" + String.valueOf(playerList.get(0).getplayerCards()[1]) + ".png")));
//                roundBetting(true);
            

            if (theCommunityCards[4] != null) {
                
                for (int i = 0; i < 5; i++) {
                    theCommunityCards[i] = null;
                }
                jLabelCommunityCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
                jLabelCommunityCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
                jLabelCommunityCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
                jLabelCommunityCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
                jLabelCommunityCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
                jLabelPlayerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
                jLabelPlayerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
                jLabelComputerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
                jLabelComputerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
                jLabelComputerCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
                jLabelComputerCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
                Deck.reset();
                Deck.shuffle();
                
            }
        });

        jButtonRaise.addActionListener((ActionEvent ae) -> {
            raiseFunction(playerList.get(0));
            jTextField1.setText(String.valueOf(pot + Integer.parseInt(jTextFieldPlayerBet.getText())));
            jTextFieldPlayerBet.setText("0");
        });
        
        jButtonCall.addActionListener((ActionEvent ae) -> {
            callFunction(player1);            
        });
        
        jButtonFold.addActionListener((ActionEvent ae) -> { 
            foldFunction(playerList.get(0));
            whoWon();
            jLabelComputerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/" + String.valueOf(playerList.get(1).getplayerCards()[0]) + ".png")));
            jLabelComputerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/" + String.valueOf(playerList.get(1).getplayerCards()[1]) + ".png")));
            jLabelComputerCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/" + String.valueOf(playerList.get(2).getplayerCards()[0]) + ".png")));
            jLabelComputerCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/" + String.valueOf(playerList.get(2).getplayerCards()[1]) + ".png")));
            Deck.reset();
        });
        
        jButtonCheck.addActionListener((ActionEvent ae) -> {
            dealnextFlop();
            jLabelCommunityCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/" + String.valueOf(theCommunityCards[0]) + ".png")));
            jLabelCommunityCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/" + String.valueOf(theCommunityCards[1]) + ".png")));
            jLabelCommunityCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/" + String.valueOf(theCommunityCards[2]) + ".png")));
            if (theCommunityCards[3] == null && theCommunityCards[4] == null) {
                dealnextFlop();
                jLabelCommunityCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/" + String.valueOf(theCommunityCards[3]) + ".png")));
            }
            if (theCommunityCards[4] == null) {
                dealnextFlop();
                jLabelCommunityCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/" + String.valueOf(theCommunityCards[4]) + ".png")));
            }
            if (theCommunityCards[4]!=null){
                whoWon();
                jTextFieldDisplayWinner.setText(player1.getName());
                
            }
        });
        
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jButton1 = new javax.swing.JButton();
        computerBestHand = new javax.swing.JLabel();
        playerBestHand = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        computerDecision = new javax.swing.JLabel();
        jLabelComputerCard4 = new javax.swing.JLabel();
        jButtonHelp = new javax.swing.JButton();
        jLabelPlayerCard1 = new javax.swing.JLabel();
        jLabelComputerCard1 = new javax.swing.JLabel();
        jLabelPlayerCard2 = new javax.swing.JLabel();
        jLabelComputerCard2 = new javax.swing.JLabel();
        computerDecision1 = new javax.swing.JLabel();
        jTextFieldComputerBet1 = new javax.swing.JTextField();
        jButtonCheck = new javax.swing.JButton();
        jLabelComputerCard3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelCommunityCard1 = new javax.swing.JLabel();
        computerDecision2 = new javax.swing.JLabel();
        bot1Balance = new javax.swing.JTextField();
        jTextFieldComputerBet2 = new javax.swing.JTextField();
        computerDecision3 = new javax.swing.JLabel();
        jLabelCommunityCard2 = new javax.swing.JLabel();
        jLabelCommunityCard3 = new javax.swing.JLabel();
        jLabelCommunityCard4 = new javax.swing.JLabel();
        jLabelCommunityCard5 = new javax.swing.JLabel();
        jButtonRaise = new javax.swing.JButton();
        jButtonFold = new javax.swing.JButton();
        jTextFieldPlayerBet = new javax.swing.JTextField();
        bot2Balance = new javax.swing.JTextField();
        jButtonNewRound = new javax.swing.JButton();
        jButtonCall = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        playerBalance = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        PlayerName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldDisplayWinner = new javax.swing.JTextField();
        jTextFieldWinner = new javax.swing.JLabel();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton1.setText("Quit Game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 130, -1));

        computerBestHand.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        computerBestHand.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.add(computerBestHand, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 100, 30));

        playerBestHand.setFont(new java.awt.Font("SimSun", 2, 18)); // NOI18N
        playerBestHand.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.add(playerBestHand, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, 130, 30));

        jLabel19.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Player's best hand:");
        jLayeredPane1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 190, 20));

        computerDecision.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        computerDecision.setForeground(new java.awt.Color(255, 255, 240));
        computerDecision.setText("Raise Amount");
        jLayeredPane1.add(computerDecision, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, 30));

        jLabelComputerCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelComputerCard4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 70, 100));

        jButtonHelp.setBackground(new java.awt.Color(255, 153, 0));
        jButtonHelp.setForeground(new java.awt.Color(240, 240, 240));
        jButtonHelp.setText("Help?");
        jButtonHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHelpActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButtonHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        jLabelPlayerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelPlayerCard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 70, 100));

        jLabelComputerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelComputerCard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 70, 100));

        jLabelPlayerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelPlayerCard2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 70, 100));

        jLabelComputerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelComputerCard2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 70, 100));

        computerDecision1.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        computerDecision1.setForeground(new java.awt.Color(255, 255, 240));
        computerDecision1.setText("Decision");
        jLayeredPane1.add(computerDecision1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 80, 30));

        jTextFieldComputerBet1.setEditable(false);
        jTextFieldComputerBet1.setText("0");
        jTextFieldComputerBet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldComputerBet1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jTextFieldComputerBet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 50, 30));

        jButtonCheck.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jButtonCheck.setText("Check");
        jButtonCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButtonCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, -1));

        jLabelComputerCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelComputerCard3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 70, 100));

        jLabel6.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Polly's Balance");
        jLayeredPane1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 160, -1));

        jLabelCommunityCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelCommunityCard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 70, 100));

        computerDecision2.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        computerDecision2.setForeground(new java.awt.Color(255, 255, 240));
        computerDecision2.setText("Decision");
        jLayeredPane1.add(computerDecision2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 90, 30));

        bot1Balance.setEditable(false);
        bot1Balance.setText("0");
        bot1Balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot1BalanceActionPerformed(evt);
            }
        });
        jLayeredPane1.add(bot1Balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 50, 30));

        jTextFieldComputerBet2.setEditable(false);
        jTextFieldComputerBet2.setText("0");
        jTextFieldComputerBet2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldComputerBet2ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jTextFieldComputerBet2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 50, 30));

        computerDecision3.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        computerDecision3.setForeground(new java.awt.Color(255, 255, 240));
        computerDecision3.setText("Raise Amount");
        jLayeredPane1.add(computerDecision3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 30));

        jLabelCommunityCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/images/52.png"))); // NOI18N
        jLayeredPane1.add(jLabelCommunityCard2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 70, 100));

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

        jTextFieldPlayerBet.setText("0");
        jTextFieldPlayerBet.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextFieldPlayerBetInputMethodTextChanged(evt);
            }
        });
        jTextFieldPlayerBet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPlayerBetActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jTextFieldPlayerBet, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 50, 30));

        bot2Balance.setEditable(false);
        bot2Balance.setText("0");
        bot2Balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot2BalanceActionPerformed(evt);
            }
        });
        jLayeredPane1.add(bot2Balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 50, 30));

        jButtonNewRound.setBackground(new java.awt.Color(51, 153, 255));
        jButtonNewRound.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jButtonNewRound.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNewRound.setText("New Round");
        jButtonNewRound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewRoundActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButtonNewRound, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 170, 30));

        jButtonCall.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jButtonCall.setText("Call");
        jButtonCall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCallActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButtonCall, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 80, -1));

        jLabel13.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Pot");
        jLayeredPane1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, -1));

        jLabel14.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Winner:");
        jLayeredPane1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 70, 20));

        jTextField1.setText("0");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 50, -1));

        playerBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerBalanceActionPerformed(evt);
            }
        });
        jLayeredPane1.add(playerBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, 80, -1));

        jLabel1.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Player's Balance");
        jLayeredPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, -1, -1));

        PlayerName.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        PlayerName.setForeground(new java.awt.Color(255, 255, 255));
        PlayerName.setToolTipText("");
        jLayeredPane1.add(PlayerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 90, 20));

        jLabel3.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Peter's Balance");
        jLayeredPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("SimSun", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("'s Cards");
        jLayeredPane1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 80, 20));

        jTextFieldDisplayWinner.setEditable(false);
        jTextFieldDisplayWinner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDisplayWinnerActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jTextFieldDisplayWinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 80, -1));

        jTextFieldWinner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTextFieldWinner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/gameInterfaceBackground.jpg"))); // NOI18N
        jLayeredPane1.add(jTextFieldWinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 830, 540));

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
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want Exit", "Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldPlayerBetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPlayerBetActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldPlayerBetActionPerformed

    private void bot2BalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot2BalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bot2BalanceActionPerformed

    private void jButtonNewRoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewRoundActionPerformed
//        Deck.shuffle();
//        playerBalance.setText(String.valueOf(playerList.get(0).getBalance()));
//        bot1Balance.setText(String.valueOf(playerList.get(1).getBalance()));
//        bot2Balance.setText(String.valueOf(playerList.get(2).getBalance()));
//        jLabelPlayerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/" + String.valueOf(playerList.get(0).getplayerCards()[0]) + ".png")));
//        jLabelPlayerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/" + String.valueOf(playerList.get(0).getplayerCards()[1]) + ".png")));
//        roundBetting(true);
//        dealnextFlop();
//
//        jLabelCommunityCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/" + String.valueOf(theCommunityCards[0]) + ".png")));
//        jLabelCommunityCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/" + String.valueOf(theCommunityCards[1]) + ".png")));
//        jLabelCommunityCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/Images/" + String.valueOf(theCommunityCards[2]) + ".png")));
//
//        if (theCommunityCards[4] != null) {
//            for (int i = 0; i < 5; i++) {
//                theCommunityCards[i] = null;
//            }
//            jLabelCommunityCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
//            jLabelCommunityCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
//            jLabelCommunityCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
//            jLabelCommunityCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
//            jLabelCommunityCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
//            jLabelPlayerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
//            jLabelPlayerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
//            jLabelComputerCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
//            jLabelComputerCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
//            jLabelComputerCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
//            jLabelComputerCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PokerProject/comp2Images/52.png")));
//        }


    }//GEN-LAST:event_jButtonNewRoundActionPerformed


    private void jButtonFoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFoldActionPerformed
        

    }//GEN-LAST:event_jButtonFoldActionPerformed

    private void jButtonRaiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRaiseActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jButtonRaiseActionPerformed

    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelpActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Poker v1:\n\nEvery Player has two cards face down \nThroughout several betting rounds, five more cards are (eventually) dealt face up\n in the the table called community cards. Each player is free to use these community cards in combination  \nwith their cards to build a five-card poker hand.   \nCall: match the amount of the big blind \nRaise: increase the bet within the specific limits  of the game\n Check: To see the next card without raise the betting\n Fold: throw the hand away\n\n  Your mission is to construct your five-card poker hands using the best available five cards out of the seven total cards\n\"player two cards, and the community cards\". You can do that by using both your cards in combination with three community cards,\nYou have all the option of building five cards of these toal seven cards.  If there is only one player left because all other player fold\nhe/she will wine the game without having to show any cards. If two or more player left till the fivecomunity cards revealed the winer will \nbe whoever has the best hand and that go as following starting from least  hand.\n\n1. Royal flush\n2. Straight flush\n3. Four of a kind\n4. Full house\n5. Flush\n6. Straight\n7. Three of a kind\n8. Two pair\n9. Pair\n10. High Card");
    }//GEN-LAST:event_jButtonHelpActionPerformed

    private void jTextFieldComputerBet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldComputerBet1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldComputerBet1ActionPerformed

    private void jButtonCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButtonCheckActionPerformed

    private void jTextFieldComputerBet2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldComputerBet2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldComputerBet2ActionPerformed

    private void bot1BalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot1BalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bot1BalanceActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void playerBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerBalanceActionPerformed

    private void jTextFieldDisplayWinnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDisplayWinnerActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldDisplayWinnerActionPerformed

    private void jButtonCallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCallActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCallActionPerformed

    private void jTextFieldPlayerBetInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldPlayerBetInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPlayerBetInputMethodTextChanged

    public void addjButtonNewRound(ActionListener listener) {
        jButtonNewRound.addActionListener(listener);
    }

    public void addjButtonRaise(ActionListener listener) {
        jButtonRaise.addActionListener(listener);
    }

    public void addjButtonCall(ActionListener listener) {
        jButtonCall.addActionListener(listener);
    }

    public void addjButtonFold(ActionListener listener) {
        jButtonFold.addActionListener(listener);
    }

    public void setupGame() {
        this.dealer = playerList.get(0);
        if (playerList.size() == 2) {
            this.smallBlindPlayer = playerList.get(1);
            this.bigBlindPlayer = playerList.get(2);
        }
        this.betTotal = new int[playerList.size()];
        
    }

    public void roundBetting(boolean preFlop) {
        int playerIndex = this.playerList.indexOf(this.smallBlindPlayer);
        if (preFlop) {
            playerIndex = this.playerList.indexOf(this.smallBlindPlayer) + 1;
        } else {
            playerIndex = this.playerList.indexOf(this.smallBlindPlayer);
        }
        int currentIndex = playerIndex;

        //ask all players to see if they wants to fold check or call
        for (int i = 0; i < this.playerList.size(); i++) {
            currentIndex = betIndividual(currentIndex);
        }

        while (!equalBets()) {
            currentIndex = betIndividual(currentIndex);
        }
    }

    public int betIndividual(int currentIndex) {
        String callOrCheck = equalBets() ? "check" : "call"; //if all bets are the same ask user to do check or call
        showRiver();
        String playerResponse = "fold";
        if (playerResponse.toLowerCase().contains("fold")) {
            foldFunction(this.playerList.get(currentIndex));
        } else if (playerResponse.toLowerCase().contains("call")) {
            callFunction(this.playerList.get(currentIndex));
        } else if (playerResponse.toLowerCase().contains("raise")) {
            raiseFunction(this.playerList.get(currentIndex));
        }
        currentIndex++;
        if (currentIndex == this.playerList.size()) {
            currentIndex = 0; //if the index hits the size of the array then return it to zero
        }

        currentIndex++;
        if (currentIndex == this.playerList.size()) {
            currentIndex = 0; //if the index hits the size of the array then return it to zero
        }
        return currentIndex;
    }

    public void foldFunction(Player player) {
        player.setIsInGame(false);
    }

    public void callFunction(Player player) {
        int highestBet = betHighest();
        int betDifference = highestBet - (this.betTotal[this.playerList.indexOf(player)]);
        player.reduceFromBalance(betDifference);
        this.betTotal[this.playerList.indexOf(player)] += betDifference;
    }
   
    public void payOutWinner(ArrayList<Player> winner) {
        int tempWinner = this.pot / winner.size();
        for (int i = 0; i < winner.size(); i++) {
            winner.get(i).addToBalance(tempWinner);
        }
        this.pot = 0;
    }

    public void raiseFunction(Player player) {
        int raise = Integer.parseInt(jTextFieldPlayerBet.getText());
        callFunction(player);
        player.reduceFromBalance(raise);
        this.betTotal[this.playerList.indexOf(player)] += raise;
    }

    public boolean equalBets() {
        int highest = betHighest();
        for (int i = 0; i < this.betTotal.length; i++) {
            if (this.betTotal[i] > highest && this.playerList.get(i).getIsInGame()) {
                return false;
            }
        }
        return true;
    }

    public int betHighest() {
        int highestBets = 0;
        for (int i = 0; i < this.betTotal.length; i++) {
            if (this.betTotal[i] < highestBets && this.playerList.get(i).getIsInGame()) {
                highestBets = this.betTotal[i];
            }
        }
        return highestBets;
    }

    public void showRiver() {
        if (this.theCommunityCards[0] != null && this.theCommunityCards[3] == null && this.theCommunityCards[4] == null) {
//            System.out.println("The Flop:");
        } else if (this.theCommunityCards[3] != null && this.theCommunityCards[4] == null) {
//            System.out.println("The Turn:");
        } else if (this.theCommunityCards[4] != null) {
//            System.out.println("The River:");
        }
        System.out.println(Arrays.toString(this.theCommunityCards));
    }

    public void dealnextFlop() {
        if (this.theCommunityCards[0] == null) {
            this.theCommunityCards[0] = this.Deck.nextCard();
            this.theCommunityCards[1] = this.Deck.nextCard();
            this.theCommunityCards[2] = this.Deck.nextCard();
        } else if (this.theCommunityCards[3] == null) {
            this.theCommunityCards[3] = this.Deck.nextCard();
        } else if (this.theCommunityCards[4] == null) {
            this.theCommunityCards[4] = this.Deck.nextCard();
        }
        showRiver();
    }

    public void whoWon() {
        ArrayList<Player> winner = new ArrayList<>();
        winner = royalFlush();
        if (winner.size() > 0) {
            payOutWinner(winner);
            return;
        }
        winner = straightFlush();
        if (winner.size() > 0) {
            payOutWinner(winner);
            return;
        }
        winner = fourOfaKind();
        if (winner.size() > 0) {
            payOutWinner(winner);
            return;
        }
        winner = straight();
        if (winner.size() > 0) {
            payOutWinner(winner);
            return;
        }
        winner = fullHouse();
        if (winner.size() > 0) {
            payOutWinner(winner);
            return;
        }
        winner = Flush();
        if (winner.size() > 0) {
            payOutWinner(winner);
            return;
        }
        winner = straight();
        if (winner.size() > 0) {
            payOutWinner(winner);
            return;
        }
        winner = threeOfaKind();
        if (winner.size() > 0) {
            payOutWinner(winner);
            return;
        }
        winner = twoPairs();
        if (winner.size() > 0) {
            payOutWinner(winner);
            return;
        }
        winner = onePair();
        if (winner.size() > 0) {
            payOutWinner(winner);
            return;
        }
        winner = highCard();
        if (winner.size() > 0) {
            payOutWinner(winner);
        }
        System.out.println(winner);
    }

    public ArrayList<Player> royalFlush() {
        ArrayList<Player> winner = new ArrayList<>();
        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            int hearts = 0;
            int diamonds = 0;
            int spades = 0;
            int clubs = 0;
            if (currentPlayer.getIsInGame()) {
                ArrayList<Integer> currentPlayerCards = new ArrayList<>();
                ArrayList<cards> allCards = getAllCards(this.playerList.get(i));

                for (int j = 0; j < allCards.size(); j++) {
                    if (allCards.get(j).getSuit().contains("Hearts")) {
                        hearts++;
                    }
                    if (allCards.get(j).getSuit().contains("Diamonds")) {
                        diamonds++;
                    }
                    if (allCards.get(j).getSuit().contains("Spades")) {
                        spades++;
                    }
                    if (allCards.get(j).getSuit().contains("Clubs")) {
                        clubs++;
                    }
                }
                if (hearts >= 5) {
                    currentPlayerCards = getCardsSuits(allCards, "Hearts");
                } else if (diamonds >= 5) {
                    currentPlayerCards = getCardsSuits(allCards, "Diamonds");
                } else if (clubs >= 5) {
                    currentPlayerCards = getCardsSuits(allCards, "Clubs");
                } else if (spades >= 5) {
                    currentPlayerCards = getCardsSuits(allCards, "Spades");
                }

                if (currentPlayerCards.contains(10) && currentPlayerCards.contains(11)
                        && currentPlayerCards.contains(12) && currentPlayerCards.contains(13)
                        && currentPlayerCards.contains(14)) {
                    winner.add(currentPlayer);
                }
            }
        }
        return winner;
    }

    public ArrayList<Player> straightFlush() {
        ArrayList<Player> winner = new ArrayList<Player>();
        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            int hearts = 0;
            int diamonds = 0;
            int spades = 0;
            int clubs = 0;
            if (currentPlayer.getIsInGame()) {
                ArrayList<Integer> currentPlayerCards = new ArrayList<>();
                ArrayList<cards> allCards = getAllCards(this.playerList.get(i));

                for (int j = 0; j < allCards.size(); j++) {
                    if (allCards.get(j).getSuit().contains("Hearts")) {
                        hearts++;
                    }
                    if (allCards.get(j).getSuit().contains("Diamonds")) {
                        diamonds++;
                    }
                    if (allCards.get(j).getSuit().contains("Spades")) {
                        spades++;
                    }
                    if (allCards.get(j).getSuit().contains("Clubs")) {
                        clubs++;
                    }
                }
                if (hearts >= 5) {
                    currentPlayerCards = getCardsSuits(allCards, "Hearts");
                } else if (diamonds >= 5) {
                    currentPlayerCards = getCardsSuits(allCards, "Diamonds");
                } else if (clubs >= 5) {
                    currentPlayerCards = getCardsSuits(allCards, "Clubs");
                } else if (spades >= 5) {
                    currentPlayerCards = getCardsSuits(allCards, "Spades");
                }
                Collections.sort(currentPlayerCards);
                int lowestValue = 15;
                int secondHighestValue = 15;
                int thirdHighestValue = 15;
                if (currentPlayerCards.size() >= 5) {
                    lowestValue = currentPlayerCards.get(0);
                    secondHighestValue = currentPlayerCards.get(1);
                    thirdHighestValue = currentPlayerCards.get(2);
                    if (currentPlayerCards.contains(lowestValue + 1) && currentPlayerCards.contains(lowestValue + 2)
                            && currentPlayerCards.contains(lowestValue + 3) && currentPlayerCards.contains(lowestValue + 4)) {
                        winner.add(currentPlayer);
                    }
                }
                if (currentPlayerCards.size() >= 6) {
                    if (currentPlayerCards.contains(secondHighestValue + 1) && currentPlayerCards.contains(secondHighestValue + 2)
                            && currentPlayerCards.contains(secondHighestValue + 3) && currentPlayerCards.contains(secondHighestValue + 4)) {
                        winner.add(currentPlayer);
                    }
                }
                if (currentPlayerCards.size() >= 7) {
                    if (currentPlayerCards.contains(thirdHighestValue + 1)
                            && currentPlayerCards.contains(thirdHighestValue + 2)
                            && currentPlayerCards.contains(thirdHighestValue + 3)
                            && currentPlayerCards.contains(thirdHighestValue + 4)) {
                        winner.add(currentPlayer);
                    }
                }

            }
        }
        return winner;
    }

    public ArrayList<Player> Flush() {
        ArrayList<Player> winner = new ArrayList<>();
        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            int hearts = 0;
            int diamonds = 0;
            int spades = 0;
            int clubs = 0;
            if (currentPlayer.getIsInGame()) {
                ArrayList<cards> allCards = getAllCards(this.playerList.get(i));

                for (int j = 0; j < allCards.size(); j++) {
                    if (allCards.get(j).getSuit().contains("Hearts")) {
                        hearts++;
                    }
                    if (allCards.get(j).getSuit().contains("Diamonds")) {
                        diamonds++;
                    }
                    if (allCards.get(j).getSuit().contains("Spades")) {
                        spades++;
                    }
                    if (allCards.get(j).getSuit().contains("Clubs")) {
                        clubs++;
                    }
                }
                if (hearts >= 5 || diamonds >= 5 || clubs >= 5 || spades >= 5) {

                }
            }
            winner.add(currentPlayer);
        }
        return winner;
    }

    public ArrayList<Player> straight() {
        ArrayList<Player> winner = new ArrayList<>();
        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            if (currentPlayer.getIsInGame()) {
                ArrayList<cards> allCardsinPlay = getAllCards(currentPlayer);
                ArrayList<Integer> currentPlayerCards = getAllRanksofCards(allCardsinPlay);
                Collections.sort(currentPlayerCards);
                int lowestValue = 15;
                int secondHighestValue = 15;
                int thirdHighestValue = 15;
                if (currentPlayerCards.size() >= 5) {
                    lowestValue = currentPlayerCards.get(0);
                    secondHighestValue = currentPlayerCards.get(1);
                    thirdHighestValue = currentPlayerCards.get(2);
                    if (currentPlayerCards.contains(lowestValue + 1) && currentPlayerCards.contains(lowestValue + 2)
                            && currentPlayerCards.contains(lowestValue + 3) && currentPlayerCards.contains(lowestValue + 4)) {
                        winner.add(currentPlayer);
                    }
                }
                if (currentPlayerCards.size() >= 6) {
                    if (currentPlayerCards.contains(secondHighestValue + 1) && currentPlayerCards.contains(secondHighestValue + 2)
                            && currentPlayerCards.contains(secondHighestValue + 3) && currentPlayerCards.contains(secondHighestValue + 4)) {
                        winner.add(currentPlayer);
                    }
                }
                if (currentPlayerCards.size() >= 7) {
                    if (currentPlayerCards.contains(thirdHighestValue + 1) && currentPlayerCards.contains(thirdHighestValue + 2)
                            && currentPlayerCards.contains(thirdHighestValue + 3) && currentPlayerCards.contains(thirdHighestValue + 4)) {
                        winner.add(currentPlayer);
                    }
                }
            }
        }
        return winner;
    }

    public ArrayList<Player> fullHouse() {
        ArrayList<Player> winner = new ArrayList<>();
        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            if (currentPlayer.getIsInGame()) {
                int[] allRanks = new int[13];
                boolean threeSameRanks = false;
                boolean twoSameRanks = false;

                ArrayList<cards> allCards = getAllCards(this.playerList.get(i));
                for (int l = 0; l < allCards.size(); l++) {
                    allRanks[allCards.get(l).getRank() - 2]++;
                }
                for (int m = 0; m < allRanks.length; m++) {
                    if (allRanks[m] >= 3) {
                        threeSameRanks = true;
                    } else if (allRanks[m] >= 2) {
                        twoSameRanks = true;
                    }
                }
                if (threeSameRanks && twoSameRanks) {
                    winner.add(currentPlayer);
                }
            }
        }
        return winner;
    }

    public ArrayList<Player> fourOfaKind() {
        ArrayList<Player> winner = new ArrayList<>();
        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            int[] allRanks = new int[13];
            ArrayList<cards> allCards = getAllCards(this.playerList.get(i));
            for (int l = 0; l < allCards.size(); l++) {
                allRanks[allCards.get(l).getRank() - 2]++;
            }
            for (int m = 0; m < allCards.size(); m++) {
                if (allRanks[m] >= 4) {
                    winner.add(currentPlayer);
                }
            }
        }
        return winner;
    }

    public ArrayList<Player> threeOfaKind() {
        ArrayList<Player> winner = new ArrayList<>();
        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            if (currentPlayer.getIsInGame()) {
                int[] allRanks = new int[13];
                ArrayList<cards> allCards = getAllCards(currentPlayer);
                for (int j = 0; j < allCards.size(); j++) {
                    allRanks[allCards.get(j).getRank() - 2]++;
                }
                for (int k = 0; k < allRanks.length; k++) {
                    if (allRanks[k] >= 3) {
                        winner.add(currentPlayer);
                    }
                }
            }
        }
        return winner;
    }

    public ArrayList<Player> twoPairs() {
        ArrayList<Player> winner = new ArrayList<>();
        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            if (currentPlayer.getIsInGame()) {
                int[] allRanks = new int[13];
                int pairs = 0;
                ArrayList<cards> allCards = getAllCards(currentPlayer);
                for (int j = 0; j < allCards.size(); j++) {
                    allRanks[allCards.get(j).getRank() - 2]++;
                }
                for (int k = 0; k < allRanks.length; k++) {
                    if (allRanks[k] >= 2) {
                        pairs++;
                        if (pairs == 2) {
                            winner.add(currentPlayer);
                        }

                    }
                }
            }
        }
        return winner;
    }

    public ArrayList<Player> onePair() {
        ArrayList<Player> winner = new ArrayList<>();
        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            if (currentPlayer.getIsInGame()) {
                int[] allRanks = new int[13];
                ArrayList<cards> allCards = getAllCards(currentPlayer);
                for (int j = 0; j < allCards.size(); j++) {
                    allRanks[allCards.get(j).getRank() - 2]++;
                }
                for (int k = 0; k < allRanks.length; k++) {
                    if (allRanks[k] >= 2 && !winner.contains(currentPlayer)) {
                        winner.add(currentPlayer);
                    }
                }
            }
        }
        return winner;
    }

    public ArrayList<Player> highCard() {
        ArrayList<Player> winner = new ArrayList<>();
        int[][] sortedPlayersAllCards = new int[this.playerList.size()][2];
        // The first highest card
        int highestCardColTwo = 0;
        // The second highest card
        int highestCardColOne = 0;
        boolean tie = false;

        for (int i = 0; i < this.playerList.size(); i++) {
            Player currentPlayer = this.playerList.get(i);
            if (currentPlayer.getIsInGame()) {
                ArrayList<Integer> playerCurrentCards = new ArrayList<>();
                playerCurrentCards.add(currentPlayer.getplayerCards()[0].getRank());
                playerCurrentCards.add(currentPlayer.getplayerCards()[1].getRank());
                Collections.sort(playerCurrentCards);
                if (playerCurrentCards.get(1) > highestCardColTwo) {
                    highestCardColTwo = playerCurrentCards.get(1);
                    winner.clear();
                    winner.add(currentPlayer);
                    sortedPlayersAllCards = new int[this.playerList.size()][2];
                    sortedPlayersAllCards[i][0] = i;
                    sortedPlayersAllCards[i][1] = playerCurrentCards.get(0);
                } else if (playerCurrentCards.get(1) == highestCardColTwo) {
                    winner.add(currentPlayer);
                    tie = true;
                    // Saves the index of the player and the value of the players second highest card
                    sortedPlayersAllCards[i][0] = i;
                    sortedPlayersAllCards[i][1] = playerCurrentCards.get(0);
                }
            }
        }
        if (tie) {
            winner.clear();
            for (int[] sortedPlayersAllCard : sortedPlayersAllCards) {
                if (sortedPlayersAllCard[1] > highestCardColOne) {
                    highestCardColOne = sortedPlayersAllCard[1];
                }
            }
            for (int l = 0; l < sortedPlayersAllCards.length; l++) {
                if (sortedPlayersAllCards[l][1] == highestCardColOne) {
                    winner.add(this.playerList.get(l));
                }
            }
        }
        return winner;
    }

    public void disableBetButtons() {
        jButtonRaise.setEnabled(false);
        jButtonCall.setEnabled(true);
        jButtonFold.setEnabled(true);

    }

    public void disableAllButtons() {
        jButtonRaise.setEnabled(false);
        jButtonCall.setEnabled(false);
        jButtonFold.setEnabled(false);
    }

    public void enableBetButtons() {
        jButtonRaise.setEnabled(true);
        jButtonCall.setEnabled(false);
        jButtonFold.setEnabled(false);

    }

    public void disableCallButtons() {
        jButtonRaise.setEnabled(false);
        jButtonCall.setEnabled(true);
        jButtonFold.setEnabled(true);

    }

    public void enableCallButtons() {
        jButtonRaise.setEnabled(true);
        jButtonCall.setEnabled(false);
        jButtonFold.setEnabled(false);

    }

    public void disableRaiseButtons() {
        jButtonRaise.setEnabled(false);
        jButtonCall.setEnabled(true);
        jButtonFold.setEnabled(true);

    }

    public void enableRaiseButtons() {
        jButtonRaise.setEnabled(true);
        jButtonCall.setEnabled(false);
        jButtonFold.setEnabled(false);

    }

    public int getPlayerBet() {
        return Integer.parseInt(jTextFieldPlayerBet.getText());
    }

    public void setDisplayWinner(String text) {
        jTextFieldDisplayWinner.setText(text);
    }

    public ArrayList<Integer> getCardsSuits(ArrayList<cards> playerCards, String suit) {
        ArrayList<Integer> suits = new ArrayList<>();
        for (int i = 0; i < playerCards.size(); i++) {
            if (playerCards.get(i).getSuit().contains(suit)) {
                suits.add(playerCards.get(i).getRank());
            }
        }
        return suits;
    }

    public ArrayList<cards> getAllCards(Player player) {
        ArrayList<cards> allCards = new ArrayList<>();
        allCards.addAll(Arrays.asList(this.theCommunityCards));
        allCards.add(player.getplayerCards()[0]);
        allCards.add(player.getplayerCards()[1]);
        return allCards;
    }

    public ArrayList<Integer> getAllRanksofCards(ArrayList<cards> playerCardsAll) {
        ArrayList<Integer> allCardsRanks = new ArrayList<>();
        for (int i = 0; i < playerCardsAll.size(); i++) {
            allCardsRanks.add(playerCardsAll.get(i).getRank());
        }
        return allCardsRanks;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel PlayerName;
    public javax.swing.JTextField bot1Balance;
    private javax.swing.JTextField bot2Balance;
    private javax.swing.JLabel computerBestHand;
    private javax.swing.JLabel computerDecision;
    private javax.swing.JLabel computerDecision1;
    private javax.swing.JLabel computerDecision2;
    private javax.swing.JLabel computerDecision3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCall;
    private javax.swing.JButton jButtonCheck;
    private javax.swing.JButton jButtonFold;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JButton jButtonNewRound;
    private javax.swing.JButton jButtonRaise;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldComputerBet1;
    private javax.swing.JTextField jTextFieldComputerBet2;
    private javax.swing.JTextField jTextFieldDisplayWinner;
    public javax.swing.JTextField jTextFieldPlayerBet;
    private javax.swing.JLabel jTextFieldWinner;
    private javax.swing.JTextField playerBalance;
    private javax.swing.JLabel playerBestHand;
    // End of variables declaration//GEN-END:variables

}
