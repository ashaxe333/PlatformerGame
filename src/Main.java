public class Main {
    public static void main(String[] args){

        Cube cube = new Cube(15, 20);
        Block block = new Block(34, 65, 2, 2);
        if(cube.intersects(block)){

        }
        new GameFrame();
    }
}
