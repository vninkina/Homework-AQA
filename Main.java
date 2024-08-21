//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        public static void main(String[] args) {
        Employee employee1 = new Employee("Pinkman", "Jessi", "Ivanovich",
                "pinkman@yandex.ru", "89376690900", 50000, 28);
        System.out.println(employee1.lastName + " " + employee1.firstName + " " + employee1.middleName + " " +
                employee1.email + " " + employee1.phone + " " + employee1.salary + " " + employee1.age);
    }
}