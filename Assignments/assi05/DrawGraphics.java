import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

public class DrawGraphics {
    // Add three different shapes to the initial window we provide.
    // Add three instances of the BouncingBox class to your window, moving in different directions.
    // Use an ArrayList to hold them.
    BouncingBox box1;
    BouncingBox box2;
    BouncingBox box3;
    ArrayList<BouncingBox> boxes = new ArrayList<BouncingBox>();
    
    /** Initializes this class for drawing. */
    public DrawGraphics() {
        box1 = new BouncingBox(200, 50, Color.RED);
        box2 = new BouncingBox(150, 100, Color.CYAN);
        box3 = new BouncingBox(100, 50, Color.GREEN);
        Collections.addAll(boxes, box1, box2, box3);
        for (int i = 0; i < boxes.size(); i++){
            boxes.get(i).setMovementVector(i,-1);
        }
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        surface.drawLine(50, 50, 250, 250);
        surface.drawOval(30, 30, 30, 30);
        surface.drawRect(100,150,50,50);
        surface.drawRoundRect(30,150,30,50,30,50);
        for (BouncingBox box : boxes){
            box.draw(surface);
        }
    }
} 