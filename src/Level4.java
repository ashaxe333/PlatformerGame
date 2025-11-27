import java.awt.*;
import java.util.ArrayList;

/**
 * Creates level 4 (all blocks and spikes)
 */
public class Level4 extends Level{

    private ArrayList<Block> blocks = new ArrayList<>();
    private ArrayList<Spike> spikes = new ArrayList<>();
    private ArrayList<BallPort> ballPorts = new ArrayList<>();

    /**
     * Respawn x coordinate
     */
    private final int xStart = 140;

    /**
     * Respawn y coordinate
     */
    private final int yStart = 100;
    private Checkpoint checkpoint = new Checkpoint(GamePanel.UNIT_SIZE*42+GamePanel.UNIT_SIZE/2, GamePanel.UNIT_SIZE*20);

    /**
     * Respawn character (cube)
     */
    private final boolean baseCharakter = true;

    public Level4() {}

    public ArrayList<Block> getBlocks() {
        return blocks;
    }
    public ArrayList<Spike> getSpikes() {
        return spikes;
    }

    @Override
    public ArrayList<BallPort> getBallPorts() {
        return ballPorts;
    }

    public Checkpoint getCheckpoint() {
        return checkpoint;
    }
    public int getXStart() {return xStart;}
    public int getYStart() {return yStart;}
    public boolean isBaseCharakter() {
        return baseCharakter;
    }

    /**
     * Creates blocks of the level
     */
    public void createBlocks(){
        //base
        blocks.add(new Block(GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*10+GamePanel.UNIT_SIZE/4, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*4+GamePanel.UNIT_SIZE/4, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*8));
        blocks.add(new Block(0, 0, GamePanel.GAME_WIDTH, GamePanel.UNIT_SIZE*2)); //top

        //platforms
        blocks.add(new Block(GamePanel.UNIT_SIZE*18, GamePanel.UNIT_SIZE*12, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE));
        blocks.add(new Block(GamePanel.UNIT_SIZE*26, GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE));
        blocks.add(new Block(GamePanel.UNIT_SIZE*34, GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE));
        blocks.add(new Block(GamePanel.UNIT_SIZE*42, GamePanel.UNIT_SIZE*18, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE));
        blocks.add(new Block(GamePanel.UNIT_SIZE*54, GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE));

        blocks.add(new Block(0, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*2));

        blocks.add(new Block(GamePanel.UNIT_SIZE*12, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*30, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*38, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2));
    }

    /**
     * Creates spikes of the level
     */
    public void createSpikes(){
        //1
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*15}, new int[]{GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*9}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*24, GamePanel.UNIT_SIZE*23}, new int[]{GamePanel.UNIT_SIZE*13, GamePanel.UNIT_SIZE*13, GamePanel.UNIT_SIZE*11}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*30, GamePanel.UNIT_SIZE*32, GamePanel.UNIT_SIZE*31}, new int[]{GamePanel.UNIT_SIZE*15, GamePanel.UNIT_SIZE*15, GamePanel.UNIT_SIZE*13}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*38, GamePanel.UNIT_SIZE*40, GamePanel.UNIT_SIZE*39}, new int[]{GamePanel.UNIT_SIZE*17, GamePanel.UNIT_SIZE*17, GamePanel.UNIT_SIZE*15}, 1));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*46, GamePanel.UNIT_SIZE*48, GamePanel.UNIT_SIZE*47}, new int[]{GamePanel.UNIT_SIZE*19, GamePanel.UNIT_SIZE*19, GamePanel.UNIT_SIZE*17}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*48, GamePanel.UNIT_SIZE*50, GamePanel.UNIT_SIZE*49}, new int[]{GamePanel.UNIT_SIZE*20, GamePanel.UNIT_SIZE*20, GamePanel.UNIT_SIZE*18}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*50, GamePanel.UNIT_SIZE*52, GamePanel.UNIT_SIZE*51}, new int[]{GamePanel.UNIT_SIZE*21, GamePanel.UNIT_SIZE*21, GamePanel.UNIT_SIZE*19}, 1));

        //3
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*15}, new int[]{GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*13}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*24, GamePanel.UNIT_SIZE*23}, new int[]{GamePanel.UNIT_SIZE*13, GamePanel.UNIT_SIZE*13, GamePanel.UNIT_SIZE*15}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*30, GamePanel.UNIT_SIZE*32, GamePanel.UNIT_SIZE*31}, new int[]{GamePanel.UNIT_SIZE*15, GamePanel.UNIT_SIZE*15, GamePanel.UNIT_SIZE*17}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*38, GamePanel.UNIT_SIZE*40, GamePanel.UNIT_SIZE*39}, new int[]{GamePanel.UNIT_SIZE*17, GamePanel.UNIT_SIZE*17, GamePanel.UNIT_SIZE*19}, 3));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*46, GamePanel.UNIT_SIZE*48, GamePanel.UNIT_SIZE*47}, new int[]{GamePanel.UNIT_SIZE*19, GamePanel.UNIT_SIZE*19, GamePanel.UNIT_SIZE*21}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*48, GamePanel.UNIT_SIZE*50, GamePanel.UNIT_SIZE*49}, new int[]{GamePanel.UNIT_SIZE*20, GamePanel.UNIT_SIZE*20, GamePanel.UNIT_SIZE*22}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*50, GamePanel.UNIT_SIZE*52, GamePanel.UNIT_SIZE*51}, new int[]{GamePanel.UNIT_SIZE*21, GamePanel.UNIT_SIZE*21, GamePanel.UNIT_SIZE*23}, 3));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*5}, new int[]{GamePanel.UNIT_SIZE*12+GamePanel.UNIT_SIZE/4, GamePanel.UNIT_SIZE*12+GamePanel.UNIT_SIZE/4, GamePanel.UNIT_SIZE*14+GamePanel.UNIT_SIZE/4}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*10, GamePanel.UNIT_SIZE*12, GamePanel.UNIT_SIZE*11}, new int[]{GamePanel.UNIT_SIZE*12+GamePanel.UNIT_SIZE/4, GamePanel.UNIT_SIZE*12+GamePanel.UNIT_SIZE/4, GamePanel.UNIT_SIZE*14+GamePanel.UNIT_SIZE/4}, 3));

        //top
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*41, GamePanel.UNIT_SIZE*43, GamePanel.UNIT_SIZE*42}, new int[]{GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*4}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*43, GamePanel.UNIT_SIZE*45, GamePanel.UNIT_SIZE*44}, new int[]{GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*4}, 3));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*33, GamePanel.UNIT_SIZE*35, GamePanel.UNIT_SIZE*34}, new int[]{GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*4}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*35, GamePanel.UNIT_SIZE*37, GamePanel.UNIT_SIZE*36}, new int[]{GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*4}, 3));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*26, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*27}, new int[]{GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*4}, 3));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*18, GamePanel.UNIT_SIZE*20, GamePanel.UNIT_SIZE*19}, new int[]{GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*4}, 3));
    }

    /**
     * Creates all ports of the level
     */
    public void createPorts(){
        ballPorts.add(new BallPort(GamePanel.UNIT_SIZE*57, GamePanel.UNIT_SIZE*17));
    }

    /**
     * Paints blocks and spikes, checkpoint and ballPort
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
    }
}
