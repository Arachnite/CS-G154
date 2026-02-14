
package Project_01;

public class Pentagon implements Polygon {

    private double side;

    public Pentagon(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        // Formula for regular pentagon
        return (Math.sqrt(25 + 10 * Math.sqrt(5)) / 4) * side * side;
    }

    @Override
    public double perimeter() {
        return 5 * side;
    }
}
