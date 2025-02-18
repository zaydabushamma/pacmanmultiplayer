## 11/21/2023 - Meeting Minutes

- Time: 5:00pm - 6:30pm
- Attendees
    - Joseph (Joey) Sodergren
    - Steven Cao
    - Sophia Gyamfuah
    - Zayd Abushamma
- Meeting was held via Discord voice and video chat.

- Items Discussed
    - Now using GroupLayout to automatically calculate correct size of the window to fit its contents. (commit: [Fixed our GraphicsPanel...](https://github.com/WSU-DGscheidle/fall-2023-team08_atomic_coders/commit/13e9208823d1b9fe2fde645ed81aea3f0ced8974))
    - Steven ran demo test to confirm the engine runs on his system as well and doesn't need to be resized due to the window.
    - Make sure to run `git config --global fetch.prune true` to clean up repository from any zombie branches.
    - Tested Sophia's new keyboard code with gui
        - Keys (W,A,S,D) and arrows work at the same time (in parallel, without interfering with each other) with two copies of the game in one window

- Github changes/reviews
    - Sophia Gyamfuah merged code from her branch regarding keyboard inputs. ([pr 19](https://github.com/WSU-DGscheidle/fall-2023-team08_atomic_coders/pull/19))

- TODO
    - Steven assigned task to modify graphics panel in demo code to create a new method called `drawNumber()`. Function needs to draw a number one charachter at a time.
    - Sophia assigned to start generating some documentation from code using WSL and install doxygen on her computer. Describe the structure of the code and add comments.
    - Check up and follow up on team members tasks within the next couple days.
    - Zayd assigned task with creating tests on keyboard programs. Install git software for windows and java21. Update branch so it is up to date with main. Modify the code in the graphics panel so that it dosent draw any ghosts or maze. Make it only draw a request text, such as `Please press the down arrow` slide and stay the message until the correct key has been pressed. Print message about the success or failure of each of these attempts and then kill the process. (Note cannot listen to keys until you create a jframe, see code currently in `Main.java` to see how we're currently doing this.)
    - Individuals with extended deadline need to notify the team once their task is complete.
