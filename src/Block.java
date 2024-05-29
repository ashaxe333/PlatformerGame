import java.awt.*;

/**
 * Creates Rectangle which is normal block
 */
public class Block extends Rectangle{

    /**
     * Creates block
     * @param x - x coordinate
     * @param y - y coordinate
     * @param width - width of block
     * @param height - height of block
     */
    public Block(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    /**
     * Paints block
     * @param g - Graphics for painting
     */
    public void draw(Graphics g){
        g.setColor(new Color(45, 180, 0));
        g.fillRect(x, y, width, height);
    }
}
