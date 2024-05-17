import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Cube extends Rectangle implements KeyListener {
    private int xDirection;
    private int yDirection;
    static final int fallSpeed = 5;
    static final int speed = 5;
    private int velocityUp = 0;

    private HashMap<Integer, Boolean> keyMap = new HashMap<>();


    public Cube(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = GamePanel.UNIT_SIZE*2;
        this.height = GamePanel.UNIT_SIZE*2;
        keyMap.put(KeyEvent.VK_A, false);
        keyMap.put(KeyEvent.VK_D, false);
        keyMap.put(KeyEvent.VK_W, false);
        keyMap.put(KeyEvent.VK_X, false);
    }

    public void setX(int x) {
        this.x = x;
        GamePanel.x = x;
    }

    public void setY(int y) {
        this.y = y;
        GamePanel.y = y;
    }

    public void setVelocityUp(int velocityUp) {
        this.velocityUp = velocityUp;
    }

    public int getVelocityUp() {
        return velocityUp;
    }

    public HashMap<Integer, Boolean> getKeyMap() {
        return keyMap;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }


    @Override
    public void keyPressed(KeyEvent e){
        keyMap.put(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyMap.put(e.getKeyCode(), false);
    }

    public void setXDirection(int speed){
        xDirection = speed;
    }
    public void setYDirection(int speed){
        yDirection = speed;
    }

    public boolean checkX(ArrayList<Block> blocks, int xMovement, int yMovement){
        for (Block block: blocks) {
            if(
                    (x+width+xMovement > block.x) &&
                    (x+xMovement < block.x + block.width) &&
                    (y+height+yMovement > block.y) &&
                    (y+yMovement < block.y + block.height)
            ){
                setXDirection(0);
                setYDirection(0);
                //move();
                return true;
            }
        }
        setXDirection(xMovement);
        setYDirection(yMovement);
        move();
        return false;
    }

    public boolean onGround(ArrayList<Block> blocks){
        for (Block block: blocks) {
            if(
                    y+height+fallSpeed >= block.y &&
                    y < block.y+block.height &&
                    x+width > block.x &&
                    x < block.x + block.width
            ) {
                return true;
            }
        }
        return false;
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

