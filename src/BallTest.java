import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    private Ball ball1 = new Ball(1000, 60); //false false
    private Ball ball2 = new Ball(900, 500); //true true

    //blockCollision test
    private Ball ball3 = new Ball(555, 350); //false
    private Ball ball4 = new Ball(700, 250); //false
    private Ball ball5 = new Ball(700, 255); //false
    private Ball ball6 = new Ball(700, 260); //true

    //onGround test
    private Ball ball7 = new Ball(700, 260); //true
    private Ball ball8 = new Ball(700, 255); //true
    private Ball ball9 = new Ball(700, 250); //false
    private Ball ball10 = new Ball(300, 260); //false

    //inWindow test
    private Ball ball11 = new Ball(1500, 300); //false
    private Ball ball12 = new Ball(-200, 300); //false
    private Ball ball13 = new Ball(600, 1000); //false
    private Ball ball14 = new Ball(600, -200); //false

    //cubePortCollison test
    private Ball ball15 = new Ball(161, 200); //true
    private Ball ball16 = new Ball(160, 200); //false
    private Ball ball17 = new Ball(800, 800); //false
    private Ball ball18 = new Ball(200, 200); //true

    //spikeCollision test
    private Ball ball19 = new Ball(600, 520); //true
    private Ball ball20 = new Ball(570, 520); //false
    private Ball ball21 = new Ball(200, 200); //false
    private Ball ball22 = new Ball(630, 520); //false

    private Block block1 = new Block(600, 300, 600, 300);
    private Block block2 = new Block(0, 0, 100, 100);
    private Spike spike1 = new Spike(new int[]{600, 640, 620}, new int[]{560, 560, 520}, 1);
    private Spike spike2 = new Spike(new int[]{600, 640, 620}, new int[]{560, 560, 520}, 2);
    private CubePort cubePort = new CubePort(200, 200);

    @Test
    void blockCollision() {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(block1);
        blocks.add(block2);

        assertFalse(ball1.blockCollision(blocks, 5, 0));
        assertTrue(ball2.blockCollision(blocks, 0, 5));
        assertFalse(ball3.blockCollision(blocks, 5, 0));
        assertFalse(ball4.blockCollision(blocks, 5, 0));
        assertFalse(ball5.blockCollision(blocks, 0, 5));
        assertTrue(ball6.blockCollision(blocks, 0, 5));
    }

    @Test
    void spikeCollision() {
        ArrayList<Spike> spikes = new ArrayList<>();
        spikes.add(spike1);
        spikes.add(spike2);

        assertTrue(ball19.spikeCollision(spikes));
        assertFalse(ball20.spikeCollision(spikes));
        assertFalse(ball21.spikeCollision(spikes));
        assertFalse(ball22.spikeCollision(spikes));
    }

    @Test
    void cubePortCollision() {
        //assertTrue(ball15.cubePortCollision(cubePort));
        //assertFalse(ball16.cubePortCollision(cubePort));
        //assertFalse(ball17.cubePortCollision(cubePort));
        //assertTrue(ball18.cubePortCollision(cubePort));
    }

    @Test
    void onGround() {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(block1);
        blocks.add(block2);

        assertFalse(ball1.onGround(blocks));
        assertTrue(ball2.onGround(blocks));
        assertTrue(ball7.onGround(blocks));
        assertTrue(ball8.onGround(blocks));
        assertFalse(ball9.onGround(blocks));
        assertFalse(ball10.onGround(blocks));
    }

    @Test
    void inWindow() {
        assertTrue(ball1.inWindow());
        assertFalse(ball11.inWindow());
        assertFalse(ball12.inWindow());
        assertFalse(ball13.inWindow());
        assertFalse(ball14.inWindow());
    }
}