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
    static Level1 level1 = new Level1();

    GamePanel(){
        newCube(100, 100);
        newBall(cube.x, cube.y);
        level1.createBlocks();
        level1.createSpikes();
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);
        this.setBackground(new Color(10, 40, 0));

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newCube(int x, int y){
        cube = new Cube(x, y);
    }


    public void newBall(int x, int y){
        ball = new Ball(x, y);
    }


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
        //System.out.println(level1.getBlocks());
        //System.out.println(level1.getBlocks().size());
        System.out.println(cube.x);
        //System.out.println(cube.y);
        if (lastCharacter) {
            //bloky
            cube.gravity(level1.getBlocks());
            //strany okna
            if (cube.x - 10 == GAME_WIDTH || cube.x + cube.width + 10 == 0) {
                newCube(300, 300);
            }
        //Ball
        }else {

        }
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
