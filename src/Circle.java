
/**
 * Circle.java
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of 
 * CSC-115 (Daniel Archambault and Liam O’Reilly)
 * Slightly modified for the purposes of doing CS-115 CW1 Stage5 (689591)
 */

import java.awt.*;

/**
 * Circle is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the circle's bounding rectangle.
 */

public class Circle extends ClosedShape {
    //The diameter of the circle
	private int diameter;

    /**
     * Creates a circle.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param diameter The diameter of the circle.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the circle is filled with colour, false if opaque.
     * @param isFlash True if the circle will flash, false if not.
     * @param fColour The line colour or fill colour will flash to.
     */
    public Circle (int insertionTime, int x, int y, int vx, int vy, int diameter, Color colour, boolean isFilled, boolean isFlash, Color fColour) {
    	super (insertionTime, x, y, vx, vy, colour, isFilled, isFlash, fColour);
    	this.diameter = diameter;
    }
    
    /**
     * Method to convert a circle to a string.
     */
    public String toString () {
    	String result = "This is a circle\n";
    	result += super.toString ();
	result += "Its diameter is " + this.diameter + "\n";
    	return result;
    }
    
    /**
     * @param Resets the diameter.
     */
    public void setDiameter (int diameter) {
    	this.diameter = diameter;
    }
    
    /**
     * @return The diameter of the circle.
     */
    public int getDiameter() {
    	return diameter;
    }

    /**
     * @return The width of the circle
     */
 	public int getWidth() {
		return diameter;
	}

 	/**
 	 * @return The height of the circle
 	 */
 	public int getHeight() {
		return diameter;
	}
    
    /**
     * Draw the circle on the screen.
     * @param g The graphics object of the drawable component.
     */
    public void draw (Graphics g) {
    	g.setColor( colour );
    	if (isFilled) {
    		g.fillOval( xPos, yPos, diameter, diameter );
    	} 
    	else {
    		g.drawOval( xPos, yPos, diameter, diameter );
	    }
    }
}
