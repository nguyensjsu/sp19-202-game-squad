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
        if (Greenfoot.isKeyDown("Left")) {
            turn(-WorldConfig.getInstance().TURTLE_DEGREE);
        }

        if (Greenfoot.isKeyDown("Right")) {
            turn(WorldConfig.getInstance().TURTLE_DEGREE);
        }

        if (Greenfoot.isKeyDown("Up")) {
            move(WorldConfig.getInstance().TURTLE_SPEED);
        }

        if (Greenfoot.isKeyDown("Down")) {
            move(-WorldConfig.getInstance().TURTLE_SPEED);
        }
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
}
