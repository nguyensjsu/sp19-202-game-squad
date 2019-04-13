import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bug here.
 * 
 * @author: Marianne Paulson based on watching this video series: https://blogs.kcl.ac.uk/proged/2012/01/14/joc-9/
 * @version: 1
 */
public class Bug extends Animal
{
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(5);
        randomTurn();
        worldEdge();
    }

    /**
     * 10% of the time turn at a random angle between -20 and 20.
     */
    public void randomTurn()
    {
        if (Greenfoot.getRandomNumber(100) < 10)
        {
            turn(Greenfoot.getRandomNumber(40)-20);
        }
    }

    /**
     * If we reach the end of the world, turn a little bit
     */
    public void worldEdge()
    {
        if (atWorldEdge())
        {
            turn(7);
        }
    }

      
}
