Fall 2023 - CEG 4110-01\
Introduction to Software Engineering\
Software Development Plan (Agile)
========

---

This document has been officially reviewed and approved by the following team members:
- Joey Sodergren
- Steven Cao
- Sophia Gyamfuah
- Nathaniel Ryan
- Pending...

---


### Project Title
- Pac-Man

### Project Synopsis
- We plan to implement a clone or imitation of the original Pac-Man arcade game. We're targeting computers (that is to say, not phones), and we're planning on using Java.

### Concept of Operation
- The game should run in a window, featuring a pixel art graphical output. Pac-Man should be controllable using the arrow keys or WASD. Ghost behavior, score keeping, and the general rules of play should be functionally identical to those of the original arcade game.

### Schedule
- **Project Start Date:** October 15th, 2023
- **Project End Date:** December 4th, 2023
- **Sprint Duration:** One week per Sprint

### Software Development Environment
- Java 21 running on a 64-bit computer.
    - For the most part, Java is OS agnostic. We will not be mandating a specific OS or a specific *version* of an OS that will be used for development.

### Configuration Management
- Each of us should make our own development branch. Development of individual components should be done in our own branches, without interfering with parallel development from other team members. The interoperability and format of data passed between components will be decided through face-to-face meetings, Discord meetings, and Discord chats. Completed components will be brought together to assemble the full project via Pull Requests into the `main` branch.
- Doxygen will be used to generate code documentation from in-code comments. This documentation will be generated (or regenerated) after official pulls into the `main` branch.
    - The specifics of how we will format and stylize our Doxygen-generated documentation will be agreed upon at a later date.
    - We will be both leaving comments in our own code and suggesting comments to each other during reviews and Scrum meetings.
- JUnit 5 will be used to write and run tests.
    - Since we do not plan to mandate the usage of any one particular IDE or code editor across our group, we will likely be using the [JUnit 5 Console Launcher](https://junit.org/junit5/docs/current/user-guide/#running-tests-console-launcher) to execute our tests.
    - The results of JUnit test runs will be committed into a centralized file at the same time that we upload new documents generated by Doxygen.
- We have created a Discord server for team communication.
    - Discord can facilitate synchronous voice and video calls, as well as asynchrnous text and voice messages.
    - In the event that we begin holding serious development conversations and making system decisions via Discord, Joey has volunteered to turn our messages into pseudo-Meeting Minutes reports to be uploaded here.

### Target Environment
- Any 64-bit computer running Windows, Linux, or Mac, with an OS from at most 5 years ago, should be able to run our version of Pac-Man.
    - This includes Desktops and Laptops.
    - Mobile phones, tablets, or other mobile devices are not a part of our category of targets.

### Development Methodology
- Agile

### Identify Roles
- **Product Owner:** Zayd Abushamma
- **Scrum Master:** Joey Sodergren
- **Team:** Everybody, including the above. All members will be contributing code.
    - Zayd Abushamma
    - Steven Cao
    - Sophia Gyamfuah
    - Nathaniel Ryan
    - Joey Sodergren

### Identify The Product Backlog

Our minimum viable product should have the following components present and functioning properly:

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

If we have more time in the semester after completing our minimum viable product, we may implement the following features as bonus material:

1. A sound system that plays background music and gameplay sound effects according to the sound behavior of the original arcade game.
    - The reason this item is not part of our minimum viable product is due to my (Joey's) past experience playing sounds and music in Java. Although there *are* systems available in Java to play sounds, the behavior of these systems is clunky, and is not well suited to the programming of a video game.
    - It may be possible to overcome this clunkiness by implementing a sort of "sound engine" that sits between Java's sound systems and our game engine, and implements more useful behavior for playing live sounds. This system would take considerable time, effort, and testing to make operational, so we officially decided it would be a bonus item, not a required item.
1. An opponent system that can play against you, provided a "player vs. computer" competitive play mode.
    - After implementing our game engine, some of us think it could be fun to create a Pac-Man playing AI. Game state interpretation would not be a challenge, since any AI we build right into our own system would already have access to all game state data available in the system.
    - If we embark upon this idea, it may become "viable" very quickly if it can play decently, even if its strategy is rudimentary. Time until the end of the semester could be used to improve the intelligence of this AI.

### Identify Initial Sprint Backlog
1. Figure out how to display live-updating bitmap graphics through Java Swing.
1. Get the input system working so we can move Pac-Man.
1. Identify how the original arcade game represented and measured character positions, speed, and the point worths of all possible game actions.
1. Constrain Pac-Man's movement to the bounds and pathways of the level maze.
1. Get dots-eating working.
1. Get the ghosts to chase Pac-Man.
1. Get the ghosts to run away from Pac-Man.
1. Get the scorekeeping to track everything accurately.
1. Get the fruit to appear, and be eatable, and scorable.

If we complete all of those, remaining Sprint time may be used for the following, in no particular order:

- Get interactions between Pac-Man, the dots, the fruit, the ghosts, and the level to produce sound in a similar manner to the original arcade game.
- Create an autonomous Pac-Man playing AI that responds to the current state of the play environment, and tries to play better than a human player.
    - In this context, "better" means "can go for longer without dying."

### Tracking Backlog and User Stories
- The Product Backlog listed above can be pretty easily rewritten as User Stories, so we will do so.
    - We are aware that each team member is required to write at least two User Stories.
- All User Stories are to be posted to the repo as [issues](https://github.com/WSU-DGscheidle/fall-2023-team08_atomic_coders/issues).
    - GitHub's issues system solves many of our traceability challenges for us, including logging the dates of posting, and who has written each User Story and reported each Bug.
    - GitHub's issues system also allows us to organize these backlog items with categorical tags, track progress by leaving comments on issues, and easily see which issues are still Open for continued development and which ones are Closed.

### Design
Certain aspects of the structure and component design of the Pac-Man project have alrady become clear to us through conversation and through some past familiarty with game engines. Components we plan to implement include:

- Simple GUI management
- CPU-based bitmap graphics renderer
- Keyboard controls watcher
- Scoring subsystem
- Environment interaction manager
- Ghost AI subsystem

Specifics on how these components will work, how these components will inter-communicate, and whether new components or sub-components will be needed will be discussed and documented in future meetings. Any further future documentation on this topic will be placed in the `Documents` folder.

### Meeting Minutes
- Shall be written as `.md` files.
- Shall be placed within the `Communication Logs` folder in the `main` branch.
- The names of the files should match the pattern `mm-dd-yyyy - Meeting Minutes.md`.
- Shall contain the following contents, at a minimum:
    - Date and Time the meeting occurred
    - Who attended / who was involved with the meeting
    - How the meeting took place
        - In person, Discord Voice/Video Chat, Discord Text Chat
    - Items discussed
    - GitHub changes
        - New pull requests for completed items, new commits that need testing, new issues (which could be bugs or user stories)

### Commits
Each team member will be required to submit at least 20 commits to the repo, in order to comply with class requirements. We are expecting to meet and exceed that requirement easily.
- We expected to meet that requirement so easily that we initially thought it wasn't necessary to include this section in this document. Prof. Gscheidle insisted we should write it down anyway.

## Sprint Execution

### Sprint Planning
#### Inputs
- Product backlog
- Sprint backlog
- Any required technical information (interface definitions, etc.)
#### Team Activity
- **Product Owner:** Updates product backlog to contain updated requirements.
- **Scrum Master:** Works with the team and Product Owner to define the new Sprint backlog.
- **Development Team:** Provides feedback on task efforts and sprint backlog.
- All members define what "Done" is.
#### Outputs
- Refined product backlog
- New Sprint backlog
    - Weekly Sprint backlogs will be added to `Scrum Logs.md`, along with dates, in chronological order.

### Daily Scrum
#### Inputs
- Sprint backlog
#### Team Activity
- **Scrum Master:** Polls the team as to status
- **Development Team:** Provides status on progress, information on any newly discovered bugs, and other needs
#### Outputs
- Updated Sprint backlog
#### Methodology
Sophia and Joey have come up with a new proposal on how to perform asynchronous, self-documenting Scrum reviews. The process works as follows:
1. Joey would create a new issue, with a special `Scrum Update` tag.
1. Joey will add a description to the issue detailing what development work he has completed since the previous day.
1. Joey will ping all team members via Discord to notify them that the new Update issue has been posted, and reminding the members to respond.
1. Over the next couple hours, team members will respond to the update request by leaving Comments on the issue.
    - If enough time has passed and no info has been recieved from a specific team member, Joey may send them additional pings via Discord.
1. Once all team members have responded with their short updates (or if that does not occur, then when the day ends) Joey will close the issue.
1. Joey will add a date-stamped link to the issue to the current week's section in `Scrum Logs.md` to make all such special issues easy to find by date.
1. Joey will then mark Scrum backlog items as `(complete)` in `Scrum Logs.md` as needed.

### Sprint Review
#### Inputs
- Product backlog
- Sprint backlog
#### Team Activity
- Sprint Review
- Newly completed functions and components are pulled into the `main` branch, and subsequently into all personal development branches
#### Outputs
- Delivered new software capability (increment)
