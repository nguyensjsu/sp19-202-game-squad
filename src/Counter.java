import java.util.ArrayList;
import java.util.List;

import greenfoot.*;

public class Counter extends Actor implements IEatObserver, IScoreSubject {
  private static final Color transparent = new Color(0, 0, 0, 0);
  private GreenfootImage background;
  private int value;

  List<IScoreObserver> observers;

  int increments = 0;

  /**
   * Create a new counter, initialised to 0.
   */
  public Counter() {
    observers = new ArrayList<>();
    background = getImage();  // get image from class
    value = 0;
    increments = 0;
    updateImage();
    System.out.println("Counter value: " + value);
  }

  /**
   * Animate the display to count up (or down) to the current target value.
   */
  public void act() {

  }

  /**
   * Add a new score to the current counter value.
   */
  public void add(int score) {
    setValue(score + getValue());
  }

  /**
   * Return the current counter value.
   */
  public int getValue() {
    return value;
  }

  /**
   * Set a new counter value.
   */
  public void setValue(int newValue) {
    value = newValue;
    updateImage();
  }

  /**
   * Update the image on screen to show the current value.
   */
  private void updateImage() {
    GreenfootImage image = new GreenfootImage(background);
    GreenfootImage text = new GreenfootImage("" + value, 22, Color.BLACK,
      transparent);
    image.drawImage(text, (image.getWidth() - text.getWidth()) / 2,
      (image.getHeight() - text.getHeight()) / 2);
    this.setImage(image);
  }

  @Override
  public void invoke(String clss) {

    if (clss.equals(Lettuce.class.getName())) {
      add(5);
    }

    if (clss.equals(Bug.class.getName())) {
      add(20);
    }
    int diff = value - (increments * 10);
    if (diff >= 10) {
      System.out.println("notifiying score observers for score:" + value);
      increments++;
      notifyObservers();
      System.out.println("value of counter :" + value + " obj:" + this.toString());
    }
  }

  @Override
  public void attach(IScoreObserver obj) {
    observers.add(obj);
  }

  @Override
  public void removeObserver(IScoreObserver obj) {
    int i = observers.indexOf(obj);
    if (i >= 0)
      observers.remove(i);
  }

  @Override
  public void notifyObservers() {
    for (int i = 0; i < observers.size(); i++) {
      IScoreObserver observer = observers.get(i);
      observer.scoreAction(value);
    }
  }
}