Experimentation with Java's Graphics2D System
========

### Summary
- We are looking for someone to explore Java's Graphics2D system, specifically the `java.awt.Graphics2D` class, which inherits methods from its parent class, `java.awt.Graphics`. The goal is to understand various aspects of the system, including:

### Drawing Points and Lines
- Experiment with drawing points and lines using the Graphics2D class to understand the fundamental concepts of rendering basic shapes.

Example:

Create a class to use Graphics2D and define a point and line:
```java
import java.awt.Graphics;
import java.awt.Graphics2D;

public class DrawingExample {

    public void drawPointsAndLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Drawing a point
        g2d.drawLine(x1, y1, x1, y1);

        // Drawing a line
        g2d.drawLine(x1, y1, x2, y2);
    }
}
```
Then create a class that extends JFrame which is part of the Java Swing library.
- In Java, JFrame is a class in the Swing framework that allows you to create and manage a top-level window. It provides all the features you would expect from a window, including borders, menus, and buttons.
```java
import java.awt.*;
import javax.swing.*;

// SWING FRAMEWORK

// Create a class that extends JFrame which is part of the Java Swing library

public class MainFrame extends JFrame {

    // Set up the JFrame
    public MainFrame() {

        // Constructor for JFrame
        setTitle("Drawing Example"); // This line sets the title of the GUI window to "Drawing Example".
        setSize(400, 400); // This line sets the initial size of the GUI window to be 400 pixels wide and 400 pixels tall.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This line sets the default close operation for the window. When the user clicks the close button on the window, the application will exit. JFrame.EXIT_ON_CLOSE is a constant that indicates the program should terminate when the frame is closed.
        setLocationRelativeTo(null); // This line centers the window on the screen. If you pass null as the argument, it means the window will be placed in the center of the screen.
        setVisible(true); // This line makes the window visible. By default, newly created frames are not visible until you set this property to true. When this line is executed, the GUI window will become visible on the screen.
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Create an instance of DrawingExample
        drawingPointsAndLines drawingExample = new drawingPointsAndLines();

        // Call drawPointsAndLines method with specific coordinates
        int x1 = 50, y1 = 50, x2 = 250, y2 = 250;
        drawingExample.drawPointsAndLines(g, x1, y1, x2, y2);
    }

    public static void main(String[] args) {
        // Create an instance of MainFrame
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}

```
When executing code, the window should look like this:

![pointsAndLines](https://cdn.discordapp.com/attachments/811148913523687434/1166402436915810356/image.png?ex=654a5beb&is=6537e6eb&hm=2e2d6e54e1523375e060ea1260533d6415146cfd62c9725fe4131cf7c847a5f8&)

### Drawing Rectangles
- Explore the functionality of drawing rectangles using Java's Graphics2D system. Understand the parameters and methods involved in creating rectangles of different sizes and positions.

Example:

Create a class that shows two rectangles, one filled with color and one outlined in color.

```Java
import java.awt.*;
import javax.swing.*;

public class RectangleDrawingExample extends JPanel { //Extends JPanel to create a custom panel where the rectangles will be drawn

    @Override
    protected void paintComponent(Graphics g) { // Overridden to draw the rectangles
        super.paintComponent(g);                // Inside this method, the Graphics object is cast to Graphics2D for advanced drawing options
                                                

        // Convert Graphics to Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        // Draw a rectangle at position (x, y) with width w and height h
        int x = 50;
        int y = 50;
        int width = 100;
        int height = 50;

        // Draw a filled rectangle
        g2d.setColor(Color.BLUE); // Can set to all colors
        g2d.fillRect(x, y, width, height);

        // Draw a outlined rectangle
        g2d.setColor(Color.GREEN);
        g2d.drawRect(x + 150, y, width, height); // Adding 150 to the x-axis creates that space between the two shapes
    }

    // Main creates a JFrame, adds an instance of `RectangleDrawingExample` to it, and sets the frame visible for display
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rectangle Drawing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RectangleDrawingExample());
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}
```
When executing code, the window should look like this:

![RectangleDrawingExample](https://cdn.discordapp.com/attachments/811148913523687434/1166496581525192796/image.png?ex=654ab399&is=65383e99&hm=08a62d9d9d92e3d8b352a17288440acd81ac258e77aaeed9d1649359a8f134e4&)

### Loading Data from .png Images
- Learn how to load data from .png images using Java. Explore methods to read image files and manipulate them within the `Graphics2D` context. Understand how to convert image data into a format compatible with `Graphics2D` objects.

- Java provides the ``ImageIO`` class, which can be used to read images from various formats, including .png. 

Here's an example of how you can read a .png image file in Java:
```Java
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {
    public static void main(String[] args) {
        try {
            // Load the .png image
            BufferedImage image = ImageIO.read(new File("image.png"));

            // Perform operations on the image here

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
In the above code, replace "image.png" with the path to your .png file.
### Manipulating Images with Graphics2D
- Once you have loaded the image, you can manipulate it within the `Graphics2D` context. 

Here's an example of drawing on the loaded image:
```Java
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageManipulator {
    public static void drawOnImage(BufferedImage image) {
        // Get the graphics context of the image
        Graphics2D g2d = image.createGraphics();

        // Draw a red rectangle on the image
        g2d.setColor(Color.RED);
        g2d.fillRect(50, 50, 100, 100);

        // Dispose of the graphics context to free up resources
        g2d.dispose();
    }
}
```
In this example, a red rectangle is drawn on the image at coordinates (50, 50) with a width and height of 100 pixels each. You can perform various operations like drawing shapes, text, or applying filters using the Graphics2D methods.
### Converting Image Data for Graphics2D
- If you need to convert image data into a format compatible with Graphics2D objects, you can use `ImageDataProducer` and `PixelGrabber` classes.

Here's a basic example:
```Java
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.awt.image.PixelGrabber;

public class ImageConverter {
    public static Image convertToCompatibleImage(BufferedImage originalImage) {
        ImageProducer producer = originalImage.getSource();
        PixelGrabber pg = new PixelGrabber(producer, 0, 0, -1, -1, true);

        try {
            pg.grabPixels();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int width = pg.getWidth();
        int height = pg.getHeight();
        int[] pixels = (int[]) pg.getPixels();

        // Create a compatible image
        Image compatibleImage = Toolkit.getDefaultToolkit().createImage(
            new MemoryImageSource(width, height, pixels, 0, width));

        return compatibleImage;
    }
}
```
- In this example, `convertToCompatibleImage` takes a `BufferedImage` as input and converts it into a format compatible with Graphics2D objects.

### Drawing .png Images on a Graphics2D Object
- Experiment with drawing loaded .png images on a Graphics2D object. Understand the coordinate systems and transformations necessary to accurately render images within the graphical context.

Example:
```Java
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageDrawer {
    public static void main(String[] args) {
        // Create a blank BufferedImage (canvas)
        int canvasWidth = 800;
        int canvasHeight = 600;
        BufferedImage canvas = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);

        // Get the Graphics2D object from the canvas
        Graphics2D g2d = canvas.createGraphics();

        try {
            // Load the .png image
            BufferedImage image = ImageIO.read(new File("image.png"));

            // Draw the loaded image onto the canvas at specific coordinates
            int imageX = 100; // X-coordinate where the image will be drawn
            int imageY = 50;  // Y-coordinate where the image will be drawn
            g2d.drawImage(image, imageX, imageY, null);

            // Perform other drawing operations on the canvas
            // For example, draw shapes, text, etc.

            // Dispose of the graphics context to free up resources
            g2d.dispose();

            // Save the canvas as a new image (optional)
            ImageIO.write(canvas, "PNG", new File("output.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
- In this example, the `.drawImage()` method of the `Graphics2D` class is used to draw the loaded .png image onto the canvas at specific coordinates (imageX, imageY). You can adjust these coordinates to position the image wherever you want on the canvas.
### Understanding Coordinate Systems and Transformations:
- **Coordinate System:** The coordinate system of the `Graphics2D` object starts from the top-left corner, where x-coordinates increase from left to right, and y-coordinates increase from top to bottom.

- **Transformations:** You can apply transformations to the `Graphics2D` object to scale, rotate, translate, or shear the drawn images. 

Here's an example of how you can scale the .png image before drawing it:
```Java
// Scale the image by 2 times in both width and height
double scaleX = 2.0;
double scaleY = 2.0;
g2d.scale(scaleX, scaleY);

// Draw the scaled image at specific coordinates
int scaledImageX = 100; // Scaled X-coordinate where the image will be drawn
int scaledImageY = 50;  // Scaled Y-coordinate where the image will be drawn
g2d.drawImage(image, scaledImageX, scaledImageY, null);
```
In this code, the `.scale()` method is used to scale the `Graphics2D` object. The drawn image will be twice its original size due to the scaling factors `scaleX` and `scaleY`.

### Saving a Graphics2D as a New .png Image
- Explore methods to save a Graphics2D object as a new .png image. This functionality is crucial for debugging graphics contents and generation. Understand how to preserve the quality and integrity of the rendered content when saving it as an image file.

Saving a Generated Graphic to a PNG or JPEG File The source code was found from this link: http://www.java2s.com/Code/Java/2D-Graphics-GUI/SavingaGeneratedGraphictoaPNGorJPEGFile.htm

Here is an example of how you can save a graphics2D as a new .png image:
```Java
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Main {
  public static void main(String[] argv) throws Exception {
    int width = 100;
    int height = 100;

    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    Graphics2D g2d = bufferedImage.createGraphics();

    g2d.setColor(Color.white);
    g2d.fillRect(0, 0, width, height);
    g2d.setColor(Color.black);
    g2d.fillOval(0, 0, width, height);

    g2d.dispose();
    RenderedImage rendImage = bufferedImage;

    File file = new File("newimage.png");
    ImageIO.write(rendImage, "png", file);

    file = new File("newimage.jpg");
    ImageIO.write(rendImage, "jpg", file);
  }

}
```