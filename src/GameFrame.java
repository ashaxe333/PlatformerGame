import javax.swing.*;
import java.awt.*;

/**
 * Window of the game
 */
public class GameFrame extends JFrame {

    /**
     * Creates window
     */
    public GameFrame(){
        GamePanel gamePanel = new GamePanel();
        this.add(gamePanel);
        this.setBackground(new Color(10, 40, 0));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
