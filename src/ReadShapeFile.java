
/**
 * This class reads a shape file.
 *
 * @author 689591
 */
import java.awt.Color;
import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class reads a shape file.
 */
public class ReadShapeFile {

    /**
     * Reads the data file used by the program and returns the constructed queue
     *
     * @param in the scanner of the file
     * @return the queue represented by the data file
     */
    private static Queue readDataFile(Scanner in) {
        Queue shapeQueue = new Queue();
        Scanner lineReader;

        while (in.hasNext()) {//read the next line if it exist
            String line = in.nextLine();
            lineReader = new Scanner(line);

            try {//read data in a line
                String shape = lineReader.next();

                int px = lineReader.nextInt();
                int py = lineReader.nextInt();

                int vx = lineReader.nextInt();
                int vy = lineReader.nextInt();

                boolean isFilled = lineReader.nextBoolean();

                //side or diameter or width
                int length1 = 0;
                int height = 0;
                
                if (shape.equalsIgnoreCase("circle") || shape.equalsIgnoreCase("square")) {
                    //read in 1 integer (side or diameter) if the shape is circle or square
                    length1 = lineReader.nextInt();
                } else if (shape.equalsIgnoreCase("oval") || shape.equalsIgnoreCase("rect") || shape.equalsIgnoreCase("triangle")) {
                    //read in 2 integers (width and height) if the shape is oval or rectangle or triangle
                    length1 = lineReader.nextInt();
                    height = lineReader.nextInt();
                } else {
                    //tell the user the shape cannot be defined in other case
                    System.err.println("No This Shape: " + shape);
                }

                int r = lineReader.nextInt();
                int g = lineReader.nextInt();
                int b = lineReader.nextInt();

                boolean isFlash = lineReader.nextBoolean();

                //rgb of the flashing colour
                int fr = 0;
                int fg = 0;
                int fb = 0;
                if (isFlash) {//read in rgb value only if the shape is flash
                    fr = lineReader.nextInt();
                    fg = lineReader.nextInt();
                    fb = lineReader.nextInt();
                }

                int insertionTime = lineReader.nextInt();

                if (shape.equalsIgnoreCase("circle")) {//crate and enqueue a circle if shape is circle
                    shapeQueue.enqueue(creatCircle(insertionTime, px, py, vx, vy, length1, r, g, b, isFilled, isFlash, fr, fg, fb));
                } else if (shape.equalsIgnoreCase("oval")) {//crate and enqueue an oval if shape is oval
                    shapeQueue.enqueue(creatOval(insertionTime, px, py, vx, vy, length1, height, r, g, b, isFilled, isFlash, fr, fg, fb));
                } else if (shape.equalsIgnoreCase("square")) {//crate and enqueue a square if shape is square
                    shapeQueue.enqueue(creatSquare(insertionTime, px, py, vx, vy, length1, r, g, b, isFilled, isFlash, fr, fg, fb));
                } else if (shape.equalsIgnoreCase("rect")) {//crate and enqueue a rectangle if shape is retangle
                    shapeQueue.enqueue(creatRect(insertionTime, px, py, vx, vy, length1, height, r, g, b, isFilled, isFlash, fr, fg, fb));
                } else if (shape.equalsIgnoreCase("triangle")) {//crate and enqueue a triangle if shape is triangle
                    shapeQueue.enqueue(creatTriangle(insertionTime, px, py, vx, vy, length1, height, r, g, b, isFilled, isFlash, fr, fg, fb));
                } else {//tell the user shape cannot be created in other case
                    System.err.println("Cannot Creat Shape: " + shape + "\nError line: " + line + "\n");
                }
            } catch (InputMismatchException e) {//tell the user input type is wrong
                System.err.println("Wrong data type inputted!\nError line: " + line + "\n");
            } catch (NoSuchElementException e) {//tell the user data is missing
                System.err.println("Some input data are missing!\nError line: " + line + "\n");
            }
            lineReader.close();
        }
        in.close();
        shapeQueue.print();
        return shapeQueue;
    }

    /**
     * Method to read the file and return a queue of shapes from this file.
     *
     * @param filename the name of the file
     * @return the queue of shapes from the file
     */
    public static Queue readFile(String filename) {
        Scanner in = null;

        File inputFile = new File(filename);

        try {//open the file
            in = new Scanner(inputFile);
        } catch (FileNotFoundException e) {//tell the user file does not exist if file not found
            System.out.println("Cannot open " + filename);
            System.exit(0);
        }

        return ReadShapeFile.readDataFile(in);
    }

    /**
     * Method to create a circle based on the data read from the file.
     *
     * @param insertionTime The time when the shape display on screen.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param diameter The diameter of the circle.
     * @param r The r value of the line colour or fill colour.
     * @param g The g value of the line colour or fill colour.
     * @param b The b value of the line colour or fill colour.
     * @param isFilled True if the circle is filled with colour, false if
     * opaque.
     * @param isFlash True if the circle will flash, false if not.
     * @param fr The r value of the flashing colour.
     * @param fg The r value of the flashing colour.
     * @param fb The r value of the flashing colour.
     * @return return the circle to enqueue
     */
    public static Circle creatCircle(int insertionTime, int x, int y, int vx, int vy, int diameter, int r, int g, int b, boolean isFilled, boolean isFlash, int fr, int fg, int fb) {
        Circle circle = new Circle(insertionTime, x, y, vx, vy, diameter, new Color(r, g, b), isFilled, isFlash, new Color(fr, fg, fb));
        return circle;
    }

    /**
     * Method to create an oval based on the data read from the file.
     *
     * @param insertionTime The time when the shape display on screen.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the oval (in pixels).
     * @param height The height of the oval (in pixels).
     * @param r The r value of the line colour or fill colour.
     * @param g The g value of the line colour or fill colour.
     * @param b The b value of the line colour or fill colour.
     * @param isFilled True if the oval is filled with colour, false if opaque.
     * @param isFlash True if the oval will flash, false if not.
     * @param fr The r value of the flashing colour.
     * @param fg The r value of the flashing colour.
     * @param fb The r value of the flashing colour.
     * @return return the oval to enqueue
     */
    public static Oval creatOval(int insertionTime, int x, int y, int vx, int vy, int width, int height, int r, int g, int b, boolean isFilled, boolean isFlash, int fr, int fg, int fb) {
        Oval oval = new Oval(insertionTime, x, y, vx, vy, width, height, new Color(r, g, b), isFilled, isFlash, new Color(fr, fg, fb));
        return oval;
    }

    /**
     * Method to create a square based on the data read from the file.
     *
     * @param insertionTime The time when the shape display on screen.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The side length of the square.
     * @param r The r value of the line colour or fill colour.
     * @param g The g value of the line colour or fill colour.
     * @param b The b value of the line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if
     * opaque.
     * @param isFlash True if the square will flash, false if not.
     * @param fr The r value of the flashing colour.
     * @param fg The r value of the flashing colour.
     * @param fb The r value of the flashing colour.
     * @return return the square to enqueue
     */
    public static Square creatSquare(int insertionTime, int x, int y, int vx, int vy, int side, int r, int g, int b, boolean isFilled, boolean isFlash, int fr, int fg, int fb) {
        Square square = new Square(insertionTime, x, y, vx, vy, side, new Color(r, g, b), isFilled, isFlash, new Color(fr, fg, fb));
        return square;
    }

    /**
     * Method to create a rectangle based on the data read from the file.
     *
     * @param insertionTime The time when the shape display on screen.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     * @param r The r value of the line colour or fill colour.
     * @param g The g value of the line colour or fill colour.
     * @param b The b value of the line colour or fill colour.
     * @param isFilled True if the rectangle is filled with colour, false if
     * opaque.
     * @param isFlash True if the rectangle will flash, false if not.
     * @param fr The r value of the flashing colour.
     * @param fg The r value of the flashing colour.
     * @param fb The r value of the flashing colour.
     * @return return the rectangle to enqueue
     */
    public static Rect creatRect(int insertionTime, int x, int y, int vx, int vy, int width, int height, int r, int g, int b, boolean isFilled, boolean isFlash, int fr, int fg, int fb) {
        Rect rect = new Rect(insertionTime, x, y, vx, vy, width, height, new Color(r, g, b), isFilled, isFlash, new Color(fr, fg, fb));
        return rect;
    }

    /**
     * Method to create a triangle based on the data read from the file.
     *
     * @param insertionTime The time when the shape display on screen.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the triangle.
     * @param height The height of the triangle.
     * @param r The r value of the line colour or fill colour.
     * @param g The g value of the line colour or fill colour.
     * @param b The b value of the line colour or fill colour.
     * @param isFilled True if the triangle is filled with colour, false if
     * opaque.
     * @param isFlash True if the triangle will flash, false if not.
     * @param fr The r value of the flashing colour.
     * @param fg The r value of the flashing colour.
     * @param fb The r value of the flashing colour.
     * @return return the triangle to enqueue
     */
    public static Triangle creatTriangle(int insertionTime, int x, int y, int vx, int vy, int width, int height, int r, int g, int b, boolean isFilled, boolean isFlash, int fr, int fg, int fb) {
        Triangle triangle = new Triangle(insertionTime, x, y, vx, vy, width, height, new Color(r, g, b), isFilled, isFlash, new Color(fr, fg, fb));
        return triangle;
    }
}
