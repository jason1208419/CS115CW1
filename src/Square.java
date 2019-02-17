
/**
 * This class create a square
 *
 * @author 689591
 */
import java.awt.*;

/**
 * Squre is a square shape that can be drawn to the screen, either filled with
 * colour or opaque.
 * Its position is determined by the upper left corner of the
 * square
 */
public class Square extends ClosedShape {

    //The side length of the square
    private int side;

    /**
     * Creates a square.
     *
     * @param insertionTime The time when the shape display on screen.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The side length of the square.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if
     * opaque.
     * @param isFlash True if the square will flash, false if not.
     * @param fColour The line colour or fill colour will flash to.
     */
    public Square(int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled, boolean isFlash, Color fColour) {
        super(insertionTime, x, y, vx, vy, colour, isFilled, isFlash, fColour);
        this.side = side;
    }

    /**
     * Method to convert an square to a string.
     *
     * @return the detail of the square
     */
    @Override
    public String toString() {
        String result = "This is an square\n";
        result += super.toString();
        result += "Its side length is " + this.side + "\n";
        return result;
    }

    /**
     * Set the side length of the square
     *
     * @param side Resets the side length.
     */
    public void setSide(int side) {
        this.side = side;
    }

    /**
     * Get the side length of the square
     *
     * @return The side length of the square.
     */
    public int getSide() {
        return side;
    }

    /**
     * Get the width of the square
     *
     * @return The width of the square
     */
    @Override
    public int getWidth() {
        return side;
    }

    /**
     * Get the height of the square
     *
     * @return The height of the square
     */
    @Override
    public int getHeight() {
        return side;
    }

    /**
     * Draw the square.
     *
     * @param g The graphics object of the drawable component.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(colour);
        if (isFilled) {//create a filled square if it is filled
            g.fillRect(xPos, yPos, side, side);
        } else {//create a hollow square if it is not filled
            g.drawRect(xPos, yPos, side, side);
        }
    }
}
