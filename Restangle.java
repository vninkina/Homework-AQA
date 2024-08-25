public class Restangle {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Restangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculatePerimeter() {
        return 2 * (width * height);
    }

    public double calculateArea() {
        return width * height;
    }

    public void setFillColor(String color) {
        this.fillColor = color;
    }

    public void setBorderColor(String color) {
        this.borderColor = color;
    }

    public void printCharacteristics() {
        System.out.println("Прямоугольник:");
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет фона: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
    }
}
