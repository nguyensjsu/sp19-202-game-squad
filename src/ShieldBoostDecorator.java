import greenfoot.*;

 public class ShieldBoostDecorator extends ShieldDecorator implements IShotSubject
{
    IShield shield;
    int shots = WorldConfig.getInstance().SHOTS;
    IShotObserver observer = null;

     public ShieldBoostDecorator(IShield shield)
    {
       super(shield); 
       this.shield = shield;
    }

     public void attach(IShotObserver obj) {
       System.out.println("In attach shot observer"); 
       observer = obj;
    }

     public void removeObserver() {
      observer = null;
    }

     public void notifyObserver() {
       if (observer != null)
        observer.invoke();
    }

     public void attack() {
        System.out.println("In booster");
        if (this.shots > 0) {  
            Actor a = (Actor)shield;
        Shot shot = new Shot(5);
        World world = a.getWorld();
        world.addObject(shot, a.getX(), a.getY());
        shot.setRotation(a.getRotation());
        shot.move(55);
        move(WorldConfig.getInstance().TURTLE_SPEED);
        this.shots -= 1;
        if (this.shots == 0)
            notifyObserver();
      }
    }
}