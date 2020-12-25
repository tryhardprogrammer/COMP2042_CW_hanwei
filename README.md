# COMP2042_CW_OoiHanWei20194531
Code from github user hirish99.
 
## Refactoring
 #### Organising Files
 Separated all resources like images and text files away from the source codes.
 
 #### Breaking and Cleaning up Classes
 Some classes from hirish99's source codes were broken up to different classes. This is to make the classes to follow the Single Responsibility Principle.
 
 For example, class MyStage from hirish99 is responsible for initializing the game timer and the background music. In this source code, it has been broken up into class BackgroundMusic and Levels, where the former is reponsible for only the background music(without inheriting the class World), while the latter is a Parent class for all levels created which is responsible for the stage timer and the structure of the game.
 
 #### Added new Classes
 Added new classes to increase the modularity or add features of the program. For example, Classes like Menu, Help, Level1, Level2, Level3, Level4, Level5 are like views in the MVC model. The class HighScore is also a class which specifically in charge of the high scores.

 #### Encapsulation
 All variables for every classes has been encapsulated by setting them to private instead of public. Classes getting and setting data from other classes must use get and set methods.

 #### Use of MVC Design Pattern
 Implemented Controller classes like LevelController and ScreenController for separating the logic part and the view part. The design will make the source code easier to modify or extend.
   
 For example, LevelController controls the view of the requested level, Levels classes(Level1, Level2...) are views of the game, LevelModel runs the logic behind the view.  
   
 #### Use of Singleton Pattern
 Classes like LevelController, ScreenController and HighScore implemented Singleton Pattern to ensure there's only one instance from them. 
 
 This prevents from making the program more complicated by having a same controller being instantiate multiple times.
 
 #### Gameplay
 Modifed the program to have 5 levels in total. Each level will be more difficult as speed and vehicle will increase while platform decreases.
 
 The speed of each level can be modified easier as each level class (Level1, Level2..) has the speed variable that affects all actors. (except the main character)
 
 The program is also modified to be continuous instead of a one-time program. This is made possible due to the modularity of the program. The program can move from one screen to another using the Controller class, making the program to be very flexible in changing screens. 
 
 
 
 ## Additions
 #### Additional Screens like Menu, Help, Leaderboard
 At the start of the game, the menu screen you pop out, where user can click different buttons to play the game, learn instructions or show the game's leaderboard.
 
 #### Leaderboard
 The leaderboard will show the top 10 high score and player's name will an alert box. Whenever player starts the game, the program will ask his/her name regardless whether the player win or lose before proceeding.
 
 When the player wins, the leaderboard will automatically store the high score information in a descending sequence.
 
 #### Javadocs
 Added Javadocs for all classes to ensure easier understanding about the codes.
  
  #### Maven
  Used Maven to create build files, indicating the dependencies of the codes.
  
  The build file can help with creating a clean build environment and what to complie.
  
  #### JUnit
  Added 2 test class, where both of them together contains 5 test cases.
  
## Game Rules
Press 'Play' in the Menu to start the game. There are 5 levels total, where each level will get much more difficult. 
Player will need to finish their current stage in order to proceed to the next one. 

## Running the program
### Download JavaFX before running!
#### Option 1
- 1. Import project into your IDE
- 2. Run maven clean -> maven build

#### Option 2
- 1. Import new Java FX project into your IDE
- 2. Select Run Configurations of the project
- 3. Type --module-path "D:<path>" --add-modules=ALL-MODULE-PATH in VM arguments, where path is your location for javafx-sdk\lib.
- 4. Run.