public class Main {
  public static void main(String[] args) {
      Circle circle = new Circle(5);
      circle.setFillColor("Желтый");
      circle.setBorderColor("Черный");
      circle.printCharacteristics();

      Restangle restangle = new Restangle(10, 15);
      restangle.setFillColor("Синий");
      restangle.setBorderColor("Белый");
      restangle.printCharacteristics();

      Triangle triangle = new Triangle(3, 5, 9);
      triangle.setFillColor("Зеленый");
      triangle.setBorderColor("Голубой");
      triangle.printCharacteristics();
  }
}