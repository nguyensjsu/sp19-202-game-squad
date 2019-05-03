/**
 * Write a description of class Shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package org.droidfoot.turtleworld;

import greenfoot.*;

public class Shot extends Actor
{
    int gunShots;

    /**
     * Constructor for objects of class Shot
     */
    public Shot(int gunShots)
    {
        this.gunShots = gunShots;
        setImage("beeper.png");
    }

    public void act()
    {
        move(25);
        if (canSee(Snake.class)) {
            Actor snake = getOneObjectAtOffset(0, 0, Snake.class);
            if(snake != null) {
                Snake sn = (Snake)snake;
                getWorld().removeObject(snake);
                new ActorManager().invoke("Snake");
                getWorld().removeObject(this);
            }
        } else {
            if (atWorldEdge()) {
                getWorld().removeObject(this);
            }
        }


    }

    private boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;
    }

    /**
     * Test if we are close to one of the edges of the world. Return true if we are.
     */
    private boolean atWorldEdge()
    {
        if(getX() < 10 || getX() > getWorld().getWidth() - 10)
            return true;
        if(getY() < 10 || getY() > getWorld().getHeight() - 10)
            return true;
        else
            return false;
    }
}



