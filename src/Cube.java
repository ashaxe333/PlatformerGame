import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is first of two player characters. This one can jump
 */
public class Cube extends Rectangle implements KeyListener {
    private int xDirection;
    private int yDirection;
    static final int fallSpeed = 5;
    static final int speed = 5;
    private int velocityUp = 0;

    /**
     * This HashMap contains all game Key Events and their boolean values if they are in use or not
     */
    private HashMap<Integer, Boolean> keyMap = new HashMap<>();

    /**
     * creates cube on coordinates and sets all keyEvents on false (not in use)
     * @param x - x coordinate
     * @param y - y coordinate
     */
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
    }
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Sets up velocity for jump
     * @param velocityUp - jump height
     */
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
    public void keyTyped(KeyEvent e) {}

    /**
     * If the key is pressed, value in keyMap will sets on true (key is in use)
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e){
        keyMap.put(e.getKeyCode(), true);
    }

    /**
     * If the key is released, value in keyMap will sets on false (key is not in use)
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keyMap.put(e.getKeyCode(), false);
    }

    /**
     * Sets x direction
     * @param speed - speed of cube
     */
    public void setXDirection(int speed){
        xDirection = speed;
    }

    /**
     * Sets y direction
     * @param speed - fall speed of cube
     */
    public void setYDirection(int speed){
        yDirection = speed;
    }

    /**
     * Checks collisions between cube and blocks of current level
     * @param blocks - block ArrayList of current level
     * @param xMovement - speed of cube for the x-axis
     * @param yMovement - speed of cube for the y-axis
     * @return boolean if cube has collision
     */
    public boolean blockCollision(ArrayList<Block> blocks, int xMovement, int yMovement){
        for (Block block: blocks) {
            if(
                    x+width+xMovement > block.x &&
                    x+xMovement < block.x + block.width &&
                    y+height+yMovement > block.y &&
                    y+yMovement < block.y + block.height
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
     * Checks if cube touches one of spikes of current level
     * @param spikes - spike ArrayList of current level
     * @return - boolean if cube touched spike
     */
    public boolean spikeCollision(ArrayList<Spike> spikes){
        for (Spike spike: spikes) {
            if(this.intersects(spike)){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if cube touches ballPort of current level
     * @param ballPorts - ballPort ArrayList of current level
     * @return - boolean if cube touched ballPort
     */
    public boolean ballPortCollision(ArrayList<BallPort> ballPorts){
        boolean x = false;
        if(ballPorts.isEmpty()){
        }else {
            for (BallPort ballPort: ballPorts) {
                if(this.intersects(ballPort)){
                    x = true;
                }
            }
        }
        return x;
    }

    /**
     * Checks if cube is touching ground. If yes, cube can jump
     * @param blocks - block ArrayList of current level
     * @return boolean if cube is touching ground
     */
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

    /**
     * @return boolean if cube is in game window
     */
    public boolean inWindow(){
        if (this.x-10 >= GamePanel.GAME_WIDTH || this.x+this.width+10 <= 0 || this.y-10 > GamePanel.GAME_HEIGHT || this.y+this.height+10 <= 0) {
            return false;
        }
        return true;
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
     * Paints cube on current coordinates
     * @param g - Graphics for painting
     */
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }
}

