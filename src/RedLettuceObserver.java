public class RedLettuceObserver implements IEatObserver
{

    public RedLettuceObserver()
    {
    }

    public void invoke(String className) {
        System.out.println("In red lettuce observer");
        if (RedLettuce.class.getName().equalsIgnoreCase(className)) {	       
            Turtle turtle = Turtle.getTurtle();	            
            Shield shield = Turtle.getShield();
            System.out.println("In red lettuce");
            ShieldBoostDecorator booster = new ShieldBoostDecorator(shield);
            booster.attach(new ShotObserver());
            shield.setDecorator(booster);
        }	        
    }
}
