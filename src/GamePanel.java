import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable{

    static final int GAME_WIDTH = 1200;
    static final int GAME_HEIGHT = 600;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);

    static final int UNIT_SIZE = 20;
    static int x = 100;
    static int y = 100;
    static boolean lastCharacter = false;
    private Thread gameThread;
    private Image image;
    private Graphics graphics;
    private Cube cube;
    private Ball ball;

    Level1 level1 = new Level1();
    private ArrayList<Block> blocks = new ArrayList<>();

    GamePanel(){
        start();
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);
        this.setBackground(new Color(10, 40, 0));

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void start(){
        newCube(x, y);
        newBall(x, y);
        System.out.println(cube.getX() + ", " + cube.getY());
    }

    public void newCube(int x, int y){
        cube = new Cube(x, y);
    }


    public void newBall(int x, int y){
        ball = new Ball(x, y);
    }


    /*
    public boolean switchCharakter(){
        if(lastCharacter){
            newBall(x, y);
        }else {
            newCube(x, y);
        }
        return lastCharacter;
    }
    */

    public void paint(Graphics g){
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g){
        if(lastCharacter){
            cube.draw(g);
        }else {
            ball.draw(g);
        }

        level1.draw(g);


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
            //g2D.drawLine(0, i*(random.nextInt(3)+39), GAME_WIDTH, i*(random.nextInt(3)+39)); NEFUNGUJE, WTF
            g2D.drawLine(0, i*UNIT_SIZE*2-(random.nextInt(21)-10), GAME_WIDTH, i*UNIT_SIZE*2-(random.nextInt(21)-10));
        }
        */
    }

    public void move(){
        if(lastCharacter){
            cube.move();
        }else {
            ball.move();
        }


    }

    public void checkCollision() {

        /*
        if(cube.getY()+cube.height == 560){
            cube.setYDirection(0);
        }else {
            cube.setYDirection(Cube.fallSpeed);
        }
        */


        if(lastCharacter){
            //bloky
            for (Block block: level1.getBlocks()) {
                if (cube.intersects(block)) {
                    cube.setYDirection(0);
                    break;
                } else {
                    cube.setYDirection(Cube.fallSpeed);
                }
            }
        }else {
            //bloky
            for (Block block: level1.getBlocks()) {
                if (ball.intersects(block)) {
                    ball.setYDirection(0);
                    break;
                } else {
                    ball.setYDirection(Cube.fallSpeed);
                }
            }
        }




        /*
        //strany okna
        if(cube.getX()-10 == GAME_WIDTH || cube.getX()+cube.getWidth()+10 == 0){
            newCube(300, 300);
        }

        //spiky
        for (Spike spike: level1.getSpikes()) {
            if (cube.intersects(spike)) {
                cube.setYDirection(0);
                cube.setXDirection(0);
                newCube(50, 100);
            }
        }

 */



/*
        for(int i = 0; i < blocks.size(); i++){
            if(cube.getY() + cube.getHeight() == block.getY()){
                cube.setYDirection(0);
            }else {
                cube.setYDirection(cube.getFallSpeed());
            }
        }

        }else {
            for(int i = 0; i < blocks.size(); i++){
                if(ball.getY() + ball.getHeight() == blocks.get(i).getY()){
                    ball.setYDirection(0);
                }else {
                    ball.setYDirection(ball.getFallSpeed());
                }
            }

            if(ball.getX()-10 == GAME_WIDTH || ball.getX()+ball.getWidth()+10 == 0){
                Thread.sleep(1000);
                newBall(100, 100);
            }
        }

        //Pruchody na stranach

        if(cube.getX()-10 == GAME_WIDTH){
            newCube(-50, cube.getY());
        }
        if(cube.getX()+cube.getWidth()+10 == 0){
            newCube(GAME_WIDTH, cube.getY());
        }       FUNGUJE NAPUL???
        */

    }

    public void run(){
        //game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double nanoSeconds = 1000000000/amountOfTicks;
        double delta = 0;
        while(true){
            long now = System.nanoTime();
            delta += (now - lastTime)/nanoSeconds;
            lastTime = now;
            if(delta >= 1){
                checkCollision();
                move();
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
}
