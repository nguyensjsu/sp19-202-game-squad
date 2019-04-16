import greenfoot.*;

public class DirectorState extends World 
{
    private AbstractWorld playState;
    private AbstractWorld currentState;

    public DirectorState() {
        super(WorldConfig.getX(), WorldConfig.getY(), WorldConfig.getCellSize());    
        playState = new TurtleWorld(this);
        System.out.println("construc call");
        setState(new TurtleWorld(this));
    }
    
    public void setState(AbstractWorld state) {
        this.currentState = state;
        Greenfoot.setWorld(currentState);
        System.out.println("this");
        currentState.prepare();
        System.out.println("this act");
        currentState.started();
        currentState.act();
        System.out.println(currentState.toString());
        System.out.println(currentState.numberOfObjects());
    }
}
