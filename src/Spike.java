import java.awt.*;

public class Spike extends Rectangle{

    private int[] xPoints;
    private int[] yPoints;
    private int nPoints;


    public Spike(int[] xPoints, int[] yPoints, int nPoints) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.nPoints = nPoints;
    }

    public void draw(Graphics g){
        g.setColor(new Color(45, 180, 0));
        g.fillPolygon(xPoints, yPoints, nPoints);
    }
}
