import java.awt.*;

/**
 * Creates triangle with hitbox. If player touches this hitbox, player dies
 */
public class Spike extends Rectangle{

    private int[] xPoints;
    private int[] yPoints;
    private int nPoints;

    /**
     * creates a spike with hitbox
     * @param xPoints - array of x-axis of spike
     * @param yPoints - array of y-axis of spike
     * @param rotation - helps to make a hitbox
     */
    public Spike(int[] xPoints, int[] yPoints, int rotation) {
        int help1 = Integer.MAX_VALUE;
        int help2 = Integer.MIN_VALUE;
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.nPoints = 3;
        //upper/under
        if(rotation == 1 || rotation == 3){
            for (int i: xPoints) {
                if(i < help1){
                    help1 = i;
                }
            }
            this.x = help1+GamePanel.UNIT_SIZE/2;
            help1 = Integer.MAX_VALUE;
            for (int i: yPoints) {
                if(i < help1){
                    help1 = i;
                }
            }
            this.y = help1+GamePanel.UNIT_SIZE/2;
        }
        //side
        if(rotation == 2 || rotation == 4) {
            for (int i: xPoints) {
                if(i < help1){
                    help1 = i;
                }
            }
            this.x = help1+GamePanel.UNIT_SIZE/2;
            help1 = Integer.MAX_VALUE;
            for (int i: yPoints) {
                if(i < help1){
                    help1 = i;
                }
            }
            this.y = help1+GamePanel.UNIT_SIZE/2;
        }
        this.width = GamePanel.UNIT_SIZE;
        this.height = GamePanel.UNIT_SIZE;
    }

    /**
     * Paints spike
     * @param g - Graphics for painting
     */
    public void draw(Graphics g){
        g.setColor(new Color(45, 180, 0));
        g.fillPolygon(xPoints, yPoints, nPoints);
        //g.setColor(Color.BLUE);
        //g.fillRect(x, y, width, height);
    }
}
