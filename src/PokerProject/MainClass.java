
package PokerProject;

/**
 *
 * @author Mustafa Adam & Bach Nguyen
 */
public class MainClass {
    
    public static void main(String[] args) {
        
        WelcomeInterface startPage = new WelcomeInterface();
        GameInterface gamePage = new GameInterface();
        
        FrameHandeler controller = new FrameHandeler(startPage, gamePage);
        
        controller.launchGame();
    }
}