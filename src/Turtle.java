
import greenfoot.*; 
/*
 * Turtle class, singleton
 */
public class Turtle extends Animal implements KeyListener
{
    private static Turtle turtle = new Turtle();
    private PowerDecorator powerDecorator = null;

    private Turtle() {}
    
    public static Turtle getTurtle() {
     return turtle;   
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
           keyLeftAction();
        }

        if (Greenfoot.isKeyDown("Right"))
        {
            keyRightAction();
        }

        if ("up".equals(Greenfoot.getKey()))
        {
            keyUpAction();
        }

        if (Greenfoot.isKeyDown("Down"))
        {
           keyDownAction();
        }
    }

    public void keyLeftAction() {
        if (this.powerDecorator != null) {
            this.powerDecorator.keyLeftAction();
        } else {
            turn(-WorldConfig.TURTLE_DEGREE);
        }
    }

     public void keyRightAction() {
          if (this.powerDecorator != null) {
            this.powerDecorator.keyLeftAction();
        } else {
            turn(WorldConfig.TURTLE_DEGREE);
        }
    }

     public void keyUpAction() {
          if (this.powerDecorator != null) {
            this.powerDecorator.keyLeftAction();
        } else {
            Shot shot = new Shot();
            getWorld().addObject(shot, getX(), getY());
            shot.setRotation(getRotation());
            shot.move(55);
            move(WorldConfig.TURTLE_SPEED);
        }
    }

     public void keyDownAction() {
          if (this.powerDecorator != null) {
            this.powerDecorator.keyLeftAction();
        } else {
            move(-WorldConfig.TURTLE_SPEED);
        }
    }
    
    public void setDecorator(PowerDecorator powerDecorator) {
        this.powerDecorator = powerDecorator;
    }

    public void removeDecorator() {
        this.powerDecorator = null;
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
