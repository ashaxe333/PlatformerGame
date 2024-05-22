import java.awt.*;
import java.util.ArrayList;

public class Level{

    private ArrayList<Block> blocks = new ArrayList<>();
    private ArrayList<Spike> spikes = new ArrayList<>();
    private int xStart;
    private int yStart;
    private Checkpoint checkpoint;

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
    public int getXStart() {return xStart;}
    public int getYStart() {return yStart;}

    public void createBlocks(){}
    public void createSpikes(){}
    public void draw(Graphics g){}


}
