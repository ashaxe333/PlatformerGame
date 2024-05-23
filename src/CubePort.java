import java.awt.*;

public class CubePort extends Rectangle {

    public CubePort(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = GamePanel.UNIT_SIZE;
        this.height = GamePanel.UNIT_SIZE*4;
    }

    public void draw(Graphics g){
        g.setColor(new Color(255, 180, 0));
        g.fillRect(x, y, width, height);
    }
}
