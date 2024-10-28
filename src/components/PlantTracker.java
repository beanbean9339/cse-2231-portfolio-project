package components;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;

/**
 * The PlantTracker class is responsible for managing a collection of plants,
 * allowing users to add plants, water them, and display care instructions.
 */
public class PlantTracker implements PlantTrackerKernel {
    // Fields to store plant data
    private Map<String, Plant> plants;

    /**
     * Constructs a new PlantTracker instance with an empty plant collection.
     */
    public PlantTracker() {
        this.plants = new HashMap<>();
    }

    @Override
    public void addPlant(String name, String careInstructions, int wateringInterval) {
        if (this.plants.containsKey(name)) {
            System.out.println("Plant already exists: " + name);
        } else {
            this.plants.put(name, new Plant(name, careInstructions, wateringInterval));
            System.out.println("Added plant: " + name);
        }
    }

    @Override
    public void waterPlant(String name) {
        Plant plant = this.plants.get(name);
        if (plant != null) {
            if (plant.needsWatering()) {
                plant.water();
                System.out.println("Watered plant: " + name);
            } else {
                System.out.println("No need to water " + name + " yet.");
            }
        } else {
            System.out.println("Plant not found: " + name);
        }
    }

    @Override
    public void showCareInstructions(String name) {
        Plant plant = this.plants.get(name);
        if (plant != null) {
            System.out.println("Care instructions for " + name + ": "
                    + plant.getCareInstructions()
                    + " Last watered on: " + plant.getLastWatered());
        } else {
            System.out.println("Plant not found: " + name);
        }
    }

    @Override
    public void listAllPlants() {
        if (this.plants.isEmpty()) {
            System.out.println("No plants in the tracker.");
        } else {
            System.out.println("Plants in tracker:");
            for (Plant plant : this.plants.values()) {
                System.out.println("- " + plant.name + " (Last watered: " + plant.getLastWatered() + ")");
                if (plant.needsWatering()) {
                    System.out.println("  Needs watering soon.");
                }
            }
        }
    }

    /**
     * Inner class representing a Plant with a name, care instructions,
     * watering status, and interval.
     */
    public class Plant {
        private String name;
        private String careInstructions;
        private LocalDateTime lastWatered; // Track last watered time
        private int wateringInterval; // Watering interval in days

        /**
         * Constructs a new Plant instance with a name, care instructions,
         * and watering interval.
         *
         * @param name             the name of the plant
         * @param careInstructions  the care instructions for the plant
         * @param wateringInterval   the interval for watering the plant (in days)
         */
        public Plant(String name, String careInstructions, int wateringInterval) {
            this.name = name;
            this.careInstructions = careInstructions;
            this.lastWatered = LocalDateTime.now(); // Set initial last watered time
            this.wateringInterval = wateringInterval;
        }

        /**
         * Marks the plant as watered and updates the last watered time.
         */
        public void water() {
            this.lastWatered = LocalDateTime.now();
        }

        /**
         * Returns the care instructions for the plant.
         *
         * @return the care instructions
         */
        public String getCareInstructions() {
            return this.careInstructions;
        }

        /**
         * Returns the last watered date and time.
         *
         * @return the last watered date and time
         */
        public LocalDateTime getLastWatered() {
            return this.lastWatered;
        }

        /**
         * Checks if the plant needs watering based on the last watered time
         * and watering interval.
         *
         * @return true if the plant needs watering, false otherwise
         */
        public boolean needsWatering() {
            return this.lastWatered.plusDays(this.wateringInterval).isBefore(LocalDateTime.now());
        }

		public String getName() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("Unimplemented method 'getName'");
		}
    }

    /**
     * Main method to demonstrate the functionality of the PlantTracker class.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        PlantTracker tracker = new PlantTracker();

        // Adding plants with care instructions and watering intervals
        tracker.addPlant("Spider Plant", "Water every 1-2 weeks.", 14);
        tracker.addPlant("Pothos", "Water when the top inch of soil is dry.", 7);

        // Show care instructions
        tracker.showCareInstructions("Spider Plant");
        tracker.showCareInstructions("Pothos");

        // Watering plants
        tracker.waterPlant("Pothos");
        tracker.waterPlant("Cactus"); // Testing a non-existing plant

        // List all plants
        tracker.listAllPlants();
    }
}
