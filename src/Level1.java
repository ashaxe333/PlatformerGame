import java.awt.*;
import java.util.ArrayList;

/**
 * Creates level 1 (all blocks and spikes)
 */
public class Level1 extends Level{

    private ArrayList<Block> blocks = new ArrayList<>();
    private ArrayList<Spike> spikes = new ArrayList<>();

    /**
     * Respawn x coordinate
     */
    private final int xStart = 160;

    /**
     * Respawn y coordinate
     */
    private final int yStart = 500;
    private final Checkpoint checkpoint = new Checkpoint(GamePanel.UNIT_SIZE*56, GamePanel.UNIT_SIZE*6);

    /**
     * Respawn character (cube)
     */
    private final boolean baseCharakter = true;

    public Level1() {}

    public ArrayList<Block> getBlocks() {
        return blocks;
    }
    public ArrayList<Spike> getSpikes() {
        return spikes;
    }
    public Checkpoint getCheckpoint() {return checkpoint;}
    public boolean isBaseCharakter() {
        return baseCharakter;
    }
    public int getXStart() {
        return xStart;
    }
    public int getYStart() {
        return yStart;
    }

    /**
     * Creates blocks of the level
     */
    public void createBlocks(){
        blocks.add(new Block(0, GamePanel.UNIT_SIZE*28, GamePanel.GAME_WIDTH, GamePanel.UNIT_SIZE*2)); //bottom
        blocks.add(new Block(0, 0, GamePanel.UNIT_SIZE*2, GamePanel.GAME_HEIGHT)); //left
        blocks.add(new Block(GamePanel.UNIT_SIZE*58, 0, GamePanel.UNIT_SIZE*2, GamePanel.GAME_HEIGHT)); //right
        blocks.add(new Block(0, 0, GamePanel.GAME_WIDTH, GamePanel.UNIT_SIZE*2)); //top

        blocks.add(new Block(GamePanel.UNIT_SIZE*32, GamePanel.UNIT_SIZE*26, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*46, GamePanel.UNIT_SIZE*24, GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*56, GamePanel.UNIT_SIZE*20, GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*4));
        blocks.add(new Block(GamePanel.UNIT_SIZE*56, GamePanel.UNIT_SIZE*10, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2));

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

    /**
     * Creates spikes of the level
     */
    public void createSpikes(){
        //1
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*30, GamePanel.UNIT_SIZE*32, GamePanel.UNIT_SIZE*31}, new int[]{GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*26}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*30, GamePanel.UNIT_SIZE*29}, new int[]{GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*26}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*26, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*27}, new int[]{GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*26}, 1));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*3}, new int[]{GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*26}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*5}, new int[]{GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*26}, 1));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*5}, new int[]{GamePanel.UNIT_SIZE*18, GamePanel.UNIT_SIZE*18, GamePanel.UNIT_SIZE*16}, 1));

        //3
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*5}, new int[]{GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*6}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*6, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*7}, new int[]{GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*6}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*10, GamePanel.UNIT_SIZE*9}, new int[]{GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*4, GamePanel.UNIT_SIZE*6}, 3));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*44, GamePanel.UNIT_SIZE*46, GamePanel.UNIT_SIZE*45}, new int[]{GamePanel.UNIT_SIZE*26, GamePanel.UNIT_SIZE*26, GamePanel.UNIT_SIZE*24}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*42, GamePanel.UNIT_SIZE*44, GamePanel.UNIT_SIZE*43}, new int[]{GamePanel.UNIT_SIZE*26, GamePanel.UNIT_SIZE*26, GamePanel.UNIT_SIZE*24}, 3));
    }

    /**
     * Paints blocks and spikes and checkpoint
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
    }
}
