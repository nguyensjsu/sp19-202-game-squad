import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EndWorld extends AbstractWorld
{
    public EndWorld(DirectorState director) {
        super(director);
    }
   
    public void setEndGameState() {
        this.director.setState(new EndWorld(director));
    }
    
    public void setPlayGameState() {
        this.director.setState(this);
    }
    
    public void setLevelUpState() {
        this.director.setState(new LevelUpWorld(director));
    }
    
    public void setInitState() {
        this.director.setState(new InitState(director));
    }
    
    public void prepare() {
    }
}
