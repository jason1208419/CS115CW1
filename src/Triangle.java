
/**
 * This class create a triangle
 *
 * @author 689591
 */
import java.awt.*;

/**
 * Triangle is a triangle shape that can be drawn to the screen, either filled
 * with colour or opaque.
 * Its position is determined by the upper left corner of
 * the triangle's bounding rectangle.
 */
public class Triangle extends ClosedShape {

    //The number of points of the triangle
    private final int POINTS = 3;

    //The width and height of the triangle
    private int width, height;

    /**
     * Creates a triangle.
     *
     * @param insertionTime The time when the shape display on screen.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the triangle.
     * @param height The height of the triangle.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the triangle is filled with colour, false if
     * opaque.
     * @param isFlash True if the triangle will flash, false if not.
     * @param fColour The line colour or fill colour will flash to.
     */
    public Triangle(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled, boolean isFlash, Color fColour) {
        super(insertionTime, x, y, vx, vy, colour, isFilled, isFlash, fColour);
        this.width = width;
        this.height = height;
    }

    /**
     * Method to convert a triangle to a string.
     *
     * @return The detail of the triangle
     */
    @Override
    public String toString() {
        String result = "This is a triangle\n";
        result += super.toString();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }

    /**
     * Set the width of the triangle
     *
     * @param width Resets the width.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Set thhe height of the triangle
     *
     * @param height Resets the height.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Get the width of the triangle
     *
     * @return The width of the triangle.
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Get the height of the triangle
     *
     * @return The height of the triangle.
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Draw the triangle.
     *
     * @param g The graphics object of the drawable component.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(colour);
        if (isFilled) {//create a filled triangle if it is filled
            g.fillPolygon(new int[]{xPos, xPos + (width / 2), xPos + width}, new int[]{yPos + height, yPos, yPos + height}, POINTS);
        } else {//create a hollow triangle if it is not filled
            g.drawPolygon(new int[]{xPos, xPos + (width / 2), xPos + width}, new int[]{yPos + height, yPos, yPos + height}, POINTS);
        }
    }
}
