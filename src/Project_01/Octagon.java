
package Project_01;

public class Octagon implements Polygon {

    private double side;

    public Octagon(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        // Formula for regular octagon
        return 2 * (1 + Math.sqrt(2)) * side * side;
    }

    @Override
    public double perimeter() {
        return 8 * side;
    }
}
