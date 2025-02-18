import java.awt.Graphics;
import java.awt.image.BufferedImage;

/*!
This class represents an edible pellet. It exists at a location (until eaten, when it no longer exists). It has a collider with the GraphicsPanel uses to detect its collision with Pac-Man. It can be either a normal pellet or a PowerPellet, and its point worth and sprite appearance will differ depending on which it is.
*/

public class Pellet {
    private final int x;
    private final int y;
    private final RectangleCollider collider;
    private final boolean powerPellet;
    private final BufferedImage sprite;
    private final int pointWorth;

    /*!
    The constructor is passed the (x, y) location of the pellet, and a boolean to state whether or not it is to act as a Power Pellet.
    */
    public Pellet(int newX, int newY, boolean power){
        x = newX;
        y = newY;
        collider = new RectangleCollider(x+2, y+2, 4, 4);
        powerPellet = power;
        if(powerPellet){
            sprite = SpriteLoader.power_pellet;
            pointWorth = 50;
        } else {
            sprite = SpriteLoader.pellet;
            pointWorth = 10;
        }
    }

    /*!
    This method draws itself through the provided Graphics object, or perhaps it will not draw itself, depending on the value of animCounter. Regular pellets always draw themselves. Power pellets perform a cyclic, 20-frame animation in which they are visible for 10 frames, then invisible for 10 frames, then repeat. The animCounter argument controls that logic, and the GraphicsPanel is responsible for passing in the proper value.
    */
    public void drawSelf(Graphics g, int animCounter){
        if(!powerPellet || animCounter < 10) g.drawImage(sprite, x, y, null);
    }

    /*!
    This method is for debugging purposes. It draws a visual representation of its collider to the Graphics object.
    */
    public void drawCollider(Graphics g){
        collider.debugPaint(g);
    }

    /*!
    This method detects whether this object's RectangleCollider is overlapping with another one.
    */
    public boolean overlaps(RectangleCollider rc){
        return collider.overlaps(rc);
    }

    /*!
    This method does what it says on the tin.
    */
    public boolean isPowerPellet(){
        return powerPellet;
    }

    /*!
    This method returns the point worth of this Pellet. It should be 10 for a regular pellet and 50 for a Power Pellet.
    */
    public int getPoints(){
        return pointWorth;
    }
}