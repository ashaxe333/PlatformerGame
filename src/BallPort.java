import java.awt.*;

/**
 * If cube touches this rectangle, it changes it to ball. If ball touches it, nothing will happen
 */
public class BallPort extends Rectangle{

    /**
     * Creates rectangle on x and y coordinates
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public BallPort(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = GamePanel.UNIT_SIZE;
        this.height = GamePanel.UNIT_SIZE*4;
    }

    /**
     * Paints this rectangle
     * @param g - Graphics for painting
     */
    public void draw(Graphics g){
        g.setColor(new Color(255, 60, 0));
        g.fillRect(x, y, width, height);
    }
}
