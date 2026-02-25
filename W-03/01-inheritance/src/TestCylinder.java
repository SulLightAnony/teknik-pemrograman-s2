public class TestCylinder { // save as "TestCylinder.java"
    public static void main(String[] args) {
        // Declare and allocate a new instance of cylinder
        // with default color, radius, and height
        Cylinder c1 = new Cylinder();
        System.out.println("Cylinder:"
                + " radius=" + c1.getRadius()
                + " height=" + c1.getHeight()
                + " surface area=" + c1.getArea()
                + " volume=" + c1.getVolume());
        System.out.println(c1.toString());

        // Declare and allocate a new instance of cylinder
        // specifying height, with default color and radius
        Cylinder c2 = new Cylinder(10.0);
        System.out.println("\nCylinder:"
                + " radius=" + c2.getRadius()
                + " height=" + c2.getHeight()
                + " surface area=" + c2.getArea()
                + " volume=" + c2.getVolume());
        System.out.println(c2.toString());

        // Declare and allocate a new instance of cylinder
        // specifying radius and height, with default color
        Cylinder c3 = new Cylinder(2.0, 10.0);
        System.out.println("\nCylinder:"
                + " radius=" + c3.getRadius()
                + " height=" + c3.getHeight()
                + " surface area=" + c3.getArea()
                + " volume=" + c3.getVolume());
        System.out.println(c3.toString());

        // Declare and allocate a new instance of cylinder
        // specifying radius and height, with custom color
        Cylinder c4 = new Cylinder(4.0, 10.0, "Blue");
        System.out.println("\nCylinder:"
                + " radius=" + c4.getRadius()
                + " height=" + c4.getHeight()
                + " surface area=" + c4.getArea()
                + " volume=" + c4.getVolume()
                + " color=" + c4.getColor());
        System.out.println(c4.toString());
    }
}