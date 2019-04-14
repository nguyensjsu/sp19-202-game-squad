import greenfoot.*;

public class DirectorState extends World 
{
    private AbstractWorld playState;
    private AbstractWorld currentState;

    public DirectorState() {
        super(WorldConfig.getX(), WorldConfig.getY(), WorldConfig.getCellSize());    
        playState = new TurtleWorld(this);
        setState(new InitState(this));
    }
    
    public void setState(AbstractWorld state) {
        this.currentState = state;
        Greenfoot.setWorld(currentState);
        currentState.prepare();
    }
}
