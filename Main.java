public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal animal1 = new Animal();

        Cat maffin = new Cat("Маффин");
        Dog sharik = new Dog("Шарик");
        maffin.run(150);
        maffin.run(250);
        maffin.swim(9);

        sharik.run(500);
        sharik.run(501);
        sharik.swim(9);
        sharik.swim(15);
        System.out.println("Total animals: " +Animal.getCountAnimal());
        System.out.println("Total cats: "+Cat.getCountCat());
        System.out.println("Total dogs: "+Dog.getCountDod());
    }
}