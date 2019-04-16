import greenfoot.*;

public class ActorGenerator implements ActorFactory  
{
    public Actor createActor(String type, int x, int y) {
        Actor actor = null;
        if (Bug.class.getName().equalsIgnoreCase(type)) {
            actor = createBug(x, y);
        } else if (Lettuce.class.getName().equalsIgnoreCase(type)) {
            actor = createLettuce(x, y);
        } else if (RedLettuce.class.getName().equalsIgnoreCase(type)) {
            actor = createRedLettuce(x, y);
        } else if (Snake.class.getName().equalsIgnoreCase(type)) {
            actor = createSnake(x, y);
        }
        return actor;
    }
    
    private Actor createSnake(int x, int y) {
        Snake snake = new Snake();
        Helper.createActor(snake,x,y);
        return snake;
    }
    
    private Actor createLettuce(int x, int y) {
        Lettuce lettuce = new Lettuce();
        Helper.createActor(lettuce,x,y);
        return lettuce;
    }
    
    private Actor createRedLettuce(int x, int y) {
        RedLettuce rl = new RedLettuce();
        Helper.createActor(rl,x,y);
        return rl;
    }
    
    private Actor createBug(int x, int y) {
        Bug bug = new Bug();
        Helper.createActor(bug,x , y);
        return bug;
    }

}
