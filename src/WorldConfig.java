/**
 * Write a description of class WorldConfig here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WorldConfig {
   
    private static WorldConfig worldConfig;
    public DifficultyStrategy ds;

    private static int x = 800;
    private static int y = 800;
    private static int cellSize = 1;
    public int TURTLE_SPEED = 2;
    public int TURTLE_DEGREE = 3;
    public int SHOTS = 10;

    public int MAX_LEVEL=3;
    public int LEVEL_FACTOR=20;

    public int NUM_OF_LETTUCE = 10;
    public int RED_LETTUCE_CREATION_ON_SCORE = 20;
    public int NUM_OF_RED_LETTUCE = 1;
    public int LETTUCE_CREATION_DELAY = 30;

    // these will come from strategy pattern
    public int NUM_OF_SNAKES = 10;
    public int SPEED_OF_SNAKES = 1;
    public int SNAKES_ATTRACTION = 50;
    //==================

    public int SNAKE_CREATION_DELAY = 30;

    public int NUM_OF_BUGS = 1;
    public int BUG_SPEED = 1;
    public int BUG_CREATION_DELAY = 60;

    
    private WorldConfig(DifficultyStrategy ds)
    {
        this.ds = ds;
        NUM_OF_SNAKES = ds.getNumberOfSnakes();
        SPEED_OF_SNAKES = ds.getSpeedOfSnake();
    }

    public static WorldConfig getInstance()
    {
        return worldConfig;
    }

    public static void createWorldConfig(DifficultyStrategy ds)
    {
        worldConfig = new WorldConfig(ds);
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static int getCellSize() {
        return cellSize;
    }
}
