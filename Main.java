    import java.util.Scanner;

    public class Main {
        public static Scanner sc = new Scanner(System.in);
        public static void main(String[] args) {
            int action;
            Cats[] catsArray = new Cats[3];
            catsArray[0] = new Cats("Коржик", 10, false);
            catsArray[1] = new Cats("Карамелька", 15, false);
            catsArray[2] = new Cats("Компот", 25, false);


            Plate plate = new Plate(40);
            plate.info();
            for (int i = 0; i < catsArray.length; i++) {
                if (catsArray[i].fullness == false && catsArray[i].appetite < plate.food){
                    catsArray[i].eat(plate);
                    catsArray[i].fullness = true;
                    System.out.println("Котик " + catsArray[i].name + " покушал.");
                } else {
                    System.out.println("Котик " + catsArray[i].name + " не поел!");
                }
            }
            plate.info();
            System.out.println("Сколько добавить еще в миску?");
            action = sc.nextInt();
            plate.increaseFood(action);
            plate.info();

        }
    }