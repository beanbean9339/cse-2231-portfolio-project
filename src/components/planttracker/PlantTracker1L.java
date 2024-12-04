package components.planttracker;

import java.util.ArrayList;
import java.util.List;

public class PlantTracker1L {
    private List<Plant> plants;

    public PlantTracker1L() {
        this.plants = new ArrayList<>();
    }

    public void addPlant(String name, String species, String wateringSchedule, String careInstructions) {
        // Handle empty name or species
        if (name.isEmpty()) {
            System.out.println("Plant name cannot be empty.");
            return;
        }
        if (species.isEmpty()) {
            System.out.println("Species cannot be empty.");
            return;
        }

        // Prevent adding duplicate plants by name
        for (Plant plant : this.plants) {
            if (plant.getName().equals(name)) {
                System.out.println("Plant already exists: " + name);
                return;
            }
        }

        // Create new plant and add to list
        Plant newPlant = new Plant(name, species, wateringSchedule, careInstructions);
        this.plants.add(newPlant);
        System.out.println("Added plant: " + name);
    }

    public void removePlant(String name) {
        // Iterate through the plants list and remove the plant by name
        for (int i = 0; i < this.plants.size(); i++) {
            if (this.plants.get(i).getName().equals(name)) {
                this.plants.remove(i);
                System.out.println("Removed plant: " + name);
                return;
            }
        }
        // If plant is not found, print message
        System.out.println("Plant not found: " + name);
    }

    public void viewPlants() {
        // If there are no plants, print message
        if (this.plants.isEmpty()) {
            System.out.println("No plants found.");
        } else {
            // Print out each plant's details
            for (Plant plant : this.plants) {
                System.out.println("Plant Name: " + plant.getName());
                System.out.println("Species: " + plant.getSpecies());
                System.out.println("Watering Schedule: " + plant.getWateringSchedule());
                System.out.println("Care Instructions: " + plant.getCareInstructions());
                System.out.println("------");
            }
        }
    }

    // Static inner Plant class to avoid potential issues with non-static inner classes
    static class Plant {
        private String name;
        private String species;
        private String wateringSchedule;
        private String careInstructions;

        public Plant(String name, String species, String wateringSchedule, String careInstructions) {
            this.name = name;
            this.species = species;
            this.wateringSchedule = wateringSchedule;
            this.careInstructions = careInstructions;
        }

        public String getName() {
            return this.name;
        }

        public String getSpecies() {
            return this.species;
        }

        public String getWateringSchedule() {
            return this.wateringSchedule;
        }

        public String getCareInstructions() {
            return this.careInstructions;
        }
    }
}
