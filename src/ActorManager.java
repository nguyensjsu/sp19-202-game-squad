
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import greenfoot.*;

/**
 * This class can be the observer of actor like lettuce, red lettuce and
 * bug and snake. Purpose of this class can be strictly to recreate the actors
 * based on timer provided in the configs.
 */
public class ActorManager implements IEatObserver {

  private ActorFactory factory = new ActorGenerator();
  private Set<String> lettuceSet;

  private Set<String> threadQueued = new HashSet<>();
  private ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

  public ActorManager() {

  }

  public void createLettuce() {

    lettuceSet = new HashSet<>();

    World world = Turtle.getTurtle().getWorld();
    List<Lettuce> lettucs = world.getObjects(Lettuce.class);

    for (Lettuce lt : lettucs) {
      lettuceSet.add(str(lt.getX(), lt.getY()));
    }
    int existing = lettucs.size();

    int worldWidth = world.getWidth();
    int worldHeight = world.getHeight();

    int remaining = WorldConfig.NUM_OF_LETTUCE - existing;

    int i = 0;
    while (0 < remaining) {
      int x = Greenfoot.getRandomNumber(worldWidth);
      int y = Greenfoot.getRandomNumber(worldHeight);
      if (!lettuceSet.contains(str(x, y))) {
        factory.createActor(Lettuce.class.getName(), x, y);
        remaining--;
      }
    }
  }

  public void createRedLettuce() {
    // only at multiple of 100 it should be created.
    // wait for 1 minute after that remove it.
    World world = Turtle.getTurtle().getWorld();
    List<RedLettuce> redLettucs = world.getObjects(RedLettuce.class);

    if (redLettucs.isEmpty()) {

      int worldWidth = world.getWidth();
      int worldHeight = world.getHeight();

      int x = Greenfoot.getRandomNumber(worldWidth);
      int y = Greenfoot.getRandomNumber(worldHeight);
      Actor lettuce = factory.createActor(RedLettuce.class.getName(), x, y);

      String className = RedLettuce.class.getName();
      if (!threadQueued.contains(className)) {
        threadQueued.add(className);
        System.out.println("Red Lettuce scheduled:" + className);
        Thread thread = new Thread(() -> {
          world.removeObject(lettuce);
          threadQueued.remove(className);
        });
        executor.schedule(thread, 60, TimeUnit.SECONDS);
      }
    }
  }





  public void createBug() {

    World world = Turtle.getTurtle().getWorld();
    List<Bug> bugs = world.getObjects(Bug.class);
    int worldWidth = world.getWidth();
    int worldHeight = world.getHeight();

    if (bugs.isEmpty()) {
      int x = Greenfoot.getRandomNumber(worldWidth);
      int y = Greenfoot.getRandomNumber(worldHeight);
      factory.createActor(Bug.class.getName(), x, y);
    }
  }

  private String str(int x, int y) {
    return x + ":" + y;
  }

  @Override
  public void invoke(String clss) {
    if (clss.equals(Lettuce.class.getName())) {
      if (!threadQueued.contains(clss)) {
        threadQueued.add(clss);
        System.out.println("Green Lettuce scheduled:" + clss);
        Thread thread = new Thread(() -> {
          createLettuce();
          threadQueued.remove(clss);
        });
        executor.schedule(thread, 30, TimeUnit.SECONDS);
      }

    }

    if (clss.equals(Bug.class.getName())) {
      if (!threadQueued.contains(clss)) {
        threadQueued.add(clss);
        System.out.println("Bug scheduled:" + clss);
        Thread thread = new Thread(() -> {
          createBug();
          threadQueued.remove(clss);
        });
        executor.schedule(thread, 60, TimeUnit.SECONDS);
      }
    }
  }

}
