import java.awt.*;
import java.util.ArrayList;

public class Level2 {

    private ArrayList<Block> blocks = new ArrayList<>();
    private ArrayList<Spike> spikes = new ArrayList<>();

    private Checkpoint checkpoint = new Checkpoint(GamePanel.UNIT_SIZE*56, GamePanel.UNIT_SIZE*6);

    public Level2() {
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public ArrayList<Spike> getSpikes() {
        return spikes;
    }

    public Checkpoint getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(Checkpoint checkpoint) {
        this.checkpoint = checkpoint;
    }

    public void createBlocks(){
        blocks.add(new Block(GamePanel.UNIT_SIZE*3, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*2)); //bottom

        blocks.add(new Block(GamePanel.UNIT_SIZE*32, GamePanel.UNIT_SIZE*26, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*46, GamePanel.UNIT_SIZE*24, GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*56, GamePanel.UNIT_SIZE*20, GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*4));

        blocks.add(new Block(GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*18, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*20, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*18, GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*32, GamePanel.UNIT_SIZE*20, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*44, GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*2));

        blocks.add(new Block(GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*10, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*18, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*32, GamePanel.UNIT_SIZE*10, GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*42, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*50, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*10, GamePanel.UNIT_SIZE*2));
    }

    public void createSpikes(){
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*30, GamePanel.UNIT_SIZE*32, GamePanel.UNIT_SIZE*31}, new int[]{GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*26}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*30, GamePanel.UNIT_SIZE*29}, new int[]{GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*26}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*5}, new int[]{GamePanel.UNIT_SIZE*18, GamePanel.UNIT_SIZE*18, GamePanel.UNIT_SIZE*16}, 3));
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
