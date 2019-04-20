import greenfoot.*;

public class Helper {

  public static void createActor(Actor actor, int x, int y) {
    World world = Turtle.getTurtle().getWorld();
    world.addObject(actor, x, y);
  }
  
  public static void loadEndScreen(String text, World world) {
    deleteAll(world);
    world.showText(text,400,300);
  }
  
  public static void deleteAll(World world) {
    world.removeObjects(world.getObjects(null));
  }
}
