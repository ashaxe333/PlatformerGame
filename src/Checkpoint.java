import java.awt.*;

public class Checkpoint extends Rectangle{

    private boolean tauched = false;

    public Checkpoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isTauched() {
        return tauched;
    }

    public void setTauched(boolean tauched) {
        this.tauched = tauched;
    }

    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x, y, 20, 20);
    }
}
