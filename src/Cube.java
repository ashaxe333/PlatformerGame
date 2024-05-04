import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Cube extends Rectangle implements KeyListener {
    private int xDirection;
    private int yDirection;
    static final int fallSpeed = 10;
    private int lastPressed;

    public Cube(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = GamePanel.UNIT_SIZE*2;
        this.height = GamePanel.UNIT_SIZE*2;
    }

    public void setX(int x) {
        this.x = x;
        GamePanel.x = x;
    }

    public void setY(int y) {
        this.y = y;
        GamePanel.y = y;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        /*
        if(e.getKeyCode() == KeyEvent.VK_W){
            switch (lastPressed){
                case KeyEvent.VK_A:
                    setX(x-portLength);
                    move();
                    break;
                case KeyEvent.VK_D:
                    setX(x+portLength);
                    move();
                    break;
            }
        }
        */
    }


    @Override
    public void keyPressed(KeyEvent e){

        int speed = 5;

        if(e.getKeyCode() == KeyEvent.VK_A){
            setXDirection(-speed);
            setLastPressed(KeyEvent.VK_A);
            move();
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            setXDirection(speed);
            setLastPressed(KeyEvent.VK_D);
            move();
        }
        if(e.getKeyCode() == KeyEvent.VK_W){

            int portLength = width * 3;

            switch (lastPressed){
                case KeyEvent.VK_A:
                    setX(x - portLength);
                    move();
                    break;
                case KeyEvent.VK_D:
                    setX(x + portLength);
                    move();
                    break;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_X){
            GamePanel.lastCharacter = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A){
            setXDirection(0);
            move();
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            setXDirection(0);
            move();
        }
    }

    public void setXDirection(int speed){
        xDirection = speed;
    }
    public void setYDirection(int speed){
        yDirection = speed;
    }

    public void setLastPressed(int keyEvent){
        lastPressed = keyEvent;
    }

    public void move(){
        x += xDirection;
        setX(x);
        y += yDirection;
        setY(y);
    }

    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }
}

