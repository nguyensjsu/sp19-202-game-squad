/**
 * @author (Saumil)
 */
public class DifficultyLevelHigh implements DifficultyStrategy  
{
    private int numberOfSnakes;
    private int speedOfSnake;
    private int snakeVisibilityRadius;
    
    public DifficultyLevelHigh()
    {
        this.numberOfSnakes = 10;
        this.speedOfSnake = 3;
        this.snakeVisibilityRadius = 30;
    }
    
    public int getNumberOfSnakes()
    {
        return this.numberOfSnakes;
    }
    
    public int getSpeedOfSnake()
    {
        return this.speedOfSnake;
    }
    
    public int getSnakeVisibilityRadius()
    {
        return this.snakeVisibilityRadius;
    }
}
