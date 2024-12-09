package by.aston;

import java.util.Arrays;

public class Park {
    private Attraction[] attractions;
    private int attractionCount = 0;

    public Park() {
        attractions = new Attraction[3];
    }

    public Park(Attraction[] attractions) {
        this.attractions = attractions;
        attractionCount = attractions.length;
    }

    public void addAttraction(Attraction attraction) {
        if (attractions.length <= attractionCount) {
            attractions = Arrays.copyOf(attractions, attractions.length * 2);
        }
        attractions[attractionCount] = attraction;
        attractionCount++;
    }

    public void deleteAttraction(String attractionName) {
        int index = 0;
        for (int i = 0; i < attractionCount; i++) {
            if (attractions[i].name.compareTo(attractionName) == 0) {
                index = i;
                break;
            }
        }
        for (int i = index; i < attractionCount; i++) {
            attractions[i] = i == attractions.length - 1 ? null : attractions[i + 1];
        }
        attractionCount--;
    }

    @Override
    public String toString() {
        return "Park{" + "attractions=" + Arrays.toString(attractions) + '}';
    }

    static class Attraction {
        private String name;
        private String workTime;
        private int cost;

        @Override
        public String toString() {
            return "Attraction{" + "name='" + name + '\'' + ", workTime='" + workTime + '\'' + ", cost=" + cost + '}';
        }

        public Attraction(String name, String workTime, int cost) {
            this.name = name;
            this.workTime = workTime;
            this.cost = cost;
        }
    }
}