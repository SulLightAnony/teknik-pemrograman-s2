public class Rectangle extends Shape {
    private double width;
    private double length;
    //----------------------------------
    // Constructor: Sets up the rectangle.
    //----------------------------------
    public Rectangle(double width, double length)
    {
        super("Rectangle");
        this.width = width;
        this.length = length;
    }

    //-----------------------------------------
    // Returns the surface area of the rectangle.
    //-----------------------------------------
    @Override
    public double area()
    {
        return width * length;
    }

    //-----------------------------------
    // Returns the rectangle as a String.
    //-----------------------------------
    @Override
    public String toString()
    {
        return super.toString() + " of width: " + this.width + " and length: " + this.length;
    }
}
