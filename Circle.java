    public class Circle {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

        public double calculateArea() {
        return Math.PI * radius * radius;
    }

        public void setFillColor(String color) {
        this.fillColor = color;
    }

        public void setBorderColor(String color) {
        this.borderColor = color;
    }

    public void printCharacteristics() {
        System.out.println("Круг:");
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет фона: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
    }
    }
