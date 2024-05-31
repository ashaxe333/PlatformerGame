import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CubeTest {


    private Cube cube1 = new Cube(1000, 60); //false false
    private Cube cube2 = new Cube(900, 500); //true true

    //blockCollision test
    private Cube cube3 = new Cube(555, 350); //false
    private Cube cube4 = new Cube(700, 250); //false
    private Cube cube5 = new Cube(700, 255); //false
    private Cube cube6 = new Cube(700, 260); //true

    //onGround test
    private Cube cube7 = new Cube(700, 260); //true
    private Cube cube8 = new Cube(700, 255); //true
    private Cube cube9 = new Cube(700, 250); //false
    private Cube cube10 = new Cube(300, 260); //false

    //inWindow test
    private Cube cube11 = new Cube(1500, 300); //false
    private Cube cube12 = new Cube(-200, 300); //false
    private Cube cube13 = new Cube(600, 1000); //false
    private Cube cube14 = new Cube(600, -200); //false

    //ballPortCollison test
    private Cube cube15 = new Cube(161, 200); //true
    private Cube cube16 = new Cube(160, 200); //false
    private Cube cube17 = new Cube(800, 800); //false
    private Cube cube18 = new Cube(200, 200); //true

    //spikeCollision test
    private Cube cube19 = new Cube(600, 520); //true
    private Cube cube20 = new Cube(570, 520); //false
    private Cube cube21 = new Cube(200, 200); //false
    private Cube cube22 = new Cube(630, 520); //false

    private Block block1 = new Block(600, 300, 600, 300);
    private Block block2 = new Block(0, 0, 100, 100);
    private Spike spike1 = new Spike(new int[]{600, 640, 620}, new int[]{560, 560, 520}, 1);
    private Spike spike2 = new Spike(new int[]{600, 640, 620}, new int[]{560, 560, 520}, 2);
    private BallPort ballPort = new BallPort(200, 200);


    @Test
    void blockCollision() {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(block1);
        blocks.add(block2);

        assertFalse(cube1.blockCollision(blocks, 5, 0));
        assertTrue(cube2.blockCollision(blocks, 0, 5));
        assertFalse(cube3.blockCollision(blocks, 5, 0));
        assertFalse(cube4.blockCollision(blocks, 5, 0));
        assertFalse(cube5.blockCollision(blocks, 0, 5));
        assertTrue(cube6.blockCollision(blocks, 0, 5));
    }

    @Test
    void spikeCollision() {
        ArrayList<Spike> spikes = new ArrayList<>();
        spikes.add(spike1);
        spikes.add(spike2);

        assertTrue(cube19.spikeCollision(spikes));
        assertFalse(cube20.spikeCollision(spikes));
        assertFalse(cube21.spikeCollision(spikes));
        assertFalse(cube22.spikeCollision(spikes));
    }

    @Test
    void ballPortCollision() {
        assertTrue(cube15.ballPortCollision(ballPort));
        assertFalse(cube16.ballPortCollision(ballPort));
        assertFalse(cube17.ballPortCollision(ballPort));
        assertTrue(cube18.ballPortCollision(ballPort));
    }

    @Test
    void onGround() {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(block1);
        blocks.add(block2);

        assertFalse(cube1.onGround(blocks));
        assertTrue(cube2.onGround(blocks));
        assertTrue(cube7.onGround(blocks));
        assertTrue(cube8.onGround(blocks));
        assertFalse(cube9.onGround(blocks));
        assertFalse(cube10.onGround(blocks));
    }

    @Test
    void inWindow() {
        assertTrue(cube1.inWindow());
        assertFalse(cube11.inWindow());
        assertFalse(cube12.inWindow());
        assertFalse(cube13.inWindow());
        assertFalse(cube14.inWindow());
    }
}