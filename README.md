# Pacxon

## Description

Pacxon is a arcade game based on the classic Pacman in which the goal is to fill the arena with blocs. In each level, the goal is to 
fill the majority of the arena, while avoiding to cross paths with the monsters. Pacxon can conquer little portions of the arena iteratively
and wins as soon as the area conquered is equal or bigger than 80%.

## Key Features

- **Main Menu**: As soon as the game is open, the main menu is displayed, giving the user 3 options to choose from: _play_, _rules_ and _exit_. 

- **Initial State**: The game starts with a rectangular arena, with all the borders already filled with space "conquered" by the hero.
The hero starts with 3 lives and, obviously, the score and the progress(%) start at 0. 

- **Game Elements**:
    - Pacxon - the element that the user controls. Can move up, down, left or right, unless it moves against the borders of the arena. Starts with
3 lives, and loses 1 if it collides with a monster.
    - Monster - computer-controlled elements that chase the Pacxon trying to avoid its progress. Have the same move privilleges as Pacxon.
    - Blocks - square-shaped area unit that defines user progress. Every Pacxon move increments the current path by one.
    - Power Ups - influence the game state depending on which of them has been catched. 

- **Gameplay**:
  - For each square of the arena conquered by the hero, the score goes up 10 points, and the percentage of the arena filled goes up in the progress stat. To do that the hero must start and finish in the parts of the arena that are already conquered, while avoiding to collide directly with the monsters, and also avoiding for the monsters to collide with the path that the hero is tracing.
  - There are two types of power ups, the beer and the heart. In the case of the beer, if it is catched by the hero, all the enemies stop in their positions 5 seconds, in the case of the heart, the hero gains one life. 
  - There are two types of outcome in the game, or the user can fill at least 80% of the map, ad goes through to the next level, or the hero loses all the lives and have to start from the beggining, by going back all the way to level 1. Each level will go up in difficulty, the enemyies ,will go up in number, and also the speed of them will also increase.

## Design

1. 
**Problem in context.**
The most central question we faced at the start of the developing of this project was to choose the way we would have to structure the game, i.e., how to divide and connect each part of the game development.

**The pattern.**
To overcome this problem, we chose the Model-View-Control Architectural Pattern. Its intent is to separate the development process between 3 components:
- Model: represent and manage game logic, assuring the correct execution of it, not caring how to graphically display the game elements.
- View: represent the user interface, being responsible for the graphical representation of the game elements and placing them into the arena.
- Controller: even though this part is not going to feature in this phase of delivery, it will be responsible for the exchanges of information between the Model and the View layer
Manages input from the user and sends update signals to those two layers, to change the internal state and the corresponding graphical display.

**Consequences:** more organized developing process, making it faster to correct/add code for a known matter. Increases scalability tolerance.
