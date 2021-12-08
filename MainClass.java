
package PokerProject;

/**
 *
 * @author Mustafa Adam & Bach Nguyen
 */
public class MainClass {
    
    public static void main(String[] args) {
        
        WelcomeInterface startInterface = new WelcomeInterface();
        GameInterface gameInt = new GameInterface();
        CardsDealer dealer = new CardsDealer();
        Bot comp = new Bot();
        HumanPlayer player = new HumanPlayer();
        FrameHandeler controller = new FrameHandeler(startInterface, gameInt, player, comp, dealer);
        
        controller.launchGame();
    }
}