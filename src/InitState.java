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
        
    }
    
    public void prepare() {
        Counter counter = new Counter();
        addObject(counter, 58, 26);
        Turtle turtle = Turtle.getTurtle();
        addObject(turtle,100,100);
    }
}
