
package Project_01;

public class EquilateralTriangle extends Triangle {

    public EquilateralTriangle(double side) {
        super(side, side, side);
    }

    @Override
    public double area() {
        // More efficient formula for equilateral triangle
        return (Math.sqrt(3) / 4) * sideA * sideA;
    }
}
