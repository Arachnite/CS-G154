
package Project_01;

public class Hexagon implements Polygon {

    private double side;

    public Hexagon(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        // Formula for regular hexagon
        return (3 * Math.sqrt(3) / 2) * side * side;
    }

    @Override
    public double perimeter() {
        return 6 * side;
    }
}
