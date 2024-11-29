package by.aston;

public class Park {
    private Attraction[] attractions;

    public Park(Attraction[] attractions) {
        this.attractions = attractions;
    }

    static class Attraction {
        private String name;
        private String workTime;
        private int cost;

        public Attraction(String name, String workTime, int cost) {
            this.name = name;
            this.workTime = workTime;
            this.cost = cost;
        }
    }
}
