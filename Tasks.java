import java.util.Arrays;

public class Tasks {
    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign() {
        int a = 10, b = 15;
        int c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 100;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 1, b = 2;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void compareRangeNumbers() {
        int a = 10, b = 5;
        if (10 <= (a + b) && (a + b) <= 20) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static void task_6() {
        int a = -1;
        if (0 <= a) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static void task_7() {
        int a = 1;
        if (a <= 0) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static void task_8() {
        String str = "Hello world";
        int i = 0;
        for (; i < 5; i++)
            System.out.println(str);
    }

    public static void task_9() {
        int year = 2023;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " год является високосным.");
        } else {
            System.out.println(year + " год не является високосным.");
        }
    }

    public static void task_10() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++)
            arr[i] = 1 - arr[i];
        System.out.println(Arrays.toString(arr));
    }

    public static void task_11() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void task_12() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void task_13() {
        int size = 5;
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            arr[i][i] = 1;
            arr[i][size - i - 1] = 1;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void task_14() {
        int len = 10;
        int initialValue = 5;
        int arr[] = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
            System.out.print(arr[i]);
        }
    }
}