
package PokerProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.util.Random;
/**
 *
 * @author Mustafa Adam & Bach Nguyen
 */
public class FrameHandeler {
    
    WelcomeInterface startPage;
    GameInterface gameInt;
    int stage = 0;
    ImageIcon logo;
        CardsDealer dealer;
    HumanPlayer player;
    Bot computer;
    boolean payer2=false;
    
    public FrameHandeler(WelcomeInterface startPage, GameInterface gamePage, HumanPlayer player, Bot computer, CardsDealer dealer){
        this.logo = new ImageIcon(".//Images//ico.jgp");
        this.startPage = startPage;
        this.gameInt = gamePage;
        this.computer = computer;
        this.player = player;
        this.dealer = dealer;
        this.startPage.addjButtonStartGame(new jButtonStartGameListener());
        this.gameInt.addjButtonNewRound(new jButtonNewRoundListener());
        this.gameInt.addjButtonRaise(new jButtonRaiseListener());
        this.gameInt.addjButtonCheck(new jButtonCheckListener());
        this.gameInt.addjButtonFold(new jButtonFoldListener());
        this.gameInt.setIconImage(logo.getImage());
        this.startPage.setIconImage(logo.getImage());
        
    }
    private void hideAllCards() {
        this.gameInt.PCard1(52);
        this.gameInt.PCard2(52);
        this.gameInt.ComCard1(52);
        this.gameInt.ComCard2(52);
        this.gameInt.communityCard1(52);
        this.gameInt.communityCard2(52);
        this.gameInt.communityCard3(52);
        this.gameInt.communityCard4(52);
        this.gameInt.communityCard5(52);
    }
        private void computerPlays() {
        Random rand = new Random();
        
        this.computer.setDifficultyLevel(this.gameInt.difficultyLevel());
        
        int decision = this.computer.decide();
        
        switch(this.computer.getDifficultyLevel()){
            case "Easy":
                if(0 <= decision && decision <= 50){ // omputer Raises
                    this.gameInt.setcomputerDecision("Raise");

                    this.computer.raiseBet(rand.nextInt(100));
                    this.gameInt.setComputerBet(Integer.toString(this.computer.getBet()));
                } else if(50 < decision && decision <= 45){ //Calls
                        this.gameInt.setcomputerDecision("Call");
                } else { //Folds
                        this.disableBetButton();
                        
                        this.gameInt.setcomputerDecision("Fold");
                        this.displayWinnerAsPlayer();
                }   
                break;
            case "Medium":
                if(0 <= decision && decision <= 50){ // omputer Raises
                    this.gameInt.setcomputerDecision("Raise");

                    this.computer.raiseBet(rand.nextInt(100));
                    this.gameInt.setComputerBet(Integer.toString(this.computer.getBet()));
                } else if(50 < decision && decision <= 85){ //Calls
                        this.gameInt.setcomputerDecision("Call");
                } else { //Folds
                        this.disableBetButton();
                        this.gameInt.setcomputerDecision("Fold");
                        this.displayWinnerAsPlayer();
                }   
                break;
            case "Hard":
                if(0 <= decision && decision <= 75){ // omputer Raises
                    this.gameInt.setcomputerDecision("Raise");

                    this.computer.raiseBet(rand.nextInt(100));
                    this.gameInt.setComputerBet(Integer.toString(this.computer.getBet()));
                } else if(75 < decision && decision <= 95){ //Calls
                        this.gameInt.setcomputerDecision("Call");
                } else { //Folds
                        this.disableBetButton();
                        this.gameInt.setcomputerDecision("Fold");
                        this.displayWinnerAsPlayer();
                }   
                break;
            default:
                break;
        }
            
    }//end of computerPlays method
        
            private void displayWinner() {
        int playerRank = this.dealer.DetermineBestHand(this.dealer.getPlayerCards(), this.dealer.getCommunityCards());
        int computerRank = this.dealer.DetermineBestHand(this.dealer.getComputerCards(), this.dealer.getCommunityCards());
        
        String winner = this.dealer.identifyWinner(playerRank, computerRank);
        
        switch(winner){
            case "Player":
               this.gameInt.displayWinner("Player Won");
               this.handOverBet("Computer"); 
               break;
            case "Computer":
               this.gameInt.displayWinner("Computer Won");
               this.handOverBet("Player"); 
               break;
            case "Draw":
               this.gameInt.displayWinner("Draw");
               break;
            default:
                break;
        }
        //
        
        //if
        
        this.gameInt.computerBestHand(this.dealer.identifyHouselast(computerRank));
        this.gameInt.playerBestHand(this.dealer.identifyHouselast(playerRank));
    }//end of displayWinner method
            //////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void handOverBet(String dec) {
        if (dec.equals("Player")){
            this.computer.raiseBet(this.player.getBet());
            this.player.setBet(0);
        } else {
            this.player.raiseBet(this.computer.getBet());
            this.computer.setBet(0);
        }
        
        this.gameInt.setComputerBet(Integer.toString(this.computer.getBet()));
        this.gameInt.setPlayerBet(Integer.toString(this.player.getBet()));
    }
    private class jButtonCheckListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        playerCheck();
        }
    }
    
    private class jButtonFoldListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
        disableBetButton();
        displayWinnerAsComputer();
        }
    }
    
    private class jButtonRaiseListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
             playerRaise(gameInt.getPlayerBetAmount());
        }
    }
    
    private class jButtonStartGameListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(" >>>>>>>>>>>>>>>>>>>>>"+startPage.numberOfPlaers());
            if(startPage.numberOfPlaers()==0)
                gameInt.disable2dBot();
            else
                payer2=true;
            startGame();
        }
    }
    
    private class jButtonNewRoundListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            newRound();
        }
    }
    
    public void launchGame(){
        this.startPage.setVisible(true);
    }
    
    public void startGame(){
        
        this.gameInt.setVisible(true);
        if(this.startPage.getName().equals("Please Enter Your Name..."))
            this.gameInt.jLabelPlayerName.setText("Anonymous User");
            else
        this.gameInt.jLabelPlayerName.setText(this.startPage.getName());
        this.disableBetButton();
        this.startPage.dispose();
    }
    
   private void disableBetButton() {
        this.gameInt.disableBetButton();
    }//end of disableBetButtons
           public void playerRaise(int bet){
        switch(this.stage){
            case 0:
                this.player.raiseBet(bet);
                this.gameInt.setPlayerBet(Integer.toString(this.player.getBet()));
                this.computerPlays();
                this.displayFlopCards();
                this.stage++;
                break;
            case 1:
                this.player.raiseBet(bet);
                this.gameInt.setPlayerBet(Integer.toString(this.player.getBet()));
                
                this.computerPlays();
                
                this.displayRiverCards();
                this.stage++;
                break;
            case 2:
                this.player.raiseBet(bet);
                this.gameInt.setPlayerBet(Integer.toString(this.player.getBet()));
                
                this.computerPlays();

                this.displayShowDownCards();
                this.stage++;
                break;
            case 3:
                this.disableBetButton();
                this.displayComputerCards();
                this.displayWinner();
                break;
            default:
                this.disableBetButton();
                this.displayWinner();
                break;
        }
    }
       private void displayWinnerAsPlayer() {
        this.gameInt.displayWinner("Player Won");
        
        this.gameInt.computerBestHand("Forfeited");
        this.gameInt.playerBestHand("Winner");

        this.handOverBet("C"); 
    }//end of displayWinnerAsPlayer
           private void displayWinnerAsComputer() {
        this.gameInt.displayWinner("Computer Won");
        
        this.gameInt.computerBestHand("Winner");
        this.gameInt.playerBestHand("Forfeited");

        this.handOverBet("P"); 
    }//end of displayWinnerAsComputer
        public void newRound(){
            this.player.setBet(0);
            this.computer.setBet(0);
        this.stage = 0;
        this.gameInt.restbet();
        this.dealer.shuffleDeck();
        this.dealer.dealCards();
        
        hideAllCards();
        
        displayPlayerCards();
        
        this.gameInt.enableBetButton();
        
        this.gameInt.setcomputerDecision("Decision");
        
    }//end of new round method
                   public void displayPlayerCards(){
        this.gameInt.PCard1(this.dealer.getPlayerCards()[0]);
        this.gameInt.PCard2(this.dealer.getPlayerCards()[1]);
    }//end of desplay player card method
        public void playerCheck(){
        switch (this.stage){
            case 0:
                this.displayFlopCards();
                this.computerPlays();

                this.stage++;
                break;
            case 1:
                this.displayRiverCards();
                this.computerPlays();
                this.stage++;
                break;
            case 2:
                this.displayShowDownCards();
                this.computerPlays();
                this.stage++;
                break;
            case 3:
                this.disableBetButton();
               this.displayWinner();
                this.displayComputerCards();
                break;
            default:
                this.displayWinner();
                this.disableBetButton();
                break;
        }
    }//end of player check method
                           public void displayComputerCards(){
        this.gameInt.ComCard1(this.dealer.getComputerCards()[0]);
        this.gameInt.ComCard2(this.dealer.getComputerCards()[1]);
    }
                               public void displayShowDownCards(){
        this.gameInt.communityCard1(this.dealer.getCommunityCards()[0]);
            this.gameInt.communityCard2(this.dealer.getCommunityCards()[1]);
            this.gameInt.communityCard3(this.dealer.getCommunityCards()[2]);
        this.gameInt.communityCard4(this.dealer.getCommunityCards()[3]);
               this.gameInt.communityCard5(this.dealer.getCommunityCards()[4]);

    }
                                   public void displayRiverCards(){
        this.gameInt.communityCard1(this.dealer.getCommunityCards()[0]);
            this.gameInt.communityCard2(this.dealer.getCommunityCards()[1]);
            this.gameInt.communityCard3(this.dealer.getCommunityCards()[2]);
        this.gameInt.communityCard4(this.dealer.getCommunityCards()[3]);
    }
                                       public void displayFlopCards(){
            this.gameInt.communityCard1(this.dealer.getCommunityCards()[0]);
            this.gameInt.communityCard2(this.dealer.getCommunityCards()[1]);
            this.gameInt.communityCard3(this.dealer.getCommunityCards()[2]);
    }
}