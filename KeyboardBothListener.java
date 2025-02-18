import java.awt.event.*;
import javax.swing.JFrame;

/*!
This class returns its boolean answers based on an aggregate state of both the WASD and Arrow keys.
*/

public class KeyboardBothListener implements PacmanKeyboard {

    private KeyAdapter ka;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

        /*!
        The constructor must be passed a JFrame on which this class can register a KeyAdapter, which will in turn recieve KeyEvent notifications, which will be sent back to this object for processing.
        */
        public KeyboardBothListener(JFrame parentFrame) {
            ka = new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                        case KeyEvent.VK_W:
                            up = true;
                            break;
                        case KeyEvent.VK_DOWN:
                        case KeyEvent.VK_S:
                            down = true;
                            break;
                        case KeyEvent.VK_LEFT:
                        case KeyEvent.VK_A:
                            left = true;
                            break;
                        case KeyEvent.VK_RIGHT:
                        case KeyEvent.VK_D:
                            right = true;
                            break;
                    }
                }
                public void keyReleased(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                        case KeyEvent.VK_W:
                            up = false;
                            break;
                        case KeyEvent.VK_DOWN:
                        case KeyEvent.VK_S:
                            down = false;
                            break;
                        case KeyEvent.VK_LEFT:
                        case KeyEvent.VK_A:
                            left = false;
                            break;
                        case KeyEvent.VK_RIGHT:
                        case KeyEvent.VK_D:
                            right = false;
                            break;
                    }
                }
            };
            parentFrame.addKeyListener(ka);
        }

        public boolean isUpPressed(){
            return up;
        }

        public boolean isDownPressed(){
            return down;
        }

        public boolean isLeftPressed(){
            return left;
        }

        public boolean isRightPressed(){
            return right;
        }
}