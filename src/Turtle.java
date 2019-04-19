import java.util.ArrayList;
import greenfoot.*; 
/*
 * Turtle class, singleton
 */
public class Turtle extends Animal implements KeyListener, IEatSubject
{
    private static Turtle turtle = new Turtle();
    private PowerDecorator powerDecorator = null;
    ArrayList<IEatObserver> observers;

    private Turtle() {
        observers = new ArrayList<IEatObserver>();
    }
    
    public static Turtle getTurtle() {
     return turtle;   
    }
    
    public void act()
    {
        move(WorldConfig.TURTLE_SPEED);
        checkKeys();
        if(canSee(Lettuce.class))
        {
            eat(Lettuce.class);  
            Greenfoot.playSound("slurp.wav");
        } else if(canSee(RedLettuce.class))
        {
            eat(RedLettuce.class); 
            Greenfoot.playSound("slurp.wav");
        }
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
        
        if (Greenfoot.isKeyDown("Space"))
        {
           keySpaceAction();
        }
    }

    public void keyLeftAction() {
        
            turn(-WorldConfig.TURTLE_DEGREE);
        
    }

     public void keyRightAction() {
        
            turn(WorldConfig.TURTLE_DEGREE);
        
    }

     public void keyUpAction() {
          turn(WorldConfig.TURTLE_DEGREE);
    }

     public void keyDownAction() {
          
            move(-WorldConfig.TURTLE_SPEED);
        
    }
    
    public void keySpaceAction() {
          
            if (this.powerDecorator != null) {
            this.powerDecorator.keySpaceAction();
          } 
        
    }
    
    public void setDecorator(PowerDecorator powerDecorator) {
        this.powerDecorator = powerDecorator;
    }

    public void removeDecorator() {
        this.powerDecorator = null;
    }
    
    public void eat(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
       
        if(actor != null) {
            String className = actor.getClass().getName();
            getWorld().removeObject(actor);
            notifyObservers(className);
        }
    }
    
    public void attach (IEatObserver obj) {
        observers.add(obj);
    }
    
    public void removeObserver (IEatObserver obj) {
        int i = observers.indexOf(obj) ;
        if ( i >= 0 )
            observers.remove(i) ;
    }
    
    public void notifyObservers(String className) {
        for (int i=0; i<observers.size(); i++)
        {
            IEatObserver observer = observers.get(i) ;
            observer.invoke(className);
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
