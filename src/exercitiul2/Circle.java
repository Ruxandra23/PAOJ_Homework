package exercitiul2;

public class Circle extends Form {
    private float radius;

    public Circle() {
        super();
        this.radius = 0;
    }

    public Circle(String color, float radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Cerc: " + super.toString() + " " + String.format("%.2f", getArea());
    }

    public void printCircleDimensions() {
        System.out.println("Rază: " + radius);
    }
}
