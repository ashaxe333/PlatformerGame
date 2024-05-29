import java.awt.*;

/**
 * If player touches Checpoint, current level will be changed to another one
 */
public class Checkpoint extends Rectangle{

    /**
     * Creates Checkpoint on x and y coordinate with width and height 20
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public Checkpoint(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = GamePanel.UNIT_SIZE;
        this.height = GamePanel.UNIT_SIZE;
    }

    /**
     * Paints Checkpoint
     * @param g - Graphics for painting
     */
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
    }
}
