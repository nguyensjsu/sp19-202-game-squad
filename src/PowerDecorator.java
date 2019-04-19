/**
 * Write a description of class PowerDecorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import greenfoot.*;
public class PowerDecorator extends Actor implements KeyListener 
{
   
    KeyListener keyListener;
    
    public PowerDecorator(KeyListener keyListener)
    {   
        this.keyListener = keyListener;
    }

    public void keyLeftAction() {
        keyListener.keyLeftAction();
    }
    
     public void keyRightAction() {
         keyListener.keyRightAction();
    }
    
     public void keyUpAction() {
        keyListener.keyUpAction();
    }
    
     public void keyDownAction() {
       keyListener.keyDownAction();
    }
}

