/**
 * ClosedShape.java
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of 
 * CSC-115 (Daniel Archambault and Liam O'Reilly)
 * Slightly modified for the purposes of doing CS-115 CW1 Stage5 (689591)
 */

import java.awt.*;

/**
 * A ClosedShape is any shape that can be drawn without
 * taking a pencil off a piece of paper.
 * It's representation on computer has a line colour
 * and a position on the drawable screen component.
 * It can be filled in with colour or opaque.
 * This class is a super class for all shapes.
 */

public class ClosedShape {
	
	/**
	 *  The x position of the Shape.
	 */
	protected int xPos;
 	/**
 	 * The y position of the Shape.
 	 */
 	protected int yPos;

	/**
	 *  The x position of the Shape.
	 */
	protected int xVec;
	
	/**
	 * The y position of the Shape.
	 */
	protected int yVec;

	/**
	 * The line colour of the shape, or the filled in
	 * colour if the Shape has fill.
	 */
	protected Color colour;

	/**
	 * Determines if the Shape has a fill colour or not.
	 */
	protected boolean isFilled;

	/**
	 * Encodes the insertion time into the scene
	 */
	private int insertionTime;

	/**
	 * Determines if the Shape will flash or not.
	 */
	protected boolean isFlash;

	/**
	 * The line colour of the shape, or the filled in
	 * colour will flash to if the Shape will flash.
	 */
	protected Color fColour;
	
	/**
	 * Creates a closed shape object.
	 * @param x The x position.
	 * @param y the y position.
	 * @param colour The line or fill colour.
	 * @param isFilled True if the shape is filled, false if not.
	 * @param isFlash True if the shape will flash, false if not.
	 * @param fColour The line or fill colour will flash to.
	 */
	protected ClosedShape (int insertionTime, int x, int y, int vx, int vy, Color colour, boolean isFilled, boolean isFlash, Color fColour) {
		this.xPos = x;
		this.yPos = y;
		this.xVec = vx;
		this.yVec = vy;
		this.colour = colour;
		this.isFilled = isFilled;
		this.insertionTime = insertionTime;
		this.isFlash = isFlash;
		this.fColour = fColour;
	}
	
	/**
	 * The method returns a string suitable for printing.
	 * @return string to print out shape.
	 */
	public String toString () {
		String result = "";
		result += "Its position is " + xPos + " " + yPos + "\n";
		result += "Its velocity is " + xVec + " " + yVec + "\n";
		result += "Its colour is " + colour + "\n";
		if (isFilled)
			result += "It is filled" + "\n";
		else
			result += "It is not filled" + "\n";
		if (isFlash) {
			result += "It is flashing" + "\n";
			result += "Its flashing colour is " + fColour + "\n";
		} else
			result += "It is not flashing" + "\n";
		result += "It should be inserted at " + insertionTime + "\n";
		return result;
	}

	/**
	 * Resets the x position.
	 */
 	public void setX (int x) {
		this.xPos = x;
	}

 	/**
 	 * Resets the y position.
 	 */
 	public void setY (int y) {
		this.yPos = y;
	}

	/**
	 * Resets the x vector
	 */
	 public void setVecX (int x) {
		this.xVec = x;
	 }//end setVecX

	/**
	 * Resets the y position.
	 */
	 public void setVecY (int y) {
		this.yVec = y;
	}//end setVecY

	 /**
	  * Resets the colour.
	  */
	 public void setColour (Color colour) {
	 	this.colour = colour;
	 }

	 /**
	  * Sets the shape to filled.
	  */
	 public void setFilled () {
		 isFilled = true;
	 }

	 /**
	  * Sets the shape to unfilled.
	  */
	 public void unsetFilled () {
	 	isFilled = false;
	 }
         
	/**
	 * Resets the flashing colour.
	 * @param fColour The colour of the shape which will flash to
	 */
	public void setFlashingColour(Color fColour) {
		this.fColour = fColour;
	}

	/**
	 * Sets the shape to flash.
	 */
	public void setFlash() {
		isFlash = true;
	}
        
	/**
	 * Sets the shape to unflash.
	 */
	public void unsetFlash() {
		isFlash = false;
	}
	 
	 /**
	  * Sets the insertion time.
	  */
	 public void setInsertionTime (int time) {
		 insertionTime = time;
	 }

	 /**
	  * @return The x position value.
	  */
	 public int getX() {
	 	return xPos;
	 }

	 /**
	  * @return The y position value.
	  */
	 public int getY() {
	 	return yPos;
	 }

	 /**
	  * @return The colour.
	  */
	 public Color getColour() {
	 	return colour;
	 }

	 /**
	  * @return True if the shape is filled, false if not.
	  */
	 public boolean isFilled() {
	 	return isFilled;
	 }
         
	/**
	 * Return the flashing colour
	 * @return The flash colour.
	 */
	public Color getFlashingColour() {
		return fColour;
	}

	/**
	 * Return if the shape flash
	 * @return True if the shape is flashing, false if not.
	 */
	public boolean isFlash() {
		return isFlash;
	}
	 
	 /**
	  * @return the insertion time.
	  */
	 public int getInsertionTime () {
		 return insertionTime;
	 }
    
	 /**
	  * Puts the shape back in bounds in X
	  */
	 public void putInBoundsX (double winX) {
	 	if (xPos < 0) xPos = 0;
	 	if (xPos + this.getWidth() > winX) {
	 		xPos = (int) (winX - Math.ceil (this.getWidth ()));
	 	}
	 }//end inBoundsX;
    
	 /**
	  * Puts the shape back in bounds
	  */
	 public void putInBoundsY (double winY) {
	 	if (yPos < 0) yPos = 0;
	 	if (yPos + this.getHeight() > winY) {
	 		yPos = (int) (winY - Math.ceil (this.getHeight ()));
	 	}
	 }//end inBoundsY;

	 /**
	  * Bounces the shape off a vertical wall
	  */
	 public void bounceX () {
	 	xVec = -xVec;
	 }

	 /**
	  * Bounces the shape off a horizontal wall
	  */
	 public void bounceY () {
	 	yVec = -yVec;
	 }

	 /**
	  * Returns true if the shapes have gone out of bounds in X
	  */
	 public boolean outOfBoundsX (double winX) {
	 	return (xPos + this.getWidth()> winX) || (xPos < 0);
	 }

	 /**
	  * Returns true if the shapes have gone out of bounds in Y
	  */
	 public boolean outOfBoundsY (double winY) {
	 	return (yPos + this.getHeight() > winY) || (yPos < 0);
	 }

	 /**
	  * Takes in a direction and a velocity and moves the shape
	  * in that direction on unit
	  */
	 public void move () {
	 	xPos += xVec;
	 	yPos += yVec;
	 }

	 /**
	  * Draws the object to the current component.
	  * @param g The graphics object associated with the drawing component.
	  */
	 public void draw (Graphics g) {
	 	System.out.println ("You forgot to override this method! (draw)");
	 	System.out.println ("Don't modify this method.");
	 }

	 /**
	  * Get the width of the current component
	  */
	 public int getWidth () {
	 	System.out.println ("You forgot to override this method! (getWidth)");
	 	System.out.println ("Don't modify this method.");
	 	return 1;
	 }

	 /**
	  * Get the width of the current component
	  */
	 public int getHeight () {
	 	System.out.println ("You forgot to override a method! (getHeight)");
	 	System.out.println ("Don't modify this method.");
	 	return 1;
	 }
}