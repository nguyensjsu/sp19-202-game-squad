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
      this.turn(WorldConfig.TURTLE_DEGREE);
      move(WorldConfig.SPEED_OF_SNAKES * 5);
    }

    List<Turtle> turtles = this.getNeighbours(WorldConfig.SNAKES_ATTRACTION, true, Turtle.class);
    if (!turtles.isEmpty()) {
      this.setImage("snake2_red.png");

      Turtle turtle = turtles.get(0);
      this.turnTowards(turtle.getX(), turtle.getY());
      move(0);
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
    if (canSee(Turtle.class) && (Turtle.getShield().power == 1)) {
        World world = Turtle.getTurtle().getWorld();
      eat(Turtle.class);
      eat(Shield.class);
      Helper.loadEndScreen("Looser", world); 
      Greenfoot.playSound("gameover.wav");
      Greenfoot.stop();
    }
  }

}
