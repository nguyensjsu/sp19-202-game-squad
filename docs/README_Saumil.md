Strategy Pattern

We used <b>strategy pattern</b> for Game startup screen. When user wants to play the game, user will first see the game startup screen. Game startup screen has 3 difficulty button Low, Medium and High. User has to choose one of the difficulty to play the game. Each difficulty is different from each other in various attributes. So we have decided to use strategy pattern for this story. There are number of attributes such of number of snakes, speed of snakes, visibility of snakes etc which has different values in different difficulties. For Low difficulty, these attributes are set in such a way that it is easier to play the game. As user goes towards Medium and High, these attributes are set in such a way that the game would be harder to play.

Strategy Interface: DifficultyStrategy

Strategy Concrete Class: DifficultyLevelLow, DifficultyLevelMedium, DifficultyLevelHigh

Actor: DifficultyLow, DifficultyMedium, DifficultyHigh


Feature: Won the game

When turtle is moving, turtle can eat many things and user gains points on the basis of what was eaten by the turtle. User also gets point when turtle has a gun power if turtle shoots down snake. Whenever turtle eats or kills anything, it will be notified to ScoreManager which will keep track of points. This is a notification type of calling. Therefore, we decided to use <b>Observer pattern</b> here. When ScoreManager adds score, it will also notify Level class to keep track of the levels. So if user is on the highest level and reaches to 2000 points, the game will be over and user will be declared as winner.

Interface: IScoreObserver

Class: ScoreManager, Level