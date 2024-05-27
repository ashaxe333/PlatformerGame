import java.awt.*;

public class Spike extends Rectangle{

    private int[] xPoints;
    private int[] yPoints;
    private int nPoints;


    public Spike(int[] xPoints, int[] yPoints, int nPoints, int x, int y) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.nPoints = nPoints;
        this.x = x;
        this.y = y;
        this.width = GamePanel.UNIT_SIZE;
        this.height = GamePanel.UNIT_SIZE;
    }

    public void draw(Graphics g){
        g.setColor(new Color(45, 180, 0));
        g.fillPolygon(xPoints, yPoints, nPoints);
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
}
