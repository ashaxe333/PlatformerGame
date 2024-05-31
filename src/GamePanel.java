import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * GamePanel Creates Graphic output of the game
 */
public class GamePanel extends JPanel implements Runnable{

    static final int GAME_WIDTH = 1200;
    static final int GAME_HEIGHT = 600;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int UNIT_SIZE = 20;
    private boolean lastCharacter = true;
    private Thread gameThread;
    private Image image;
    private Graphics graphics;
    private Cube cube;
    private Ball ball;
    private Level currentLevel;
    private Level1 level1 = new Level1();
    private Level2 level2 = new Level2();
    private Level3 level3 = new Level3();
    private Level4 level4 = new Level4();
    private int help = 1;
    private boolean lastCheckpoint = false;

    /**
     * Creates Game Panel, all levels and endscreen and starts game thread
     */
    public GamePanel(){
        level1.createBlocks();
        level2.createBlocks();
        level3.createBlocks();
        level4.createBlocks();
        level1.createSpikes();
        level2.createSpikes();
        level3.createSpikes();
        level4.createSpikes();
        newCube(level1.getXStart(), level1.getYStart());
        newBall(cube.x, cube.y);
        currentLevel = level1;

        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);
        this.setBackground(new Color(10, 40, 0));

        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Creates a new Cube
     * @param x - x coordinate of the new Cube
     * @param y - y coordinate of the new Cube
     */
    public void newCube(int x, int y){
        cube = new Cube(x, y);
    }

    /**
     * Creates a new Ball
     * @param x - x coordinate of the new Ball
     * @param y - y coordinate of the new Ball
     */
    public void newBall(int x, int y){
        ball = new Ball(x, y);
    }

    /**
     * Draws all components
     * <a href="https://www.youtube.com/watch?v=oLirZqJFKPE&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=98">...</a>
     * @param g the <code>Graphics</code> context in which to paint
     */
    public void paint(Graphics g){
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    /**
     * Graphic output
     * @param g - Graphics for methods "draw" of each instance
     */
    public void draw(Graphics g){
        if(lastCharacter){
            cube.draw(g);
        }else {
            ball.draw(g);
        }
        currentLevel.draw(g);
        if(lastCheckpoint){
            endScreen(g);
        }

/*
        //effect
        Random random = new Random();
        Graphics2D g2D = (Graphics2D)g;
        for (int i = 0; i < GAME_HEIGHT/UNIT_SIZE; i++) {
            g2D.setColor(new Color(40, 160, 0));
            g2D.setStroke(new BasicStroke(random.nextInt(7)+1));
            g2D.drawLine(0, i*UNIT_SIZE*2-(random.nextInt(21)-10), GAME_WIDTH, i*UNIT_SIZE*2-(random.nextInt(21)-10));
        }
*/

    }

    /**
     * Checks collisions between cube/ball X block/spike/checkpoint
     */
    public void checkCollision() throws InterruptedException {
        switch (help){
            case 1:
                if(cube.intersects(currentLevel.getCheckpoint()) || ball.intersects(currentLevel.getCheckpoint())) {
                    Thread.sleep(500);
                    help = 2;
                    currentLevel = level2;
                    lastCharacter = currentLevel.baseCharakter;
                    ball.setNormalGravity(true);
                    newBall(currentLevel.getXStart(), currentLevel.getYStart());
                }
            case 2:
                if(cube.intersects(currentLevel.getCheckpoint()) || ball.intersects(currentLevel.getCheckpoint())) {
                    Thread.sleep(500);
                    help = 3;
                    currentLevel = level3;
                    lastCharacter = currentLevel.isBaseCharakter();
                    newCube(currentLevel.getXStart(), currentLevel.getYStart());
                }
            case 3:
                if(cube.intersects(currentLevel.getCheckpoint()) || ball.intersects(currentLevel.getCheckpoint())) {
                    Thread.sleep(500);
                    help = 4;
                    currentLevel = level4;
                    lastCharacter = currentLevel.isBaseCharakter();
                    newCube(currentLevel.getXStart(), currentLevel.getYStart());
                }
            case 4:
                if(cube.intersects(currentLevel.getCheckpoint()) || ball.intersects(currentLevel.getCheckpoint())) {
                    Thread.sleep(500);
                    lastCheckpoint = true;
                }
        }

        //Cube
        if (lastCharacter) {
            if(cube.getKeyMap().get(KeyEvent.VK_A)){
                cube.blockCollision(currentLevel.getBlocks(), -Cube.speed, 0);
            }
            if(cube.getKeyMap().get(KeyEvent.VK_D)){
                cube.blockCollision(currentLevel.getBlocks(), Cube.speed, 0);
            }
            if(cube.onGround(currentLevel.getBlocks()) && cube.getKeyMap().get(KeyEvent.VK_W)){
                cube.setVelocityUp(14);
            }
            if(cube.getVelocityUp() > 0){
                if(cube.blockCollision(currentLevel.getBlocks(), 0, -cube.getVelocityUp())){
                    cube.setVelocityUp(0);
                }else{
                    cube.setVelocityUp(cube.getVelocityUp()-1);
                }
            }else{
                cube.blockCollision(currentLevel.getBlocks(), 0, Cube.fallSpeed);
            }
            if(currentLevel.getBallPort() != null && cube.ballPortCollision(currentLevel.getBallPort())){
                cube.getKeyMap().put(KeyEvent.VK_A, false);
                cube.getKeyMap().put(KeyEvent.VK_D, false);
                ball.setX(cube.x);
                ball.setY(cube.y);
                ball.setNormalGravity(true);
                lastCharacter = false;
            }
            if(!cube.inWindow()){
                Thread.sleep(500);
                lastCharacter = currentLevel.isBaseCharakter();
                if(lastCharacter){
                    newCube(currentLevel.getXStart(), currentLevel.getYStart());
                }else {
                    newBall(currentLevel.getXStart(), currentLevel.getYStart());
                }
            }
            if(cube.spikeCollision(currentLevel.getSpikes())){
                Thread.sleep(500);
                lastCharacter = currentLevel.isBaseCharakter();
                if(lastCharacter){
                    newCube(currentLevel.getXStart(), currentLevel.getYStart());
                }else {
                    newBall(currentLevel.getXStart(), currentLevel.getYStart());
                }
            }

        //Ball
        }else {
            if(ball.getKeyMap().get(KeyEvent.VK_A)){
                ball.blockCollision(currentLevel.getBlocks(), -Ball.speed, 0);
            }
            if(ball.getKeyMap().get(KeyEvent.VK_D)){
                ball.blockCollision(currentLevel.getBlocks(), Ball.speed, 0);
            }
            if(ball.isNormalGravity()){
                if(ball.onGround(currentLevel.getBlocks()) && ball.getKeyMap().get(KeyEvent.VK_W)){
                    ball.setNormalGravity(false);
                    ball.getKeyMap().put(KeyEvent.VK_W, false);
                }
            }else {
                if(ball.onGround(currentLevel.getBlocks()) && ball.getKeyMap().get(KeyEvent.VK_W)){
                    ball.setNormalGravity(true);
                    ball.getKeyMap().put(KeyEvent.VK_W, false);
                }
            }
            if(ball.isNormalGravity()){
                ball.blockCollision(currentLevel.getBlocks(), 0, Ball.fallSpeed);

            }else {
                ball.blockCollision(currentLevel.getBlocks(), 0, -Ball.fallSpeed);
            }
            if(currentLevel.getCubePort() != null && ball.cubePortCollision(currentLevel.getCubePort())){
                ball.getKeyMap().put(KeyEvent.VK_A, false);
                ball.getKeyMap().put(KeyEvent.VK_D, false);
                cube.setX(ball.x);
                cube.setY(ball.y);
                lastCharacter = true;
            }
            if(!ball.inWindow()){
                Thread.sleep(500);
                lastCharacter = currentLevel.isBaseCharakter();
                if(lastCharacter){
                    newCube(currentLevel.getXStart(), currentLevel.getYStart());
                }else {
                    newBall(currentLevel.getXStart(), currentLevel.getYStart());
                }
            }
            if (ball.spikeCollision(currentLevel.getSpikes())) {
                Thread.sleep(500);
                lastCharacter = currentLevel.isBaseCharakter();
                if(lastCharacter){
                    newCube(currentLevel.getXStart(), currentLevel.getYStart());
                }else {
                    newBall(currentLevel.getXStart(), currentLevel.getYStart());
                }
            }
        }
    }

    /**
     * Paints string at the end
     * @param g - Graphics for painting
     */
    public void endScreen(Graphics g){
        g.setColor(Color.WHITE);
        Font font = new Font("Calibri", Font.BOLD, 120);
        g.setFont(font);
        FontMetrics fontMetrics = getFontMetrics(font);
        g.drawString("YOU WIN!", (GAME_WIDTH - fontMetrics.stringWidth("YOU WIN!"))/2, GAME_HEIGHT/2 + 60);
    }


    /**
     * Game loop
     * <a href="https://www.youtube.com/watch?v=oLirZqJFKPE&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=98">...</a>
     */
    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 100;
        double nanoSeconds = 1000000000/amountOfTicks;
        double delta = 0;
        while(!lastCheckpoint){
            long now = System.nanoTime();
            delta += (now - lastTime)/nanoSeconds;
            lastTime = now;
            if(delta >= 1){
                try {
                    checkCollision();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                repaint();
                delta--;
            }
        }
    }

    /**
     * Inner class - Listens to keyboard
     */
    public class AL extends KeyAdapter {

        /**
         * Checks if player pressed key
         * @param e the event to be processed
         */
        public void keyPressed(KeyEvent e){
            if(lastCharacter){
                cube.keyPressed(e);
            }else {
                ball.keyPressed(e);
            }
        }

        /**
         * Checks if player released key
         * @param e the event to be processed
         */
        public void keyReleased(KeyEvent e) {
            if(lastCharacter){
                cube.keyReleased(e);
            }else {
                ball.keyReleased(e);
            }
        }
    }
}
