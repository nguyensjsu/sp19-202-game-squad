import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LowDifficulty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DifficultyLow extends Actor
{


    private TurtleWorld world;
    public DifficultyLow(TurtleWorld world) {
        this.world = world;
    }    
    /**
     * Act - do whatever the LowDifficulty wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            WorldConfig.createWorldConfig(new DifficultyLevelLow());
            this.world.loadPlayScreen();
            
        }
    }    
}
