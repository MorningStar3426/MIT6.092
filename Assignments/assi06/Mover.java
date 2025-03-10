import java.awt.Graphics;

public interface Mover {
    /** Starts moving the object in the direction (xIncrement, yIncrement). */
    void setMovementVector(int xIncrement, int yIncrement);

    void draw(Graphics surface);

}
