import java.awt.*;
import java.util.ArrayList;

/**
 * Creates level 3 (all blocks and spikes)
 */
public class Level3 extends Level{

    private ArrayList<Block> blocks = new ArrayList<>();
    private ArrayList<Spike> spikes = new ArrayList<>();
    private ArrayList<BallPort> ballPorts = new ArrayList<>();
    private ArrayList<CubePort> cubePorts = new ArrayList<>();

    /**
     * Respawn x coordinate
     */
    private final int xStart = 500;

    /**
     * Respawn y coordinate
     */
    private final int yStart = 500;
    private Checkpoint checkpoint = new Checkpoint(GamePanel.UNIT_SIZE*39+GamePanel.UNIT_SIZE/2, GamePanel.UNIT_SIZE*9);

    /**
     * Respawn character (cube)
     */
    private final boolean baseCharakter = true;
    public Level3() {}

    public ArrayList<Block> getBlocks() {
        return blocks;
    }
    public ArrayList<Spike> getSpikes() {
        return spikes;
    }
    public Checkpoint getCheckpoint() {
        return checkpoint;
    }
    public int getXStart() {
        return xStart;
    }
    public int getYStart() {
        return yStart;
    }

    @Override
    public ArrayList<BallPort> getBallPorts() {
        return ballPorts;
    }

    @Override
    public ArrayList<CubePort> getCubePorts() {
        return cubePorts;
    }

    public boolean isBaseCharakter() {
        return baseCharakter;
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
        //1
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*10, GamePanel.UNIT_SIZE*12, GamePanel.UNIT_SIZE*11}, new int[]{GamePanel.UNIT_SIZE*20, GamePanel.UNIT_SIZE*20, GamePanel.UNIT_SIZE*18}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*33, GamePanel.UNIT_SIZE*35, GamePanel.UNIT_SIZE*34}, new int[]{GamePanel.UNIT_SIZE*15, GamePanel.UNIT_SIZE*15, GamePanel.UNIT_SIZE*13}, 1));

        //3
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*45, GamePanel.UNIT_SIZE*47, GamePanel.UNIT_SIZE*46}, new int[]{GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*18}, 3));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*12, GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*13}, new int[]{GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*4}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*15}, new int[]{GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*4}, 3));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*30, GamePanel.UNIT_SIZE*32, GamePanel.UNIT_SIZE*31}, new int[]{GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*10}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*32, GamePanel.UNIT_SIZE*34, GamePanel.UNIT_SIZE*33}, new int[]{GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*10}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*34, GamePanel.UNIT_SIZE*36, GamePanel.UNIT_SIZE*35}, new int[]{GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*10}, 3));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*46, GamePanel.UNIT_SIZE*48, GamePanel.UNIT_SIZE*47}, new int[]{GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*10}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*48, GamePanel.UNIT_SIZE*50, GamePanel.UNIT_SIZE*49}, new int[]{GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*10}, 3));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*20, GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*21}, new int[]{GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*4}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*24, GamePanel.UNIT_SIZE*23}, new int[]{GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*4}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*24, GamePanel.UNIT_SIZE*26, GamePanel.UNIT_SIZE*25}, new int[]{GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*4}, 3));

        //4
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*4}, new int[]{GamePanel.UNIT_SIZE*13, GamePanel.UNIT_SIZE*15, GamePanel.UNIT_SIZE*14}, 4));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*52, GamePanel.UNIT_SIZE*52, GamePanel.UNIT_SIZE*54}, new int[]{GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*24, GamePanel.UNIT_SIZE*23}, 4));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*52, GamePanel.UNIT_SIZE*52, GamePanel.UNIT_SIZE*54}, new int[]{GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*10, GamePanel.UNIT_SIZE*9}, 4));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*30, GamePanel.UNIT_SIZE*30, GamePanel.UNIT_SIZE*32}, new int[]{GamePanel.UNIT_SIZE*21, GamePanel.UNIT_SIZE*23, GamePanel.UNIT_SIZE*22}, 4));


        //2
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*58, GamePanel.UNIT_SIZE*58, GamePanel.UNIT_SIZE*56}, new int[]{GamePanel.UNIT_SIZE*15, GamePanel.UNIT_SIZE*17, GamePanel.UNIT_SIZE*16}, 2));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*6}, new int[]{GamePanel.UNIT_SIZE*20, GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*21}, 2));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*6}, new int[]{GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*7}, 2));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*50, GamePanel.UNIT_SIZE*50, GamePanel.UNIT_SIZE*48}, new int[]{GamePanel.UNIT_SIZE*13, GamePanel.UNIT_SIZE*15, GamePanel.UNIT_SIZE*14}, 2));
    }

    /**
     * Creates all ports of the level
     */
    public void createPorts(){
        cubePorts.add(new CubePort(340, 300));
        ballPorts.add(new BallPort(200, 460));
    }

    /**
     * Paints blocks and spikes, checkpoint and cubePorts with ballPorts
     * @param g - Graphics for painting
     */
    public void draw(Graphics g){
        checkpoint.draw(g);
        for(Block b: blocks){
            b.draw(g);
        }
        for (Spike s: spikes){
            s.draw(g);
        }
        for (BallPort bp: ballPorts) {
            bp.draw(g);
        }
        for (CubePort cp: cubePorts) {
            cp.draw(g);
        }
    }
}

