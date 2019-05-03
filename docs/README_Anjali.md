##Composite Pattern

We used Composite pattern to add shield to the Turtle.
The shield and turtle share methods to move around, action on keypress and snake Hit. Shield and turtle move together and can be treated as a group. With composite we can add multiple accessories to Turtle and move them together.  Also Implemented a feature of changing shield power. On intersection with a snake power of shield decreases by 1, which also results in changing the image of the shield to a smaller shield.
Interface: IComponent
Classes: Shield, Turtle


##Feature: The snake movement and its attraction towards Turtle

For this we have used method getNeighbours() provided by Greenfoot. On every move snake keeps on checking if there is a turtle in its radius of effect (getNeighbours()). On finding	a turtle in its neighborhood, snake’s changes its direction and starts moving in direction of the turtle. Also snake’s image changes to ‘RedSnakeImage’ on attraction.

Classes: Snake, Turtle
