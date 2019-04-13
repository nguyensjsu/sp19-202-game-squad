import greenfoot.*; 
/*
 * @author: Marianne Paulson based on watching this video series: https://blogs.kcl.ac.uk/proged/2012/01/14/joc-9/
 * @version: 1
 */
public class Turtle extends Animal
{
    private int points;
    private Counter counter;

    public Turtle()
    {
       
    }
    
    public Turtle(Counter pointCounter)
    {
        counter = pointCounter;
    }

    public void act()
    {
        move(4);
        checkKeys();
        eat();
    }

    /**
     * Check keys
     */
    public void checkKeys()
    {
        if (Greenfoot.isKeyDown("Left"))
        {
            turn(-5);
        }

        if (Greenfoot.isKeyDown("Right"))
        {
            turn(5);
        }

        if (Greenfoot.isKeyDown("Up"))
        {
            move(5);
        }

        if (Greenfoot.isKeyDown("Down"))
        {
            move(-5);
        }
    }

    /**
     * Check if lettuce or bugs there and then eat
     */
    public void eat()
    {
        if(canSee(Lettuce.class))
        {
            eat(Lettuce.class);  
            //points++;
            counter.add(5);
            Greenfoot.playSound("slurp.wav");
        }

        if(canSee(Bug.class))
        {
            eat(Bug.class);  
            //points = points + 5;
            counter.add(20);
            Greenfoot.playSound("slurp.wav");
            createNewBug();
        }

        if (counter.getValue() >= 80) 
        {
            gameOver();
        }
    }

    /**
     * Create a new bug
     */
    private void createNewBug()
    {
        Bug newBug;

        newBug = new Bug();

        World world;
        world = getWorld();

        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();

        int x = Greenfoot.getRandomNumber(worldWidth);
        int y = Greenfoot.getRandomNumber(worldHeight);

        world.addObject(newBug, x, y);
    }

    public void gameOver()
    {
        Greenfoot.playSound("fanfare.aiff");
        Greenfoot.stop();
    }
}
