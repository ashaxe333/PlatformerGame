import java.awt.*;

public class Block extends Rectangle{

    public Block(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    /**
     * Paints block
     * @param g - Graphics
     */
    public void draw(Graphics g){
        g.setColor(new Color(45, 180, 0));
        g.fillRect(x, y, width, height);
    }
}
