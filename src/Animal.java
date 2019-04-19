import greenfoot.*;

/**
 * Animal. This is the base class for all animals. In addition to the standard Actor
 * methods, it provides methods to eat other animals and check for the edge of the world.
 * 
 * @author: Marianne Paulson based on watching this video series: https://blogs.kcl.ac.uk/proged/2012/01/14/joc-9/
 * @version: 1
 */
public class Animal extends Actor
{
    /**
     * Test if we are close to one of the edges of the world. Return true if we are.
     */
    public boolean atWorldEdge()
    {
        if(getX() < 10 || getX() > getWorld().getWidth() - 10)
            return true;
        if(getY() < 10 || getY() > getWorld().getHeight() - 10)
            return true;
        else
            return false;
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
     * Return true if we can see an object of class 'clss' right where we are. 
     * False if there is no such object here.
     */
    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
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


    /**
     * Try to eat an object of class 'clss'. This is only successful if there
     * is such an object where we currently are. Otherwise this method does
     * nothing.
     */
    public void eat(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) {
            getWorld().removeObject(actor);
        }
    }
}