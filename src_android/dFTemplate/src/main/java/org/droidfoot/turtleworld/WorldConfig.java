/**
 * Write a description of class WorldConfig here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
package org.droidfoot.turtleworld;

public class WorldConfig {

    private static WorldConfig worldConfig;
    public DifficultyStrategy ds;

    private static int x = 800;
    private static int y = 800;
    private static int cellSize = 1;

    // Turtle configuration
    public int TURTLE_SPEED = 8;
    public int TURTLE_DEGREE = 3;

    // Ammo configuration
    public int SHOTS = 5;

    // Level  configuration
    public int MAX_LEVEL=10;
    public int LEVEL_FACTOR=20; // level increment in

    // Lettuce configuration
    public int NUM_OF_LETTUCE = 5;
    public int RED_LETTUCE_CREATION_ON_SCORE = 40;
    public int NUM_OF_RED_LETTUCE = 1;
    public int LETTUCE_CREATION_DELAY = 30;

    // Snake configuration
    // these will come from strategy pattern, defaults
    public int NUM_OF_SNAKES = 5;
    public int SPEED_OF_SNAKES = 1;
    public int SNAKES_ATTRACTION = 50;
    public int SNAKE_CREATION_DELAY = 30;

    // Bugs configuration
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
