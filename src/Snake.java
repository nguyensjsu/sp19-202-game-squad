import greenfoot.*;

public class Snake extends Animal
{
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    move(1);
        randomTurn();
        worldEdge();
        eatTurtle();
    }
    
    /**
     * 10% of the time turn at a random angle between -20 and 20.
     */
    public void randomTurn()
    {
        if (Greenfoot.getRandomNumber(100) < 10)
        {
            turn(Greenfoot.getRandomNumber(40)-20);
        }
    }
    
    /**
     * If we reach the end of the world, turn a little bit
     */
    public void worldEdge()
    {
        if (atWorldEdge())
        {
            turn(7);
        }
    }
    
    /**
     * Check if lettuce there and then eat
     */
    public void eatTurtle()
    {
        if(canSee(Turtle.class) && (Turtle.getShield().power == 1))
        {
         eat(Turtle.class);  
         eat(Shield.class);  
         Greenfoot.playSound("gameover.wav");
         Greenfoot.stop();
        }
    }   
      
}
