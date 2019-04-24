/**
 * Write a description of class WorldConfig here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WorldConfig {
    private static int x = 800;
    private static int y = 800;
    private static int cellSize = 1;
    public static int TURTLE_SPEED = 1;
    public static int TURTLE_DEGREE = 3;
    public static int SHOTS = 10;

    public static int MAX_LEVEL=3;
    public static int LEVEL_FACTOR=20;

    public static int NUM_OF_LETTUCE = 10;
    public static int RED_LETTUCE_CREATION_ON_SCORE = 20;
    public static int NUM_OF_RED_LETTUCE = 1;
    public static int LETTUCE_CREATION_DELAY = 30;

    // these will come from strategy pattern
    public static int NUM_OF_SNAKES = 0;
    public static int SPEED_OF_SNAKES = 1;
    public static int SNAKES_ATTRACTION = 50;
    //==================

    public static int SNAKE_CREATION_DELAY = 30;

    public static int NUM_OF_BUGS = 1;
    public static int BUG_SPEED = 1;
    public static int BUG_CREATION_DELAY = 60;

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
