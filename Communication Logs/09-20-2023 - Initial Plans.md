# 9/20/2023 - Initial Plans
What follows are our initial plans for our project this semester. All of the items below were discussed and agreed upon **in person** by all five members of the team. This document was written by Joey Sodergren.

1. As a team, we are going to be trying to create a version of **Pac-Man.**
    - We picked Pac-Man because we decided it would be complex enough that it would require a nonzero amount of real programming effort, but not so complex that we might not be able to get it working within one semester.
1. We will be writing it in Java.
1. Our minimum viable product should have the following components present and functioning properly:
    1. The program displays current game state through a live-updating bitmap graphical window.
    1. The player can control Pac-Man with the arrow keys, and can interact with the environment as expected.
        - Eating dots and Power Pills
        - Eating ghosts
        - Eating treats (bonus items that appear near the center of the map)
        - Moving between the left and right sides of the map by way of the extra tunnel.
    1. Each of the four ghosts track and follow Pac-Man using their own algorithm, as they behave in the original arcade game.
        - The YouTube channel [Retro Game Mechanics Explained](https://www.youtube.com/@RGMechEx) has published in-depth explanations of exactly how the ghosts originally behaved, according to the assembly programming of the original arcade game, both in their normal state and when they enter the "scared" state after Pac-Man eats a Power Pill. It should be possible to replicate the ghosts' original behavior by using these videos as a guide.
    1. The scoring system tracks all the different ways that Pac-Man can score points throughout gameplay, and keeps a correct running tally of all accrued points over the course of play.
        - We believe this may need to take the current "level" of play the player has reached. The point values of certain actions may scale depending on the current level.
1. If we have more time in the semester after completing our minimum viable product, we may implement the following features as bonus material:
    1. A sound system that plays background music and gameplay sound effects according to the sound behavior of the original arcade game.
        - The reason this item is not part of our minimum viable product is due to my (Joey's) past experience playing sounds and music in Java. Although there *are* systems available in Java to play sounds, the behavior of these systems is clunky, and is not well suited to the programming of a video game.
        - It may be possible to overcome this clunkiness by implementing a sort of "sound engine" that sits between Java's sound systems and our game engine, and implements more useful behavior for playing live sounds. This system would take considerable time, effort, and testing to make operational, so we officially decided it would be a bonus item, not a required item.
    1. An opponent system that can play against you, provided a "player vs. computer" competitive play mode.
        - After implementing our game engine, some of us think it could be fun to create a Pac-Man playing AI. Game state interpretation would not be a challenge, since any AI we build right into our own system would already have access to all game state data available in the system.
        - If we embark upon this idea, it may become "viable" very quickly if it can play decently, even if its strategy is rudimentary. Time until the end of the semester could be used to improve the intelligence of this AI.
1. We have created a Discord server for team communication.
    - Discord can facilitate synchronous voice and video calls, as well as asynchrnous text and voice messages.
    - In the event that we begin holding serious development conversations and making system decisions via Discord, Joey has volunteered to turn our messages into pseudo-Meeting Minutes reports to be uploaded here.