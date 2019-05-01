import greenfoot.*;

public class TurtleWorld extends World {

    public TurtleWorld() {
        super(WorldConfig.getX(), WorldConfig.getY(), WorldConfig.getCellSize());
        System.out.println("construc call");
        loadInitScreen();
    }

    public void loadPlayScreen() {
        Helper.resetAll(this);
        reinitialize();
    }

    public void loadInitScreen() {
        Helper.resetAll(this);
        initScreen();
    }

    private void initScreen() {
        // init function
        addObject(new ChooseDifficulty(), 380, 100);
        addObject(new DifficultyLow(this), 390, 200);
        addObject(new DifficultyMedium(this), 390, 305);
        addObject(new DifficultyHigh(this), 390, 410);
    }

    private void reinitialize() {
        int worldWidth = getWidth();
        int worldHeight = getHeight();

        ActorManager actorManager = new ActorManager();
        ScoreManager scoreManager = new ScoreManager(actorManager);
        Level level = new Level();
        addObject(level, 380,26);
        Counter counter = new Counter();
        addObject(counter, 58, 26);
        counter.attach(scoreManager);
        counter.attach(level);
        Turtle turtle = Turtle.init();
        Shield shield = Turtle.getShield();
        addObject(shield,100,100);
        addObject(turtle, 100, 100);
        turtle.attach(new RedLettuceObserver());
        turtle.attach(counter);
        turtle.attach(actorManager);
        actorManager.createLettuce();
        actorManager.createSnakes();
        actorManager.createBug();
    }
}