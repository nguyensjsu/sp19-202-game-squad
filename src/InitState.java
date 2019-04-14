import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class InitState extends AbstractWorld
{
    public InitState(DirectorState director) {
        super(director);
    }
   
    public void setEndGameState() {
        this.director.setState(new EndWorld(director));
    }
    
    public void setPlayGameState() {
        this.director.setState(new TurtleWorld(director));
    }
    
    public void setLevelUpState() {
        this.director.setState(new LevelUpWorld(director));
    }
    
    public void setInitState() {
        this.director.setState(this);
    }
    
    public void prepare() {
        Counter counter = new Counter();
        addObject(counter, 58, 26);
        Turtle turtle = new Turtle(counter);
        addObject(turtle,100,100);
    }
}
