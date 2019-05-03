
package org.droidfoot.turtleworld;
import greenfoot.*;

public class Helper {

  public static void createActor(Actor actor, int x, int y) {
    World world = Turtle.getTurtle().getWorld();
    world.addObject(actor, x, y);
  }

  public static void loadEndScreen(String text, World world) {
    Greenfoot.playSound("gameover.wav");
    Greenfoot.stop();
    deleteAll(world);
    world.showText(text,400,300);
  }

  public static void resetAll(World world) {
    world.removeObjects(world.getObjects(null));
  }

  public static void deleteAll(World world) {
    world.removeObjects(world.getObjects(Bug.class));
    world.removeObjects(world.getObjects(Shield.class));
    world.removeObjects(world.getObjects(Snake.class));
    world.removeObjects(world.getObjects(Turtle.class));
    world.removeObjects(world.getObjects(Lettuce.class));
    world.removeObjects(world.getObjects(RedLettuce.class));
    world.removeObjects(world.getObjects(Shot.class));
  }
}