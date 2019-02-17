
/**
 * This class create a rectangle
 *
 * @author 689591
 */
import java.awt.*;

/**
 * Rectangle is a rectangle shape that can be drawn to the screen, either filled
 * with colour or opaque.
 * Its position is determined by the upper left corner of
 * the rectangle
 */
public class Rect extends ClosedShape {

    //The width and height of the rectangle
    private int width, height;

    /**
     * Creates a rectangle.
     *
     * @param insertionTime The time when the shape display on screen.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the rectangle is filled with colour, false if
     * opaque.
     * @param isFlash True if the rectangle will flash, false if not.
     * @param fColour The line colour or fill colour will flash to.
     */
    public Rect(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled, boolean isFlash, Color fColour) {
        super(insertionTime, x, y, vx, vy, colour, isFilled, isFlash, fColour);
        this.width = width;
        this.height = height;
    }

    /**
     * Method to convert a rectangle to a string.
     *
     * @return The detail of the rectangle
     */
    @Override
    public String toString() {
        String result = "This is a rectangle\n";
        result += super.toString();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }

    /**
     * Set the width of the rectangle
     *
     * @param width Resets the width.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Set the height of the rectangle
     *
     * @param height Resets the height.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Get the width of the rectangle
     *
     * @return The width of the rectangle.
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Get the height of the rectangle
     *
     * @return The height of the rectangle.
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Draw the rectangle.
     *
     * @param g The graphics object of the drawable component.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(colour);
        if (isFilled) {//create a filled rectangle if it is filled
            g.fillRect(xPos, yPos, width, height);
        } else {//create a hollow retangle if it is not filled
            g.drawRect(xPos, yPos, width, height);
        }
    }
}
