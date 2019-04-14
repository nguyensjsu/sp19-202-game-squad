import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelUpWorld extends AbstractWorld
{
    public LevelUpWorld(DirectorState director) {
        super(director);
    }
   
    public void setEndGameState() {
        this.director.setState(new EndWorld(director));
    }
    
    public void setPlayGameState() {
        this.director.setState(new TurtleWorld(director));
    }
    
    public void setLevelUpState() {
        this.director.setState(this);
    }
    
    public void setInitState() {
        this.director.setState(new InitState(director));
    }
    
    public void prepare() {
    }
}
