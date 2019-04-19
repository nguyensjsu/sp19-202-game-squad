import greenfoot.*;

public class TurtleWorld extends AbstractWorld
{
    
    public TurtleWorld(DirectorState director) {
        super(director);
    }
   
    public void setEndGameState() {
        this.director.setState(new EndWorld(director));
    }
    
    public void setPlayGameState() {
        this.director.setState(this);
    }
    
    public void setLevelUpState() {
        this.director.setState(new LevelUpWorld(director));
    }
    
    public void setInitState() {
        this.director.setState(new InitState(director));
    }
   
    
    public void prepare()
    {

        int worldWidth = getWidth();
        int worldHeight = getHeight();

        ActorManager actorManager = new ActorManager();
        ScoreManager scoreManager = new ScoreManager(actorManager);
        Counter counter = new Counter();
        addObject(counter, 58, 26);
        counter.attach(scoreManager);
        Turtle turtle = Turtle.getTurtle();
        Shield shield = Turtle.getShield();
        addObject(shield,100,100);
        addObject(turtle,100,100);
        turtle.attach(new RedLettuceObserver());
        turtle.attach(counter);
        turtle.attach(actorManager);
        actorManager.createLettuce();
        actorManager.createSnakes();
        actorManager.createBug();
        actorManager.createLettuce();
        
        Snake snake3 = new Snake();
        addObject(snake3,417,317);
        /*
        Lettuce lettuce = new Lettuce();
        addObject(lettuce,395,135);
        Lettuce lettuce2 = new Lettuce();
        addObject(lettuce2,240,183);
        Lettuce lettuce3 = new Lettuce();
        addObject(lettuce3,138,184);
        Lettuce lettuce4 = new Lettuce();
        addObject(lettuce4,103,294);
        Lettuce lettuce5 = new Lettuce();
        addObject(lettuce5,103,388);
        Lettuce lettuce6 = new Lettuce();
        addObject(lettuce6,275,385);
        Lettuce lettuce7 = new Lettuce();
        addObject(lettuce7,415,254);
        Lettuce lettuce8 = new Lettuce();
        addObject(lettuce8,300,254);
        Lettuce lettuce9 = new Lettuce();
        addObject(lettuce9,142,79);
        Snake snake = new Snake();
        addObject(snake,350,81);
        Snake snake2 = new Snake();
        addObject(snake2,456,189);
        Snake snake3 = new Snake();
        addObject(snake3,417,317);
        Snake snake4 = new Snake();
        addObject(snake4,512,150);
        Snake snake5 = new Snake();
        addObject(snake5,517,77);
        Snake snake6 = new Snake();
        addObject(snake6,528,227);
        Snake snake7 = new Snake();
        addObject(snake7,495,322);
        Snake snake8 = new Snake();
        addObject(snake8,484,385);
        Snake snake9 = new Snake();
        addObject(snake9,390,407);
        Snake snake10 = new Snake();
        addObject(snake10,334,315);
        Snake snake11 = new Snake();
        addObject(snake11,327,254);
        Snake snake12 = new Snake();
        addObject(snake12,347,179);
        Snake snake13 = new Snake();
        addObject(snake13,355,163);
        Snake snake14 = new Snake();
        addObject(snake14,389,118);
        Snake snake15 = new Snake();
        addObject(snake15,407,84);
        Snake snake16 = new Snake();
        addObject(snake16,412,77);
        Snake snake17 = new Snake();
        addObject(snake17,278,59);
        Snake snake18 = new Snake();
        addObject(snake18,276,121);
        Snake snake19 = new Snake();
        addObject(snake19,197,292);
        Snake snake20 = new Snake();
        addObject(snake20,169,183);
        lettuce9.setLocation(155,91);
        Snake snake21 = new Snake();
        addObject(snake21,155,91);
        Snake snake22 = new Snake();
        addObject(snake22,213,104);
        snake22.setLocation(213,104);
        Snake snake23 = new Snake();
        addObject(snake23,213,104);
        Snake snake24 = new Snake();
        addObject(snake24,21,116);
        Snake snake25 = new Snake();
        addObject(snake25,109,51);
        Snake snake26 = new Snake();
        addObject(snake26,95,112);
        Snake snake27 = new Snake();
        addObject(snake27,269,175);
        Snake snake28 = new Snake();
        addObject(snake28,119,145);
        Snake snake29 = new Snake();
        addObject(snake29,27,197);
        Snake snake30 = new Snake();
        addObject(snake30,302,182);
        Snake snake31 = new Snake();
        addObject(snake31,311,154);
        snake20.setLocation(195,172);
        Snake snake32 = new Snake();
        addObject(snake32,195,172);
        Snake snake33 = new Snake();
        addObject(snake33,205,21);
        removeObject(snake10);
        removeObject(snake30);
        removeObject(snake13);
        removeObject(snake9);
        removeObject(snake16);
        removeObject(snake15);
        removeObject(snake14);
        removeObject(snake5);
        removeObject(snake4);
        removeObject(snake6);
        removeObject(snake7);
        removeObject(snake8);
        removeObject(snake3);
        removeObject(snake2);
        removeObject(snake11);
        removeObject(snake12);
        removeObject(snake);
        removeObject(snake31);
        removeObject(snake27);
        removeObject(snake18);
        removeObject(snake17);
        removeObject(snake19);
        removeObject(snake32);
        removeObject(snake23);
        removeObject(snake20);
        removeObject(snake22);
        removeObject(snake33);
        removeObject(snake21);
        removeObject(snake28);
        removeObject(snake26);
        removeObject(snake25);
        removeObject(snake24);
        snake29.setLocation(317,59);
        removeObject(lettuce9);
        removeObject(lettuce6);
        Bug bug = new Bug();
        addObject(bug,327,323);
        Snake snake34 = new Snake();
        addObject(snake34,486,71);
        */
    }
}