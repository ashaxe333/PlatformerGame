import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements Runnable{

    static final int GAME_WIDTH = 1200;
    static final int GAME_HEIGHT = 600;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int UNIT_SIZE = 20;
    static int x;
    static int y;
    static boolean lastCharacter = true;
    private Thread gameThread;
    private Image image;
    private Graphics graphics;
    private Cube cube;
    private Ball ball;
    static Level currentLevel = new Level();
    static Level1 level1 = new Level1();
    static Level2 level2 = new Level2();
    static Level3 level3 = new Level3();
    static Level4 level4 = new Level4();

    /**
     * Creates Game Panel and all levels
     */
    GamePanel(){
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
     * -
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void paint(Graphics g){
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    /**
     * Graphic output
     * @param g - Graphics for draw methods in each instances
     */
    public void draw(Graphics g){
        if(lastCharacter){
            cube.draw(g);
        }else {
            ball.draw(g);
        }
        currentLevel.draw(g);



/*
        //bílé čary
        for (int i = 0; i < GAME_HEIGHT/UNIT_SIZE; i++) {
            g.setColor(Color.WHITE);
            g.drawLine(0, i*UNIT_SIZE, GAME_WIDTH, i*UNIT_SIZE);
        }
        for (int i = 0; i < GAME_WIDTH/UNIT_SIZE; i++) {
            g.setColor(Color.WHITE);
            g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, GAME_HEIGHT);
        }

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
     * This method checks collisions between cube/ball X block/spike/checkpoint
     */
    public void checkCollision() {
        System.out.println(currentLevel.getCheckpoint());
        if(cube.intersects(level1.getCheckpoint())) {
            currentLevel = level2;
            System.out.println(currentLevel.getBlocks());
            newCube(currentLevel.getXStart(), currentLevel.getYStart());
        }
        if(cube.intersects(level2.getCheckpoint())) {
            currentLevel = level3;
            System.out.println(currentLevel.getBlocks());
            newCube(currentLevel.getXStart(), currentLevel.getYStart());
        }
        if(cube.intersects(level3.getCheckpoint())) {
            currentLevel = level4;
            System.out.println(currentLevel.getBlocks());
            newCube(currentLevel.getXStart(), currentLevel.getYStart());
        }

        //Cube
        if (lastCharacter) {
            if(cube.getKeyMap().get(KeyEvent.VK_A)){
                cube.checkX(currentLevel.getBlocks(), -Cube.speed, 0);
            }
            if(cube.getKeyMap().get(KeyEvent.VK_D)){
                cube.checkX(currentLevel.getBlocks(), Cube.speed, 0);
            }
            if(cube.onGround(currentLevel.getBlocks()) && cube.getKeyMap().get(KeyEvent.VK_W)){
                cube.setVelocityUp(15);
            }
            if(cube.getKeyMap().get(KeyEvent.VK_X)){
                ball.setX(cube.x);
                ball.setY(cube.y);
                ball.setNormalGravity(true);
                lastCharacter = false;
            }
            if(cube.getVelocityUp() > 0){
                if(cube.checkX(currentLevel.getBlocks(), 0, -cube.getVelocityUp())){
                    cube.setVelocityUp(0);
                }else{
                    cube.setVelocityUp(cube.getVelocityUp()-1);
                }
            }else{
                cube.checkX(currentLevel.getBlocks(), 0, Cube.fallSpeed);
            }
            if (cube.x-10 >= GAME_WIDTH || cube.x+cube.width+10 <= 0 || cube.y-10 > GAME_HEIGHT) {
                newCube(100, 500);
            }
        //Ball
        }else {
            if(ball.getKeyMap().get(KeyEvent.VK_A)){
                ball.checkX(currentLevel.getBlocks(), -Ball.speed, 0);
            }
            if(ball.getKeyMap().get(KeyEvent.VK_D)){
                ball.checkX(currentLevel.getBlocks(), Ball.speed, 0);
            }
            if(ball.isNormalGravity()){
                if(ball.onGround(currentLevel.getBlocks()) && ball.getKeyMap().get(KeyEvent.VK_W)){
                    ball.setNormalGravity(false);
                }
            }else {
                if(ball.onGround(currentLevel.getBlocks()) && ball.getKeyMap().get(KeyEvent.VK_W)){
                    ball.setNormalGravity(true);
                }
            }
            if(ball.getKeyMap().get(KeyEvent.VK_X)){
                cube.setX(ball.x);
                cube.setY(ball.y);
                lastCharacter = true;

            }
            if(ball.isNormalGravity()){
                ball.checkX(currentLevel.getBlocks(), 0, Ball.fallSpeed);

            }else {
                ball.checkX(currentLevel.getBlocks(), 0, -Ball.fallSpeed);
            }
            if (ball.x-10 >= GAME_WIDTH || ball.x+ball.width+10 <= 0 || ball.y-10 > GAME_HEIGHT) {
                newCube(100, 500);
            }
        }
    }

    /**
     * Game loop
     */
    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 100;
        double nanoSeconds = 1000000000/amountOfTicks;
        double delta = 0;
        while(true){
            long now = System.nanoTime();
            delta += (now - lastTime)/nanoSeconds;
            lastTime = now;
            if(delta >= 1){
                checkCollision();
                repaint();
                delta--;
            }
        }
    }

    public class AL extends KeyAdapter {

        public void keyPressed(KeyEvent e){
            if(lastCharacter){
                cube.keyPressed(e);
            }else {
                ball.keyPressed(e);
            }
        }
        public void keyReleased(KeyEvent e) {
            if(lastCharacter){
                cube.keyReleased(e);
            }else {
                ball.keyReleased(e);
            }
        }
        public void keyTyped(KeyEvent e) {
            if (lastCharacter){
                cube.keyTyped(e);
            }else {
                ball.keyTyped(e);
            }
        }
    }

    /*
    public void checkCollision() {
        if(cube.intersects(level1.getCheckpoint())){
            currentLevel = level2;
        }
        //Cube
        if (lastCharacter) {
            if(cube.getKeyMap().get(KeyEvent.VK_A)){
                cube.checkX(level1.getBlocks(), -Cube.speed, 0);
            }
            if(cube.getKeyMap().get(KeyEvent.VK_D)){
                cube.checkX(level1.getBlocks(), Cube.speed, 0);
            }
            if(cube.onGround(level1.getBlocks()) && cube.getKeyMap().get(KeyEvent.VK_W)){
                cube.setVelocityUp(15);
            }
            if(cube.getKeyMap().get(KeyEvent.VK_X)){
                ball.setX(cube.x);
                ball.setY(cube.y);
                ball.setNormalGravity(true);
                lastCharacter = false;
            }
            if(cube.getVelocityUp() > 0){
                if(cube.checkX(level1.getBlocks(), 0, -cube.getVelocityUp())){
                    cube.setVelocityUp(0);
                }else{
                    cube.setVelocityUp(cube.getVelocityUp()-1);
                }
            }else{
                cube.checkX(level1.getBlocks(), 0, Cube.fallSpeed);
            }
            if (cube.x-10 >= GAME_WIDTH || cube.x+cube.width+10 <= 0 || cube.y-10 > GAME_HEIGHT) {
                newCube(100, 500);
            }
        //Ball
        }else {
            if(ball.getKeyMap().get(KeyEvent.VK_A)){
                ball.checkX(level1.getBlocks(), -Ball.speed, 0);
            }
            if(ball.getKeyMap().get(KeyEvent.VK_D)){
                ball.checkX(level1.getBlocks(), Ball.speed, 0);
            }
            if(ball.isNormalGravity()){
                if(ball.onGround(level1.getBlocks()) && ball.getKeyMap().get(KeyEvent.VK_W)){
                    ball.setNormalGravity(false);
                }
            }else {
                if(ball.onGround(level1.getBlocks()) && ball.getKeyMap().get(KeyEvent.VK_W)){
                    ball.setNormalGravity(true);
                }
            }
            if(ball.getKeyMap().get(KeyEvent.VK_X)){
                cube.setX(ball.x);
                cube.setY(ball.y);
                lastCharacter = true;

            }
            if(ball.isNormalGravity()){
                ball.checkX(level1.getBlocks(), 0, Ball.fallSpeed);

            }else {
                ball.checkX(level1.getBlocks(), 0, -Ball.fallSpeed);
            }
            if (ball.x-10 >= GAME_WIDTH || ball.x+ball.width+10 <= 0 || ball.y-10 > GAME_HEIGHT) {
                newCube(100, 500);
            }
        }
    }
     */
}
