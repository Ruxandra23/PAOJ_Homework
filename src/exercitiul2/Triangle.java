package exercitiul2;

public class Triangle extends Form {
    private float base;
    private float height;

    public Triangle() {
        super();
        this.base = 0;
        this.height = 0;
    }

    public Triangle(String color, float base, float height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return (base * height) / 2;
    }

    @Override
    public String toString() {
        return "Triunghi: " + super.toString() + " " + getArea();
    }

    public void printTriangleDimensions() {
        System.out.println("Bază: " + base + ", Înălțime: " + height);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Triangle)) return false;
        Triangle t = (Triangle) obj;
        return this.base == t.base && this.height == t.height && this.color.equals(t.color);
    }
}
