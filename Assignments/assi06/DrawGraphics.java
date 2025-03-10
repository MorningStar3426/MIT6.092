import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
    ArrayList<Mover> moving = new ArrayList<Mover>();
    
    /** Initializes this class for drawing. */
    public DrawGraphics() {
        Rectangle box = new Rectangle(15, 20, Color.RED);
        Oval box2 = new Oval(15, 20, Color.BLUE);
        Rectangle box3 = new Rectangle(15, 20, Color.RED);
        Oval box4 = new Oval(15, 20, Color.BLUE);
        
        moving.add(new Bouncer(100, 170, box));
        moving.add(new Bouncer(50, 170, box2));
        moving.add(new StraightMover(100, 100, box3));
        moving.add(new StraightMover(50, 100, box4));
        
        for (int i = 0; i < moving.size(); i++) {
        	Mover tmp = moving.get(i);
        	tmp.setMovementVector(3, 1);
        }
    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
        for (int i = 0; i < moving.size(); i++) {
        	Mover tmp = moving.get(i);
        	tmp.draw(surface);
        }
    }
}
