package org.droidfoot.turtleworld;

public interface IShotSubject
{
    void attach (IShotObserver obj);
    void removeObserver ();
    void notifyObserver();
}