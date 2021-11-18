package PokerProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
/**
 *
 * @author Mustafa Adam & Bach Nguyen
 */
public class FrameHandeler {
    
    WelcomeInterface startPage;
    GameInterface gamePage;
    int stage = 0;
    ImageIcon logo;
    
    public FrameHandeler(WelcomeInterface startPage, GameInterface gamePage){
        this.logo = new ImageIcon(".//Images//ico.jgp");
        this.startPage = startPage;
        this.gamePage = gamePage;
        
        this.startPage.addjButtonStartGame(new jButtonStartGameListener());
        this.gamePage.addjButtonNewRound(new jButtonNewRoundListener());
        this.gamePage.addjButtonRaise(new jButtonRaiseListener());
        this.gamePage.addjButtonCall(new jButtonCallListener());
        this.gamePage.addjButtonFold(new jButtonFoldListener());
        this.gamePage.setIconImage(logo.getImage());
        this.startPage.setIconImage(logo.getImage());
        
    }

    
    private class jButtonCallListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
    
    private class jButtonFoldListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
    
    private class jButtonRaiseListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
    
    private class jButtonStartGameListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            startGame();
        }
    }
    
    private class jButtonNewRoundListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
    
    public void launchGame(){
        this.startPage.setVisible(true);
    }
    
    public void startGame(){
        
        this.gamePage.setVisible(true);
        if(this.startPage.getName().equals("Please Enter Your Name..."))
            this.gamePage.jLabelPlayerName.setText("Guest User");
        else{
            this.gamePage.jLabelPlayerName.setText(this.startPage.getName());
        }
        this.startPage.dispose();
    }
    
    public void quitGame(){
        
    }
}
