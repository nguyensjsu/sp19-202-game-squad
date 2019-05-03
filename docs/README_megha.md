Decorator pattern:

Shield class contains a decorator object which is initially set to Null. The attack() method of Shield invokes the decorator's attack method if it is not null. Initially Shield class does not perform any opertaion since the decorator object is Null. Once Turtle eats the Red Lettuce, RedLettuceObserver assigns ShieldBoostDecorator as the decorator. attack() method is invoked on clicking the shield. ShieldBoostDecorator's attack() method releases a Shot. It is assigned 10 Shots and once all Shots are used, the decorator is reset to null.

Feature: Points System

Implemented the Points System for the game. When the turtle eats lettuce or bug, game counter is incremented. Eating the green lettuce increments the count by 5 and eating the ladybug increments counter with 20 points.
