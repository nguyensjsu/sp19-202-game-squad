import java.util.*;
import greenfoot.*;
/**
 * This class can be the observer of actor like lettuce, red lettuce and 
 * bug and snake. Purpose of this class can be strictly to recreate the actors
 * based on timer provided in the configs.
 * 
 */
public class ActorManager {

    private ActorFactory factory = new ActorGenerator();
    private Set<String> lettuceSet;

    public ActorManager() {
    }
    
    public void createLettuce() {

        lettuceSet = new HashSet<>();
        
        World world = Turtle.getTurtle().getWorld();
        List<Lettuce> lettucs = world.getObjects(Lettuce.class);
        
        for (Lettuce lt: lettucs) {
            lettuceSet.add(str(lt.getX(), lt.getY()));
        }
        int existing = lettucs.size();
        
        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();
        
        int remaining = WorldConfig.NUM_OF_LETTUCE - existing;
        factory.createActor(RedLettuce.class.getName(),  Greenfoot.getRandomNumber(worldWidth), Greenfoot.getRandomNumber(worldHeight));
        int i = 0;
        while(0<remaining) {
            int x = Greenfoot.getRandomNumber(worldWidth);
            int y = Greenfoot.getRandomNumber(worldHeight);
            if (!lettuceSet.contains(str(x, y))) {
             factory.createActor(Lettuce.class.getName(), x, y); 
             remaining--;
            }
        }
        System.out.println("set:" + lettuceSet);
    }
    
    private String str(int x, int y) {
        return x+":"+y;
    }
}
