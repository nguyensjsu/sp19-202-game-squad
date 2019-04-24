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