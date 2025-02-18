import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;

/*!
This class acts as the graphical renderer and game state manager. It manages its own Score, uses RectangleCollider objects to govern sprite collisions (eating dots) and movment (bumping into the walls), and draws its current state graphically.
*/

public class GraphicsPanel extends JPanel {

    private BufferedImage canvas = new BufferedImage(224, 288, BufferedImage.TYPE_INT_ARGB);
    private BufferedImage mazeImage = SpriteLoader.maze; // Maze background image
    private PacmanKeyboard keyListener;
    private final double aspectRatio = 224.0 / 288.0;

    private BufferedImage[][] pacFrames; //Initialized inside the constructor.
    private int pacFrameCounter = 0;
    private int pacAnimationCounter = 0;
    private int pacX = 104;
    private int pacY = 204;
    private int pacDirection = 0; // 0 is right, 1 is down, 2 is left, and 3 is up

    private BufferedImage[] numberSprites = {SpriteLoader.char_0, SpriteLoader.char_1, SpriteLoader.char_2, SpriteLoader.char_3, SpriteLoader.char_4, SpriteLoader.char_5, SpriteLoader.char_6, SpriteLoader.char_7, SpriteLoader.char_8, SpriteLoader.char_9};
    private Score score = new Score();

    private ArrayList<Pellet> pellets = new ArrayList<>(); //Contents added inside the constructor.
    private int pelletAnimationCounter = 0; //Controls blinking of Power Pellets

    private final RectangleCollider mazeColliders[] = {
        //The walls of the maze
        new RectangleCollider(0, 24, 224, 8),
        new RectangleCollider(0, 32, 8, 64),
        new RectangleCollider(104, 32, 16, 32),
        new RectangleCollider(216, 32, 8, 64),
        new RectangleCollider(0, 96, 48, 40),
        new RectangleCollider(176, 96, 48, 40),
        new RectangleCollider(0, 144, 48, 40),
        new RectangleCollider(176, 144, 48, 40),
        new RectangleCollider(0, 184, 8, 80),
        new RectangleCollider(216, 184, 8, 80),
        new RectangleCollider(0, 264, 224, 8),
        new RectangleCollider(8, 216, 16, 16),
        new RectangleCollider(200, 216, 16, 16),
        //Barriers and blocks inside the maze
        new RectangleCollider(16, 40, 32, 24),
        new RectangleCollider(56, 40, 40, 24),
        new RectangleCollider(128, 40, 40, 24),
        new RectangleCollider(176, 40, 32, 24),
        new RectangleCollider(16, 72, 32, 16),
        new RectangleCollider(56, 72, 16, 64),
        new RectangleCollider(72, 96, 24, 16),
        new RectangleCollider(80, 72, 64, 16),
        new RectangleCollider(104, 88, 16, 24),
        new RectangleCollider(152, 72, 16, 64),
        new RectangleCollider(128, 96, 24, 16),
        new RectangleCollider(176, 72, 32, 16),
        new RectangleCollider(80, 120, 64, 40),
        new RectangleCollider(56, 144, 16, 40),
        new RectangleCollider(152, 144, 16, 40),
        new RectangleCollider(80, 168, 64, 16),
        new RectangleCollider(104, 184, 16, 24),
        new RectangleCollider(56, 192, 40, 16),
        new RectangleCollider(128, 192, 40, 16),
        new RectangleCollider(16, 192, 32, 16),
        new RectangleCollider(32, 208, 16, 24),
        new RectangleCollider(176, 192, 32, 16),
        new RectangleCollider(176, 208, 16, 24),
        new RectangleCollider(80, 216, 64, 16),
        new RectangleCollider(104, 232, 16, 24),
        new RectangleCollider(16, 240, 80, 16),
        new RectangleCollider(56, 216, 16, 24),
        new RectangleCollider(128, 240, 80, 16),
        new RectangleCollider(152, 216, 16, 24),
        //Temporary blockers for the tunnels. Would be removed if we ever get around to implementing the teleport tunnels.
        new RectangleCollider(0, 136, 8, 8),
        new RectangleCollider(216, 136, 8, 8),
    };

    /*!
    This constructor must be passed a PacmanKeyboard from which we can read current key input state.
    */
    public GraphicsPanel(PacmanKeyboard kbl){
        keyListener = kbl;
        setMinimumSize(new Dimension(224, 288)); //Original Pac-Man arcade game digital resolution.
        setDoubleBuffered(true);
        BufferedImage[] pacRight = {SpriteLoader.pac_full, SpriteLoader.pac_walk_right_1, SpriteLoader.pac_walk_right_2, SpriteLoader.pac_walk_right_1};
        BufferedImage[] pacDown = {SpriteLoader.pac_full, SpriteLoader.pac_walk_down_1, SpriteLoader.pac_walk_down_2, SpriteLoader.pac_walk_down_1};
        BufferedImage[] pacLeft = {SpriteLoader.pac_full_flip_h, SpriteLoader.pac_walk_left_1, SpriteLoader.pac_walk_left_2, SpriteLoader.pac_walk_left_1};
        BufferedImage[] pacUp = {SpriteLoader.pac_full_flip_v, SpriteLoader.pac_walk_up_1, SpriteLoader.pac_walk_up_2, SpriteLoader.pac_walk_up_1};
        pacFrames = new BufferedImage[][] {pacRight, pacDown, pacLeft, pacUp};
        final RectangleCollider pelletHoles[] = {
            new RectangleCollider(56, 96, 112, 88),
            new RectangleCollider(0, 136, 48, 8),
            new RectangleCollider(176, 136, 48, 8),
            new RectangleCollider(104, 208, 16, 8),
            new RectangleCollider(8, 48, 8, 8),
            new RectangleCollider(208, 48, 8, 8),
            new RectangleCollider(8, 208, 8, 8),
            new RectangleCollider(208, 208, 8, 8),
        };
        for(int y=32; y<=256; y+=8){
            for(int x=8; x<=208; x+=8){
                Pellet p = new Pellet(x, y, false);
                boolean hit = false;
                for(RectangleCollider rc : mazeColliders){
                    if(p.overlaps(rc)){
                        hit = true;
                        break;
                    }
                }
                if(!hit){
                    for(RectangleCollider rc : pelletHoles){
                        if(p.overlaps(rc)){
                            hit = true;
                            break;
                        }
                    }
                }
                if(!hit) pellets.add(p);
            }
        }
        pellets.add(new Pellet(8, 48, true));
        pellets.add(new Pellet(208, 48, true));
        pellets.add(new Pellet(8, 208, true));
        pellets.add(new Pellet(208, 208, true));
    }

    /*!
    This method cues this object to update its internal game state. This method reads from the PacmanKeyboard, checks whether Pac-Man is colliding with (and should interact with) any other sprites, increments the score if necessary, and calculates the next step of Pac-Man's movement throughout the maze. This method also increments the animation frame counters of all sprites who display animations.
    */
    public void updateState(){
        final boolean pelletFreeze;
        { //Test for a pellet collision
            int pelletIndex = -1;
            Pellet pellet = null;
            final RectangleCollider pac = new RectangleCollider(pacX+4, pacY+4, 8, 8);
            final int len = pellets.size();
            for(int i=0; i<len; i++){ //Iterating with index because we want to save the index.
                Pellet p =  pellets.get(i);
                if(pellets.get(i).overlaps(pac)){
                    pelletIndex = i;
                    pellet = p;
                    break;
                    // We can break, and we don't need to collect the result in a list,
                    // because Pac-Man will only ever be overlapping one or zero pellets.
                }
            }
            if(pelletIndex >= 0){
                pellets.remove(pelletIndex);
                pelletFreeze = !pellet.isPowerPellet();
                score.eatPellet(pellet);
            } else {
                pelletFreeze = false;
            }
        }
        pelletAnimationCounter = (pelletAnimationCounter + 1) % 20;
        final boolean up = keyListener.isUpPressed();
        final boolean down = keyListener.isDownPressed();
        final boolean left = keyListener.isLeftPressed();
        final boolean right = keyListener.isRightPressed();
        final boolean wantsToMove = (up || down || left || right) ^ (up && down && left && right);
        // Context for the following boolean check:
        // Yes, Pac-Man does freeze movement for one frame if he has just eaten a regular pellet!
        // https://www.reddit.com/r/todayilearned/comments/2oschi/til_every_time_pacman_eats_a_regular_dot_he_stops/
        if(!pelletFreeze && wantsToMove) {
            final int pacX_old = pacX;
            final int pacY_old = pacY;
            final int pacX_collide_old = pacX+4;
            final int pacY_collide_old = pacY+4;
            final boolean up_possible;
            final boolean down_possible;
            final boolean left_possible;
            final boolean right_possible;
            {
                //Test upwards
                RectangleCollider tester = new RectangleCollider(pacX_collide_old, pacY_collide_old-1, 8, 8);
                boolean hit = false;
                for(RectangleCollider rc : mazeColliders){
                    if(rc.overlaps(tester)){
                        hit = true;
                        break;
                    }
                }
                up_possible = !hit;
                //Test downwards
                tester = new RectangleCollider(pacX_collide_old, pacY_collide_old+1, 8, 8);
                hit = false;
                for(RectangleCollider rc : mazeColliders){
                    if(rc.overlaps(tester)){
                        hit = true;
                        break;
                    }
                }
                down_possible = !hit;
                //Test leftwards
                tester = new RectangleCollider(pacX_collide_old-1, pacY_collide_old, 8, 8);
                hit = false;
                for(RectangleCollider rc : mazeColliders){
                    if(rc.overlaps(tester)){
                        hit = true;
                        break;
                    }
                }
                left_possible = !hit;
                //Test rightwards
                tester = new RectangleCollider(pacX_collide_old+1, pacY_collide_old, 8, 8);
                hit = false;
                for(RectangleCollider rc : mazeColliders){
                    if(rc.overlaps(tester)){
                        hit = true;
                        break;
                    }
                }
                right_possible = !hit;
            }
            //Reference for pacDirection: 0 is right, 1 is down, 2 is left, and 3 is up
            switch (pacDirection) {
                case 0:
                { //Already facing right
                    if(down){
                        if(down_possible){
                            pacY++;
                        } else if(right_possible){
                            pacX++;
                        }
                    } else if(up){
                        if(up_possible){
                            pacY--;
                        } else if(right_possible){
                            pacX++;
                        }
                    } else if(right && right_possible){
                        pacX++;
                    } else if(left && left_possible){
                        pacX--;
                    }
                }
                break;
                case 1:
                { //Already facing down
                    if(left){
                        if(left_possible){
                            pacX--;
                        } else if(down_possible){
                            pacY++;
                        }
                    } else if(right){
                        if(right_possible){
                            pacX++;
                        } else if(down_possible){
                            pacY++;
                        }
                    } else if(down && down_possible){
                        pacY++;
                    } else if(up && up_possible){
                        pacY--;
                    }
                }
                break;
                case 2:
                { //Already facing left
                    if(up){
                        if(up_possible){
                            pacY--;
                        } else if(left_possible){
                            pacX--;
                        }
                    } else if(down){
                        if(down_possible){
                            pacY++;
                        } else if(left_possible){
                            pacX--;
                        }
                    } else if(left && left_possible){
                        pacX--;
                    } else if(right && right_possible){
                        pacX++;
                    }
                }
                break;
                case 3:
                { //Already facing up
                    if(right){
                        if(right_possible){
                            pacX++;
                        } else if(up_possible){
                            pacY--;
                        }
                    } else if(left){
                        if(left_possible){
                            pacX--;
                        } else if(up_possible){
                            pacY--;
                        }
                    } else if(up && up_possible){
                        pacY--;
                    } else if(down && down_possible){
                        pacY++;
                    }
                }
                break;
            }
            if(pacX_old != pacX || pacY_old != pacY){
                pacAnimationCounter = (pacAnimationCounter + 1) % 8;
                pacFrameCounter = pacAnimationCounter / 2;
                if(pacX > pacX_old){
                    pacDirection = 0;
                } else if(pacX < pacX_old){
                    pacDirection = 2;
                } else if(pacY > pacY_old){
                    pacDirection = 1;
                } else {
                    pacDirection = 3;
                }
            }
        }
    }

    /*!
    This method contains this object's redrawing logic. It reads from stored game state variables updated by updateState(), draws the game sprites to its internal virtual pixel-art canvas, and then draws that canvas to the screen scaled up to fit the current size of the window. In accordance with recommended best practices for the usage of Java Swing, this method should never be called directly. (This is why this is a `protected` method rather than a `public` method.) To request that this object update its graphical state, call the repaint() method inherited from JPanel.
    */
    @Override
    protected void paintComponent(Graphics g) {
        //Draw to virtual screen.
        Graphics2D cg = canvas.createGraphics();

        cg.setColor(Color.BLACK);
        cg.fillRect(0, 0, 224, 288); //Clear virtual screen to black before drawing.
        cg.drawImage(mazeImage, 0, 24, null); //Draw maze background image
        drawNumber(score.getScore(), 8, 8, cg); //Draw the current score
        for(Pellet p : pellets) p.drawSelf(cg, pelletAnimationCounter); //Draw all active pellets
        cg.drawImage(pacFrames[pacDirection][pacFrameCounter], pacX, pacY, null); //Draw Pac-Man

        //The following segment should remain commented out unless collision testing is ongoing:
        /*
        {
            for(RectangleCollider rc : mazeColliders) rc.debugPaint(cg);
            for(Pellet p : pellets) p.drawCollider(cg);
            new RectangleCollider(pacX+4, pacY+4, 8, 8).debugPaint(cg); //Pac-Man's collider
        }
        */

        cg.dispose(); //Recommended to run this when done drawing to buffer.
        //Done drawing to virtual screen.

        //Draw virtual screen to real screen.
        final int panelWidth = getWidth();
        final int panelHeight = getHeight();
        final int virtualWidth = (int) (((double) panelHeight) * aspectRatio);

        g.setColor(Color.BLACK); //Useful to set this to a color other than BLACK for debugging.
        g.fillRect(0, 0, panelWidth, panelHeight); //Clear screen to black before drawing.

        g.drawImage(canvas, (panelWidth/2)-(virtualWidth/2), 0, virtualWidth, panelHeight, null); //Display virtual screen, scaled, in the middle of the screen.
        //Done drawing to real screen.
    }

    /*!
    This method draws the specified number at the coordinates (x, y) through the graphics drawing object g. It draws the number one character at a time, by using the sprites `char_0` through `char_9` from SpriteLoader.
    */
    public void drawNumber(int number, int x, int y, Graphics g) {
        if (number < 0) {
            number *= -1;
        }
        String numberString = String.valueOf(number);
        for (int i = 0; i < numberString.length(); i++) {
            char digitChar = numberString.charAt(i);
            int digitValue = Character.getNumericValue(digitChar);
            BufferedImage digitImage = numberSprites[digitValue];
            //The number 8 is hardcoded here because all of the number sprites are known to 8x8 pixels.
            g.drawImage(digitImage, x+i*8, y, null);
        }
    }
}
