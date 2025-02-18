import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/*!
This class acts as a `static` repository of sprite images that are loaded during the start up phase of the game. It makes all of its `BufferedImage` fields accessible as `public static final` variables, so that they can be accessed quickly and never need to be loaded more than once throughout the lifetime of the program.
*/

public class SpriteLoader{
    public static final BufferedImage maze = loadImage("Sprites/Maze.png");
    //public static final BufferedImage maze = loadImage("Documents/PacMan Grid.png"); //Useful for alignment testing.

    public static final BufferedImage pac_full = loadImage("Sprites/Pac_Full.png");
    public static final BufferedImage pac_walk_right_1 = loadImage("Sprites/Pac_Walk_Right_1.png");
    public static final BufferedImage pac_walk_right_2 = loadImage("Sprites/Pac_Walk_Right_2.png");
    public static final BufferedImage pac_walk_down_1 = loadImage("Sprites/Pac_Walk_Down_1.png");
    public static final BufferedImage pac_walk_down_2 = loadImage("Sprites/Pac_Walk_Down_2.png");
    public static final BufferedImage pac_walk_left_1 = loadImageFlipHorizontal("Sprites/Pac_Walk_Right_1.png");
    public static final BufferedImage pac_walk_left_2 = loadImageFlipHorizontal("Sprites/Pac_Walk_Right_2.png");
    public static final BufferedImage pac_walk_up_1 = loadImageFlipVertical("Sprites/Pac_Walk_Down_1.png");
    public static final BufferedImage pac_walk_up_2 = loadImageFlipVertical("Sprites/Pac_Walk_Down_2.png");
    public static final BufferedImage pac_full_flip_h = loadImageFlipHorizontal("Sprites/Pac_Full.png");
    public static final BufferedImage pac_full_flip_v = loadImageFlipVertical("Sprites/Pac_Full.png");

    public static final BufferedImage char_0 = loadImage("Sprites/Char_0.png");
    public static final BufferedImage char_1 = loadImage("Sprites/Char_1.png");
    public static final BufferedImage char_2 = loadImage("Sprites/Char_2.png");
    public static final BufferedImage char_3 = loadImage("Sprites/Char_3.png");
    public static final BufferedImage char_4 = loadImage("Sprites/Char_4.png");
    public static final BufferedImage char_5 = loadImage("Sprites/Char_5.png");
    public static final BufferedImage char_6 = loadImage("Sprites/Char_6.png");
    public static final BufferedImage char_7 = loadImage("Sprites/Char_7.png");
    public static final BufferedImage char_8 = loadImage("Sprites/Char_8.png");
    public static final BufferedImage char_9 = loadImage("Sprites/Char_9.png");

    public static final BufferedImage pellet = loadImage("Sprites/Pellet.png");
    public static final BufferedImage power_pellet = loadImage("Sprites/Power_Pellet.png");

    private static BufferedImage loadImage(String filePath){
        BufferedImage original = null;
        try{
            original = ImageIO.read(new File(filePath));
        } catch (Exception e){
            System.err.println("CRASH IN SPRITELOADER.");
            System.err.println("Trying to load \"" + filePath + "\".");
            e.printStackTrace(System.err);
            System.exit(1);
        }
        final int width = original.getWidth();
        final int height = original.getHeight();
        BufferedImage normalized = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                normalized.setRGB(x, y, original.getRGB(x, y));
            }
        }
        return normalized;
    }

    private static BufferedImage loadImageFlipVertical(String filePath){
        BufferedImage original = null;
        try{
            original = ImageIO.read(new File(filePath));
        } catch (Exception e){
            System.err.println("CRASH IN SPRITELOADER.");
            System.err.println("Trying to load \"" + filePath + "\".");
            e.printStackTrace(System.err);
            System.exit(1);
        }
        final int width = original.getWidth();
        final int height = original.getHeight();
        BufferedImage normalized = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                normalized.setRGB(x, (height-y)-1, original.getRGB(x, y));
            }
        }
        return normalized;
    }

    private static BufferedImage loadImageFlipHorizontal(String filePath){
        BufferedImage original = null;
        try{
            original = ImageIO.read(new File(filePath));
        } catch (Exception e){
            System.err.println("CRASH IN SPRITELOADER.");
            System.err.println("Trying to load \"" + filePath + "\".");
            e.printStackTrace(System.err);
            System.exit(1);
        }
        final int width = original.getWidth();
        final int height = original.getHeight();
        BufferedImage normalized = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                normalized.setRGB((width-x)-1, y, original.getRGB(x, y));
            }
        }
        return normalized;
    }
}