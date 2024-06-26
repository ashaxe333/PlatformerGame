import java.awt.*;
import java.util.ArrayList;

/**
 * Creates level 2 (all blocks and spikes)
 */
public class Level2 extends Level{

    private ArrayList<Block> blocks = new ArrayList<>();
    private ArrayList<Spike> spikes = new ArrayList<>();

    /**
     * Respawn x coordinate
     */
    private final int xStart = 1140;

    /**
     * Respawn y coordinate
     */
    private final int yStart = 500;
    private Checkpoint checkpoint = new Checkpoint(GamePanel.UNIT_SIZE*58, GamePanel.UNIT_SIZE*3);

    /**
     * Respawn character (ball)
     */
    private final boolean baseCharakter = false;
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

    @Override
    public boolean isBaseCharakter() {
        return baseCharakter;
    }

    /**
     * Creates blocks of the level
     */
    public void createBlocks(){
        //middle y-axis
        blocks.add(new Block(GamePanel.UNIT_SIZE*7, GamePanel.UNIT_SIZE*14, GamePanel.GAME_WIDTH, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(0, GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE*2));

        //bottom
        blocks.add(new Block(GamePanel.UNIT_SIZE*53, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*7, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*37, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*7, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*21, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*7, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(0, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*12, GamePanel.UNIT_SIZE*2));

        //middle x-axis
        blocks.add(new Block(GamePanel.UNIT_SIZE*38, GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*8));
        blocks.add(new Block(GamePanel.UNIT_SIZE*40, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*14));
        blocks.add(new Block(GamePanel.UNIT_SIZE*42, GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*8));
        blocks.add(new Block(GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*8));
        blocks.add(new Block(GamePanel.UNIT_SIZE*24, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*14));
        blocks.add(new Block(GamePanel.UNIT_SIZE*26, GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*8));
        blocks.add(new Block(GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*14));
        blocks.add(new Block(GamePanel.UNIT_SIZE*10, GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*8));

        //top
        blocks.add(new Block(GamePanel.UNIT_SIZE*53, 0, GamePanel.UNIT_SIZE*7, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*37, 0, GamePanel.UNIT_SIZE*7, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(GamePanel.UNIT_SIZE*21, 0, GamePanel.UNIT_SIZE*7, GamePanel.UNIT_SIZE*2));
        blocks.add(new Block(0, 0, GamePanel.UNIT_SIZE*12, GamePanel.UNIT_SIZE*2));
    }

    /**
     * Creates spikes of the level
     */
    public void createSpikes(){
        //4
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE*3}, new int[]{GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*15}, 4));

        //2
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*7, GamePanel.UNIT_SIZE*7, GamePanel.UNIT_SIZE*5}, new int[]{GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*15}, 2));

        //1
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*58, GamePanel.UNIT_SIZE*60, GamePanel.UNIT_SIZE*59}, new int[]{GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*12}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*53, GamePanel.UNIT_SIZE*55, GamePanel.UNIT_SIZE*54}, new int[]{GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*26}, 1));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*44, GamePanel.UNIT_SIZE*46, GamePanel.UNIT_SIZE*45}, new int[]{GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*12}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*42, GamePanel.UNIT_SIZE*44, GamePanel.UNIT_SIZE*43}, new int[]{GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*9}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*40, GamePanel.UNIT_SIZE*42, GamePanel.UNIT_SIZE*41}, new int[]{GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*6}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*38, GamePanel.UNIT_SIZE*40, GamePanel.UNIT_SIZE*39}, new int[]{GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*9}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*36, GamePanel.UNIT_SIZE*38, GamePanel.UNIT_SIZE*37}, new int[]{GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*12}, 1));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*30, GamePanel.UNIT_SIZE*29}, new int[]{GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*12}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*26, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*27}, new int[]{GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*9}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*24, GamePanel.UNIT_SIZE*26, GamePanel.UNIT_SIZE*25}, new int[]{GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*6}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*24, GamePanel.UNIT_SIZE*23}, new int[]{GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*9}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*20, GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*21}, new int[]{GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*12}, 1));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*12, GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*13}, new int[]{GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*12}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*10, GamePanel.UNIT_SIZE*12, GamePanel.UNIT_SIZE*11}, new int[]{GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*11, GamePanel.UNIT_SIZE*9}, 1));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*10, GamePanel.UNIT_SIZE*9}, new int[]{GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*6}, 1));

        //3
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*58, GamePanel.UNIT_SIZE*60, GamePanel.UNIT_SIZE*59}, new int[]{GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*18}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*53, GamePanel.UNIT_SIZE*55, GamePanel.UNIT_SIZE*54}, new int[]{GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*2, GamePanel.UNIT_SIZE*4}, 3));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*44, GamePanel.UNIT_SIZE*46, GamePanel.UNIT_SIZE*45}, new int[]{GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*18}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*42, GamePanel.UNIT_SIZE*44, GamePanel.UNIT_SIZE*43}, new int[]{GamePanel.UNIT_SIZE*19, GamePanel.UNIT_SIZE*19, GamePanel.UNIT_SIZE*21}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*40, GamePanel.UNIT_SIZE*42, GamePanel.UNIT_SIZE*41}, new int[]{GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*24}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*38, GamePanel.UNIT_SIZE*40, GamePanel.UNIT_SIZE*39}, new int[]{GamePanel.UNIT_SIZE*19, GamePanel.UNIT_SIZE*19, GamePanel.UNIT_SIZE*21}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*36, GamePanel.UNIT_SIZE*38, GamePanel.UNIT_SIZE*37}, new int[]{GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*18}, 3));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*30, GamePanel.UNIT_SIZE*29}, new int[]{GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*18}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*26, GamePanel.UNIT_SIZE*28, GamePanel.UNIT_SIZE*27}, new int[]{GamePanel.UNIT_SIZE*19, GamePanel.UNIT_SIZE*19, GamePanel.UNIT_SIZE*21}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*24, GamePanel.UNIT_SIZE*26, GamePanel.UNIT_SIZE*25}, new int[]{GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*24}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*24, GamePanel.UNIT_SIZE*23}, new int[]{GamePanel.UNIT_SIZE*19, GamePanel.UNIT_SIZE*19, GamePanel.UNIT_SIZE*21}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*20, GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*21}, new int[]{GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*18}, 3));

        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*12, GamePanel.UNIT_SIZE*14, GamePanel.UNIT_SIZE*13}, new int[]{GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*16, GamePanel.UNIT_SIZE*18}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*10, GamePanel.UNIT_SIZE*12, GamePanel.UNIT_SIZE*11}, new int[]{GamePanel.UNIT_SIZE*19, GamePanel.UNIT_SIZE*19, GamePanel.UNIT_SIZE*21}, 3));
        spikes.add(new Spike(new int[]{GamePanel.UNIT_SIZE*8, GamePanel.UNIT_SIZE*10, GamePanel.UNIT_SIZE*9}, new int[]{GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*22, GamePanel.UNIT_SIZE*24}, 3));
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
