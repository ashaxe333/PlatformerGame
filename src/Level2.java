import java.awt.*;
import java.util.ArrayList;

public class Level2 extends Level{

    private ArrayList<Block> blocks = new ArrayList<>();
    private ArrayList<Spike> spikes = new ArrayList<>();
    private final int xStart = 1140;
    private final int yStart = 500;
    private Checkpoint checkpoint = new Checkpoint(GamePanel.UNIT_SIZE*58, GamePanel.UNIT_SIZE*3);

    public Level2() {}

    public ArrayList<Block> getBlocks() {
        return blocks;
    }
    public ArrayList<Spike> getSpikes() {
        return spikes;
    }
    public Checkpoint getCheckpoint() {return checkpoint;}
    public int getXStart() {
        return xStart;
    }
    public int getYStart() {
        return yStart;
    }

    public void createBlocks(){
        blocks.add(new Block(GamePanel.UNIT_SIZE*7, GamePanel.UNIT_SIZE*14, GamePanel.GAME_WIDTH, GamePanel.UNIT_SIZE*2)); //middle
        blocks.add(new Block(0, GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE*2)); //middle

        blocks.add(new Block(GamePanel.UNIT_SIZE*54, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*38, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(0, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*12, GamePanel.UNIT_SIZE*2));

        blocks.add(new Block(GamePanel.UNIT_SIZE*40, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*18));
        blocks.add(new Block(GamePanel.UNIT_SIZE*24, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*18));
        blocks.add(new Block(GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*18));

        blocks.add(new Block(GamePanel.UNIT_SIZE*54, 0, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*38, 0, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*22, 0, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(0, 0, GamePanel.UNIT_SIZE*12, GamePanel.UNIT_SIZE*2));
    }
    public void createSpikes(){
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*58, GamePanel.UNIT_SIZE*60, GamePanel.UNIT_SIZE*59}, new int[]{GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*12}, 3, GamePanel.UNIT_SIZE*58+GamePanel.UNIT_SIZE/2, GamePanel.UNIT_SIZE*12+GamePanel.UNIT_SIZE/2));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*54, GamePanel.UNIT_SIZE*56, GamePanel.UNIT_SIZE*55}, new int[]{GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*26}, 3, GamePanel.UNIT_SIZE*54+GamePanel.UNIT_SIZE/2, GamePanel.UNIT_SIZE*26+GamePanel.UNIT_SIZE/2));
    }
    public void draw(Graphics g){
        checkpoint.draw(g);
        for(Block b: blocks){
            b.draw(g);
        }
        for (Spike s: spikes){
            s.draw(g);
        }
    }
}
