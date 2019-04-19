import java.util.List;

import greenfoot.*;

public class Snake extends Animal {
  /**
   * Act - do whatever the Snake wants to do. This method is called whenever
   * the 'Act' or 'Run' button gets pressed in the environment.
   */
  public void act() {
    List<Snake> snakes = this.getNeighbours(30, false, Snake.class);
    if (!snakes.isEmpty()) {
      System.out.println("another snake near vicinity and moving ");
      this.turn(WorldConfig.TURTLE_DEGREE);
      move(WorldConfig.SPEED_OF_SNAKES * 5);
    }

    List<Turtle> turtles = this.getNeighbours(WorldConfig.SNAKES_ATTRACTION, true, Turtle.class);
    System.out.println("number of turtles:" + turtles.size());
    if (!turtles.isEmpty()) {
        this.setImage("snake2_red.png");
      System.out.println("getting attracted by turtle:"  + this.getClass());
      
      Turtle turtle = turtles.get(0);
      this.turnTowards(turtle.getX(), turtle.getY());
      move(1);
    } else {
            move(WorldConfig.SPEED_OF_SNAKES);

    this.setImage("snake2.png");
      randomTurn();
    }
    worldEdge();
    eatTurtle();
  }

  /**
   * Check if lettuce there and then eat
   */
  public void eatTurtle() {
    if (canSee(Turtle.class)) {
      eat(Turtle.class);
      Greenfoot.playSound("gameover.wav");
      Greenfoot.stop();
    }
  }

}
