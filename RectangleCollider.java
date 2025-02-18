import java.awt.*;

/*!
This class acts as an imaginary rectangle in 2D space, which can detect whether it is overlapping any other Rectangle Collider.
*/

public class RectangleCollider {
    private int x;
    private int y;
    private int width;
    private int height;

    /*!
    The constructor is passed the (x, y) location of the upper-left corner, and the object's width and height.
    */
    public RectangleCollider(int newX, int newY, int newWidth, int newHeight){
        x = newX;
        y = newY;
        width = newWidth;
        height = newHeight;
    }

    /*!
    This method is for debug purposes. It draws a visual representation of the collider to the provided Graphics object.
    */
    public void debugPaint(Graphics g){
        Color c = g.getColor();
        g.setColor(new Color(255, 0, 0));
        g.drawRect(x, y, width-1, height-1); //Subtractions necessary according to testing and documentation.
        g.setColor(new Color(255, 255, 0, 128));
        g.fillRect(x+1, y+1, width-2, height-2);
        g.setColor(c);
    }

    /*!
    This method detects whether this object is overlapping with another RectangleCollider.
    */
    public boolean overlaps(RectangleCollider other){
        final int myEndX = (x + width) - 1;
        final int myEndY = (y + height) - 1;
        final int theirEndX = (other.x + other.width) - 1;
        final int theirEndY = (other.y + other.height) - 1;
        final boolean overlapX = Math.max(x, other.x) <= Math.min(myEndX, theirEndX);
        final boolean overlapY = Math.max(y, other.y) <= Math.min(myEndY, theirEndY);
        return overlapX && overlapY;
    }
}