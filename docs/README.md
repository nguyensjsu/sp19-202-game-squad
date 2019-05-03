# Game Squad

Table of contents
=================

   * [UI Wireframes](#ui-wireframes)
   * [Use Case](#use-case)
   * [Class Diagram](#class-diagram)
   * [Activity Diagram](#activity-diagram)
   * [Design Patterns](#design-patterns)
      * [Decorator](#decorator)
      * [Strategy](#strategy)
      * [Factory](#factory)
      * [Composite](#composite)
      * [Observer](#observer)
      * [Feature 1](#feature-1)
      * [Feature 2](#feature-2)
      * [Feature 3](#feature-3)
      * [Feature 4](#feature-4)
      * [Feature 5](#feature-5)

## UI Wireframes

![Alt text](/docs/Wireframes/1_Game%20Options.png?raw=true "Story #1")

![Alt text](/docs/Wireframes/2_Startup.png?raw=true "Story #2")

![Alt text](/docs/Wireframes/3_Snake%20attracted.png?raw=true "Story #3")

![Alt text](/docs/Wireframes/4_Points.png?raw=true "Story #4")

![Alt text](/docs/Wireframes/5_Turtle%20dies.png?raw=true "Story #5")

![Alt text](/docs/Wireframes/6_Advancing%20to%20next%20level.png?raw=true "Story #6")

![Alt text](/docs/Wireframes/7_Shield.png?raw=true "Story #7")

![Alt text](/docs/Wireframes/8_Shooting%20power.png?raw=true "Story #8")

![Alt text](/docs/Wireframes/9_Lady%20Bug%20-%20Story%20%239.png?raw=true "Story #9")

![Alt text](/docs/Wireframes/10_Won%20the%20game.png?raw=true "Story #10")

## Use Case
![Alt text](/docs/UseCase_Diagram.png?raw=true "Use Case Diagram")

## Class Diagram

![Alt text](/docs/class_diagram.png?raw=true "Class Diagram")

## Activity Diagram
![Alt text](/docs/activity_diagram.png?raw=true "Activity Diagram")

## Design Patterns
#### Decorator

Shield class contains a decorator object which is initially set to Null. The ```attack()``` method of ```Shield``` invokes the decorator's attack method if it is not null. Initially Shield class does not perform any opertaion since the decorator object is Null. Once Turtle eats the ```RedLettuce```, ```RedLettuceObserver``` assigns ```ShieldBoostDecorator``` as the decorator. ```attack()``` method is invoked on clicking the shield. ShieldBoostDecorator's attack() method releases a Shot. It is assigned 10 Shots and once all Shots are used, the decorator is reset to null.

![Alt text](/docs/Story8-ShootingPower.png?raw=true "Decorator Pattern")

<img src="/docs/Story8_use_case_specification.png"  width="500" height="500">


#### Strategy

We used strategy pattern for Game startup screen. When user wants to play the game, user will first see the game startup screen. Game startup screen has 3 difficulty button Low, Medium and High. User has to choose one of the difficulty to play the game. Each difficulty is different from each other in various attributes. So we have decided to use strategy pattern for this story. There are number of attributes such of number of snakes, speed of snakes, visibility of snakes etc which has different values in different difficulties. For Low difficulty, these attributes are set in such a way that it is easier to play the game. As user goes towards Medium and High, these attributes are set in such a way that the game would be harder to play.

Strategy Interface: ```DifficultyStrategy```
Strategy Concrete Class: ```DifficultyLevelLow```, ```DifficultyLevelMedium```, ```DifficultyLevelHigh```
Actor: ```DifficultyLow```, ```DifficultyMedium```, ```DifficultyHigh```

![Alt text](/docs/Story1-GameStartUpScreen.png?raw=true "Strategy Pattern")

<img src="/docs/Story1_use_case_specification.png"  width="500" height="500">

#### Factory

We used factory pattern to create the actors on the world. Main actors in our game are : Red Lettuce, Lettuce, Snake, and Bug. All actors are being created using Factory pattern. We have an interface Actor Factory and its concrete class Actor Generator. When an actor dies (except Turtle), the observers or the world submits a request to create that specfic actor to the Actor Manager. Actor Manager then using a timer queue the request in the threadpool. When one of the background threads are free, thread using the Factory pattern, calls the ```ActorGenerator``` to create the specific actor. We have some time threshold to wait for few seconds before we see an actor in the world.

Factory Interface : ```ActorFactory```
Factory Concrete: ```ActorGenerator```
Api : ```createSnakes(), createLettuce(), createRedLettuce(), createBug()```

![Alt text](/docs/Story2-StartGame.png?raw=true "Factory Pattern")

<img src="/docs/Story2_use_case_specification.png"  width="500" height="500">

#### Composite

We used Composite pattern to add shield to the Turtle. The shield and turtle share methods to move around, action on keypress and snake Hit. Shield and turtle move together and can be treated as a group. With composite we can add multiple accessories to Turtle and move them together. Also Implemented a feature of changing shield power. On intersection with a snake power of shield decreases by 1, which also results in changing the image of the shield to a smaller shield. 

Interface: ```IComponent```
Classes: ```Shield```, ```Turtle```

![Alt text](/docs/Story7-Shield.png?raw=true "Composite Pattern")

<img src="/docs/Story7_use_case_specification.png"  width="500" height="500">

#### Observer

Though we used observer patterns quite a bit in our game, but the main observer in focus is advancing level. Once Turtle eats lettuce or bug, the score counter gets updated (via observer) and level counter. Both ```ScoreCounter``` and ```Level``` implements  ```IScoreObserver```. ```IScoreSubject``` is implemented by ```Counter```. The data flow is such, that on every eat, we update the counter via observer and once the counter is updated we update the level via another observer. Reason we implemented in such a way is because Level upgrade events are only emmited at a factor of 20 (when we change our next level).

![Alt text](/docs/Story6-AdvancingToNextLevel.png?raw=true "Observer Pattern")

<img src="/docs/Story6_use_case_specification.png"  width="500" height="500">

#### Feature 1
Game End: 

This feature is to end the game once snake eats a turtle. Since snake can move freely and in case turtle has 0 shield power, if snakes get in touch with Turtle, using the observer patterns we have in our game. On this special event, the world drops all its actors and displays Looser. This event only and can only happen when shield is not their on the turtle.

![Alt text](/docs/Story5-EatTurtle.png?raw=true "Game End")

<img src="/docs/Story5_use_case_specification.png"  width="500" height="500">

#### Feature 2
Bug Move Randomly:

This feature enables our Lady bug to move randomly. When lady bug encounters the world's edge, it changes its position and make turns instead of getting stuck at the edge. The feature enables bug to move on top of turtles and lettuces. This is to avoid collisions between different actors in our game. 

![Alt text](/docs/Story9-LadyBug.png?raw=true "Bug Move Randomly")

<img src="/docs/Story9_use_case_specification.png"  width="500" height="500">

#### Feature 3
Won the game

When turtle is moving, turtle can eat many things and user gains points on the basis of what was eaten by the turtle. User also gets point when turtle has a gun power if turtle shoots down snake. Whenever turtle eats or kills anything, it will be notified to ```ScoreManager``` which will keep track of points. This is a notification type of calling. Therefore, we decided to use Observer pattern here. When ScoreManager adds score, it will also notify Level class to keep track of the levels. So if user is on the highest level and reaches to 2000 points, the game will be over and user will be declared as winner.

Interface: ```IScoreObserver```
Class: ```ScoreManager```, ```Level```

![Alt text](/docs/Stor10-WonTheGame.png?raw=true "Won the game")

<img src="/docs/Story10_use_case_specification.png"  width="500" height="500">

#### Feature 4
Point System for Lettuce and Bug

This feature is related to the Points System for Lettuce and Bug. When the turtle eats lettuce or bug, we notify the game counter to increase the score by either 5 (for lettuce) and 20 (for bug). Point system uses a combination of observer and ```ScoreManager```. Scoremanager tracks the score and creates Redlettuce after it reaches it threshold. Basically point system is the backbone of the game to keep all the subjects and observers go hand-in-hand.

![Alt text](/docs/Story4-EatLettuceAndBug(Point%20System).png?raw=true "Eat Lettuce And Bug")

<img src="/docs/Story4_use_case_specification.png"  width="500" height="500">

#### Feature 5
Snake Attraction

For this we have used method ```getNeighbours()``` provided by Greenfoot. On every move snake keeps on checking if there is a turtle in its radius of effect (```getNeighbours()```). On finding	a turtle in its neighborhood, snake’s changes its direction and starts moving in direction of the turtle. Also snake’s image changes to ‘RedSnakeImage’ on attraction.

Classes: ```Snake```, ```Turtle```

![Alt text](/docs/Story3-SnakeAttracted.png?raw=true "Snake Attraction")

<img src="/docs/Story3_use_case_specification.png"  width="500" height="500">
