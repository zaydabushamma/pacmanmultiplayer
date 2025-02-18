/*!
This is the simple interface that allows the programmer to read directional controls from the keyboard. The different objects that implement this interface return different answers to the four required methods depending on which keys they are programmed to listen to.
*/

public interface PacmanKeyboard {
    /*!
    This method returns a boolean that indicates whether or not the user is currently requesting upward movement.
    */
    public boolean isUpPressed();
    /*!
    This method returns a boolean that indicates whether or not the user is currently requesting downward movement.
    */
    public boolean isDownPressed();
    /*!
    This method returns a boolean that indicates whether or not the user is currently requesting leftward movement.
    */
    public boolean isLeftPressed();
    /*!
    This method returns a boolean that indicates whether or not the user is currently requesting rightward movement.
    */
    public boolean isRightPressed();
}