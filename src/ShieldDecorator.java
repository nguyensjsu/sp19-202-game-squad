/**
 * Write a description of class ShieldDecorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShieldDecorator extends Animal implements IShield 
{
    
    IShield shield;
    public ShieldDecorator(IShield shield)
    {
        this.shield = shield;
    }

    public void attack() {
        shield.attack();
    }
    
}
