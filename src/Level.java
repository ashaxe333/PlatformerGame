import java.awt.*;
import java.util.ArrayList;

/**
 * Just helps with getting data like array of blocks or spikes, starting coordinates etc...
 */
public class Level{

    private ArrayList<Block> blocks = new ArrayList<>();
    private ArrayList<Spike> spikes = new ArrayList<>();
    private int xStart;
    private int yStart;
    private Checkpoint checkpoint;
    private CubePort cubePort;
    private BallPort ballPort;
    boolean baseCharakter;

    public Level() {}

    public ArrayList<Block> getBlocks() {
        return blocks;
    }
    public ArrayList<Spike> getSpikes() {
        return spikes;
    }
    public Checkpoint getCheckpoint() {
        return checkpoint;
    }
    public CubePort getCubePort() {
        return cubePort;
    }
    public BallPort getBallPort() {return ballPort;}
    public boolean isBaseCharakter() {return baseCharakter;}

    public int getXStart() {return xStart;}
    public int getYStart() {return yStart;}
    public void createBlocks(){}
    public void createSpikes(){}
    public void draw(Graphics g){}


}
