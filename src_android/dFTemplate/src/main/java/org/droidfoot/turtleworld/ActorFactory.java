package org.droidfoot.turtleworld;

import greenfoot.*;
public interface ActorFactory  
{
    public Actor createActor(String type, int x, int y);
}
