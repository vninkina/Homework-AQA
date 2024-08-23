public class Cats {
    public String name;
    public int appetite;
    public boolean fullness;

    public Cats(String name, int appetite, boolean fullness) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = fullness;
    }

    public void eat(Plate p) {
        p.decreaseFood(appetite);
    }
}
