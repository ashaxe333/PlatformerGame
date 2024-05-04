import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ball extends Rectangle implements KeyListener {
    private int xDirection;
    private int yDirection;
    static final int fallSpeed = 10;
    private boolean normalGravity = true;

    public Ball(int x, int y) {
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
            move();
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            setXDirection(speed);
            move();
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            if (normalGravity) {
                setYDirection(-fallSpeed);
                normalGravity = false;
                move();
            }else{
                setYDirection(fallSpeed);
                normalGravity = true;
                move();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_X){
            GamePanel.lastCharacter = true;
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

    public void move(){
        x += xDirection;
        setX(x);
        y += yDirection;
        setY(y);
    }

    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
    }
}

