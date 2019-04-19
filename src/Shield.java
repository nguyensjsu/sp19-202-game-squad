


import greenfoot.*; 
/**
 * Write a description of class Shield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shield extends Actor implements IComponent
{
    // instance variables - replace the example below with your own
    private int power;

    /**
     * Constructor for objects of class Shield
     */
    public Shield()
    {
        power = 5;
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

}    
  

