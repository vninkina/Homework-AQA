import java.util.*;

class Lesson11 {

    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        Map<String, Integer> hm = new HashMap<>();
        String[] words = {
                "Cat", "Dog", "Mouse",
                "Cheese", "Meat", "Milk",
                "Coffee", "Tea", "Water",
                "Cat", "Milk", "Dog"
        };

        for (int i = 0; i < words.length; i++) {
            if (hm.containsKey(words[i]))
                hm.put(words[i], hm.get(words[i]) + 1);
            else
                hm.put(words[i], 1);
        }
        System.out.println("Задание №1");
        System.out.println(hm);
    }

    private static void task2() {
        PhoneBook pB = new PhoneBook();
        System.out.println("Задание №2");
        pB.add("Синютин", "+7 (917) 111-11-11");
        pB.add("Синюгин", "+7 (911) 444-44-44");
        pB.add("Синютин", "+7 (917) 222-22-22");
        pB.add("Алексеев", "+7 (917) 555-55-55");
        pB.add("Синюгин", "+7 (917) 888-08-08");
        pB.get("Синютин");
        pB.get("Синюгин");
        }
}