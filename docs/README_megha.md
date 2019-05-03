Decorator pattern:

Shield class contains a decorator object which is initially set to Null. The attack() method of Shield invokes the decorator's attack method if it is not null. Initially Shield class does not perform any opertaion since the decorator object is Null. Once Turtle eats the Red Lettuce, RedLettuceObserver assigns ShieldBoostDecorator as the decorator. attack() method is invoked on clicking the shield. ShieldBoostDecorator's attack() method releases a Shot. It is assigned 10 Shots and once all Shots are used, the decorator is reset to null.

Feature: Turtle gets special powers:

When Turtle eats the Red Lettuce, it's shield acquires shooting powers. It can shoot 10 gunshots. Once all gunshots are used, it can't shoot any further.
