import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class AbstractWorld extends World implements WorldState
{

    protected DirectorState director;
    
    public AbstractWorld(DirectorState director)
    {    
        super(WorldConfig.getX(), WorldConfig.getY(), WorldConfig.getCellSize()); 
        this.director = director;
    }
}
