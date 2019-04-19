/**
 * Write a description of class RedLettuceObserver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import greenfoot.*;

public class RedLettuceObserver implements IEatObserver 
{
   
    public RedLettuceObserver()
    {
    }
    
    public void invoke(String className) {
        if (RedLettuce.class.getName().equalsIgnoreCase(className)) {
            Turtle turtle = Turtle.getTurtle();
            PowerDecorator p = new Gun(turtle);
            turtle.setDecorator(p);
        }
    }
}
