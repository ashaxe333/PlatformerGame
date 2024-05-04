import java.awt.*;

public class Checkpoint extends Rectangle{

    static boolean tauched = false;

    public Checkpoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static boolean isTauched() {
        return tauched;
    }

    public static void setTauched(boolean tauched) {
        Checkpoint.tauched = tauched;
    }

    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x, y, 20, 20);
    }
}
