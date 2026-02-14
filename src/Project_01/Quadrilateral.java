
package Project_01;

public class Quadrilateral implements Polygon{

    protected double sideA;
    protected double sideB;
    protected double sideC;
    protected double sideD;
    protected double diagonal;

    public Quadrilateral(double sideA, double sideB, double sideC, double sideD, double diagonal) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.sideD = sideD;
        this.diagonal = diagonal;
    }

    @Override
    public double area() {
        // Using diagonal to split into two triangles
        // Triangle 1: sideA, sideB, diagonal
        double s1 = (sideA + sideB + diagonal) / 2.0;
        double area1 = Math.sqrt(s1 * (s1 - sideA) * (s1 - sideB) * (s1 - diagonal));

        // Triangle 2: sideC, sideD, diagonal
        double s2 = (sideC + sideD + diagonal) / 2.0;
        double area2 = Math.sqrt(s2 * (s2 - sideC) * (s2 - sideD) * (s2 - diagonal));

        return area1 + area2;
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC + sideD;
    }
}
