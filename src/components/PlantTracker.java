package components;

import java.util.HashMap;
import java.util.Map;

/**
 * The PlantTracker class is responsible for managing a collection of plants,
 * allowing users to add plants, water them, and display care instructions.
 */
public class PlantTracker {
    // Fields to store plant data
    private Map<String, Plant> plants;

    /**
     * Constructs a new PlantTracker instance with an empty plant collection.
     */
    public PlantTracker() {
        this.plants = new HashMap<>();
    }

    /**
     * Adds a new plant to the tracker with specified care instructions.
     *
     * @param name
     *            the name of the plant
     * @param careInstructions
     *            the care instructions for the plant
     */
    public void addPlant(String name, String careInstructions) {
        this.plants.put(name, new Plant(name, careInstructions));
        System.out.println("Added plant: " + name);
    }

    /**
     * Waters the specified plant if it exists in the tracker.
     *
     * @param name
     *            the name of the plant to be watered
     */
    public void waterPlant(String name) {
        Plant plant = this.plants.get(name);
        if (plant != null) {
            plant.water();
            System.out.println("Watered plant: " + name);
        } else {
            System.out.println("Plant not found: " + name);
        }
    }

    /**
     * Displays the care instructions for the specified plant.
     *
     * @param name
     *            the name of the plant for which to display care instructions
     */
    public void showCareInstructions(String name) {
        Plant plant = this.plants.get(name);
        if (plant != null) {
            System.out.println("Care instructions for " + name + ": "
                    + plant.getCareInstructions());
        } else {
            System.out.println("Plant not found: " + name);
        }
    }

    /**
     * Inner class representing a Plant with a name, care instructions, and
     * watered status.
     */
    private class Plant {
        private String name;
        private String careInstructions;
        private boolean isWatered;

        /**
         * Constructs a new Plant instance with a name and care instructions.
         *
         * @param name
         *            the name of the plant
         * @param careInstructions
         *            the care instructions for the plant
         */
        public Plant(String name, String careInstructions) {
            this.name = name;
            this.careInstructions = careInstructions;
            this.isWatered = false;
        }

        /**
         * Marks the plant as watered.
         */
        public void water() {
            this.isWatered = true;
        }

        /**
         * Returns the care instructions for the plant.
         *
         * @return the care instructions
         */
        public String getCareInstructions() {
            return this.careInstructions;
        }
    }

    /**
     * Main method to demonstrate the functionality of the PlantTracker class.
     *
     * @param args
     *            command-line arguments (not used)
     */
    public static void main(String[] args) {
        PlantTracker tracker = new PlantTracker();

        // Adding plants
        tracker.addPlant("Spider Plant", "Water every 1-2 weeks.");
        tracker.addPlant("Pothos", "Water when the top inch of soil is dry.");

        // Show care instructions
        tracker.showCareInstructions("Spider Plant");
        tracker.showCareInstructions("Pothos");

        // Watering plants
        tracker.waterPlant("Pothos");
        tracker.waterPlant("Cactus"); // Testing a non-existing plant
    }
}
