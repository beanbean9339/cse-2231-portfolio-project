import components.planttracker.PlantTracker;

public class PlantCareSystem {
    public static void main(String[] args) {
        // Create a new instance of PlantTracker
        PlantTracker tracker = new PlantTracker();

        // Add some plants to the tracker
        tracker.addPlant("Rose", "Flowering", 2, "Water every 2 days");
        tracker.addPlant("Cactus", "Succulent", 5, "Water once a week");
        tracker.addPlant("Tulip", "Flowering", 1, "Water every 3 days");

        // Display all plants
        tracker.displayAllPlants();

        // Get a random plant and show its details
        tracker.getRandomPlant();

        // List plants that need watering
        tracker.listPlantsThatNeedWater();

        // Show care instructions for a specific plant
        tracker.showCareInstructions("Rose");

        // Count the total number of plants in the tracker
        System.out.println("Total plants in the tracker: " + tracker.countPlants());

        // Remove a plant
        tracker.removePlant("Cactus");
        tracker.displayAllPlants();

        // Clear all plants
        tracker.clear();
        tracker.displayAllPlants();
    }
}
