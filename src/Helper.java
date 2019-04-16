import greenfoot.*;

public class Helper {

  public static void createActor(Actor actor, int x, int y) {
    World world = Turtle.getTurtle().getWorld();
    world.addObject(actor, x, y);
  }
}
