
/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*; 
public class Gun extends PowerDecorator 
{
    KeyListener keyListener;
    int shots = 5;

    /**
     * Constructor for objects of class Gun
     */
    public Gun(KeyListener keyListener)
    {   
        super(keyListener);
        this.keyListener = keyListener;
    }

    public void keySpaceAction() {
        if (this.shots > 0) {
        Actor a = (Actor)this.keyListener;
        Shot shot = new Shot(5);
        World world = Turtle.getTurtle().getWorld();
        world.addObject(shot, a.getX(), a.getY());
        shot.setRotation(Turtle.getTurtle().getRotation());
        shot.move(55);
        move(WorldConfig.TURTLE_SPEED);
        this.shots -= 1;
      }
    }
    
}
