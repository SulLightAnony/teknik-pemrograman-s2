public class TestShapes {
    public static void main(String[] args) throws Exception {
        // Declare and allocate a new instance of circle
        Circle circle01 = new Circle();
        System.out.println("Circle:"
                + " radius = " + circle01.getRadius()
                + " area = " + circle01.getArea()
                + " perimeter =" + circle01.getPerimeter());
        System.out.println(circle01.toString());

        Circle circle02 = new Circle(10.0);
        System.out.println("\nCircle:"
                + " Radius = " + circle02.getRadius()
                + " Area = " + circle02.getArea()
                + " Perimeter =" + circle02.getPerimeter());
        System.out.println(circle02.toString());

        Circle circle03 = new Circle(10.0, "Blue", true);
        System.out.println("\nCircle:"
                + " Radius = " + circle03.getRadius()
                + " Area = " + circle03.getArea()
                + " Perimeter =" + circle03.getPerimeter());
        System.out.println(circle03.toString());

        // Declare and allocate a new instance of rectangle
        Rectangle rectangle01 = new Rectangle();
        System.out.println("\nRectangle:"
                + " Width = " + rectangle01.getWidth()
                + " Length = " + rectangle01.getLength()
                + " Area = " + rectangle01.getArea()
                + " Perimeter =" + rectangle01.getPerimeter());
        System.out.println(rectangle01.toString());

        Rectangle rectangle02 = new Rectangle(5.0, 10.0);
        System.out.println("\nRectangle:"
                + " Width = " + rectangle02.getWidth()
                + " Length = " + rectangle02.getLength()
                + " Area = " + rectangle02.getArea()
                + " Perimeter =" + rectangle02.getPerimeter());
        System.out.println(rectangle02.toString());

        Rectangle rectangle03 = new Rectangle(5.0, 10.0, "Yellow", true);
        System.out.println("\nRectangle:"
                + " Width = " + rectangle03.getWidth()
                + " Length = " + rectangle03.getLength()
                + " Area = " + rectangle03.getArea()
                + " Perimeter =" + rectangle03.getPerimeter());
        System.out.println(rectangle03.toString());

        // Declare and allocate a new instance of rectangle
        Square square01 = new Square();
        System.out.println("\nSquare:"
                + " Side = " + square01.getSide()
                + " Area = " + square01.getArea()
                + " Perimeter =" + square01.getPerimeter());
        System.out.println(square01.toString());

        Square square02 = new Square(15.0);
        System.out.println("\nSquare:"
                + " Side = " + square02.getSide()
                + " Area = " + square02.getArea()
                + " Perimeter =" + square02.getPerimeter());
        System.out.println(square02.toString());

        Square square03 = new Square(15.0, "White", true);
        System.out.println("\nSquare:"
                + " Side = " + square03.getSide()
                + " Area = " + square03.getArea()
                + " Perimeter =" + square03.getPerimeter());
        System.out.println(square03.toString());
    }
}