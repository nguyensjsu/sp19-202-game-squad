/**
 * Interface DifficutlyStrategy
 * This interface defines interface for strategy pattern for difficulty levels (i.e. Low, Medium, High)
 * @author (Saumil Patel) 
 */
public interface DifficultyStrategy  
{
    public int getNumberOfSnakes();
    public int getSpeedOfSnake();
    public int getSnakeVisibilityRadius();
}
