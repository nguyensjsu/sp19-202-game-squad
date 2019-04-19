
import greenfoot.*; 
/*
 * Turtle class, singleton
 */
public class Turtle extends Animal implements IComponent
{
    private static Shield shield = new Shield();
    private static Turtle turtle = new Turtle();
    
    private Turtle() {}
    
    public static Turtle getTurtle() {
     return turtle;   
    }
    
    public static Shield getShield() {
     return shield;   
    }
    
        public void act()
    {
        move(WorldConfig.TURTLE_SPEED);
        checkKeys();
        //eat();
    }

    public void checkKeys()
    {
        if (Greenfoot.isKeyDown("Left"))
        {
            turn(-WorldConfig.TURTLE_DEGREE);
        }

        if (Greenfoot.isKeyDown("Right"))
        {
            turn(WorldConfig.TURTLE_DEGREE);
        }

        if (Greenfoot.isKeyDown("Up"))
        {
            move(WorldConfig.TURTLE_SPEED);
        }

        if (Greenfoot.isKeyDown("Down"))
        {
            move(-WorldConfig.TURTLE_SPEED);
        }
    }
    
    /*
    private int points;
    private Counter counter;

    public Turtle()
    {
       
    }
    
    public Turtle(Counter pointCounter)
    {
        counter = pointCounter;
    }



   
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
    */
}
