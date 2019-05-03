package org.droidfoot.turtleworld;

import java.util.ArrayList;
import java.util.List;

import greenfoot.*;

/*
 * Turtle class, singleton
 */
public class Turtle extends Animal implements IEatSubject, IComponent {

    private static Turtle turtle;
    List<IEatObserver> observers;

    private static Shield shield;

    private Turtle() {
         setImage("turtle.png");
        observers = new ArrayList<>();
    }

    public static void die() {
        turtle = null;
    }

    public void snakeHit() {
        shield.snakeHit();
    }

    public static Turtle getTurtle() {
        if (turtle == null) {
            return init();
        }
        return turtle;
    }

    public static Shield getShield() {
        return shield;
    }

    public static Turtle init() {
        turtle = new Turtle();
        turtle.shield = new Shield();
        return turtle;
    }

    public void act() {
        if (turtle != null) {
            moveactor();
            shield.moveactor();
        }
    }

    public void moveactor() {
        move(WorldConfig.getInstance().TURTLE_SPEED);
        checkKeys();
        if (canSee(Lettuce.class)) {
            eat(Lettuce.class);
        } else if (canSee(RedLettuce.class)) {
            eat(RedLettuce.class);
        } else if (canSee(Bug.class)) {
            eat(Bug.class);
        }
    }

    public void checkKeys() {
        if (Greenfoot.mousePressed(null) && !Greenfoot.mousePressed(this)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            int mouseX = mouse.getX();
            int mouseY = mouse.getY();
            int myY = this.getY();
            int myX = this.getX();

            turtle.turnTowards(mouseX, mouseY);
            turtle.move(5);

        }

    }

    public void keyLeftAction() {
        turn(-WorldConfig.getInstance().TURTLE_DEGREE);
    }

    public void keyRightAction() {
        turn(WorldConfig.getInstance().TURTLE_DEGREE);
    }

    public void keyUpAction() {
        move(WorldConfig.getInstance().TURTLE_SPEED);
    }

    public void keyDownAction() {
        move(-WorldConfig.getInstance().TURTLE_SPEED);
    }

    public void eat(Class clss) {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        Greenfoot.playSound("slurp.wav");

        if (actor != null) {
            String className = actor.getClass().getName();
            getWorld().removeObject(actor);
            notifyObservers(className);
        }
    }

    public void attach(IEatObserver obj) {
        observers.add(obj);
    }

    public void removeObserver(IEatObserver obj) {
        int i = observers.indexOf(obj);
        if (i >= 0)
            observers.remove(i);
    }

    public void notifyObservers(String className) {
        for (int i = 0; i < observers.size(); i++) {
            IEatObserver observer = observers.get(i);
            observer.invoke(className);
        }
    }
    /*
    private int points;
    private Counter counter;

    public Turtle()
    {

    }

    public Turtle(Counter pointCounter)
    {
    counter = pointCounter;
    }

    public void eat()
    {
    if(canSee(Lettuce.class))
    {
    eat(Lettuce.class);  
    //points++;
    counter.add(5);
    Greenfoot.playSound("slurp.wav");
    }

    if(canSee(Bug.class))
    {
    eat(Bug.class);  
    //points = points + 5;
    counter.add(20);
    Greenfoot.playSound("slurp.wav");
    createNewBug();
    }

    if (counter.getValue() >= 80) 
    {
    gameOver();
    }
    }

    private void createNewBug()
    {
    Bug newBug;

    newBug = new Bug();

    World world;
    world = getWorld();

    int worldWidth = world.getWidth();
    int worldHeight = world.getHeight();

    int x = Greenfoot.getRandomNumber(worldWidth);
    int y = Greenfoot.getRandomNumber(worldHeight);

    world.addObject(newBug, x, y);
    }

    public void gameOver()
    {
    Greenfoot.playSound("fanfare.aiff");
    Greenfoot.stop();
    }
     */
}
