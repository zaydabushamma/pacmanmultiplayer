Welcome to the Doxygen documentation for the Java Pac-Man project, made by **Team 8: Atomic Coders**. All the following members of the team contributed to the project:
- Joseph (Joey) Sodergren
- Steven Cao
- Zayd Abushamma
- Sophia Gyamfuah
- Nathaniel Ryan

We weren't quite able to complete all of the features originally laid out in our planned Minimum Viable Product within one semester, but we did get some of them working. As currently provided, we have completed the following major features:
- Live bitmap graphics
- Keyboard control
    - Two-player local competition WASD and Arrow Keys parallel play included!
- Resizable window

To run the project for yourself, you need to have Java 21 installed on your system. After that, open the root directory of this repo and perform the following:
- **On Windows:**
    - Double-click the `Run.bat` file to launch the program.
- **On Linux and Mac:**
    - Open this directory in the terminal, and run the following command:
    ```
    javac *.java && java Main; rm *.class
    ```

Also, by the way. Doxygen appears to not usually like generating pages for classes that contain `main()` functions. To read about those classes, look for the `Files` drop-down near the top of this page.