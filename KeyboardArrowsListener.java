import java.awt.event.*;
import javax.swing.JFrame;

/*!
This class returns its boolean answers based on the state of the Arrow keys.
*/

public class KeyboardArrowsListener implements PacmanKeyboard {

    private KeyAdapter ka;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    /*!
    The constructor must be passed a JFrame on which this class can register a KeyAdapter, which will in turn recieve KeyEvent notifications, which will be sent back to this object for processing.
    */
    public KeyboardArrowsListener(JFrame parentFrame) {
        ka = new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        up = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        down = true;
                        break;
                    case KeyEvent.VK_LEFT:
                        left = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        right = true;
                        break;
                }
            }

            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        up = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        down = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        left = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        right = false;
                        break;
                }
            }
        };
        parentFrame.addKeyListener(ka);
    }

    public boolean isUpPressed() {
        return up;
    }

    public boolean isDownPressed() {
        return down;
    }

    public boolean isLeftPressed() {
        return left;
    }

    public boolean isRightPressed() {
        return right;
    }
}
