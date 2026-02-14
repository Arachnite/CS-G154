package Project_01;

import java.util.Scanner;

public class PolygonDemo {

    private static Scanner sc = new Scanner(System.in); // Scanner for user input

    /**
     * Main function for the Polygon Calculator application.
     * Creates and starts the polygon calculator user interface.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        run();
    }

    /**
     * Runs the main loop of the Polygon Calculator.
     * Displays menu, processes user input, creates polygons, and displays results.
     * Continues until user chooses to exit.
     */
    public static void run() {

        System.out.println("===========================================");
        System.out.println("   Welcome to the Polygon Calculator!");
        System.out.println("===========================================\n");

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput();

            Polygon polygon = null;

            switch (choice) {
                case 1:
                    polygon = createTriangle();
                    break;
                case 2:
                    polygon = createIsoscelesTriangle();
                    break;
                case 3:
                    polygon = createEquilateralTriangle();
                    break;
                case 4:
                    polygon = createQuadrilateral();
                    break;
                case 5:
                    polygon = createRectangle();
                    break;
                case 6:
                    polygon = createSquare();
                    break;
                case 7:
                    polygon = createPentagon();
                    break;
                case 8:
                    polygon = createHexagon();
                    break;
                case 9:
                    polygon = createOctagon();
                    break;
                case 0:
                    System.out.println("\nThank you for using the Polygon Calculator!");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.\n");
                    continue;
            }

            if (polygon != null) {
                displayResults(polygon);
            }
        }

        sc.close();
    }

    /**
     * Displays the main menu with available polygon types.
     * Shows options for creating different types of polygons and exiting the program.
     */
    private static void displayMenu() {
        System.out.println("Select a polygon type:");
        System.out.println("1. Triangle");
        System.out.println("2. Isosceles Triangle");
        System.out.println("3. Equilateral Triangle");
        System.out.println("4. Quadrilateral");
        System.out.println("5. Rectangle");
        System.out.println("6. Square");
        System.out.println("7. Pentagon (Regular)");
        System.out.println("8. Hexagon (Regular)");
        System.out.println("9. Octagon (Regular)");
        System.out.println("0. Exit");
        System.out.println();
    }

    /**
     * Creates a Triangle by prompting the user for three side lengths.
     * @return a new Triangle object with the specified dimensions
     */
    private static Triangle createTriangle() {
        System.out.println("\n=== Triangle ===");
        double sideA = getDoubleInput("Enter side A: ");
        double sideB = getDoubleInput("Enter side B: ");
        double sideC = getDoubleInput("Enter side C: ");
        return new Triangle(sideA, sideB, sideC);
    }

    /**
     * Creates an IsoscelesTriangle by prompting the user for the equal sides length and base length.
     * An isosceles triangle has two equal sides.
     * @return a new IsoscelesTriangle object with the specified dimensions
     */
    private static IsoscelesTriangle createIsoscelesTriangle() {
        System.out.println("\n=== Isosceles Triangle ===");
        double equalSides = getDoubleInput("Enter the length of equal sides: ");
        double base = getDoubleInput("Enter the base: ");
        return new IsoscelesTriangle(equalSides, base);
    }

    /**
     * Creates an EquilateralTriangle by prompting the user for the side length.
     * An equilateral triangle has all three sides equal.
     * @return a new EquilateralTriangle object with the specified dimension
     */
    private static EquilateralTriangle createEquilateralTriangle() {
        System.out.println("\n=== Equilateral Triangle ===");
        double side = getDoubleInput("Enter the side length: ");
        return new EquilateralTriangle(side);
    }

    /**
     * Creates a Quadrilateral by prompting the user for four side lengths and a diagonal.
     * The diagonal is used to calculate the area by dividing the quadrilateral into two triangles.
     * @return a new Quadrilateral object with the specified dimensions
     */
    private static Quadrilateral createQuadrilateral() {
        System.out.println("\n=== Quadrilateral ===");
        double sideA = getDoubleInput("Enter side A: ");
        double sideB = getDoubleInput("Enter side B: ");
        double sideC = getDoubleInput("Enter side C: ");
        double sideD = getDoubleInput("Enter side D: ");
        double diagonal = getDoubleInput("Enter diagonal length: ");
        return new Quadrilateral(sideA, sideB, sideC, sideD, diagonal);
    }

    /**
     * Creates a Rectangle by prompting the user for length and width.
     * A rectangle has opposite sides equal and all angles are 90 degrees.
     * @return a new Rectangle object with the specified dimensions
     */
    private static Rectangle createRectangle() {
        System.out.println("\n=== Rectangle ===");
        double length = getDoubleInput("Enter length: ");
        double width = getDoubleInput("Enter width: ");
        return new Rectangle(length, width);
    }

    /**
     * Creates a Square by prompting the user for the side length.
     * A square has all four sides equal and all angles are 90 degrees.
     * @return a new Square object with the specified dimension
     */
    private static Square createSquare() {
        System.out.println("\n=== Square ===");
        double side = getDoubleInput("Enter side length: ");
        return new Square(side);
    }

    /**
     * Creates a regular Pentagon by prompting the user for the side length.
     * A regular pentagon has five equal sides and equal angles.
     * @return a new Pentagon object with the specified dimension
     */
    private static Pentagon createPentagon() {
        System.out.println("\n=== Regular Pentagon ===");
        double side = getDoubleInput("Enter side length: ");
        return new Pentagon(side);
    }

    /**
     * Creates a regular Hexagon by prompting the user for the side length.
     * A regular hexagon has six equal sides and equal angles.
     * @return a new Hexagon object with the specified dimension
     */
    private static Hexagon createHexagon() {
        System.out.println("\n=== Regular Hexagon ===");
        double side = getDoubleInput("Enter side length: ");
        return new Hexagon(side);
    }

    /**
     * Creates a regular Octagon by prompting the user for the side length.
     * A regular octagon has eight equal sides and equal angles.
     * @return a new Octagon object with the specified dimension
     */
    private static Octagon createOctagon() {
        System.out.println("\n=== Regular Octagon ===");
        double side = getDoubleInput("Enter side length: ");
        return new Octagon(side);
    }

    /**
     * Displays the calculated perimeter and area of a polygon.
     * @param polygon the Polygon object whose results should be displayed
     */
    private static void displayResults(Polygon polygon) {
        System.out.println("\n=== Results ===");
        System.out.println(polygon.perimeter());
        System.out.println(polygon.area());
        System.out.println();
    }

    /**
     * Prompts the user for a double value and validates the input.
     * Continues to prompt until a valid double is entered.
     * @param prompt the message to display to the user
     * @return the double value entered by the user
     */
    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!PolygonDemo.sc.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a number: ");
            PolygonDemo.sc.next();
        }
        return PolygonDemo.sc.nextDouble();
    }

    /**
     * Prompts the user for an integer value and validates the input.
     * Continues to prompt until a valid integer is entered.
     * @return the integer value entered by the user
     */
    private static int getIntInput() {
        System.out.print("Enter your choice: ");
        while (!PolygonDemo.sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            PolygonDemo.sc.next();
        }
        return PolygonDemo.sc.nextInt();
    }
}
