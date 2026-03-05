public class Cylinder extends Shape {
    private double radius;
    private double height;
    //----------------------------------
    // Constructor: Sets up the cylinder.
    //----------------------------------
    public Cylinder(double radius, double height)
    {
        super("Cylinder");
        this.radius = radius;
        this.height = height;
    }

    //-----------------------------------------
    // Returns the surface area of the cylinder.
    //-----------------------------------------
    @Override
    public double area()
    {
        return Math.PI * radius * radius * height;
    }

    public double area(double radius, double height)
    {
        return 2 * Math.PI * radius * (radius + height);
    }

    //-----------------------------------
    // Returns the cylinder as a String.
    //-----------------------------------
    @Override
    public String toString()
    {
        return super.toString() + " of radius: " + this.radius + " and height: " + this.height + " and surface area: " + this.area(radius, height);
    }
}
