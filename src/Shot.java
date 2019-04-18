/**
 * Write a description of class Shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import greenfoot.*; 

public class Shot extends Actor
{
   
    /**
     * Constructor for objects of class Shot
     */
    public Shot()
    {
    }
    
    public void act()
    {
        move(25);
        if (canSee(RedLettuce.class)) {
             Actor actor = getOneObjectAtOffset(0, 0, RedLettuce.class);
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

