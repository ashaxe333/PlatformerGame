import java.awt.*;

public class Checkpoint extends Rectangle{

    private boolean tauched = false;

    public Checkpoint(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isTauched() {
        return tauched;
    }

    public void setTauched(boolean tauched) {
        this.tauched = tauched;
    }

    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
    }
}
