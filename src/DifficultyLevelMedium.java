/**
 * 
 * @author (Saumil) 
 */
public class DifficultyLevelMedium implements DifficultyStrategy
{
    private int numberOfSnakes;
    private int speedOfSnake;
    private int snakeVisibilityRadius;
    
    public DifficultyLevelMedium()
    {
        this.numberOfSnakes = 8;
        this.speedOfSnake = 3;
        this.snakeVisibilityRadius = 20;
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
