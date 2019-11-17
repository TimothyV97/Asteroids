
# EightAM - Game Asteroids

Team EightAM made a reimagination of the classic multidirectional shooter arcade game "Asteroids", originally released in 1979 by Atari, Inc. for a Game Jam where it won 1st place. New features were implemented, such as: new ship types, new power-ups and new enemies.

## Team Members

* Adrian Wang
* Tim Van
* Liyin Li (Kenny)
* Melissa Goh
* Irene Ho

## Description

### Structure

The game takes advantage of various object-oriented patterns such as: strategy, flyweight and factory.

* The strategy pattern allows for different behavior for certain objects. For example, when an asteroid spawns, it spawns outside the playable area, and as it enters the playable area, it changes its movement behavoir to wrap around the screen.
* The flyweight pattern allows us to load in assets upon the startup of the game. This greatly improves the performance and fluidity of the game.
* The factory pattern aids in the creation of objects. As there are multiple in-game entities, this pattern eases the integration of different type of in-game objects.

## Screenshots

![Link to screen3](https://github.com/TimothyV97/Asteroids/blob/master/Asteroid_screen3.jpg)

![Link to screen2](https://github.com/TimothyV97/Asteroids/blob/master/Asteroid_screen2.jpg)

![Link to screen1](https://github.com/TimothyV97/Asteroids/blob/master/Asteroid_screen1.jpg)
