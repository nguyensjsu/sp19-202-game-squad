package org.droidfoot.turtleworld;

import greenfoot.*;

public interface IEatSubject  
{
    void attach (IEatObserver obj);
    void removeObserver (IEatObserver obj);
    void notifyObservers(String clss);
}
