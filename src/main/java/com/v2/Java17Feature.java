package com.v2;

public class Java17Feature {

	public static void main(String[] args) {
		//1. sealed classes syntax
		public abstract sealed class Animal
		permits Dog, Cat, Rabbit {...}
		
		//2. 

	}

}
// Sealed Class (Shape Class)
@Getter
public sealed class Shape permits Square, Rectangle{
    protected int edge1, edge2;
    protected Shape(int edge1, int edge2) {
        this.edge1 = edge1;
        this.edge2 = edge2;
    }
}
/**
 * Sealed Interface
 */
// Sealed Interface (ShapeService Interface)
public sealed interface ShapeService permits Square, Rectangle {
    default int getArea(int a, int b) {
        return a * b;
    }
    int getPerimeter();
}
// Permitted Class 1 (Rectangle Class)
public final class Rectangle extends Shape implements ShapeService {
    public Rectangle(int edge1, int edge2) {
        super(edge1, edge2);
    }
    @Override
    public int getPerimeter() {
        return 2 * (edge1 + edge2);
    }
}
// Permitted Class 2 (Square Class)
public final class Square extends Shape implements ShapeService {
    public Square(int edge1, int edge2) {
        super(edge1, edge2);
    }
    @Override
    public int getPerimeter() {
        return 4 * edge1;
    }
}

//UnPermitted Class (Triangle Class)
//public final class Triangle extends Shape implements ShapeService {} -> Triangle is not allowed in the sealed hierarchy!!!
public final class Triangle {
  private final int base;
  private final int edge1;
  private final int edge2;
  private final int height;

  public Triangle(int base, int edge1, int edge2, int height) {
      this.base = base;
      this.edge1 = edge1;
      this.edge2 = edge2;
      this.height = height;
  }

  public int getPerimeter() {
      return base + edge1 + edge2;
  }

  public int getArea() {
      return (base * height) / 2;
  }
}
public class ShapeTest {
    @Test
    public void shapeTest() {
        /**
         * Permitted classes RECTANGLE and SQUARE
         */
        //Rectangle Declaration and tests
        Rectangle rectangle = new Rectangle(3, 5);
        assertEquals(16, rectangle.getPerimeter());
        assertEquals(15, rectangle.getArea(3, 5));
        //Square Declaration and tests
        Square square = new Square(3, 3);
        assertEquals(12, square.getPerimeter());
        assertEquals(9, square.getArea(3, 3));
        /**
         * Unpermitted Class TRIANGLE
         */
        Triangle triangle = new Triangle(6, 5, 5, 4);
        assertEquals(16, triangle.getPerimeter());
        assertEquals(12, triangle.getArea());
    }
}



