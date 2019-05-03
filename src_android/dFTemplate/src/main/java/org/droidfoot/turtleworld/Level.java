package org.droidfoot.turtleworld;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.awt.*;


public class Level extends Actor implements IScoreObserver
{
    private static final Color transparent = new Color(0, 0, 0, 0);
    private GreenfootImage background;
    private int level;

    /**
     * Create a new counter, initialised to 0.
     */
    public Level() {
        background = new GreenfootImage("corkboard.jpg"); //getImage();  // get image from class
        level = 1;
        updateImage();
    }

    /**
     * Animate the display to count up (or down) to the current target value.
     */
    public void act() {

    }

    /**
     * Set a new counter value.
     */
    public void incrementLevel(int ll) {
        System.out.println("current level: " + level + " received:"  + ll);
        if (ll > level-1) {
            this.level++;
            if (this.level >= WorldConfig.getInstance().MAX_LEVEL) {
                Helper.loadEndScreen("WON", Turtle.getTurtle().getWorld());
                updateImage();
                Turtle.die();
            }
            updateImage();
        }
    }

    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage() {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage("Level:" + level, 22, Color.BLACK,
                transparent);
        image.drawImage(text, (image.getWidth() - text.getWidth()) / 2,
                (image.getHeight() - text.getHeight()) / 2);
        this.setImage(image);
    }

    public void scoreAction(int score) {
        System.out.println("scored received in Level:" + score);
        int ll = score / WorldConfig.getInstance().LEVEL_FACTOR;
        incrementLevel(ll);
    }
}