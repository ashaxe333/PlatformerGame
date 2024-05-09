import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Cube extends Rectangle implements KeyListener {
    private int xDirection;
    private int yDirection;
    static final int fallSpeed = 5;
    static final int speed = 5;
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
    }


    @Override
    public void keyPressed(KeyEvent e){

        if(e.getKeyCode() == KeyEvent.VK_A){
            //leftXRight(GamePanel.level1.getBlocks());
            setXDirection(-speed);
            setLastPressed(KeyEvent.VK_A);
            move();
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            //rightXLeft(GamePanel.level1.getBlocks());
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
            keyReleased(e);
        }
        if(e.getKeyCode() == KeyEvent.VK_X){
            GamePanel.lastCharacter = false;
        }

        //testovací
        if(e.getKeyCode() == KeyEvent.VK_P){
            setYDirection(-4*fallSpeed);
            move();
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


    /*
    public void rightXLeft(ArrayList<Block> blocks){
        for (Block block: blocks) {
            //pravá strana charakteru X levá strana bloku
            if(((x+width >= block.x) && (x < block.x+block.width)) && ((y+height >= block.y) && (y <= block.y+block.height))){
                setXDirection(0);
                break;
            }else {
                setXDirection(speed);
            }
        }
    }

    public void leftXRight(ArrayList<Block> blocks){
        for (Block block: blocks) {
            //levá strana charakteru X pravá strana bloku
            if(((x <= block.x+block.width) && (x+width >= block.x)) && ((y+height >= block.y) && (y <= block.y+block.height))){
                setXDirection(0);
                break;
            }else {
                setXDirection(-speed);
            }
        }
    }

     */

    public void myIntersects(ArrayList<Block> blocks){
        for (Block block: blocks) {
            //spodní strana charakteru X horní strana bloku
            if(((y+height >= block.y) && (y <= block.y+block.height)) && ((x+width >= block.x) && (x <= block.x+block.width))){
                setYDirection(0);
                break;
            }else {
                setYDirection(Cube.fallSpeed);
            }
        }
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

