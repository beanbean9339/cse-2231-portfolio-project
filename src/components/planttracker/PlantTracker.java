package components.planttracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The PlantTracker class implements the PlantTrackerKernel interface,
 * managing a collection of plants, allowing users to add plants, water them,
 * and display care instructions.
 */
public interface PlantTracker extends PlantTrackerKernel {

    // Map to store plant names and their details (plant data)
    private Map<String, Plant> plants;

    /**
     * Constructs a new PlantTracker instance with an empty plant collection.
     */
    public PlantTracker() {
        this.plants = new HashMap<>();
    }

    @Override
    public void addPlant(String name, String species, int age, String careInstructions) {
        if (this.plants.containsKey(name)) {
            System.out.println("Plant already exists: " + name);
        } else {
            this.plants.put(name, new Plant(name, species, age, careInstructions));
            System.out.println("Added plant: " + name);
        }
    }

    @Override
    public List<String> listAllPlants() {
        List<String> plantNames = new ArrayList<>();
        if (this.plants.isEmpty()) {
            System.out.println("No plants in the tracker.");
        } else {
            for (Plant plant : this.plants.values()) {
                plantNames.add(plant.getName());
            }
        }
        return plantNames;
    }

    @Override
    public void waterPlant(String name) {
        Plant plant = this.plants.get(name);
        if (plant != null) {
            System.out.println("Watering " + name + "...");
            // Implement the logic to check if the plant needs watering and water it if so
            plant.water();
            System.out.println(name + " has been watered.");
        } else {
            System.out.println("Plant not found: " + name);
        }
    }

    @Override
    public void showCareInstructions(String name) {
        Plant plant = this.plants.get(name);
        if (plant != null) {
            System.out.println("Care instructions for " + name + ": " + plant.getCareInstructions());
        } else {
            System.out.println("Plant not found: " + name);
        }
    }

    /**
     * Inner class representing a Plant with details such as name, species, age,
     * care instructions, and watering status.
     */
    public class Plant {
        private String name;
        private String species;
        private int age;
        private String careInstructions;

        public Plant(String name, String species, int age, String careInstructions) {
            this.name = name;
            this.species = species;
            this.age = age;
            this.careInstructions = careInstructions;
        }

        public String getName() {
            return this.name;
        }

        public String getSpecies() {
            return this.species;
        }

        public int getAge() {
            return this.age;
        }

        public String getCareInstructions() {
            return this.careInstructions;
        }

        public void water() {
            // Logic for watering the plant (could include last watered time update, etc.)
            System.out.println("The plant " + this.name + " has been watered.");
        }
    }

    public static void main(String[] args) {
        PlantTracker tracker = new PlantTracker();

        // Adding plants
        tracker.addPlant("Spider Plant", "Chlorophytum comosum", 2, "Water every 1-2 weeks.");
        tracker.addPlant("Pothos", "Epipremnum aureum", 1, "Water when the top inch of soil is dry.");

        // Show care instructions
        tracker.showCareInstructions("Spider Plant");
        tracker.showCareInstructions("Pothos");

        // Watering plants
        tracker.waterPlant("Pothos");
        tracker.waterPlant("Cactus"); // Testing a non-existing plant

        // List all plants
        List<String> plants = tracker.listAllPlants();
        System.out.println("All plants in the tracker:");
        for (String plant : plants) {
            System.out.println("- " + plant);
        }
    }
}
