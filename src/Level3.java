import java.awt.*;
import java.util.ArrayList;

public class Level3 extends Level{

    private ArrayList<Block> blocks = new ArrayList<>();
    private ArrayList<Spike> spikes = new ArrayList<>();
    private final int xStart = 500;
    private final int yStart = 500;
    private Checkpoint checkpoint = new Checkpoint(GamePanel.UNIT_SIZE*39+GamePanel.UNIT_SIZE/2, GamePanel.UNIT_SIZE*9);
    private BallPort ballPort = new BallPort(200, 460);
    private CubePort cubePort = new CubePort(340, 300);

    public Level3() {}

    /**
     * getter for blocks
     * @return - Arraylist of blocks
     */
    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    /**
     * getter for spikes
     * @return - Arraylist of spikes
     */
    public ArrayList<Spike> getSpikes() {
        return spikes;
    }

    /**
     * getter for checkpoint
     * @return - checkpoint
     */
    public Checkpoint getCheckpoint() {
        return checkpoint;
    }

    /**
     * getter for x statring coordinate
     * @return - value of x starting coordinate
     */
    public int getXStart() {
        return xStart;
    }

    /**
     * getter for y statring coordinate
     * @return - value of y starting coordinate
     */
    public int getYStart() {
        return yStart;
    }

    @Override
    public BallPort getBallPort() {
        return ballPort;
    }

    @Override
    public CubePort getCubePort() {
        return cubePort;
    }

    /**
     * Creates blocks of the level
     */
    public void createBlocks(){
        blocks.add(new Block(0, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*30, GamePanel.UNIT_SIZE*2)); //bottom1
        blocks.add(new Block(GamePanel.UNIT_SIZE*48, GamePanel.UNIT_SIZE*28, GamePanel.GAME_WIDTH, GamePanel.UNIT_SIZE*2)); //bottom2
        blocks.add(new Block(0, 0, GamePanel.UNIT_SIZE*2, GamePanel.GAME_HEIGHT)); //left
        blocks.add(new Block(GamePanel.UNIT_SIZE*58, 0, GamePanel.UNIT_SIZE*2, GamePanel.GAME_HEIGHT)); //right
        blocks.add(new Block(0, 0, GamePanel.GAME_WIDTH, GamePanel.UNIT_SIZE*2)); //top

        //y-axis
        blocks.add(new Block(GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*2, GamePanel.GAME_HEIGHT));
        blocks.add(new Block(GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*14));
        blocks.add(new Block(GamePanel.UNIT_SIZE*16, 0, GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*14));
        blocks.add(new Block(GamePanel.UNIT_SIZE*50, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*18));

        //x-axis
        blocks.add(new Block(GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*20, GamePanel.UNIT_SIZE*20, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*24, GamePanel.UNIT_SIZE*2));

        //"stairs"
        blocks.add(new Block(GamePanel.UNIT_SIZE*26, GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE));
        blocks.add(new Block(GamePanel.UNIT_SIZE*26, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE));
        blocks.add(new Block(GamePanel.UNIT_SIZE*20, GamePanel.UNIT_SIZE*12, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE));

        //platforms
        blocks.add(new Block(GamePanel.UNIT_SIZE*33, GamePanel.UNIT_SIZE*23, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE));
        blocks.add(new Block(GamePanel.UNIT_SIZE*39, GamePanel.UNIT_SIZE*19, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE));
        blocks.add(new Block(GamePanel.UNIT_SIZE*45, GamePanel.UNIT_SIZE*15, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE));

        blocks.add(new Block(GamePanel.UNIT_SIZE*33, GamePanel.UNIT_SIZE*15, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE));
        blocks.add(new Block(GamePanel.UNIT_SIZE*39, GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE));
        blocks.add(new Block(GamePanel.UNIT_SIZE*39, GamePanel.UNIT_SIZE*27, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE));
    }

    /**
     * Creates spikes of the level
     */
    public void createSpikes(){
    }

    /**
     * Paints blocks and spikes
     * @param g - Graphics for painting
     */
    public void draw(Graphics g){
        checkpoint.draw(g);
        ballPort.draw(g);
        cubePort.draw(g);
        for(Block b: blocks){
            b.draw(g);
        }
        for (Spike s: spikes){
            s.draw(g);
        }
    }
}

