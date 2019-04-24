/**
 * Write a description of class Shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import greenfoot.*; 

public class Shot extends Actor
{
    int gunShots;
    
    /**
     * Constructor for objects of class Shot
     */
    public Shot(int gunShots)
    {
        setImage("beeper.png");
       this.gunShots = gunShots;
    }
    
    public void act()
    {
        move(25);
        if (canSee(Snake.class)) {
             Actor actor = getOneObjectAtOffset(0, 0, Snake.class);
             if(actor != null) {
                 getWorld().removeObject(actor);
                 getWorld().removeObject(this);
             }
        }
    }

    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }
    
}

