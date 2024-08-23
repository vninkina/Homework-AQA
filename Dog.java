public class Dog extends Animal{
    String name;
    static int countDod = 0;

    Dog(String name){
        super();
        countDod++;
        this.name = name;
    }

    @Override
    void run(int range) {
        if (range > 500) {
            System.out.println(name+ " не может пробежать больше 500 м");
        } else {
            System.out.println(name+ " пробежал " + range + " м");
        }

    }

    @Override
    void swim(int range) {
        if (range > 10) {
            System.out.println("Собака не проплывет больше " +range+ " м");
        } else {
            System.out.println(name + " проплыл " + range + " м");
        }
    }

    static int getCountDod (){
        return countDod;
    }
}