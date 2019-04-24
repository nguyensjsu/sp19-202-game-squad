public class ShotObserver implements IShotObserver
{


     public ShotObserver()
    {
    }

     public void invoke() {
        System.out.println("In shot observer");
        Turtle turtle = Turtle.getTurtle();
        Shield shield = turtle.getShield();
        shield.removeDecorator();
    }
}