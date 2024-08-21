public class Park {
    private String name;
    private Attraction[] attractions;

    public Park(String name) {
        this.name = name;
    }

    public void setAttractions(Attraction[] attractions) {
        this.attractions = attractions;
    }

    public class Attraction {
        private String name;
        private String workingTime;
        private double cost;

        public Attraction(String name, String workingTime, double cost) {
            this.name = name;
            this.workingTime = workingTime;
            this.cost = cost;
        }

        public String getName() {
            return name;
        }

        public String getWorkingTime() {
            return workingTime;
        }

        public double getCost() {
            return cost;
        }
    }

    public static void main(String[] args) {
        Park park = new Park("Загородный Парк");

        Park.Attraction[] attractions = new Park.Attraction[2];
        attractions[0] = park.new Attraction("Колесо обозрения", "10:00-18:00", 500.0);
        attractions[1] = park.new Attraction("Шоу тайм", "10:00-18:00", 400.0);

        park.setAttractions(attractions);

        for (Park.Attraction attraction : park.attractions) {
            System.out.println("Attraction:" + attraction.getName());
            System.out.println("WorkingTime:" + attraction.getWorkingTime());
            System.out.println("Cost:" + attraction.getCost());
            System.out.println();
        }
    }
}