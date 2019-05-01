/**
 * 
 * @author (Saumil) 
 */
public class DifficultyLevelLow implements DifficultyStrategy
{
    private int numberOfSnakes;
    private int speedOfSnake;
    private int snakeVisibilityRadius;
    
    public DifficultyLevelLow()
    {
        this.numberOfSnakes = 5;
        this.speedOfSnake = 1;
        this.snakeVisibilityRadius = 10;
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
