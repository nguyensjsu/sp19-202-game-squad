package org.droidfoot.turtleworld;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HighDifficulty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DifficultyHigh extends Actor
{
    private TurtleWorld world;
    public DifficultyHigh(TurtleWorld world) {

        this.world = world;
        setImage("DifficultyHigh.png");
    }

    /**
     * Act - do whatever the HighDifficulty wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            WorldConfig.createWorldConfig(new DifficultyLevelHigh());
            world.loadPlayScreen();
        }
    }    
}
