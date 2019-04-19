


import greenfoot.*; 
/**
 * Write a description of class Shield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shield extends Actor implements IComponent
{
    // instance variables - replace the example below with your own
    private int power;

    /**
     * Constructor for objects of class Shield
     */
    public Shield()
    {
        power = 5;
    }

    public Shield(int p)
    {
        power = p;
    }
    
    public void snakeHit(){
        power--;
        setImage(power);
    }
    
    public void setImage(int power){
     switch(power){
     case 1: 
     setImage("shield1.png");
     break;
     case 2:
     setImage("shield2.png");
     break;
     case 3:
     setImage("shield3.png");
     break;
     case 4:
     setImage("shield4.png");
     break;
     case 5:
     setImage("shield5.png");
     break;
     default:
     setImage("shield5.png");
     break;
     
    }
     
    }
    
    public void act()
    {
        move(WorldConfig.TURTLE_SPEED);
        checkKeys();
        //eat();
    }

    public void checkKeys()
    {
        if (Greenfoot.isKeyDown("Left"))
        {
            turn(-WorldConfig.TURTLE_DEGREE);
        }

        if (Greenfoot.isKeyDown("Right"))
        {
            turn(WorldConfig.TURTLE_DEGREE);
        }

        if (Greenfoot.isKeyDown("Up"))
        {
            move(WorldConfig.TURTLE_SPEED);
        }

        if (Greenfoot.isKeyDown("Down"))
        {
            move(-WorldConfig.TURTLE_SPEED);
        }
    }

}    
  

