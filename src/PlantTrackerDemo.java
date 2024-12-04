import components.planttracker.PlantTracker;

public class PlantTrackerDemo {
    public static void main(String[] args) {
        // Create a new PlantTracker instance
        PlantTracker tracker = new PlantTracker();

        // Add a new plant
        tracker.addPlant("Rose", "Flowering", 2, "Water every 2 days");

        // Display all plants
        tracker.displayAllPlants();

        // Check the water status of plants
        tracker.listPlantsThatNeedWater();
    }
}
