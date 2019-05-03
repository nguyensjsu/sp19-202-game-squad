/**
 * Interface DifficutlyStrategy
 * This interface defines interface for strategy pattern for difficulty levels (i.e. Low, Medium, High)
 * @author (Saumil Patel) 
 */
package org.droidfoot.turtleworld;

public interface DifficultyStrategy  
{
    public int getNumberOfSnakes();
    public int getSpeedOfSnake();
    public int getSnakeVisibilityRadius();
}
