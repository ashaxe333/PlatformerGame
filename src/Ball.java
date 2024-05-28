import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Ball extends Rectangle implements KeyListener {
    private int xDirection;
    private int yDirection;
    static final int fallSpeed = 5;
    static final int speed = 5;
    private boolean normalGravity = true;
    private HashMap<Integer, Boolean> keyMap = new HashMap<>();

    /**
     * creates ball on coordinates and sets all keyEvents on false
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = GamePanel.UNIT_SIZE*2;
        this.height = GamePanel.UNIT_SIZE*2;
        keyMap.put(KeyEvent.VK_A, false);
        keyMap.put(KeyEvent.VK_D, false);
        keyMap.put(KeyEvent.VK_W, false);
        keyMap.put(KeyEvent.VK_X, false);
    }

    public void setX(int x) {this.x = x;}
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return - boolean, if ball has normal gravity and falls down, or has changed gravity and falls up
     */
    public boolean isNormalGravity() {return normalGravity;}

    /**
     * Changes gravity
     * @param normalGravity - new gravity
     */
    public void setNormalGravity(boolean normalGravity) {this.normalGravity = normalGravity;}
    public HashMap<Integer, Boolean> getKeyMap() {
        return keyMap;
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e){
        keyMap.put(e.getKeyCode(), true);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        keyMap.put(e.getKeyCode(), false);
    }

    /**
     * Sets x direction
     * @param speed - speed of ball
     */
    public void setXDirection(int speed){
        xDirection = speed;
    }

    /**
     * Sets y direction
     * @param speed - fall speed of ball
     */
    public void setYDirection(int speed){
        yDirection = speed;
    }

    /**
     * Checks collisions between ball and blocks of current level
     * @param blocks - block ArrayList of current level
     * @param xMovement - speed of ball for the x-axis
     * @param yMovement - speed of ball for the y-axis
     * @return boolean if ball has collision
     */
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
                return true;
            }
        }
        setXDirection(xMovement);
        setYDirection(yMovement);
        move();
        return false;
    }

    /**
     * Checks if ball is touching ground. If yes, ball can change gravity
     * @param blocks - block ArrayList of current level
     * @return boolean if ball is touching ground
     */
    public boolean onGround(ArrayList<Block> blocks){
        for (Block block: blocks) {
            if(
                    y+height+fallSpeed >= block.y &&
                    y-fallSpeed < block.y+block.height &&
                    x+width > block.x &&
                    x < block.x+block.width
            ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sets a new coordinates using xDirection for x-axis and yDirection for y-axis
     */
    public void move(){
        x += xDirection;
        setX(x);
        y += yDirection;
        setY(y);
    }

    /**
     * Paints ball on current coordinates
     * @param g - Graphics
     */
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
    }
}