import greenfoot.*;

public class Shield extends Animal implements IComponent, IShield {
  public int power;
  public boolean hitFlag;
  private IShield shieldBooster = null;


    public Shield(int p) {
        power = p;
        hitFlag = false;
        setImage("shield5.png");
    }

    public Shield() {
        power = 5;
        hitFlag = false;
        setImage("shield5.png");
        System.out.println("shield:" + power);
    }

    public void snakeHit() {
        power--;
        this.setImagePower(power);
    }

    public void setImagePower(int power) {
        switch (power) {
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

    public void act() {
    }

    public void moveactor() {
        move(WorldConfig.getInstance().TURTLE_SPEED);
        checkKeys();
        Turtle t = Turtle.getTurtle();
        try {
            setLocation(t.getX(), t.getY());
            setRotation(t.getRotation());
            if (canSee(Snake.class) && hitFlag == false) {
                System.out.println("hit");
                hitFlag = true;
                snakeHit();
            }

            if (hitFlag == true && !canSee(Snake.class)) {
                hitFlag = false;
            }

        } catch(Exception e) {

        }

    }

    public void checkKeys() {
        if (Greenfoot.isKeyDown("Left")) {
            turn(-WorldConfig.getInstance().TURTLE_DEGREE);
        }

        if (Greenfoot.isKeyDown("Right")) {
            turn(WorldConfig.getInstance().TURTLE_DEGREE);
        }

        if (Greenfoot.isKeyDown("Up")) {
            move(WorldConfig.getInstance().TURTLE_SPEED);
        }

        if (Greenfoot.isKeyDown("Down")) {
            move(-WorldConfig.getInstance().TURTLE_SPEED);
        }
    
    if ("space".equals(Greenfoot.getKey()))
    {
        attack();
    }
  }
  
   public void setDecorator(IShield shieldBooster) {
        System.out.println("In booster decorator");
        this.shieldBooster = shieldBooster;
    }

     public void removeDecorator() {
        this.shieldBooster = null;
    }

     public void attack() {
        if (this.shieldBooster != null)
            shieldBooster.attack();
    }

}
